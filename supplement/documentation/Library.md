# Library
Platform libraries. 

## gRPC Client Library
To be injected in case module want to be `gRPC Client`.

Contains custom marker-annotations that aggregate spring annotations inside.
Should be used for clarifying purposes. 

Also, has the channel factory class to create gRPC connection.

All generic grpc client interceptors present here.

## gRPC Server Library
To be injected in case module want to be `gRPC Server`.

Contains custom marker-annotations that aggregate spring annotations inside.
Should be used for clarifying purposes.

All generic grpc server interceptors present here.
