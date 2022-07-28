# quarkus-finance project

Esse projeto foi desenvolvido em Quakus para analise da equipe do Banco de Brasil

Esse projeto usa algumas stacks:

-Jaeger para fazer tracing de nossas requisicoes

-Prometheus para enviar as métricas de execucao da aplicacao

-Grafana para exibicao de dashboards 

-Swagger para documentacao (openapi)

-Postgres como banco relacional

-Flyway para migracao dos scripts de banco


## Running the application in dev mode

Para rodar a aplicacao vc precisa subir as imagens que estao definidas no docker-compose na raiz do projeto

Antes de rodar o docker-compose build a imagem da aplicacao utilizando o Dockerfile.jvm na pasta docker do projeto

Utilize o comando : 
```shell script
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/quarkus-finance-jvm .
```
Depois de subir a aplicacao pode acessar:

Swagger : http://localhost:8080/q/swagger-ui/#

Jaegger : http://localhost:16686/search

Grafana : http://localhost:3000/  user/pass=(admin/admin)

Prometheus : http://localhost:9090/graph

Lembre-se que para o tracing do jaeeger funcionar deve usar a url certa do properties, há uma outra para banco local, essa url funciona pro banco dockerizado

Basta executar 
```shell script
docker-compose up
```
Que subirá toda a stack que o projeto precisa para funcionar.


You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-cadastro-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related guides

- REST resources for Hibernate ORM with Panache ([guide](https://quarkus.io/guides/rest-data-panache)): Generate JAX-RS resources for your Hibernate Panache entities and repositories
- Hibernate Validator ([guide](https://quarkus.io/guides/validation)): Validate object properties (field, getter) and method parameters for your beans (REST, CDI, JPA)
- REST Client ([guide](https://quarkus.io/guides/rest-client)): Call REST services
- RESTEasy JSON-B ([guide](https://quarkus.io/guides/rest-json)): JSON-B serialization support for RESTEasy
- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

## Provided examples

### RESTEasy JAX-RS example

REST is easy peasy with this Hello World RESTEasy resource.

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
