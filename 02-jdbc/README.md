# Java Database Connectivity
Java Database Connectivity (JDBC) is a Java-based AP (Application Programming Interface) that provides a standard interface for connecting and interacting with relational databases. JDBC enables Java applications to execute SQL (Structured Query Language) statements and retrieve results from a database. It serves as a bridge between Java programming and various database management systems (DBMS).

# Steps To Connect Java Application To a Database
Connecting a Java application to a database typically involves several steps. Here's a general seven-step process:

- Import JDBC Packages:
    In your Java code, import the necessary JDBC packages. These include at least java.sql and, depending on your needs additional packages for specific database operations.
    ```java 
    import java.sql.*;
    ```

- Load and Register the JDBC Driver:
    Load and register the JDBC driver for your specific database. The driver is responsible for establishing a connection between your Java application and the database. 
    ```java
    Class.forName("your.database.jdbc.Driver");
    ```
    Replace "your.database.jdbc.Driver" with the actual driver class for your database.

- Establish a Connection:
    Use the DriverManager.getConnection method to establish a connection to the database. Provide the database URL, username, and password.
    ```java
    String url = "jdbc:your_database_url";
    Connection connection = DriverManager.getConnection(url, "username", "password");
    ```
    Replace "jdbc:your_database_url" with the actual JDBC URL for your database.
 
- Create a Statement:
    Create a Statement object to execute SQL queries or updates.
    ```java
    Statement statement = connection.createStatement();
    ```
    You can also use PreparedStatement for precompiled SQL statements.

- Execute SQL Queries:
    Use the executeQuery method of the Statement object to execute SELECT queries and retrieve results.
    ```java
    ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");
    ```
    For non-SELECT queries, use executeUpdate:
    ```java
    int rowsAffected = statement.executeUpdate("UPDATE your_table SET column1 = value1 WHERE condition");
    ```

- Process the ResultSet:
    If you executed a SELECT query, use the ResultSet object to process the returned data.
    ```java
    while (resultSet.next()) {
    // Process each row of the result set
    String columnValue = resultSet.getString("columnName");
    // Perform further processing
    }
    ```
- Close the Connection:
    It's essential to close the database connection and related resources when you're done.
    ```java
    resultSet.close();
    statement.close();
    connection.close();
    ```
    Closing resources is crucial to free up system resources and prevent potential memory leaks.

 
 # DDL vs DML vs DQL
 DDL (Data Definition Language), DML (Data Manipulation Language), and DQL (Data Query Language) are subsets of SQL (Structured Query Language) that serve different purposes in managing and interacting with a relational database.

## DDL (Data Definition Language):
*Purpose:* DDL is used to define the structure and schema of a database.
*Operations:*
- CREATE: Used to create database objects like tables, indexes, and views.
- ALTER: Modifies the structure of existing database objects (e.g., adding or removing columns from a table).
- DROP: Deletes database objects (e.g., dropping a table or an index).
- TRUNCATE: Removes all records from a table but retains its structure.
- COMMENT: Adds comments to the data dictionary.

Example DDL statement:
```Sql
CREATE TABLE example_table (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);
```

## DML (Data Manipulation Language):
*Purpose*: DML is used to manipulate and work with data stored in the database.
*Operations*:
- SELECT: Retrieves data from one or more tables.
- INSERT: Adds new records to a table.
- UPDATE: Modifies existing records in a table.
- DELETE: Removes records from a table.

Example DML statements:
```Sql
-- Inserting data
INSERT INTO example_table (id, name) VALUES (1, 'John');

-- Updating data
UPDATE example_table SET name = 'Jane' WHERE id = 1;

-- Deleting data
DELETE FROM example_table WHERE id = 1;

```

## DQL (Data Query Language):
*Purpose*: DQL is a subset of SQL that specifically deals with querying and retrieving data from the database.
*Operations*:
- SELECT: Retrieves data from one or more tables based on specified conditions.

Example DQL statement:
```Sql
SELECT id, name FROM example_table WHERE id = 1;
```

#  Types Of Statement In Jdbc
In the context of JDBC (Java Database Connectivity) and database interaction, there are three main types of statements:

- *Statement:* The `Statement` interface is used for general-purpose access to a database. It is suitable for executing simple SQL queries without parameters. 
```java
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery("SELECT * FROM example_table");
```
Note: Using `Statement` directly with user inputs can expose your application to SQL injection vulnerabilities.

- *PreparedStatement:* The `PreparedStatement` interface extends Statement and is used to execute precompiled SQL queries with parameters. It helps improve performance and security by allowing the database to reuse previously prepared statements.
```java
PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO example_table (id, name) VALUES (?, ?)");
preparedStatement.setInt(1, 1);
preparedStatement.setString(2, "John");
preparedStatement.executeUpdate();
```
Using `PreparedStatement` helps prevent SQL injection as parameter values are treated as literals, not executable SQL code.

- *CallableStatement:* The `CallableStatement` interface is used to execute stored procedures, which are precompiled SQL routines stored in the database.
```java
CallableStatement callableStatement = connection.prepareCall("{call my_stored_procedure(?, ?)}");
callableStatement.setInt(1, 1);
callableStatement.setString(2, "John");
callableStatement.execute();
```
`CallableStatement` is suitable for executing stored procedures that may return results or have output parameters.




# JDBC Student Database Project

## Overview
This Java project demonstrates the use of JDBC (Java Database Connectivity) to interact with a MySQL database for managing student information. The project includes classes for establishing a database connection, a Student class to represent student entities, and a `StudentServicesImpl` class implementing various operations on the student database.

## Project Structure
- DBConnection.java: Singleton class responsible for establishing a connection to the MySQL database.
- Student.java: Class representing a student entity with attributes such as name, GPA, ID, and phone number.
- StudentServicesImpl.java: Implementation of the IStudentServices interface providing CRUD operations for managing student data.
- IStudentServices.java: Interface defining methods for student-related operations.
- StudentBuilder.java: Builder class for constructing Student objects with optional parameters.

## JDBC Connection
The project uses JDBC to connect to a MySQL database. The DBConnection class encapsulates the database connection setup. Key details include:
- Connection URL: Constructed using the host, port, and database name.
- Username and Password: Credentials for accessing the database.
- Singleton Pattern: Ensures a single instance of the connection is shared across the application.

## Student Operations
The `StudentServicesImpl` class provides the following operations:
- Get All Students: Retrieves a list of all students from the database.
- Get Student by ID: Retrieves a specific student based on their ID.
- Update Student: Updates the information of an existing student.
- Add Student: Adds a new student to the database.
- Delete Student: Removes a student from the database based on their ID.

## How to Use
- Database Setup: Ensure that MySQL is installed, and the database named studentDatabase exists.
- Configuration: Modify the DBConnection class with the correct database host, port, username, and password.
- Run the Application: Execute the main application or integrate the provided classes into your project. Use the StudentServicesImpl methods to perform operations on the student database.

## Dependencies
- Java 8 or later
- MySQL database
