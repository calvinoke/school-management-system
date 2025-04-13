package com.example.backend.repository;  
// Defines the package name, indicating that this is part of the repository layer for the application.

import org.springframework.data.jpa.repository.JpaRepository;  
// Imports JpaRepository, which provides standard CRUD and other database-related methods for the Addstudent entity.

import org.springframework.stereotype.Repository;  
// Imports the @Repository annotation, marking this interface as a Spring Data Repository, which automatically enables the implementation.

import com.example.backend.entity.Addstudent;

import java.util.List;  
// Imports List, allowing the repository to return a list of Addstudent objects for certain queries.

import java.util.Optional;  
// Imports Optional, which helps in handling cases where a query may not return any results (null safety).

@Repository  
// Marks this interface as a Spring-managed repository. The @Repository annotation indicates that it is a DAO (Data Access Object) layer 
// and Spring should automatically implement it for us at runtime.
public interface StudentRepository extends JpaRepository<Addstudent, Integer> {
    // Declares the interface that extends JpaRepository, enabling basic CRUD operations without needing to define them manually.
    // <Addstudent, Integer> specifies that this repository manages Addstudent entities with an Integer as the primary key type.

    // Find student by email, using Optional for better null safety
    Optional<Addstudent> findByEmail(String email);  
    // Defines a custom query method to find a student based on their email address.
    // Spring Data JPA will automatically generate the necessary query:
    // SELECT * FROM addstudent WHERE email = ?.
    // The return type is Optional to handle cases where no student is found for the given email.

    // Find students by class name
    List<Addstudent> findByClass1In(List<String> classNames);  
    // Defines a custom query method to find students based on their class.
    // The "In" keyword allows us to search for students in any of the provided class names (e.g., class1 = 'Math', 'Science', etc.).
    // The return type is a List of Addstudent objects, as multiple students could be in the given class.
    

}
