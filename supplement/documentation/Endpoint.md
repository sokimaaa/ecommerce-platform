# Endpoint
Platform endpoint contract and goals.

## EUMS Endpoint

- User registration : a new user creation with roles
- User authorization : auth the user by provided email, password 
- User modification : the user modification, e.g. change username, change password

`api/v1`:
- `POST /user-registration`
- `POST /user-authentication`
- `PATCH /users/{userId}/username`
- `PATCH /users/{userId}/password`

> see for [user auth contract](../../specification/spec-rest-user-auth)

> see for [user modify contract](../../specification/spec-rest-user-modify)

## EPCS Endpoint

- Product exploration : get the list of products, specific product, the product availability info
- Product modification : update product info, e.g. name, description

`api/v1`:
- `GET /products?filter=value,sort=value,page=value`
- `GET /products/{productId}`
- `PATCH /products/{productId}/name`
- `PATCH /products/{productId}/description`
- `PATCH /products/{productId}/price`


`api/v2`:
- `PATCH /products/{productId}/image`

> see for [product explore contract](../../specification/spec-rest-product-explore)

> see for [product modify contract](../../specification/spec-rest-product-modify)

## EIMS Endpoint

- Inventory Exploring : present quantity of product
- Inventory Supplying : supply product (increase quantity of product)
- Warehouse Authorization : create a new warehouse
- Inventory Allocation : create a new inventory for product

`api/v1`:
- `GET /warehouses/{warehouseId}/inventories/{inventoryId}`
- `PATCH /warehouses/{warehouseId}/inventories/{inventoryId}`
- `POST /warehouses`
- `POST /warehouses/{warehouseId}/inventories`

> see for [warehouse manage contract](../../specification/spec-rest-warehouse-manage)

> see for [inventory explore contract](../../specification/spec-rest-inventory-explore)

> see for [inventory manage contract](../../specification/spec-rest-inventory-manage)

## EOMS Endpoint

- Order Exploring : show orders history (from newest to latest), show exact order
- Order Cancelling : decline an order

`api/v1`:
- `GET /orders`
- `GET /orders/{orderId}/items`

`api/v2`:
- `PATCH /orders/{orderId}`

> see for [order explore contract](../../specification/spec-rest-order-explore)

## ESCS Endpoint

- Shopping Cart Exploring : show all cart items
- Shopping Cart Checkout  : Checkout an order
- Shopping Cart Clean : Clean up an item, or the cart
- Shopping Cart Update : adding a new cart item

`api/v1`:
- `GET /carts/{cartId}/items`
- `POST /carts/{cartId}`
- `DELETE /carts/{cartId}/items`
- `DELETE /carts/{cartId}/items/{itemId}`
- `PUT /carts/{cartId}`

> see for [cart explore contract](../../specification/spec-rest-cart-explore)
> see for [cart checkout contract](../../specification/spec-rest-cart-checkout)
> see for [cart manage contract](../../specification/spec-rest-cart-manage)

## EPGS Endpoint

- Transaction Completion : complete transaction, e.g. change status of transaction

`api/v1`:
- `PATCH /transactions/{transactionId}`

> see for [transaction complete contract](../../specification/spec-rest-transaction-complete)
