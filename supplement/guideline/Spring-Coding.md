# Spring Coding Guidelines

## To be discussed

- Field vs Constructor vs Setter injection
```java
@Autowired 
private Service service;
```

```java
private final Service service;

@Autowired
public NestedService(Service service) {
    this.service = service;
}
```

```java
private Service service;

@Autowired
public setService(Service service) {
    this.service = service;
}
```

- @PostConstruct vs Default Constructor

- @EntityGraph vs @Query vs @NativeQuery

- Templates or Repositories
