### Demo of the microservice architecture for TCI

There are three way to run microservices:
1. Use executable jar (war) applications
2. Use traditional deployment to application server
3. Use docker containers

##### Using executable jar

To run microcervices this way, just do `mvn clean package` and run each jar file.
Each service has default port, and if we need to run the second node of the already running application on port `8080`
we should pass command line argument with new port number: `--service.port=8081`

##### Using traditional deployment

To prepare war files just run `mvn clean package -P war`. After we can deploy that war file as usual.
But there are two environment variables we need to specify for our application server:
- Address of our registration and discovery service (service-registry) `eureka.client.serviceUrl.defaultZone`
  (example: `eureka.client.serviceUrl.defaultZone=http://localhost:8080/service-registry/eureka/`)
- Current port `server.port` (example: `server.port=1010`). This is workaround related with spring boot and will be fixed later.

Full example:
```
set JAVA_OPTS=-Dserver.port=8080 -Deureka.client.serviceUrl.defaultZone=http://localhost:8080/service-registry/eureka/
```

##### Using docker containers

// TODO

**** How to test

To ask `dummy-tcm` service for document, just sent request to `gateway` service with `dummy-tcm` service name and URI, for example:
```
curl http://localhost:8080/gateway/dummy-tcm/document
```

Useful links (in case `service-registry` is deployed at `http://localhost:8080`):
- To check registered services go to `http://localhost:8080/service-registry`
- To get services detail information go to `http://localhost:8080/service-registry/eureka/apps`

