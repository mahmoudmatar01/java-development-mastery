# Core Spring Framework Tutorials

Welcome to the Spring Framework tutorials repository! This series is designed to provide you with a solid foundation in the Spring framework, a versatile and widely used framework for building Java-based enterprise applications. Let's dive into the Spring Framework tutorials:

## Table of Contents

1. [Spring Tutorial 00 - Introduction to Spring Framework ](#Spring-Tutorial-00---Introduction-to-Spring-Framework)
2. [Spring Tutorial 01 - Dependency Injection in Spring](#Spring-Tutorial-01---Dependency-Injection-in-Spring)
3. [Spring Tutorial 02 - Setting Up](#spring-tutorial-02---setting-up)
4. [Spring Tutorial 03 - Understanding Spring Bean Factory](#spring-tutorial-03---understanding-spring-bean-factory)
5. [Spring Tutorial 04 - ApplicationContext and Property Initialization](#spring-tutorial-04---applicationcontext-and-property-initialization)
6. [Spring Tutorial 05 - Using Constructor Injection](#spring-tutorial-05---using-constructor-injection)
7. [Spring Tutorial 06 - Injecting Objects](#spring-tutorial-06---injecting-objects)
8. [Spring Tutorial 07 - Inner Beans, Aliases, and Idref](#spring-tutorial-07---inner-beans-aliases-and-idref)
9. [Spring Tutorial 08 - Initializing Collections](#spring-tutorial-08---initializing-collections)
10. [Spring Tutorial 09 - Bean Autowiring](#spring-tutorial-09---bean-autowiring)
11. [Spring Tutorial 10 - Understanding Bean Scopes](#spring-tutorial-10---understanding-bean-scopes)
12. [Spring Tutorial 11 - Using ApplicationContextAware](#spring-tutorial-11---using-applicationcontextaware)
13. [Spring Tutorial 12 - Bean Definition Inheritance](#spring-tutorial-12---bean-definition-inheritance)
14. [Spring Tutorial 13 - Lifecycle Callbacks](#spring-tutorial-13---lifecycle-callbacks)
15. [Spring Tutorial 14 - Coding To Interfaces](#spring-tutorial-14---coding-to-interfaces)
16. [Spring Tutorial 15 - Introduction to Annotations and the `@Required` Annotation](#spring-tutorial-15---introduction-to-annotations-and-the-required-annotation)
17. [Spring Tutorial 16 - The `@Autowired` Annotation](#spring-tutorial-16---the-autowired-annotation)
18. [Spring Tutorial 17 - Component and Stereotype Annotations](#Spring-Tutorial-17---Component-and-Stereotype-Annotations)


## Spring Tutorial 00 - Introduction to Spring Framework 

### Overview

Welcome to the Spring Framework Tutorial 00: Introduction to Spring Framework. This tutorial provides a foundational understanding of the Spring framework, a robust and comprehensive framework for building Java-based enterprise applications. Let's delve into the key aspects of Spring.

### What is Spring?

**Spring** is an open-source framework for building enterprise applications in Java. It addresses the complexity of enterprise application development by providing a cohesive and modular infrastructure.

#### Key Features

1. **Inversion of Control (IoC):** In Spring, IoC is a core principle that shifts the control of program flow from the developer to the Spring container.
2. **Aspect-Oriented Programming (AOP):** Spring supports Aspect-Oriented Programming, allowing developers to modularize cross-cutting concerns like logging and security.
3. **Data Access:** Spring provides a consistent and simplified approach to data access through JDBC and Object-Relational Mapping (ORM) frameworks.
4. **Transaction Management:** Spring facilitates declarative transaction management, ensuring data integrity in database operations.
5. **Model-View-Controller (MVC):** Spring MVC is a powerful framework for building web applications following the Model-View-Controller architectural pattern.

### Core Concepts

1. **Inversion of Control (IoC):** In Spring, IoC is achieved by the Spring container, which manages the lifecycle of application objects.
2. **Dependency Injection (DI):** Dependency Injection is a key concept where the Spring container injects dependencies into a class, promoting loose coupling.

### Spring Ecosystem

1. **Spring Boot:** Spring Boot simplifies the process of building production-ready applications, providing defaults for application setup and enhanced features like embedded servers.
2. **Spring Data:** Spring Data simplifies data access, providing a consistent approach to data repositories.
3. **Spring Security:** Spring Security offers comprehensive security services for Java EE-based enterprise software applications.

### Example: Hello, Spring!

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, Spring!");
    }
}
```


## Spring Tutorial 01 - Dependency Injection in Spring

### What is Dependency Injection?

**Dependency Injection (DI)** is a design pattern used in software development, including Spring. It addresses the coupling between classes by allowing the inversion of control over their dependencies. In simpler terms, instead of a class creating its dependencies, they are injected from the outside.

### Advantages of Dependency Injection

1. **Loose Coupling:** Dependency Injection promotes loose coupling, making it easier to modify, extend, and test code. Changes in one part of the application don't necessarily impact other parts.

2. **Testability:** DI facilitates easier testing by allowing the substitution of real dependencies with mock or test dependencies during unit testing.

3. **Reusability:** Classes become more reusable as they are not tightly coupled to specific implementations of their dependencies.

### Dependency Injection in Spring

In Spring, DI is achieved through:

### Constructor Injection

```java
public class Car {
    private Engine engine;

    // Constructor Injection
    public Car(Engine engine) {
        this.engine = engine;
    }

    // ...
}
```

### Setter Injection
```java
public class Car {
    private Engine engine;

    // Setter Injection
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    // ...
}
```

### Example: Spring Dependency Injection
```java
public interface Engine {
    void start();
}

public class GasolineEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Gasoline engine started");
    }
}

public class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric engine started");
    }
}

public class Car {
    private Engine engine;

    // Constructor Injection
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
        System.out.println("Car started!");
    }
}
```
In this example, the Car class is injected with an Engine implementation, either GasolineEngine or ElectricEngine. This enables the flexibility to switch between different engine implementations without modifying the Car class.



## Spring Tutorial 02 - Setting Up

### Overview

Welcome to Spring Tutorial 02: Setting Up. In this tutorial, we'll guide you through the process of setting up your development environment for Spring framework development. Proper setup ensures a smooth development experience and allows you to leverage the full power of Spring for building robust Java applications.

### Prerequisites

Before setting up your Spring development environment, make sure you have the following prerequisites installed:

1. **Java Development Kit (JDK):** Spring is a Java-based framework, so you need to have JDK installed on your machine. You can download the latest version from [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) or use [OpenJDK](https://adoptopenjdk.net/).

2. **Integrated Development Environment (IDE):** Choose an IDE that suits your preferences. Popular choices include [Eclipse](https://www.eclipse.org/downloads/), [IntelliJ IDEA](https://www.jetbrains.com/idea/download/), or [Visual Studio Code](https://code.visualstudio.com/). Make sure your IDE supports Java development.

### Setting Up a Spring Project

Now, let's create a simple Spring project to verify your setup. Follow these steps:

### Step 1: Install Build Tool (Optional)

You can use a build tool like [Apache Maven](https://maven.apache.org/) or [Gradle](https://gradle.org/) to manage dependencies and build your project. If you don't have Maven or Gradle installed, consider installing one of them.

### Step 2: Create a Spring Project

#### Using Spring Initializr (Online)

1. Visit [Spring Initializr](https://start.spring.io/).
2. Choose your project settings, including project type, language (Java), Spring Boot version, and dependencies.
3. Click "Generate" to download the project ZIP file.

#### Using IDE (Eclipse as an example)

1. Open your IDE and create a new Maven or Gradle project.
2. Add the necessary Spring dependencies to your project configuration.

### Step 3: Verify Your Setup

Create a simple "Hello, Spring!" application. Here's an example using Spring Boot:

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication.class, args);
    }
}
```

### Step 4: Run the Application
Run your Spring application and navigate to http://localhost:8080 in your web browser. If everything is set up correctly, you should see a "Whitelabel Error Page" indicating that your Spring application is running.



## Spring Tutorial 03 - Understanding Spring Bean Factory

### Overview

Welcome to Spring Tutorial 03: Understanding Spring Bean Factory. This tutorial provides a comprehensive understanding of the Spring Bean Factory, a fundamental concept in the Spring framework.

### What is a Spring Bean Factory?

In Spring, a **Bean Factory** is responsible for managing and creating objects, commonly known as beans. These beans are the core building blocks of a Spring application and are handled by the Spring IoC (Inversion of Control) container.

### Key Concepts

#### 1. Bean Definition

A **bean definition** serves as a blueprint for creating an object in the Spring framework. It contains metadata about the bean, including its class, scope, constructor arguments, properties, and lifecycle callbacks.

#### 2. Bean Factory Container

The **Bean Factory Container** is the central interface for managing beans in a Spring application. It reads bean definitions, instantiates beans, and manages their lifecycle. Two main implementations are `XmlBeanFactory` and `ApplicationContext`.

#### 3. XML Configuration (Optional)

Bean definitions can be defined using XML configuration files, allowing for externalized bean configurations. This enhances separation of concerns and facilitates easy modification without altering the source code.

### Creating a Simple Bean

Let's create a simple example to understand the basics. Assume we have a `Car` class:

```java
public class Car {
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    public void start() {
        System.out.println("The " + brand + " car is starting.");
    }
}
```

Now, define a bean for this class in an XML configuration file (beans.xml):

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myCar" class="com.example.Car">
        <constructor-arg value="Toyota"/>
    </bean>

</beans>
```

Access the Spring Bean Factory in a Java application:

```java
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MainApp {

    public static void main(String[] args) {
        // Load the bean factory configuration
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));

        // Get the car bean
        Car myCar = (Car) factory.getBean("myCar");

        // Use the car
        myCar.start();
    }
}
```
In this example, we use the XmlBeanFactory to load the bean definitions from the beans.xml file. The getBean method is then used to retrieve the myCar bean, and finally, the start method of the Car class is invoked.



## Spring Tutorial 04 - ApplicationContext and Property Initialization

### Overview

Welcome to Spring Tutorial 04: ApplicationContext and Property Initialization. This tutorial explores the ApplicationContext in Spring and how it facilitates property initialization for beans.

### ApplicationContext

The ApplicationContext is an advanced container in Spring that extends the basic BeanFactory. It offers additional features such as property initialization, environment awareness, event propagation, and more.

#### Key Concepts

1. **Property Initialization:** The ApplicationContext allows properties of beans to be initialized using values from configuration files.

2. **ApplicationContext Types:** Different ApplicationContext implementations, such as `ClassPathXmlApplicationContext` and `FileSystemXmlApplicationContext`, provide various ways to load configurations.

### Property Initialization

Property initialization involves setting the values of properties in a bean using external configuration. The ApplicationContext provides a convenient way to achieve this.

#### Example

Assume you have a `Car` class with properties:

```java
public class Car {
    private String brand;
    private String model;

    // getters and setters
}
```
Define a bean for this class in an XML configuration file (beans.xml):
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myCar" class="com.example.Car">
        <property name="brand" value="Toyota"/>
        <property name="model" value="Camry"/>
    </bean>

</beans>
```
Access the ApplicationContext in a Java application:
```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        // Load the application context
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Get the car bean
        Car myCar = (Car) context.getBean("myCar");

        // Use the car
        System.out.println("Brand: " + myCar.getBrand());
        System.out.println("Model: " + myCar.getModel());
    }
}
```
The ApplicationContext in Spring provides a powerful mechanism for property initialization, making it easy to externalize and configure bean properties. This enables greater flexibility and ease of configuration in Spring applications.

In the upcoming tutorials, we'll explore more advanced topics related to Spring IoC containers and beans.



## Spring Tutorial 05 - Using Constructor Injection

### Overview

Welcome to Spring Tutorial 05: Using Constructor Injection. This tutorial explores the concept of constructor injection in the Spring framework, demonstrating how to wire dependencies between beans using this powerful technique.

### Constructor Injection

Constructor injection is a method of injecting dependencies into a class through its constructor. In Spring, it is a preferred way to achieve dependency injection, providing cleaner code and promoting immutability.

#### Key Concepts

1. **Dependency Injection:** The process of providing a dependent object (or service) to another object (or client) is known as dependency injection. Constructor injection is one of the approaches to achieve this in Spring.

2. **Constructor:** In Java, a constructor is a special method used for initializing objects. Constructor injection involves passing dependencies as parameters to the constructor.

### Example

Consider a `Car` class that depends on an `Engine`:

```java
public class Car {
    private final Engine engine;

    // Constructor Injection
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
        System.out.println("Car started!");
    }
}
```
And an Engine interface:
```java
public interface Engine {
    void start();
}
```
```java
// GasolineEngine.java
public class GasolineEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Gasoline engine started");
    }
}
```
```java
// ElectricEngine.java
public class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric engine started");
    }
}
```

Let's create bean definitions for these classes in an XML configuration file (beans.xml):

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define the Engine beans -->
    <bean id="gasolineEngine" class="com.example.GasolineEngine"/>
    <bean id="electricEngine" class="com.example.ElectricEngine"/>

    <!-- Define the Car beans with constructor injection -->
    <bean id="gasCar" class="com.example.Car">
        <constructor-arg ref="gasolineEngine"/>
    </bean>
    <bean id="electricCar" class="com.example.Car">
        <constructor-arg ref="electricEngine"/>
    </bean>

</beans>
```

Now, let's access the beans in a Java application:

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        // Load the application context
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Get the car beans
        Car gasCar = (Car) context.getBean("gasCar");
        Car electricCar = (Car) context.getBean("electricCar");

        // Use the cars
        gasCar.start();
        electricCar.start();
    }
}
```
In this example, the Car class receives an Engine dependency through constructor injection. Two different Engine implementations, GasolineEngine and ElectricEngine, are injected into two different Car instances.


## Spring Tutorial 06 - Injecting Objects

### Overview

Welcome to Spring Tutorial 06: Injecting Objects. This tutorial explores the various ways Spring allows you to inject objects into your beans, providing flexibility and ease of managing dependencies.

### Injecting Objects in Spring

Injecting objects into Spring beans is a common practice for managing dependencies and promoting loose coupling. Spring offers several mechanisms to achieve object injection, including constructor injection, setter injection, and autowiring.

#### Key Concepts

1. **Object Injection:** In the context of Spring, object injection refers to the process of providing an instance of an object to another object as a dependency.

2. **Ways to Inject Objects:** Spring supports various methods of injecting objects, including constructor injection, setter injection, and autowiring.

### Example

Consider a `Car` class that depends on an `Engine` and a `Driver`:

```java
public class Car {
    private final Engine engine;
    private final Driver driver;

    // Constructor Injection
    public Car(Engine engine, Driver driver) {
        this.engine = engine;
        this.driver = driver;
    }

    public void start() {
        engine.start();
        System.out.println("Car started by " + driver.getName());
    }
}
```
And a Driver class:
```java
public class Driver {
    private final String name;

    public Driver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```
Let's create bean definitions for these classes in an XML configuration file (beans.xml):
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define the Engine bean -->
    <bean id="gasolineEngine" class="com.example.GasolineEngine"/>

    <!-- Define the Driver bean -->
    <bean id="johnDriver" class="com.example.Driver">
        <constructor-arg value="John"/>
    </bean>

    <!-- Define the Car bean with constructor injection -->
    <bean id="car" class="com.example.Car">
        <constructor-arg ref="gasolineEngine"/>
        <constructor-arg ref="johnDriver"/>
    </bean>

</beans>
```
Now, let's access the beans in a Java application:
```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        // Load the application context
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Get the car bean
        Car car = (Car) context.getBean("car");

        // Use the car
        car.start();
    }
}
```
Injecting objects into Spring beans is a fundamental concept for managing dependencies. Whether through constructor injection, setter injection, or autowiring, Spring provides flexibility in configuring and managing the relationships between objects.


## Spring Tutorial 07 - Inner Beans, Aliases, and Idref

### Overview

Welcome to Spring Tutorial 07: Inner Beans, Aliases, and Idref. This tutorial explores advanced Spring concepts, including the use of inner beans, aliases, and the idref attribute, providing more control and flexibility in managing your bean configurations.

### Inner Beans

In Spring, an inner bean is a bean definition that is scoped to the enclosing bean and cannot be referenced from outside that bean. This is useful when a bean is used only within the context of another bean.

#### Example

Consider a `Car` class that has a nested `Engine`:

```java
public class Car {
    private final Engine engine;

    // Constructor with inner bean
    public Car(Engine engine) {
        this.engine = engine;
    }

    // Getter for Engine
    public Engine getEngine() {
        return engine;
    }
}
```
In the beans.xml configuration file:
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define the Car bean with an inner Engine bean -->
    <bean id="car" class="com.example.Car">
        <property name="engine">
            <bean class="com.example.Engine"/>
        </property>
    </bean>

</beans>
```
In this example, the Engine bean is an inner bean of the Car bean, meaning it is encapsulated within the Car bean and cannot be referenced from outside.


### Aliases

Aliases provide an additional name for a bean definition, allowing multiple names to refer to the same bean. This can be helpful for backward compatibility or providing alternative names for beans.

```xml
<bean id="car" class="com.example.Car"/>

<!-- Create an alias for the "car" bean -->
<alias name="automobile" alias="car"/>
```
In this example, both "car" and "automobile" refer to the same Car bean.


### Idref Attribute
The idref attribute is used to reference another bean by its id. This is particularly useful when you want to inject the id of one bean into another.

```xml
<bean id="driver" class="com.example.Driver"/>

<!-- Reference the "driver" bean using idref -->
<bean id="car" class="com.example.Car">
    <property name="driver" idref="driver"/>
</bean>
```
In this example, the driver property of the Car bean is set to the id of the Driver bean.



## Spring Tutorial 08 - Initializing Collections

### Overview

Welcome to Spring Tutorial 08: Initializing Collections. In this tutorial, we'll explore how Spring allows you to initialize collections such as lists, sets, and maps as bean properties, providing a convenient way to manage and inject complex data structures.

### Initializing Collections in Spring

Spring provides various ways to initialize collections within bean definitions. This is particularly useful when you need to inject a collection of values or other beans into a property of a Spring bean.

#### Initializing Lists

To initialize a list in Spring, you can use the `<list>` element in the XML configuration file. Here's an example:

```xml
<bean id="exampleBean" class="com.example.ExampleBean">
    <property name="exampleList">
        <list>
            <value>Value 1</value>
            <value>Value 2</value>
            <value>Value 3</value>
        </list>
    </property>
</bean>
```
In this example, the ExampleBean class has a property named exampleList of type List<String>, and it's initialized with three values.

#### Initializing Sets

For sets, you can use the <set> element:

```xml
<bean id="exampleBean" class="com.example.ExampleBean">
    <property name="exampleSet">
        <set>
            <value>Value A</value>
            <value>Value B</value>
            <value>Value C</value>
        </set>
    </property>
</bean>
```
In this case, the ExampleBean class has a property named exampleSet of type Set<String>.

#### Initializing Maps

To initialize maps, you can use the <map> element:

```xml
<bean id="exampleBean" class="com.example.ExampleBean">
    <property name="exampleMap">
        <map>
            <entry key="Key 1" value="Value X"/>
            <entry key="Key 2" value="Value Y"/>
            <entry key="Key 3" value="Value Z"/>
        </map>
    </property>
</bean>
```
Here, the ExampleBean class has a property named exampleMap of type Map<String, String>.

Initializing collections in Spring allows you to manage complex data structures within your bean configurations. Whether you're dealing with lists, sets, or maps, Spring provides a convenient and declarative way to define and inject these collections.



## Spring Tutorial 9 - Bean Autowiring

### Overview

Welcome to Spring Tutorial 9: Bean Autowiring. In this tutorial, we'll explore the concept of autowiring in Spring, a powerful feature that simplifies the configuration of bean dependencies by automatically injecting the required beans.

### What is Autowiring?

Autowiring is a feature in Spring that allows the automatic injection of bean dependencies without explicitly specifying them in the bean configuration file. Spring can automatically discover the relationships between beans and wire them together based on certain rules.

### Types of Autowiring

Spring supports several autowiring modes, each determining how beans are automatically wired together. The common autowiring modes include:

1. **No Autowiring (`autowire="no"`):** This is the default mode. It means no autowiring, and you need to explicitly specify bean dependencies.

2. **Autowiring by Type (`autowire="byType"`):** Spring looks for a single bean of the same type as the property, and if found, it injects it.

3. **Autowiring by Name (`autowire="byName"`):** Spring looks for a bean with a matching name as the property, and if found, it injects it.

4. **Autowiring by Constructor (`autowire="constructor"`):** Similar to autowiring by type but applies to constructor arguments.

### Autowiring by Name Example

Suppose you have the following classes:

```java
public class Engine {
    // Engine implementation
}
```
```java
public class Car {
    private Engine carEngine;

    private Engine engine;  // Corrected property name
}
```

Now, let's define the beans in the Spring configuration file with autowiring by name:

```xml
<!-- Define the Engine bean -->
<bean id="engine" class="com.example.Engine" />

<!-- Define the Car bean with autowiring by name -->
<bean id="car" class="com.example.Car" autowire="byName" />
```
In this example, Spring will automatically inject the Engine bean into the Car bean because the property name (carEngine) matches the name of the Engine bean (engine).


### Autowiring by Constructor Example

Suppose you have the following classes:

```java
public interface Engine {
    void start();
}
```
```java
public class GasolineEngine implements Engine {
    // GasolineEngine implementation
}
```
```java
public class ElectricEngine implements Engine {
    // ElectricEngine implementation
}
```
```java
public class Car {
    private final Engine carEngine;

    // Constructor with autowiring by constructor
    public Car(Engine carEngine) {
        this.carEngine = carEngine;
    }

    // Method using carEngine
    public void startCar() {
        carEngine.start();
    }
}
```

Now, let's define the beans in the Spring configuration file with autowiring by constructor:

```xml
<!-- Define the GasolineEngine bean -->
<bean id="gasolineEngine" class="com.example.GasolineEngine" />

<!-- Define the Car bean with autowiring by constructor -->
<bean id="car" class="com.example.Car" autowire="constructor" />
```

In this example, Spring will automatically inject the GasolineEngine bean into the Car bean's constructor because it matches the constructor parameter type (Engine).



## Spring Tutorial 10 - Understanding Bean Scopes

### Overview

Welcome to Spring Tutorial 10: Understanding Bean Scopes. In this tutorial, we'll delve into the concept of bean scopes in the Spring framework. Bean scope defines the lifecycle and visibility of a bean within the Spring container.

### Bean Scopes in Spring

Spring supports various bean scopes, each specifying how long a bean should live and when it should be created or destroyed. The common bean scopes include:

1. **Singleton Scope (Default):** The bean is a singleton within the Spring container, and there is only one instance for the entire application context.

2. **Prototype Scope:** A new instance of the bean is created every time it is requested.

3. **Request Scope:** The bean is created once per HTTP request. Applicable to web-aware Spring applications.

4. **Session Scope:** The bean is created once per HTTP session. Applicable to web-aware Spring applications.

5. **Application Scope:** The bean is created once per ServletContext. Applicable to web-aware Spring applications.

### Setting Bean Scope in Spring

You can specify the scope of a bean using the `scope` attribute in the bean definition.

### Example:

```xml
<!-- Singleton Scope (default) -->
<bean id="singletonBean" class="com.example.SingletonBean" />

<!-- Prototype Scope -->
<bean id="prototypeBean" class="com.example.PrototypeBean" scope="prototype" />

<!-- Request Scope -->
<bean id="requestBean" class="com.example.RequestBean" scope="request" />

<!-- Session Scope -->
<bean id="sessionBean" class="com.example.SessionBean" scope="session" />

<!-- Application Scope -->
<bean id="applicationBean" class="com.example.ApplicationBean" scope="application" />
```
In this example, SingletonBean has the default singleton scope, while PrototypeBean, RequestBean, SessionBean, and ApplicationBean have different custom scopes.


## Spring Tutorial 11 - Using ApplicationContextAware

### Overview

Welcome to Spring Tutorial 11: Using ApplicationContextAware. In this tutorial, we'll explore the ApplicationContextAware interface in the Spring framework and understand how it enables beans to gain awareness of the application context.

### ApplicationContextAware Interface

The ApplicationContextAware interface is part of the Spring framework and provides a mechanism for beans to be aware of the application context in which they are deployed. Beans that implement this interface can access the ApplicationContext and perform operations based on the context.

### Implementation Example

To use ApplicationContextAware, a bean needs to implement the interface and override the setApplicationContext method. This method is called by the Spring container during bean initialization, passing the ApplicationContext as an argument.

### Example:
Let's consider an example where a bean implements ApplicationContextAware to access another bean, specifically a Car bean, from within the application context.
```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBean implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) {
        this.applicationContext = context;
    }

    // Method to access the Car bean and perform an operation
    public void performCarOperation() {
        // Accessing the Car bean from the context
        Car car = applicationContext.getBean(Car.class);

        // Perform some operation using the Car bean
        System.out.println("Performing operation on the Car bean: " + car.start());
    }
}
```

In this example:

- MyBean implements the ApplicationContextAware interface.
- The setApplicationContext method is overridden to store the reference to the application context.
- The performCarOperation method demonstrates how to access the Car bean from the application context and perform an operation.

Assuming you have a Car class:

```java
public class Car {
    public String start() {
        return "Car started!";
    }
}
```

And your Spring configuration:

```xml
<bean id="myBean" class="com.example.MyBean" />

<bean id="car" class="com.example.Car" />
```

### Use Cases
- Accessing Other Beans: Beans can use the ApplicationContext to obtain references to other beans in the application context.

- Dynamic Bean Configuration: Beans can dynamically configure themselves or perform operations based on the context information.

The ApplicationContextAware interface is a powerful tool for beans that need access to the broader application context. It allows for dynamic interactions and collaborations between beans within a Spring application.



## Spring Tutorial 12 - Bean Definition Inheritance

### Overview

Welcome to Spring Tutorial 12: Bean Definition Inheritance. In this tutorial, we'll explore the concept of bean definition inheritance in the Spring framework. Bean definition inheritance allows one bean definition to inherit configurations from another, promoting code reuse and maintainability.

### Bean Definition Inheritance in Spring

Inheritance in Spring involves creating a parent-child relationship between bean definitions. The child bean inherits the configuration of the parent bean and can customize or override specific settings.

### Implementation Example

Consider the following example with a parent bean definition:

```xml
<!-- Parent Bean Definition -->
<bean id="parentBean" class="com.example.ParentBean">
    <property name="property1" value="defaultValue1" />
    <property name="property2" value="defaultValue2" />
</bean>
```

Now, let's create a child bean definition that inherits from the parent:

```xml
<!-- Child Bean Definition -->
<bean id="childBean" class="com.example.ChildBean" parent="parentBean">
    <property name="property1" value="customValue1" />
</bean>
```
In this example, the childBean inherits the properties property1 and property2 from parentBean. Additionally, it overrides property1 with a custom 

### Use Cases
- Code Reusability: Bean definition inheritance promotes code reuse by allowing common configurations to be defined in a parent bean.

- Customization: Child beans can customize or override specific properties or settings inherited from the parent.

Bean definition inheritance in Spring provides a powerful mechanism for structuring and organizing bean configurations. It encourages a modular and maintainable configuration strategy, especially when dealing with similar beans that share common settings.



## Spring Tutorial 13 - Lifecycle Callbacks

### Overview

Welcome to Spring Tutorial 13: Lifecycle Callbacks. In this tutorial, we'll explore the lifecycle callbacks in the Spring framework. Lifecycle callbacks allow beans to execute custom logic during different phases of their lifecycle, such as initialization and destruction.

### Bean Lifecycle in Spring

The lifecycle of a Spring bean involves several phases:

1. **Instantiation:** The bean is created.
2. **Population of Properties:** Bean properties are set.
3. **BeanPostProcessor:** If registered, BeanPostProcessor methods are called.
4. **Initialization Callbacks:** Custom initialization methods are invoked.
5. **Bean Ready for Use:** The bean is now ready for use.
6. **Destruction Callbacks:** Custom destruction methods are invoked during bean destruction.

### Initialization Callbacks

#### InitializingBean Interface

The `InitializingBean` interface provides a method, `afterPropertiesSet()`, which is called by the Spring container after property population. Example:

```java
import org.springframework.beans.factory.InitializingBean;

public class MyBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() {
        // Custom initialization logic
    }
}
```

### @PostConstruct Annotation

The @PostConstruct annotation can be used on a method to indicate that it should be invoked after properties are set. Example:

```java
import javax.annotation.PostConstruct;

public class MyBean {

    @PostConstruct
    public void customInit() {
        // Custom initialization logic
    }
}
```

### Destruction Callbacks

#### DisposableBean Interface

The DisposableBean interface provides a method, destroy(), which is called during bean destruction. Example:

```java
import org.springframework.beans.factory.DisposableBean;

public class MyBean implements DisposableBean {

    @Override
    public void destroy() {
        // Custom destruction logic
    }
}
```

### @PreDestroy Annotation

The @PreDestroy annotation can be used on a method to indicate that it should be invoked before the bean is destroyed. Example:
```java
import javax.annotation.PreDestroy;

public class MyBean {

    @PreDestroy
    public void customDestroy() {
        // Custom destruction logic
    }
}

```
Lifecycle callbacks provide a way to execute custom logic during different phases of a bean's lifecycle. Choosing the appropriate method depends on your preference and whether you prefer interface-based or annotation-based configuration.



## Spring Tutorial 14 - Coding To Interfaces

In Spring Tutorial 14, we explore the fundamental design principle of "Coding To Interfaces." This approach enhances the flexibility, modularity, and maintainability of Spring applications by encouraging developers to program against interfaces instead of concrete implementations. The tutorial discusses the benefits of this practice and provides a hands-on example of implementing coding to interfaces in a Spring project.

### Benefits of Coding To Interfaces in Spring

1. **Flexibility:**
   - Programming against interfaces allows for seamless substitution of implementations, promoting adaptability in the application.

2. **Modularity:**
   - Interfaces define clear contracts between components, leading to a modular design that facilitates maintenance.

3. **Dependency Injection (DI):**
   - Coding to interfaces enables Spring to perform dependency injection, simplifying component management and testing.

4. **Unit Testing:**
   - The use of interfaces facilitates unit testing by allowing the creation of mock implementations for testing purposes.

### Example: Coding To Interfaces in Spring

### Step 1: Define an Interface

```java
public interface UserService {
    User getUserById(String userId);
}
```

### Step 2: Create a Concrete Implementation

```java
public class DatabaseUserService implements UserService {
    public User getUserById(String userId) {
        // Implementation to retrieve user from a database
    }
}
```

### Step 3: Configuration in Spring

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define the bean using the interface -->
    <bean id="userService" class="com.example.DatabaseUserService" />
</beans>

```

### Step 4: Using the Service

```java
public class UserController {
    private final UserService userService;

    // Constructor injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void displayUserInfo(String userId) {
        User user = userService.getUserById(userId);
        // Display user information
    }
}
```
Coding to interfaces is a fundamental practice in Spring development, enhancing the maintainability and flexibility of applications. By adopting this approach, developers can create modular and testable components, leading to a robust and adaptable application architecture.



## Spring Tutorial 15 - Introduction to Annotations and the `@Required` Annotation

### Overview

This topic contains documentation for Spring Tutorial 15, providing an introduction to annotations in the Spring Framework and focusing on the usage of the `@Required` annotation. Annotations play a crucial role in simplifying configuration and expressing metadata about application components. The `@Required` annotation is specifically explored in this tutorial, highlighting its importance in enforcing the requirement of specific properties during bean initialization.

### Introduction to Annotations

Annotations in Spring are markers added to Java classes, methods, or fields to provide additional information to the Spring container. They simplify configuration and enhance the readability of the code. Commonly used annotations in Spring include `@Component`, `@Autowired`, `@Service`, and `@Repository`.

### The `@Required` Annotation

The `@Required` annotation is used to indicate that the affected bean property must be populated during bean initialization. If the required property is not set, the Spring container throws a `BeanInitializationException`.

### Usage Example

Consider a class representing a `Person` with a required property `name`. We can use the `@Required` annotation to ensure that the `name` property is set before the bean is fully initialized.

```java
import org.springframework.beans.factory.annotation.Required;

public class Person {
    private String name;

    @Required
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

### MainApp.java

```java
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        try {
            // Attempt to get the Person bean
            Person person = (Person) context.getBean("person");

            // Display the person's name
            System.out.println("Person's Name: " + person.getName());
        } catch (BeanInitializationException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            context.close();
        }
    }
}
```

### applicationContext.xml

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define the Person bean -->
    <bean id="person" class="Person" />

</beans>
```


In this example, the Person class has a name property marked with the @Required annotation. The MainApp class attempts to retrieve the Person bean from the Spring container. If the name property is not set in the XML configuration, a BeanInitializationException will be thrown.



## Spring Tutorial 16 - The `@Autowired` Annotation

This topic contains documentation for Spring Tutorial 16, which provides an in-depth exploration of the `@Autowired` annotation in the Spring Framework. The tutorial focuses on the usage and benefits of `@Autowired` for automatic dependency injection, simplifying configuration and improving code readability.

### Introduction to `@Autowired`

The `@Autowired` annotation is a powerful feature in Spring, enabling automatic dependency injection. It eliminates the need for explicit bean wiring in the Spring configuration file, promoting cleaner code and improved maintainability. This tutorial explores the various aspects of `@Autowired` and its role in simplifying dependency injection in Spring.

### Usage of `@Autowired`

#### Field Injection

```java
import org.springframework.beans.factory.annotation.Autowired;

public class CarService {
    @Autowired
    private Engine engine;

    // other methods
}
```

#### Constructor Injection

```java
import org.springframework.beans.factory.annotation.Autowired;

public class CarService {
    private final Engine engine;

    @Autowired
    public CarService(Engine engine) {
        this.engine = engine;
    }

    // other methods
}
```

#### Setter Injection

```java
import org.springframework.beans.factory.annotation.Autowired;

public class CarService {
    private Engine engine;

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    // other methods
}
```

#### Method Injection

```java
import org.springframework.beans.factory.annotation.Autowired;

public class CarService {
    private Engine engine;

    @Autowired
    public void injectEngine(Engine engine) {
        this.engine = engine;
    }

    // other methods
}
```

### Qualifiers with `@Autowired`
When multiple beans of the same type exist in the container, the @Autowired annotation may cause ambiguity. In such cases, you can use the @Qualifier annotation to specify the exact bean to be injected.
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CarService {
    @Autowired
    @Qualifier("v8Engine")
    private Engine engine;

    // other methods
}
```

Engine.java (Interface)

```java
public interface Engine {
    String start();
}

// V8Engine class
public class V8Engine implements Engine {
    public String start() {
        return "V8 Engine started";
    }
}

// V6Engine class
public class V6Engine implements Engine {
    public String start() {
        return "V6 Engine started";
    }
}
```

### XML Configuration
The applicationContext.xml file provides XML-based configuration for the Spring beans used in this tutorial.

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- Enable annotation-based configuration -->
    <context:annotation-config />

    <!-- Define the Engine bean -->
    <bean id="v6Engine" class="com.example.V6Engine" />
    <bean id="v8Engine" class="com.example.V8Engine" />

    <!-- Define the CarService bean -->
    <bean id="carService" class="com.example.CarService" />

</beans>
```
In this example, the context:annotation-config element is used to enable annotation-based configuration in the Spring application context. The CarService class, which uses the @Autowired annotation for dependency injection, will automatically have its dependencies injected by Spring.

Make sure to replace the package and class names (com.example.V6Engine, com.example.V8Engine, com.example.CarService) with the appropriate names used in your project.

Additionally, ensure that you have the required Spring libraries in your project, and the classes and interfaces (Engine, V6Engine, V8Engine, CarService) are correctly implemented in your codebase.




## Spring Tutorial 17 - Component and Stereotype Annotations

### Overview

This repository contains documentation for Spring Tutorial 17, focusing on Component and Stereotype Annotations in the Spring Framework. These annotations are essential for simplifying bean configuration and promoting a more modular and readable code structure. Explore the usage of Component and Stereotype Annotations to enhance your Spring application development.

### Introduction to Component and Stereotype Annotations
In Spring, Component and Stereotype annotations are part of the stereotype annotations that help define and configure beans. These annotations reduce the need for explicit bean definitions in XML configuration files, promoting a more concise and readable codebase.

### The `@Component` Annotation
The @Component annotation is a generic stereotype annotation used to identify a Spring bean. It indicates that the class is a Spring component and should be managed by the Spring container.

#### Example: Creating a Component
```java
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    // Class implementation
}
```
In this example, the MyComponent class is annotated with @Component, making it a Spring-managed component. The Spring container will automatically detect and register this class as a bean.

### Stereotype Annotations
Spring provides several specialized stereotype annotations, including `@Repository`, `@Service`, and `@Controller`. These annotations are used to define beans with specific roles in the application.

- @Repository: Used to indicate that the annotated class is a Data Access Object (DAO) component.
- @Service: Used to indicate that the annotated class is a service component.
- @Controller: Used to indicate that the annotated class is a controller component (typically for Spring MVC).

### Example: Using Stereotype Annotations
```java
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Controller;

@Repository
public class MyRepository {
    // Repository implementation
}

@Service
public class MyService {
    // Service implementation
}

@Controller
public class MyController {
    // Controller implementation
}
```
In this example, three classes are annotated with specific stereotype annotations (@Repository, @Service, and @Controller). Each annotation provides additional information about the role of the bean in the application.

### Custom Stereotype Annotations
Using a custom stereotype annotation in Spring involves creating a custom annotation and then applying it to classes in your Spring project. Here's a step-by-step guide on how to use a custom stereotype annotation:

#### Step 1: Create a Custom Stereotype Annotation
```java
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyCustomComponent {
    // Optional additional elements for customization
}
```
In this example, MyCustomComponent is a custom stereotype annotation. It is annotated with @Component, allowing the annotated classes to be detected and registered by the Spring container.

#### Step 2: Apply the Custom Stereotype Annotation

Apply the @MyCustomComponent annotation to a class to mark it as a Spring component.

```java
@MyCustomComponent
public class CustomComponent {
    // Class implementation
}
```
Now, CustomComponent is a Spring component and will be automatically detected by the Spring container.

#### Step 3: Enable Component Scanning
Ensure that component scanning is enabled in your Spring configuration. This allows the Spring container to automatically discover and register components marked with your custom stereotype annotation.

In your Spring configuration class (typically annotated with @Configuration), include the following:
```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example") // Replace with your base package
public class AppConfig {
    // Additional configuration if needed
}
```
Replace "com.example" with the base package of your application. Component scanning will search for components within this package and its sub-packages.

#### Step 4: Run the Application

With the custom stereotype annotation applied and component scanning enabled, run your Spring application. The Spring container should detect and register the class marked with your custom stereotype annotation.

```java
public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the bean marked with your custom stereotype annotation
        CustomComponent customComponent = context.getBean(CustomComponent.class);

        // Access methods or properties of the custom component
        customComponent.doSomething();

        // Close the application context
        context.close();
    }
}
```
Replace doSomething() with actual methods or properties of your custom component.
Now, your custom stereotype annotation is successfully used to mark and register Spring components in your application.




