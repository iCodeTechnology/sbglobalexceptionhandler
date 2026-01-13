# SB Global Exception Handler

A reusable Spring Boot library for centralized exception handling.  
This library provides a common Global Exception Handler that can be used across multiple Spring Boot projects as a Maven dependency.

---

## Purpose

- Avoid writing duplicate `@ControllerAdvice` in every project
- Standardize API error responses
- Handle validation, business, and system exceptions centrally

---

## Features

- Global exception handling using `@ControllerAdvice`
- Supports validation errors (`@Valid`)
- Supports custom business exceptions (`ApiException`)
- Handles runtime and system exceptions
- Auto-configured using Spring Boot auto-configuration

---

## Maven Dependency

```xml
<dependency>
    <groupId>com.icodetech</groupId>
    <artifactId>sbglobalexceptionhandler</artifactId>
    <version>1.0</version>
</dependency>
```

## ⚙️ Auto Configuration

- This library uses Spring Boot AutoConfiguration.
- You do NOT need to add any @ControllerAdvice in your project.
- Auto-configuration class:
```text
GlobalExceptionAutoConfiguration
```
---

## Use Annotation in Main Application Class
📌 Application.java

```java
@SpringBootApplication
@EnableGlobalExceptionHandling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

---

## 🧩 Supported Exceptions

1️⃣ Validation Errors
- Triggered when @Valid fails.
- Example DTO:
```java
public class TestRequest {

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotNull(message = "age is required")
    private Integer age;
} 
```
- Controller:
```java
@PostMapping("/validate")
public String validate(@Valid @RequestBody TestRequest request) {
    return "SUCCESS";
} 
```

- Response:
```json
{
  "responseCode": 400,
  "responseMessage": "Validation Errors",
  "errors": [
    {
      "fieldName": "name",
      "message": "name is mandatory"
    },
    {
      "fieldName": "age",
      "message": "age is required"
    }
  ]
}
```

2️⃣ Business Exception (ApiException)
- Throw anywhere in your code:
```text
throw new ApiException(HttpStatus.BAD_REQUEST, "Invalid business rule");
```
- Response:
```json
{
  "responseCode": 400,
  "responseMessage": "Invalid business rule",
  "errors": {
    "message": "Invalid business rule"
  }
}
```

3️⃣ System / Runtime Exception
- Example:
```text
String value = null;
value.toString();
```
- Response:
```json
{
  "responseCode": 400,
  "responseMessage": "Error occurred",
  "errors": {
    "message": "Cannot invoke \"String.toString()\" because \"value\" is null"
  }
}
```

🚫 What NOT to Do
- ❌ Do NOT create your own @ControllerAdvice
- ❌ Do NOT override exception handling in consumer projects

The library handles everything automatically.

---

## 🔍 Debugging Auto Configuration

Enable logs:
```properties
logging.level.org.springframework.boot.autoconfigure=DEBUG
```

Startup log should contain:
```text
GlobalExceptionAutoConfiguration matched
```

---

## 🧠 Supported Exception Types

- ApiException
- MethodArgumentNotValidException
- HttpMessageNotReadableException
- MissingServletRequestParameterException
- MethodArgumentTypeMismatchException
- TypeMismatchException
- NoHandlerFoundException
- SQLIntegrityConstraintViolationException
- RuntimeException
- Exception

---

## 🛠️ Tech Stack

- Java 8+
- Spring Boot 2.7.x
- Maven

---

## 📄 License
MIT License

---

## 👨‍💻 Author

iCode Technology

---

## 🛣️ Roadmap

- Spring Boot 3.x support
- Error code enum support
- Property-based enable/disable
- RFC 7807 (Problem Details) support
- Logging & trace-id integration
