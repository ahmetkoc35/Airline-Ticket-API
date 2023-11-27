# Airline Ticket API

## Introduction

The Airline Ticket API is a Java-based application for managing airline tickets and flights. It provides functionality for flight management, ticket purchasing, and user authentication.

![AirlineDB_ERD](https://github.com/ahmetkoc35/Airline-Ticket-API/assets/114762109/bfdecc00-b9b8-4835-8edf-6db3b8dc1a13)

## Project Structure

The project is organized as follows:

- `src/main/java`: Contains the Java source files.
  - `com/example/airlineticketapi`: The main package.
    - `configuration`: Configurations for security, JWT, Swagger, etc.
    - `controller`: Controllers for handling HTTP requests.
    - `dto`: Data Transfer Objects for API requests and responses.
    - `model`: Entity classes for Customer, Ticket, and Flight.
    - `repository`: Interfaces for database access.
    - `service`: Services for business logic.
    - `AirlineTicketApiApplication.java`: The main application class.

## Features

- **Flight Management**: Handling flight information, including queries and updates.
- **Ticket Management**: Facilitation of ticket purchasing and management.
- **User Authentication**: Secure user registration and login.

## Technologies Used

- Java: Programming language.
- Maven: Dependency management and build tool.
- Spring Boot: Framework for creating stand-alone, production-grade Spring-based applications.
- JWT (JSON Web Tokens): For secure user authentication.

## Installation and Running the Application

1. Clone the repository or download the source code.
2. Navigate to the project directory.
3. Run the application using Maven:
  mvn spring-boot:run
4. The application will start and be accessible on the configured port (default: 8080).

## API Endpoints

- Authentication: `/auth` (login, registration)
- Flights: `/flights` (query, add, update)
- Tickets: `/tickets` (purchase, query)

## Security and Authentication

- JWT is used for securing the Ticket-related operations. All ticket management actions require a valid JWT token for authentication.
- The Flight section, especially the query operations, do not have JWT-based security, making them accessible without authentication.
- The application uses Spring Security for general security configuration, with specific routes being secured as mentioned above.

### Link: 
http://ec2-52-59-252-210.eu-central-1.compute.amazonaws.com:3131/swagger-ui/index.html


