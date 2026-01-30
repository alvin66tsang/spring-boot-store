## Spring Boot + Stripe Store
This is a sample project designed to demonstrate the integration of Spring Boot with the Stripe API. It provides a clear, end-to-end example of how to handle secure checkout flows, manage products, and process payments in a Java environment.

🎯 Purpose
The goal of this project is to provide a "boilerplate" for developers to understand:

1. How to initiate a Stripe Checkout Session from the backend.
2. How to handle Webhooks to confirm successful payments.
3. How to structure a simple MVC or RESTful store using Spring Boot.

💳 Stripe Integration Flow
The payment process follows these steps:

1. Selection: User add Product to Cart and clicks "Checkout".
2. Session Creation: Spring Boot sends a request to Stripe to create a Session.
3. Redirect: The app redirects the user to the Stripe-hosted URL.
4. Verification: Upon success, Stripe sends a POST Webhook to our app to confirm the transaction.

⚙️ Swagger-UI for API test.
https://spring-boot-store-production-28f7.up.railway.app/swagger-ui.html

⚙️ Setup & Configuration
To get started, you'll need to:

1. A Stripe account
2. Clone the Repo: `git clone https://github.com/alvin66tsang/spring-boot-store.git`
3. Add API keys to .env
   STRIPE_SECRET_KEY=
   STRIPE_WEBHOOK_SECRET_KEY=
4. Run the app: `mvn spring-boot:run`

📖 API Endpoints (Quick Look)

Authentication:
POST /auth/login - Authenticate and receive a JWT.

Order, Carts and Checkout:
POST /carts -- Create a new cart for current user.
POST /carts/{cartId}/items -- Add a product to the cart.
POST /checkout -- Checkout the cart.

GET /carts/{cartId} -- Get the cart by id.
GET /orders -- Get all orders for current user.
GET /orders/{orderId} -- Get the order by id.
