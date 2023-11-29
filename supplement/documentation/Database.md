# Database
Database structure based on [requirements](./Requirements.md).

## Diagram

![entire ER diagram](./diagram/)

## Conventions

- Table Names
    - Singular
    - Separate words with underscores
- Primary Keys
    - A single column, do not use composite keys
- Table fields
    - If applicable table should have `updated_at`, `created_at` fields
    - Fields that store the time should have `at` prefix\postfix
- Constraints
    - Any redundant constrains, e.g. unique for PK

## Database-Per-Service Pattern
This pattern allows for better separation of concerns, data isolation, and scalability.
Each microservice manages its data independently.
The Pattern enforces this by allocating a separate database for each microservice.

Benefits:

- Data schema flexibility: easy to change schema without impacting other microservices
- Security: preventing accidental or unauthorized access to another service’s data
- Scalability: each database can be scaled independently
- Loose coupling: domain data is encapsulated within the service
- Polyglot persistence: each service choose the technology based on its own requirements
- Fault-tolerance: when database is down it has no impact for other services

Drawbacks:

- Inconsistency: harder to ensure data consistency between different services
- Data exchange: needed to define clear api for data exchange
- Data duplication: data may duplicate in different services and may obsolete
- Slow down app: since you need to communicate through network to join some data
- Low transaction abilities: spanning transactions across microservices can negatively impact consistency and atomicity

> The service’s database can’t be accessed directly by other microservices.
> Should be used the designed API for this purpose, e.g. REST Api.

## Services

| Table       | Description                                              | Relations                                     |
|-------------|----------------------------------------------------------|-----------------------------------------------|
| user        | represents a registered user of the e-commerce platform  | 1-1 profiles <br/> 1-1 carts <br/> 1-n orders |
| profile     | stores additional user profile information               | 1-1 users                                     |
| product     | represents a product for sale                            | 1-1 inventories <br/> n-n carts               |
| cart        | represents a user's shopping cart                        | 1-1 users <br/> n-n products                  |
| order       | represents a customer's order                            | 1-n items <br/> 1-n users <br/> 1-n methods   |
| item        | represents an item within an order                       | 1-n orders <br/> 1-n products                 |
| transaction | represents a financial transaction                       | 1-n methods <br/> 1-1 orders <br/> 1-n users  |
| method      | stores information about payment methods                 | 1-n transactions <br/> 1-n orders             |
| inventory   | represents an inventory of a product                     | 1-1 products                                  |
| warehouse   | represents an warehouse that stores multiple inventories | 1-n inventories                               |

### Ecommerce User Management Service (EUMS)

| table | attribute  | type     | constraint | key |
|-------|------------|----------|------------|-----|
| user  | user_id    | int      | `-`        | PK  |
|       | username   | string   | `-`        |     |
|       | role       | string   | `-`        |     |
|       | email      | string   | `-`        |     |
|       | password   | string   | `-`        |     |
|       | created_at | datetime | `-`        |     |
|       | profile_id | int      | `-`        | FK  |

| table     | attribute  | type | constraint | key |
|-----------|------------|------|------------|-----|
| profile   | profile_id | int  | `-`        | PK  |
|           | user_id    | int  | `-`        | FK  |

| Database Type         | Explanation                                                                                             |
|-----------------------|---------------------------------------------------------------------------------------------------------|
| SQL (e.g. PostgreSQL) | Storing user data, profiles, and authentication details often benefits from relational data structures. |
| NoSQL (e.g. Redis)    | Expiry mechanism (TTL) for user sessions and low latency.                                               |

### Ecommerce Product Catalog Service (EPCS)

| table    | attribute    | type     | constraint | key |
|----------|--------------|----------|------------|-----|
| product  | product_id   | int      | `-`        | PK  |
|          | name         | string   | `-`        |     |
|          | description  | string   | `-`        |     |
|          | image        | string   | `-`        |     |
|          | price        | decimal  | `-`        |     |
|          | category     | string   | `-`        |     |
|          | created_at   | datetime | `-`        |     |
|          | updated_at   | datetime | `-`        |     |
|          | inventory_id | int      | `-`        | FK  |

| Database Type            | Explanation                                                                           |
|--------------------------|---------------------------------------------------------------------------------------|
| NoSQL (e.g. MongoDB)     | Flexible schema for handling various product attributes and allowing for scalability. |
| Object Storage (e.g. S3) | Storing images with high data availability.                                           |

### Ecommerce Order Management Service (EOMS)

| table | attribute          | type     | constraint | key |
|-------|--------------------|----------|------------|-----|
| order | order_id           | int      | `-`        | PK  |
|       | status             | string   | `-`        |     |
|       | total              | decimal  | `-`        |     |
|       | shipping_address   | string   | `-`        |     |
|       | postal_tracking_id | string   | `-`        |     |
|       | payment_method     | string   | `-`        |     |
|       | created_at         | datetime | `-`        |     |
|       | updated_at         | datetime | `-`        |     |
|       | updater            | string   | `-`        |     |
|       | item_id            | int      | `-`        | FK  |
|       | user_id            | int      | `-`        | FK  |

| table | attribute  | type    | constraint | key |
|-------|------------|---------|------------|-----|
| item  | item_id    | int     | `-`        | PK  |
|       | order_id   | int     | `-`        | FK  |
|       | product_id | int     | `-`        | FK  |
|       | quantity   | int     | `-`        |     |
|       | price      | decimal | `-`        |     |

| Database Type         | Explanation                                                                                                                                |
|-----------------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| SQL (e.g. PostgreSQL) | Orders often have well-defined structures with relationships to users and products. SQL databases handle such structured data efficiently. |

### Ecommerce Payment Gateway Service (EPGS)

| table       | attribute      | type    | constraint | key |
|-------------|----------------|---------|------------|-----|
| transaction | transaction_id | int     | `-`        | PK  |
|             | user_id        | int     | `-`        | FK  |
|             | order_id       | int     | `-`        | FK  |
|             | amount         | decimal | `-`        |     |
|             | status         | string  | `-`        |     |
|             | expired        | boolean | `-`        |     |
|             | method_id      | int     | `-`        | FK  |

| table  | attribute | type   | constraint | key |
|--------|-----------|--------|------------|-----|
| method | method_id | int    | `-`        | PK  |
|        | type      | string | `-`        |     |

| Database Type         | Explanation                                                                                        |
|-----------------------|----------------------------------------------------------------------------------------------------|
| SQL (e.g. PostgreSQL) | Transactional data like payments requires ACID compliance, making SQL databases a suitable choice. |

### Ecommerce Shopping Cart Service (ESCS)

| table | attribute   | type     | constraint | key |
|-------|-------------|----------|------------|-----|
| cart  | cart_id     | int      | `-`        | PK  |
|       | user_id     | int      | `-`        | FK  |
|       | product_ids | int[]    | `-`        | FKs |
|       | updated_at  | datetime | `-`        |     |

| Database Type        | Explanation                                                                                                                              |
|----------------------|------------------------------------------------------------------------------------------------------------------------------------------|
| NoSQL (e.g. MongoDB) | Cart data can be transient and often involves complex structures like nested items. NoSQL databases are suitable for handling such data. |

### Ecommerce Inventory Management Service (EIMS)

| table     | attribute    | type     | constraint | key |
|-----------|--------------|----------|------------|-----|
| warehouse | warehouse_id | int      | `-`        | PK  |
|           | address      | string   | `-`        |     |
|           | updated_at   | datetime | `-`        |     |
|           | updater      | string   | `-`        |     |

| table     | attribute    | type     | constraint | key |
|-----------|--------------|----------|------------|-----|
| inventory | inventory_id | int      | `-`        | PK  |
|           | warehouse_id | int      | `-`        | FK  |
|           | product_id   | int      | `-`        | FK  |
|           | updated_at   | datetime | `-`        |     |
|           | updater      | string   | `-`        |     |
|           | quantity     | int      | `-`        |     |

| Database Type         | Explanation                                                                                                  |
|-----------------------|--------------------------------------------------------------------------------------------------------------|
| SQL (e.g. PostgreSQL) | Inventory data often involves structured information like product quantities, making SQL databases suitable. |
