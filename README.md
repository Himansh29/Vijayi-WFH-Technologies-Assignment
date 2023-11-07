# Assignment README

## Description

This repository contains the source code for an assignment that I completed as part of a software engineering project. The assignment involved creating a Java Spring Boot application to manage comments between users. The assignment focused on implementing RESTful APIs, working with a PostgreSQL database, and performing user and comment validations.

## Assignment Details

- Created two RESTful APIs:
  - **Add Comment API:** Allows users to add comments with validation.
  - **Get Comment API:** Retrieves comments for a user.

- Defined two database tables in PostgreSQL:
  - **User Table:** Stores user information with columns for user ID, comment sender, and comment receiver.
  - **Comment Table:** Stores comments with columns for comment ID, message, comment date time, and the user who posted it.

- Implemented user and comment validations as per the requirements, including:
  - Validating user names to exclude special characters, numbers, and symbols.
  - Ensuring user names are not empty or blank.
  - Automatically generating comment date times.

- Used Spring Data JPA repositories to interact with the database.

- Employed Spring Boot's `@Transactional` annotation to ensure data consistency.

## Project Structure

The project is structured as follows:

- **Entities:** Contains the entity classes for User and Comment.

- **Repositories:** Contains Spring Data JPA repositories for User and Comment entities.

- **Services:** Contains service interfaces and implementations for adding and retrieving comments.

- **Controllers:** Provides REST controllers for the Add Comment and Get Comment APIs.

-  **Exceptions:** Provides user defined exceptions to ensure edge cases.

- **Application Properties:** Contains the configuration for the PostgreSQL database.

## How to Use

To run the project, you can follow these steps:

1. Clone the repository to your local machine.

2. Set up a PostgreSQL database and configure the database connection properties in the `application.properties` file.

3. Build the project using Maven or your preferred build tool.

4. Run the Spring Boot application.

5. Access the APIs using the specified endpoints.

## API Endpoints

- **Add Comment:**
  - `POST /add`
  - Request body: JSON payload with the comment details.

- **Get Comment:**
  - `GET /user/{userId}/comments`
  - Replace `{userId}` with the id to retrieve comments for.

## Additional Notes

- In case of validation failure or user not found, the APIs return "Invalid Request" or the corresponding HTTP response code.

## Author

- [Himanshu Bhange]

