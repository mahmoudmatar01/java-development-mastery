# Spring Boot Course 

## Table of Contents

- [Overview](#overview)
- [What is Spring](#what-is-spring)
- [Problem with Spring](#problem-with-spring)
- [Enter Spring Boot](#enter-spring-boot)
- [Spring Boot Features](#spring-boot-features)
- [Setting up and Development Environment](#setting-up-and-development-environment)
- [Maven](#maven)
- [How to Create a New Spring Project](#How-to-Create-a-New-Spring-Project)
- [Starting Spring Boot](#Starting-Spring-Boot)
- [Let's Add a Controller](#Let's-Add-a-Controller)
- [Returning Objects from Controller](#Returning-Objects-from-Controller)
- [How Soring MVC Works](#How-Soring-MVC-Works)
- [**What is JPA?**](#what-is-jpa)
- [**Entities and Relationships**](#entities-and-relationships)
- [**Repositories and Services**](#repositories-and-services)
- [**API Endpoints**](#api-endpoints)


## Overview

Provide a high-level overview of your project. Explain its purpose, key features, and any other relevant information.

## What is Spring

[Spring](https://spring.io/) is a comprehensive framework for building enterprise Java applications. It provides a modular and cohesive approach to developing Java applications, promoting best practices such as dependency injection and aspect-oriented programming. Key features of the Spring framework include:

- **Inversion of Control (IoC):** Spring promotes IoC, where the control of object creation and lifecycle is shifted from the application code to the Spring container. This leads to loosely coupled components and easier unit testing.

- **Dependency Injection (DI):** Spring facilitates DI, allowing developers to inject dependencies into a class rather than creating them within the class. This promotes reusability and easier management of components.

- **Aspect-Oriented Programming (AOP):** AOP in Spring enables developers to separate cross-cutting concerns, such as logging and transaction management, from the core business logic. This leads to cleaner and more maintainable code.

- **Data Access:** Spring provides robust support for data access through JDBC and ORM frameworks like Hibernate. It simplifies database transactions and offers a consistent approach to data access.

- **Model-View-Controller (MVC):** The Spring MVC framework is a part of the larger Spring framework and provides a flexible and customizable way to develop web applications.

- **Security:** Spring Security is a powerful and customizable authentication and access control framework that integrates seamlessly with Spring-based applications.

## Problem with Spring

While Spring is a powerful framework, it comes with some challenges that developers may face:

### 1. **Huge Framework:**
   Spring is a comprehensive framework, and for smaller projects, it may be perceived as overly complex due to its extensive feature set. This can result in a steeper learning curve and increased development time.

### 2. **Multiple Setup Steps:**
   Setting up a Spring project involves configuring various components, which can lead to a longer setup time. Developers may need to understand and configure XML or Java-based configuration files, leading to a potential source of errors.

### 3. **Multiple Configuration Steps:**
   Configuring Spring components, such as beans and aspects, requires careful consideration and understanding of the Spring configuration options. This complexity can lead to configuration errors and make troubleshooting more challenging.

### 4. **Multiple Build and Deploy Steps:**
   Building and deploying a Spring application can involve multiple steps, especially in larger projects. Understanding the intricacies of the build process, managing dependencies, and deploying to different environments may add complexity to the development workflow.

It's essential to note that these challenges can be mitigated with proper documentation, best practices, and tools designed to simplify the development process.

## Enter Spring Boot

[Spring Boot](https://spring.io/projects/spring-boot) is a framework built on top of the Spring framework, designed to simplify the development of production-ready applications with Spring. Here are some key characteristics of Spring Boot:

### 1. **Opinionated:**
   Spring Boot is opinionated, meaning it comes with predefined conventions and defaults. This allows developers to quickly set up projects without spending time on extensive configuration.

### 2. **Convention Over Configuration:**
   Following the convention over configuration principle, Spring Boot eliminates the need for explicit configuration in many cases. It assumes sensible defaults, reducing the amount of boilerplate code.

### 3. **Stand Alone:**
   Spring Boot applications are stand-alone, meaning they can be run as executable JARs with an embedded server. This simplifies deployment and reduces the need for external web servers.

### 4. **Production Ready:**
   Spring Boot includes production-ready features out of the box, such as health checks, metrics, and monitoring through the Spring Boot Actuator. This ensures that applications built with Spring Boot are well-prepared for deployment in production environments.

Spring Boot makes it easy to create stand-alone, production-grade Spring-based Applications that you can " Just Run ".

## Spring Boot Features

### 1. **Opinionated Defaults:**
   Spring Boot comes with sensible defaults for configuration, reducing the need for manual setup. It follows the convention over configuration principle, enabling developers to start projects quickly with minimal configuration.

### 2. **Embedded Servers:**
   Spring Boot includes embedded servers like Tomcat, Jetty, and Undertow, making it easy to deploy applications as standalone JARs without the need for an external web server.

### 3. **Auto-Configuration:**
   Spring Boot automatically configures common components based on the project's dependencies. This feature significantly reduces the need for explicit configuration and boilerplate code.

### 4. **Spring Boot Starters:**
   Starters are pre-configured templates that streamline the integration of various technologies (e.g., databases, and messaging systems) into your Spring Boot application. They simplify dependency management and configuration.

### 5. **Spring Boot Actuator:**
   The actuator provides production-ready features like health checks, metrics, and monitoring out of the box. It helps developers and administrators monitor and manage Spring Boot applications easily.

### 6. **Spring Boot DevTools:**
   DevTools offers features like automatic application restart, live reload, and remote debugging, making the development process more efficient and enjoyable.

## Setting up and Development Environment

To set up the development environment for this project, follow these steps:

### Prerequisites

Make sure you have the following tools installed:

- [Java Development Kit (JDK)](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)

## Maven

[Maven](https://maven.apache.org/) is a build automation and project management tool used to manage the build lifecycle of a software project. It simplifies the process of building, testing, and packaging Java applications.

### Maven Commands

- **Clean the project:**
```bash
  mvn clean
```
- **Compile the project:**
```bash
  mvn compile
```
- **Package the project into a JAR file:**
```bash
 mvn package
```
- **Install the project artifacts to the local repository:**
```bash
 mvn install
```

## How to Create a New Spring Project

Follow these steps to create a new Spring project using Spring Initializr:

1. **Visit the Spring Initializr website:**

   Open your web browser and go to [https://start.spring.io/](https://start.spring.io/).

2. **Configure your project:**

   - Choose the desired project options, such as project type (Maven or Gradle), language (Java or Kotlin), and packaging (JAR or WAR).
   - Select the Spring Boot version.
   - Specify project metadata, including Group, Artifact, and Package names.

3. **Select dependencies:**

   Choose the dependencies required for your project. Spring Initializr allows you to add common dependencies such as Spring Web, Spring Data JPA, Spring Security, and more. Click on the "Add Dependencies" button to include the necessary components.

4. **Generate the project:**

   After configuring your project and selecting dependencies, click the "Generate" button. This will download a ZIP file containing your project skeleton.

5. **Extract the ZIP file:**

   Once the ZIP file is downloaded, extract its contents to your local development environment.

6. **Import into your IDE:**

   Open your preferred Integrated Development Environment (IDE), such as IntelliJ IDEA, Eclipse, or Visual Studio Code. Import the project as a Maven or Gradle project, depending on your initial configuration.

7. **Build and run:**

   Build the project using your IDE or the command line. Run the application, and it should start on the default port (usually 8080).

8. **Access the application:**

   Open your web browser and go to [http://localhost:8080](http://localhost:8080) to access the default Spring Boot welcome page.

Now you have successfully created and set up a new Spring project using Spring Initializr. Customize the project based on your requirements and start building your Spring application!



## Starting Spring Boot

To start your Spring Boot application, follow these steps:

1. **Default Configuration:**

   Spring Boot comes with sensible defaults for configuration, reducing the need for manual setup. The default configuration is provided in the `application.properties` or `application.yml` file, allowing you to customize settings based on your project requirements.

2. **Starting the Spring Application Context:**

   The Spring Boot application context is responsible for managing the components of your application, handling dependency injection, and providing a runtime environment for your Spring beans. When you run your Spring Boot application, the application context is automatically started.

   To run your application from the command line, use the following Maven command:

 ```bash
   mvn spring-boot:run
```
Alternatively, if you have a packaged JAR file, you can run it using the java -jar command:

```bash
java -jar target/your-project-1.0.0.jar
```

3. **Performing Class Path Scan:**

Spring Boot performs classpath scanning to identify components, configurations, and services within your project. This is based on the package structure defined in your project. Ensure that your classes are organized in a way that Spring Boot can discover and manage them automatically.

4. **Starting the Tomcat Server:**

Spring Boot includes an embedded web server, such as Tomcat, Jetty, or Undertow. When you start your Spring Boot application, the embedded server is initialized automatically.

If you want to customize the server settings, you can do so in the `application.properties` or `application.yml` file. For example, to change the default port to 8081:

```properties
server.port=8081
```
The embedded server starts and your Spring Boot application becomes accessible at the specified port. Open your web browser and navigate to http://localhost:8080 to access the application.


## Let's Add a Controller

In Spring Boot, controllers are responsible for handling incoming HTTP requests, processing them, and returning an appropriate response. Here's how you can create a simple controller:

1. **Create a Java Class:**

   Create a new Java class in your project. For example, `HelloController.java`.

2. **Marked with Annotations:**

   Mark the class with the `@RestController` annotation. This annotation combines the `@Controller` and `@ResponseBody` annotations, indicating that this class will handle web requests and return the response directly.

```java
   import org.springframework.web.bind.annotation.RestController;

   @RestController
   public class HelloController {
       // Your controller logic will go here
   }
```
1. **Define Request Mapping:**

Use the `@RequestMapping` annotation to define the URL path that triggers the controller method. Also, specify the HTTP method using the `method` attribute.

```java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello, Spring Boot!";
    }
}
```

In this example, the `hello` method is mapped to the `/hello` URL, and it responds to HTTP GET requests.


2. **Access the Controller:**

After adding the controller, run your Spring Boot application. Open your web browser and navigate to http://localhost:8080/hello. You should see the response "Hello, Spring Boot!".

The URL `/hello` triggers the `hello` method in the` HelloController` class when accessed with a GET request.

Now you have a basic controller set up in your Spring Boot project. You can expand on this example by adding more methods, handling different HTTP methods, and incorporating path variables or request parameters as needed.


## Returning Objects from Controller

In Spring Boot, controllers can return objects as responses. Here's how you can return a list of `Topic` objects from your controller:

1. **Create a Java Class:**

   Ensure you have a model class, for example, `Topic.java`, to represent the data you want to return.

```java
   import lombok.AllArgsConstructor;
   import lombok.Data;
   import lombok.NoArgsConstructor;

   @Data
   @AllArgsConstructor
   @NoArgsConstructor
   public class Topic {
       private Long id;
       private String name;
   }
```

2. **Create a Controller:**

Create a controller class, for example,` TopicController.java.` This controller will handle requests related to topics.

```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    List<Topic> topicList = List.of(
            new Topic(1L, "topic 1"),
            new Topic(2L, "topic 2"),
            new Topic(3L, "topic 3"),
            new Topic(4L, "topic 4"),
            new Topic(5L, "topic 5")
    );

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public ResponseEntity<List<Topic>> findTopics() {
        return ResponseEntity.status(HttpStatus.OK).body(topicList);
    }
}
```

3. **Access the Controller:**

After adding the controller, run your Spring Boot application. Open your web browser and navigate to http://localhost:8080/topics. You should see a JSON response containing the list of topics.

The URL` /topics` triggers the `findTopics` method in the `TopicController` class when accessed with a `GET `request.



## How Spring MVC Works

Spring MVC (Model-View-Controller) is a framework within the larger Spring framework that facilitates the development of web applications. It follows the MVC architectural pattern, which divides the application into three main components: Model, View, and Controller. Here's an overview of how Spring MVC works:

1. **Client Sends a Request:**

   When a user interacts with a web application (for example, by clicking a link or submitting a form), the client sends an HTTP request to the server.

2. **DispatcherServlet Handles the Request:**

   In a Spring MVC application, the central component for handling web requests is the `DispatcherServlet`. It acts as a front controller, intercepting incoming requests and dispatching them to the appropriate controllers.

3. **Controller Processes the Request:**

   The `Controller` is responsible for processing the request and returning a response. Controllers are typically annotated with `@Controller` and contain methods annotated with `@RequestMapping` to map URLs to specific actions.

   ```java
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.RequestMapping;
   import org.springframework.web.bind.annotation.RequestMethod;

   @Controller
   public class MyController {

       @RequestMapping(value = "/myEndpoint", method = RequestMethod.GET)
       public String handleRequest() {
           // Controller logic goes here
           return "viewName"; // Name of the view to be rendered
       }
   }
   ```

4. **Controller Returns a Model and View:**

The controller processes the request, performs any necessary business logic, and returns a ModelAndView object. The Model contains data that will be passed to the view for rendering, and the View is the template or page that will be displayed to the user.

```java
@RestController
public class MvcController {
    @RequestMapping(value = "/myEndpoint", method = RequestMethod.GET)
    public ModelAndView handleRequest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hello, Spring MVC!");
        modelAndView.setViewName("myView");
        return modelAndView;
    }
}
```

5. **ViewResolver Resolves the View:**

The `ViewResolver` is responsible for translating the logical view name returned by the controller into the actual view template. It resolves the view and renders the response.

6. **Response Sent to the Client:**

Finally, the `DispatcherServlet` sends the response back to the client, and the user sees the rendered view.


## Configuration

The application uses `application.properties` for configuration. Update the file to set your database properties, such as the URL, username, and password.

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## What is JPA?

Java Persistence API (JPA) is a Java specification for accessing, managing, and persisting data between Java objects and relational databases. It provides a standardized way to interact with databases using object-oriented approaches.

## Adding Spring Data JPA

Spring Data JPA is a part of the larger Spring Data project that makes it easy to implement JPA-based repositories. It provides a set of abstractions and default implementations for common database operations.


## Entities and Relationships

### Topics Entity
```java
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Topics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topicName;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Course> courseList = new ArrayList<>();
}
```

### Course Entity
```java
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    // ... (similar structure)
}
```

### Lesson Entity
```java
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lesson {
    // ... (similar structure)
}
```

## Repositories and Services

### Topics Repository
```java
@Repository
public interface TopicsRepository extends JpaRepository<Topics, Long> {
}
```

### Course Repository
```java
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
```

### Lesson Repository
```java
@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
```

### Topics Service Implementation
```java
@Service
@RequiredArgsConstructor
@Transactional
public class TopicServiceImpl implements TopicService {
    // ... (similar structure)
}
```

### Course Service Implementation
```java
@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService {
    // ... (similar structure)
}

```

### Lesson Service Implementation
```java
@Service
@RequiredArgsConstructor
@Transactional
public class LessonServiceImpl implements LessonService {
    // ... (similar structure)
}

```


## API Endpoints

### Topic Controller
```java
@RestController
@RequestMapping("/api/topic")
@RequiredArgsConstructor
public class TopicsController {
    // ... (similar structure)
}
```

### Course Controller
```java
@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {
    // ... (similar structure)
}
```

### Lesson Controller
```java
@RestController
@RequestMapping("/api/lesson")
@RequiredArgsConstructor
public class LessonController {
    // ... (similar structure)
}
```







