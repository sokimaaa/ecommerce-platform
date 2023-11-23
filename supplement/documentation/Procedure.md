# Procedure
Platform procedure contract and goals.

## Shared Contract Approach
We are going to use gRPC for internal communication only, 
so we will provide `envelope` contract only.

Each service should decide what kind of gRPC service they need to expose and utilize.

`envelope` is a wrapper object that will be exchanged between stubs as a request and response.

The service that want to expose gRPC, just need to implement contract in own way.
The service that want to utilize gRPC, just need to connect to existing gRPC service. 

## EUMS Procedure

- unary `getUser()` : get the user
- stream `getUsers()` : get the stream of users

> to be extended

## EPCS Procedure
> to be extended

## EIMS Procedure
> to be extended

## EOMS Procedure 
> to be extended

## ESCS Procedure

- unary `allocateCart()` : creating cart for a new user

> to be extended

## EPGS Procedure
> to be extended
