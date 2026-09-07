CREATE DATABASE IF NOT EXISTS zomato_db;
USE zomato_db;

CREATE TABLE IF NOT EXISTS customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS restaurants (
    restaurant_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    city VARCHAR(100) NOT NULL,
    cuisine VARCHAR(100) NOT NULL,
    rating DECIMAL(2,1) DEFAULT 4.0
);

CREATE TABLE IF NOT EXISTS food_items (
    food_id INT PRIMARY KEY AUTO_INCREMENT,
    restaurant_id INT NOT NULL,
    name VARCHAR(150) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(10,2) NOT NULL,
    category VARCHAR(100),
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(restaurant_id)
);

INSERT INTO restaurants(name,city,cuisine,rating) VALUES
('Spice Garden','Bhopal','North Indian',4.5),
('Pizza Hub','Bhopal','Pizza, Italian',4.3),
('South Express','Bhopal','South Indian',4.6);

INSERT INTO food_items(restaurant_id,name,description,price,category) VALUES
(1,'Paneer Butter Masala','Creamy paneer curry',220,'Main Course'),
(1,'Dal Tadka','Yellow dal with tempering',160,'Main Course'),
(1,'Veg Biryani','Aromatic vegetable biryani',190,'Rice'),
(2,'Margherita Pizza','Classic cheese pizza',249,'Pizza'),
(2,'Farmhouse Pizza','Loaded vegetable pizza',349,'Pizza'),
(2,'Garlic Bread','Crispy garlic bread',149,'Sides'),
(3,'Masala Dosa','Crispy dosa with potato masala',140,'South Indian'),
(3,'Idli Sambar','Soft idli with sambar',110,'South Indian'),
(3,'Vada','Crispy medu vada',100,'South Indian');