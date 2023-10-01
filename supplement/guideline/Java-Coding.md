# Java Coding Guidelines

This document is designed for coding in the consistence way throughout entire e-commerce platform.
It provides the way how components should be designed, implemented and to restrict language syntax.

## Design Rules

### General

1. Remove **unused imports**.
2. **Format** the code before every commit.
3. Add Javadocs only for important ones:
    - all interfaces
    - code with complex business logic
    - anywhere it makes sense
4. Use interfaces instead of specific implementations as data types whenever possible.
5. Use java naming convention.
6. Return `Collections.emptyList()`, `Collections.emptySet()`, `Collections.singletonList()` etc over the `null` value.
7. Use `Objects` whenever possible.

### Code Formatting

1. Use the [bundled code formatter](./formatting/.editorconfig) settings.
2. Use brackets for **control structures** (`if`, `for`, `while`, etc.).

### Documentation

1. Comments should be written in **English**
2. JavaDoc should be started with a **capital letter** and ended with a **dot**.
3. Use multi-line comments over C++-style comments:
   ```java
    // Bad comment
    
    /**
     * Good comment
     */
    ```
4. For `@param`, `@throws`, and `@return` tag descriptions:
   - *No dots* at the end of a comment.
   - *Don't start* comments with a capital letter or delimiter.
   - Start the `@param` and `@return` comments with **the** or **a** resp. **an**.
   - Start the `@throws` with **if** or **in case**.
   - For the unchecked exceptions `@throws` should be present as well.
5. Unchecked exceptions should be documented.
6. In case `null` is a valid return value should be documented additionally.
7. In case `null` is a valid parameter value should be documented additionally.

### Lombok

1. Use Lombok to reduce boilerplate whenever is possible.
2. Don't use experimental features. 
3. Use `@NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor` whenever you need constructors.
4. Don't use shortcuts `@Data`, `@Value`.
5. Don't use `@SneakyThrows`.
6. Use `@NonNull` if param shouldn't be the `null`.

### Logging 

1. Don't use **System.out** and et cetera to log.
2. Use **lombok.extern.slf4j.Slf4j** to log.
3. Use log levels according to the [logging guideline](./Logging.md#log-levels).
4. Use **log format** over the **string concatenation**.
5. Don't use **spaces**, **tabs** or any kind of indention in log messages
   ```java
   log.info("There is correct log message.");
   log.info("---> There is incorrect log message <---");
   log.info("     There is incorrect log message     ");
   ```
6. One line per log message, don't **split** information across multiple line.
7. Use log levels to mark message importance, not **exclamation marks**.
8. Pass the `Exception` object along with the message whenever applicable.

Also, see [logging guideline](./Logging.md).

### Exception Handling 

1. Always provide **message** and **cause** of exception when throwing.
2. On the critical error try to **throw** the exception and do handle on the highest possible level.
3. All close or cleanup operation should be done in a `finally` block.

### Multithreading

### Utility Classes 

The **Utility Class** should always be implemented as a **final** class 
to avoid inheritance. Furthermore, it should overwrite the default constructor 
with a private one. The Utility Class should expose only `static` methods.

### Malicious

1. Hide secrets when override `Object#toString()` method.

## To Be Discussed

1. Using interfaces whenever possible **General point 4**.
2. Using **final** whenever possible.
3. Using **var** keyword.
4. Using **switch** statement.
5. Using **Unchecked Exceptions** over **Checked Exception**.
6. **General point 3** to be extended if needed. 
7. Using **record** keyword.
8. Handling general exceptions, e.g. 
   ```java
   try {
   
   } catch (Exception ex) {
   
   }
   ```
9. Multithreading module
10. Using lombok **val**. 
11. Immutability over mutability
