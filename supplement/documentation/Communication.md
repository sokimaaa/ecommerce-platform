# Communication
Communication types based on [requirements](./Requirements.md).

## Api first approach

## Api Gateway Pattern

## Internal microservice communication
gRPC 

## Exposing public Api
REST API

## Messaging
Kafka

## Services

### Ecommerce User Management Service (EUMS)
Communicates with other services via RESTful APIs or message queues for user-related actions and events.

### Ecommerce Product Catalog Service (EPCS)
Communicates with the Inventory Management service for displaying products and updating stock.

### Ecommerce Order Management Service (EOMS)
Communicates with User Management, and Payment Gateway services for order-related actions and updates.

### Ecommerce Payment Gateway Service (EPGS)
Communicates with Order Management and User Management services for payment authorization and order completion.

### Ecommerce Shopping Cart Service (ESCS)
Interacts with the User Management, Product Catalog, Inventory Management and Order Management services for cart actions and order placement.

### Ecommerce Inventory Management Service (EIMS)
Communicates with the User Management and Product Catalog services for real-time stock updates.
