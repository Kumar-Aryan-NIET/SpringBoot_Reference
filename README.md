# Spring Boot Reference

![1](https://github.com/Kumar-Aryan-NIET/SpringBoot_Reference/assets/101974240/52e9ac5e-f260-4860-b453-5407dddbc6dd)
![2](https://github.com/Kumar-Aryan-NIET/SpringBoot_Reference/assets/101974240/0e361071-1361-4a46-bdc8-6f6c27ca0564)
![3](https://github.com/Kumar-Aryan-NIET/SpringBoot_Reference/assets/101974240/4bb17616-6097-4fbd-9336-47892bfa038c)
![4](https://github.com/Kumar-Aryan-NIET/SpringBoot_Reference/assets/101974240/917d5c45-ef0e-4cc4-9644-52786cd6df58)

Spring Framework is 
- an open-source application framework and 
- inversion of control container _for the Java platform._

Key features of Spring Framework include:

1. **Dependency Injection**: This is a design pattern that removes the dependency from the programming code. It makes the code easier to test and maintain.


2. **Aspect-Oriented Programming (AOP)**: This is a programming paradigm that aims to increase modularity by allowing the separation of cross-cutting concerns.


3. **Spring MVC**: This is a model-view-controller framework for building web applications.


4. **Spring Boot**: This is a project built on top of the Spring Framework. It provides an easier and faster way to set up, configure, and run both simple and web-based applications.


5. **Integration with other frameworks**: Spring Framework can be easily integrated with other popular frameworks like Hibernate, JPA, Struts, etc.


6. **Transaction Management**: Spring provides a consistent transaction management interface that can scale down to a local transaction (using a single database, for example) and scale up to global transactions (using JTA, for example).

Inversion of Control (IoC)
--------------------------
Inversion of Control (IoC) is 
- a design principle in software engineering 
- which inverts the flow of control as compared to traditional control flow. 

In traditional programming, 
- the custom code that expresses the purpose of the program 
  - calls into reusable libraries to take care of generic tasks, 
- but with _inversion of control_, 
  - it is the framework that calls into the custom, or task-specific, code.

In the context of the Spring Framework, IoC is implemented through Dependency Injection (DI). This means that objects are given their dependencies at creation time by some external entity that coordinates each object in the system. That is, dependencies are pushed into objects from outside.

This approach has several benefits:

1. **Decoupling**: The objects do not need to look up their dependencies, or even know where they are located. They are simply presented to them when they are instantiated. This leads to a high degree of decoupling.

2. **Easier to test**: Because dependencies are injected into objects, it's easy to inject mock dependencies for testing.

3. **More readable code**: Code is often more readable and easier to understand since there's no need for complicated setup procedures.

Here's a simple example of how IoC works in Spring:

```java
public class TextEditor {
    private SpellChecker spellChecker;

    // a spellChecker is injected via this constructor
    public TextEditor(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
```

In this example, `TextEditor` doesn't create a `SpellChecker` using a `new` keyword. Instead, it's being injected into `TextEditor` via the constructor, an example of Constructor-based Dependency Injection. This is the essence of Inversion of Control.


Spring Core
----
Spring Core is the fundamental part of the Spring Framework which 
- provides the Dependency Injection features. 

The core package uses the technique of Inversion of Control (IoC) that enables a Java application to use its components with dependencies. 

Essentially, the Spring Core is responsible for 
- creating the objects, 
- managing them (creating and deleting), 
- wiring them together, 
- configuring them, and 
- managing their complete lifecycle.

The Spring Core consists of the `BeanFactory`, 
- which is a sophisticated implementation of the factory pattern. 

_It removes the need for programmatic singletons and allows you to decouple the configuration and specification of dependencies from your actual program logic._

Here's a simple example of how Spring Core works:

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
      obj.getMessage();
   }
}
```

In this example, `Beans.xml` is the configuration file which contains the information of classes and how to wire them, and `HelloWorld` is a simple bean class. The `ApplicationContext` is a Spring container which instantiates, configures and assembles the beans by reading the configuration metadata from the XML file.

Application Context
---

`ApplicationContext` is a central interface within Spring Framework. It provides configuration for an application. This is read-only while the application is running, but may be reloaded if the implementation supports it. It inherits from `BeanFactory` interface and adds more enterprise-specific functionality on top of it.

In the context of Spring, a `Bean` is a normal Java object that is instantiated, assembled, and managed by a Spring IoC container. These beans are created with the configuration metadata that is supplied to the container, typically in the form of XML configuration files.

`ApplicationContext` is responsible for instantiating, configuring, and assembling these beans. The container gets its instructions on what objects to instantiate, configure, and assemble by reading configuration metadata provided. This metadata can be provided in XML, Java annotations, or Java code.

Here's a simple example of how `ApplicationContext` and `Bean` work together:

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
      obj.getMessage();
   }
}
```

In this example, `Beans.xml` is the configuration file which contains the information of classes and how to wire them, and `HelloWorld` is a simple bean class. The `ApplicationContext` is a Spring container which instantiates, configures and assembles the beans by reading the configuration metadata from the XML file.


Spring Dependency Injection
---

## **What is DI?**
The context of software development, a "dependency" typically 
- refers to a software component that is required by other components to perform their functions. 

For example, 

_a class might depend on a database connection to retrieve data._

Dependency Injection is a way to provide these dependencies to a component. 
- The component doesn't need to know how to create or locate the dependent objects. 
- Instead, the dependent objects are "injected" into the component by an external entity.

Dependency injection is the glue that 
- binds your application components together. 

Today developers expect to write concise, independent pieces of code for things such as microservices. 

_Dependency Injection-based applications gain readability and concision by reducing boilerplate code (e.g., manually configuring and gluing components together)_ 
  - while managing resources with a conventional and predictable execution strategy. 


**Code decoupling**
- Having discreet or non-overlapping packages in the overall function of an application simplifies processes. 

For example,

_if component A doesn't need to know how component B works,it shouldn't see inside component B, but rather, just how to interface with it_.

**Testability** 
- Decoupled code assists with testing efforts by reducing the surface area needed to test a component in isolation. 
- Also, mocking dependencies (with a mocking library) helps reduce noise in test cases.

**Maintainability** 

- Adherence to dependency injection means each component will be configured in one or more overarching configuration classes. 
- Therefore, the application resources are visible to the developer as code. 
- As such, a downstream developer will have better insights into the operation of the application and make better-informed changes.

Inversion of control
---

Spring’s Inversion of Control (IoC) container 
- _facilitates dependency injection throughout your application._ 

With IoC, you may achieve a low level of coupling because each managed component, also known as Spring beans, 
- can be specified in terms of IoC idioms, 
- such as property collaborators and constructors. 

The bean lifecycle (construction to destruction) is managed within this container and 
- provides the flexibility to name and create groupings of beans 
  - that are organized in self-contained configuration classes.

Let’s make a basic interaction with the IoC by defining a configuration class containing a single bean:

```java
@Configuration
public class AppConfig {

  @Bean
  DataSource myDataSource() {
      return new DataSource();
  }
}
```
By marking the class @Configuration, _we are telling the IoC to scan this class for additional bean creation opportunities._ 
This configuration class tells Spring IoC that a Datasource bean named "myDataSource" is to be created. 

_By default, Spring will attempt to name the bean by the method that created it._

**A useful dependency injection approach**

In most scenarios, we want to assemble a component that depends on other components. 

_Spring already goes through the correct processes to collect all dependencies_
- _and determine instantiating order and which components they belong to._ 

_However, it is up to the developer to inform Spring_ where _the dependencies get injected._ 

**constructor injection**

In the constructor injection technique, an object’s required components 
- become arguments on its constructor. 
- Spring will recognize public constructors as valid sites of injection. 
- This is also the preferred method since we are typically sure once an object gets created, its composition doesn't change. 
- This allows for immutability, however, it doesn't follow the JavaBeans style, which states an empty constructor.

```java
public class ComponentA {

ComponentB b;

  void ComponentA(ComponentB b) {
      this.b = b;
  }
}
```
The above represents construction injection. Setters are not forbidden but add boilerplate and lend to a mutable design, which may be discouraged.

Dependency injection guide
---
Getting started

The application you will build today is modeled around the idea of a blog. A blog is a place where you can write and publish new articles for others to read. You will be creating the backend (REST API) for the application which could be consumed by a frontend (client) later on. 

```java
// To create your application, head over to start.spring.io, 
// fill in the metadata about the project, and 
// select the Spring Web dependency.
```
![img.png](img.png)
```java
// When you’re done, click on the generate button at the bottom of the screen, 
// which will download a zipped file with the starting code for your project. 
// You can open that project in whatever text editor or IDE you’re comfortable with. 
// In this article, we are using IntelliJ IDEA.
```
**Create the REST API**
```java
// Create a new record named Article inside of a package named model. 
// An article will have properties such as an ID, title, content of the article, and the date/time it was published on.
```
```java
public record Article(
  Integer id,
  String title,
  String content,
  LocalDateTime publishedOn
) { ... }
```

With the model in place, you need a location to store all of the articles that you write for your blog. 

_In the real world, you would most likely use a database to house your articles, but for simplicity's sake, you will use an in-memory data structure in this guide._

```java
// Create a new class called ArticleRepository in a repository package. 
// The term repository comes from the repository pattern, 
// which you will see as you begin to build applications in Spring that take advantage of Spring Data.
```
```java
// In your repository, you will create a list that holds a collection of articles. 
// You will provide two methods: 
// one for returning all of the articles in the collection, and 
// another for returning a single article by the article ID.
```

```java
public class ArticleRepository {

    private List<Article> articles;

    public List<Article> findAll() {
        return articles;
    }

    public Article findById(Integer id) {
        return articles
                .stream()
                .filter(a -> a.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
```

You need a way to initialize the list of articles so that you have some sample data to work with. 

The constructor of a Java class is a great place to start. 

Create three new articles and add them to the collection of articles.

```java
public ArticleRepository() {
    articles = List.of(
            new Article(1, "Hello, World!", "Welcome to my new Blog!", LocalDateTime.now()),
            new Article(2, "Spring Initializr", "Get started with Spring Boot at start.spring.io", LocalDateTime.now()),
            new Article(3, "Spring Dependency Injection", "An introduction to Dependency Injection in Spring", LocalDateTime.now())
    );
}
```

With the domain model and repository in place, 
it's time to create the REST Controller. 
Create a new class named ArticleController in a package named controller. 
The controller suffix is not required but is a commonly used convention for creating controllers.

```java
// The @RestController annotation marks this class as one that will accept requests and return responses. 
// The @RequestMapping annotation allows you to map web requests to methods. 
// In the following example, you will map the article controller to the path /api/articles.

@RestController
@RequestMapping("/api/articles")
public class ArticleController {}
```


The controller needs a way to retrieve all of the articles in the application. 

```JAVA
// You should already have this in place by delegating that responsibility to the ArticleController. 
// This means that for your controller to work you are dependent on the ArticleRepository. 

// Now the question becomes: 
// how can you get an instance of the class that you already created?
```

```JAVA
// The basic constructs of the Java language give us a way to do this by creating a new instance of the ArticleRepository. 
// But now, where should you create this instance? 
// You are going to need this instance throughout your controller 
// so it might make sense to create an instance variable and initialize it in the constructor.

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

  private final ArticleRepository articles;

  public ArticleController(ArticleRepository articles) {
    this.articles = new ArticleRepository();
  }
}
```
Now that you have an instance of the ArticleRepository, you can use the methods that you created in it to return a list of articles, or just a single article.

```JAVA
@RestController
@RequestMapping("/api/articles")
public class ArticleController {

private final ArticleRepository articles;

public ArticleController(ArticleRepository articles) {
this.articles = new ArticleRepository();
}
  @GetMapping
  public List<Article> findAll() {
    return articles;
  }

  @GetMapping("/{id}")
  public Article findById(@PathVariable Integer id) {
    return articles
            .stream()
            .filter(a -> a.id().equals(id))
            .findFirst()
            .orElse(null);
  }
}
```

That is the basic structure of the blogging application you will work on within this guide. 

_If you run the application and visit http://localhost:8080/api/articles, you should see the following JSON returned in the response._

```JSON
[
  {
  "id": 1,
  "title": "Hello, World!",
  "content": "Welcome to my new Blog!",
  "publishedOn": "2022-09-28T15:05:49.226358"
  },
  {
  "id": 2,
  "title": "Spring Initializr",
  "content": "Get started with Spring Boot at start.spring.io",
  "publishedOn": "2022-09-28T15:05:49.226797"
  },
  {
  "id": 3,
  "title": "Spring Dependency Injection",
  "content": "An introduction to Dependency Injection in Spring",
  "publishedOn": "2022-09-28T15:05:49.226802"
  }
]
```
**_With that in place, we can talk about what dependency injection is and how it’s going to help us improve our application._**


### Create a controller unit test

This could be by informing us that our business logic is incorrect, the particular unit of code we are testing does more than it should, pointing out holes in the structure of our code, and so much more.

To ensure that your blog API is working properly, you will write a unit test for the controller. 
```java
// In a unit test, you focus specifically on the system under test (SUT), 
// which in this case is just the ArticleController.
```

This means that any dependencies (such as other classes, services, or repositories) should be mocked out. 
If your ArticleRepository talked to a real database, you wouldn’t want to include that part of the application in a test designed by the controller. 
When you start involving multiple parts of the application, you are actually writing integration tests.

If you write a simple unit test for the ArticleController, you might begin to see the problem.

```java
class ArticleControllerTest {

    ArticleController controller;

    @BeforeEach
    void setUp() {
        controller = new ArticleController();
    }

    @Test
    void shouldReturnAllArticles() {
        assertEquals(3, controller.findAll().spliterator().getExactSizeIfKnown());
    }

    @Test
    void shouldReturnArticleByIdWithValidId() {
        Article article = controller.findById(1);
        assertNotNull(article);
    }
}
```

When you create a new instance of the controller in the set up method, 
you call the ArticleController’s constructor. 

This will, in turn, create a new instance of the ArticleRepository thanks to the code you wrote earlier.
```java
@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleRepository articles;

    public ArticleController() {
        this.articles = new ArticleRepository();
    }
// ...

}
```
This gives us no way to mock or stub out the ArticleRepository in our unit test. 
Let’s compound the problem by adding on to our application.


