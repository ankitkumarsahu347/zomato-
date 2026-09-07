# Zomato Application

A beginner-friendly Zomato-style food ordering web application built using the same layered approach as the `amazon-application` reference project.

## Tech Stack
- Java 25
- Spring Boot 3.5.4
- Thymeleaf
- MySQL 9.6 connector
- Maven
- HTML/CSS

## Features
- Restaurant listing
- Restaurant menu
- Customer registration/login
- Session-based cart
- Add food to cart
- Clear cart
- MySQL restaurant and food data

## Project Structure
```
src/main/java/com/zomato/
├── controller
├── dao
├── model
├── main
└── util
```

## Run
1. Create the database by running `database.sql` in MySQL.
2. Open `DBConnection.java` and replace `YOUR_MYSQL_PASSWORD` with your MySQL password.
3. Open the project in IntelliJ IDEA.
4. Run `ZomatoApplication.java`.
5. Open `http://localhost:8080`.

## Reference
The architecture is inspired by the user's `amazon-application` project: controllers handle web requests, DAOs handle SQL, models hold data, and a DB utility manages MySQL connections.