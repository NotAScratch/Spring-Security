# Spring-Security
Spring Boot application for user registration and login with email verification, built using Java, Spring Data JPA, Thymeleaf, Spring Security and Maven.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Backend Components](#backend-components)
- [Dependencies](#dependencies)
- [Setup Instructions](#setup-instructions)
- [License](#license)

## Introduction
This project is a Spring Boot application designed for user registration and login with email verification. It leverages various Spring components to provide a secure and robust authentication system.

## Features
- User Registration
- Email Verification
- User Login
- Password Encryption
- Role-Based Access Control

## Backend Components
### Spring Boot
Spring Boot simplifies the development of production-ready applications by providing a set of conventions and tools.

### Spring Data JPA
Spring Data JPA provides easy integration with JPA-based data stores, allowing for seamless database interactions.

### Thymeleaf
Thymeleaf is a modern server-side Java template engine for web and standalone environments.

### Spring Security
Spring Security is a powerful and customizable authentication and access control framework for Java applications. Key features used in this project include:
- **Authentication**: Verifying user identity.
- **Authorization**: Granting access to resources based on roles.
- **Password Encoding**: Securely storing user passwords.
- **Email Verification**: Ensuring users verify their email addresses before accessing certain features.

### Maven
Maven is used for project build and dependency management.

## Dependencies
- **Spring Boot Starter Web**: For building web applications.
- **Spring Boot Starter Data JPA**: For database interactions.
- **Spring Boot Starter Thymeleaf**: For server-side rendering.
- **Spring Boot Starter Security**: For implementing security features.
- **Spring Boot Starter Mail**: For sending verification emails.
- **My SQL Database**: Database for development and testing.
- **Lombok**: To reduce boilerplate code.

## Setup Instructions
1. Clone the repository:
    ```bash
    git clone https://github.com/NotAScratch/Spring-Security.git
    ```
2. Navigate to the project directory:
    ```bash
    cd Spring-Security
    ```
3. Build the project using Maven:
    ```bash
    mvn clean install
    ```
4. Run the application:
    ```bash
    mvn spring-boot:run
    ```
5. Access the application at `http://localhost:8080`.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
