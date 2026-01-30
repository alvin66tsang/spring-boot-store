INSERT INTO categories (name) VALUES
                                  ('Produce'),
                                  ('Dairy'),
                                  ('Meat & Seafood'),
                                  ('Bakery'),
                                  ('Frozen Foods'),
                                  ('Beverages'),
                                  ('Snacks'),
                                  ('Pantry'),
                                  ('Household'),
                                  ('Personal Care');
INSERT INTO products (name, price, description, category_id) VALUES

-- Produce
('Bananas (1 lb)', 0.79, 'Fresh ripe bananas, sold per pound.', 1),
('Gala Apples (1 lb)', 1.49, 'Sweet and crisp Gala apples.', 1),
('Baby Spinach', 2.99, 'Fresh organic baby spinach, 5 oz.', 1),
('Roma Tomatoes (1 lb)', 1.89, 'Juicy Roma tomatoes, perfect for cooking.', 1),
('Avocados (2 pack)', 3.49, 'Ripe Hass avocados.', 1),

-- Dairy
('Whole Milk 1 Gallon', 4.29, 'Vitamin D whole milk.', 2),
('Cheddar Cheese Block', 5.49, 'Sharp cheddar cheese, 400g.', 2),
('Greek Yogurt Plain', 3.99, 'High-protein plain Greek yogurt.', 2),
('Salted Butter', 4.79, 'Creamy salted butter, 454g.', 2),
('Large Brown Eggs (12)', 4.99, 'Farm fresh large brown eggs.', 2),

-- Meat & Seafood
('Chicken Breast', 9.99, 'Boneless skinless chicken breast, 1 kg.', 3),
('Ground Beef', 8.49, 'Lean ground beef, 1 lb.', 3),
('Pork Chops', 7.99, 'Center-cut pork chops.', 3),
('Atlantic Salmon Fillet', 12.99, 'Fresh Atlantic salmon fillet.', 3),
('Bacon Strips', 6.99, 'Smoked bacon strips, 375g.', 3),

-- Bakery
('White Sandwich Bread', 2.79, 'Soft white sandwich bread loaf.', 4),
('Whole Wheat Bread', 3.29, '100% whole wheat bread.', 4),
('Croissants (6 pack)', 4.99, 'Buttery baked croissants.', 4),
('Blueberry Muffins', 5.49, 'Fresh baked blueberry muffins.', 4),
('Bagels Plain (6)', 3.99, 'Classic plain bagels.', 4),

-- Frozen Foods
('Frozen Pizza Pepperoni', 6.99, 'Pepperoni frozen pizza.', 5),
('Frozen Mixed Vegetables', 2.49, 'Frozen carrots, peas, and corn.', 5),
('Ice Cream Vanilla', 5.99, 'Classic vanilla ice cream.', 5),
('Frozen Chicken Nuggets', 7.49, 'Breaded chicken nuggets.', 5),
('Frozen French Fries', 3.99, 'Crispy frozen French fries.', 5),

-- Beverages
('Orange Juice', 4.59, '100% pure orange juice.', 6),
('Bottled Water (24 pack)', 5.99, 'Purified drinking water.', 6),
('Cola Soda (2L)', 2.29, 'Classic cola soft drink.', 6),
('Almond Milk Unsweetened', 3.79, 'Unsweetened almond milk.', 6),
('Ground Coffee', 9.99, 'Medium roast ground coffee.', 6),

-- Snacks
('Potato Chips Classic', 3.49, 'Classic salted potato chips.', 7),
('Chocolate Chip Cookies', 4.29, 'Soft baked chocolate chip cookies.', 7),
('Granola Bars', 3.99, 'Chewy granola bars, 6 pack.', 7),
('Trail Mix', 5.49, 'Nut and dried fruit trail mix.', 7),
('Popcorn Microwave', 3.29, 'Butter flavored microwave popcorn.', 7),

-- Pantry
('White Rice 5 lb', 7.99, 'Long grain white rice.', 8),
('Pasta Spaghetti', 1.99, 'Classic spaghetti pasta.', 8),
('Olive Oil Extra Virgin', 9.49, 'Extra virgin olive oil.', 8),
('Canned Black Beans', 1.49, 'Canned black beans.', 8),
('Peanut Butter', 3.79, 'Creamy peanut butter.', 8);
