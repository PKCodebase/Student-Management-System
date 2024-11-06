#SStudent Management System

This is a Spring Boot application designed for managing student information. The application provides a RESTful API to perform CRUD operations (Create, Read, Update, Delete) on student records, as well as a search functionality to find students by name.


Technologies Used:
Java: Version 17
Spring Boot: Version 3.1.2
Spring Data JPA: For database interaction
MySQL: As the relational database
Lombok: For simplifying boilerplate code
Spring Web: For creating RESTful APIs
Spring Boot DevTools: For hot reloading during development


API Endpoints
The application provides the following API endpoints for managing students:

1. Get All Students:

Endpoint: /students
Method: GET
Description: Retrieves all students.

2. Get Student by ID:

Endpoint: /students/{id}
Method: GET
Description: Retrieves a student by their ID.

3. Add New Student:

Endpoint: /students
Method: POST
Description: Adds a new student.

4. Update Student by ID:

Endpoint: /students/{id}
Method: PUT
Description: Updates an existing student's information by ID.

5. Delete Student by ID:

Endpoint: /students/{id}
Method: DELETE
Description: Deletes a student by their ID.

6. Search Students by Name:

Endpoint: /students/search
Method: GET
Description: Searches for students whose names match the provided string.
Query Parameter: name


Project Structure:
com.Student_Management.Students_Management_System.controller: Contains the REST controller for handling API requests.
com.Student_Management.Students_Management_System.entity: Defines the Student entity class, which maps to the database.
com.Student_Management.Students_Management_System.exception: Custom exception class for handling errors.
com.Student_Management.Students_Management_System.repository: Interface for database operations using Spring Data JPA.
com.Student_Management.Students_Management_System.service: Service layer for business logic and data handling.
