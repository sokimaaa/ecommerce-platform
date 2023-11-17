# Requirements

## Features (Functional Requirements)

- user registration and authentication
- [see the list of products](#product-actions)
- [see details of a product](#product-actions)
- [adding item to shopping cart](#shopping-cart-actions)
- [removing item from shopping cart](#shopping-cart-actions)
- [top up an inventory](#inventory-actions)
- [make an order](#order-actions)
- [make a payment](#payment-actions)

### Product Actions 

Interactions:
- get the list of products (filtering, sorting, pagination)
- get the specific product info
- a new product creation
- provide the product availability info

Triggers inventory space allocation.


### Inventory Actions

Interactions:
- get the count of product
- allocation the space for a new product
- supply the products
- inform product catalog about updates
- registration a new warehouse

Gets the `productId` and the `supplyCount` from outside.

Allocates the space `productInventoryId` when a `productId` is being added.

`productId` needs to provide the count information.

`productId` and `supplyCount` need to update the count of products.

Returns tuple (`productId`, `count`) for the get request.

Triggers EPCS that `productId` is available now.


### Shopping Cart Actions

Interactions: 
- create the cart with the user registration
- get the state of the cart
- add to the cart
- remove from the cart
- order creation when the cart is complete

Gets the `userId`, `itemId` and `quantity` from outside.

Generates `cartId` when `userId` is being created.

`userId` needs to identify the cart.

`itemId` needs to get the product from EPCS.

`itemId` needs to check the availability from EIMS.

`quantity` the optional param for identifying count of product, by default is 1.

Triggers order creation when the cart is complete. Sends the `userId`, the set of tuples (`itemId`, `quantity`), and the calculated `total`.


### Order Actions

Interactions: 
- managing order lifecycle
- get the list of all orders sorted by date of creation (from newest)
- get the specific order
- decline the order

Instantiates order when triggered by ESCS.

Provides `actions` to be made, e.g. make a payment, provide shipping address. 

According to `actions` provide the `orderStatus`.

Gets the `paymentStatus` from EPGS.

Gets the `orderId` and `userId` to decline the order.

Order Statuses: 
- CREATED: when was triggered by ESCS
- PAYMENT_PROCESSING: when all data provided, but `paymentStatus` is not `DONE`
- DELIVERING: while delivering the order
- DELIVERED: while the order is located in the postal
- CLOSED: the order was picked up by user
- CANCELLED: the user is declined the order (or cancelled the payment)


### Payment Actions

Interactions:
- managing payment lifecycle
- send the payment updates (PAID or CANCELLED) to order service

Processing user payment.

Sends to EOMS the payment status updates.

## Priorities (Non-Functional Requirements)

- Should be written using Java mainly
- Should have up-to-date technologies
- Should be fairly independent
- Should have scalable potential
- Should be fault-tolerance
- Should consist different ways to communicate (REST, Messaging, etc.)
- Should be secured (JWT, OAuth 2.0)
- Should have monitoring and logging for visibility
- Should be covered with tests (unit, integration, e2e, etc.)
- Should provide single entry point (API gateway)
