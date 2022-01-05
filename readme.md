# Java Example implementation of a TMF 666 with MongoDB

## Description
To enable a fast implementation of new digital services, TMForum publishes the TMF Open API. Through these REST interface definitions, a standardized data exchange between telecommunication standard solutions and individually developed services is very easily possible.

This Github project shows how easy TMF Open APIs can be implemented using MongoDB as persistence layer. (Note: TMForum also provides reference implementations that can serve as a good basis for own TMF compatible services).

## Disclaimer
This service does not implement the complete TMF-666 specification and does not represent a finished project. The persistence was implemented exemplarily for `FinancialAccounts`.

## How to use this Repo
First, update the `application.yml`. The only property that needs to be updated is `db.connectionString`.  
The Repo uses Maven to manage its dependencies. The project can be built with:
```shell
mvn clean install
```

Run the service (Sprint Boot) with:
```shell
maven spring-boot:run
```

## References

* [Blog Post - MongoDB and TMForum](www.mongodb.com)
* [TMForum Open APIs](https://www.tmforum.org/open-apis)



