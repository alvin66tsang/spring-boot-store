package com.project.ecommercestore.controllers;

import com.project.ecommercestore.config.JwtConfig;
import com.project.ecommercestore.dtos.JwtResponse;
import com.project.ecommercestore.dtos.LoginRequest;
import com.project.ecommercestore.dtos.UserDto;
import com.project.ecommercestore.mappers.UserMapper;
import com.project.ecommercestore.repositories.UserRepository;
import com.project.ecommercestore.services.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final JwtConfig jwtConfig;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
            @Valid @RequestBody LoginRequest rq,
            HttpServletResponse response
    ) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        rq.getEmail(),
                        rq.getPassword())
        );

        var user = userRepository.findByEmail(rq.getEmail()).orElseThrow();

        var accessToken = jwtService.generateAccessToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        var cookie = new Cookie("refreshToken", refreshToken.toString());
        cookie.setHttpOnly(true); // cannot be access by JavaScript
        cookie.setPath("/auth/refresh");
        cookie.setMaxAge(jwtConfig.getRefreshTokenExpiration()); // 7d
        cookie.setSecure(true); // only send over HTTPS
        response.addCookie(cookie);

        return ResponseEntity.ok(new JwtResponse(accessToken.toString()));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refresh(
            @CookieValue(value = "refreshToken") String refreshToken
    ) {

        var jwt = jwtService.parseToken(refreshToken);
        if(jwt == null || jwt.isExpired()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        var userId = jwt.getUserId();
        var user = userRepository.findById(userId).orElseThrow();
        var accessToken = jwtService.generateAccessToken(user);

        return ResponseEntity.ok(new JwtResponse(accessToken.toString()));
    }

//    @GetMapping("/me")
//    public ResponseEntity<UserDto> me() {
//
//        var auth = SecurityContextHolder.getContext().getAuthentication();
//        var userId = (Long) auth.getPrincipal();
//
//        var user = userRepository.findById(userId).orElse(null);
//        if(user == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//        }
//        return ResponseEntity.ok(userMapper.toDto(user));
//    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Void> handleBadCredentialException() {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
