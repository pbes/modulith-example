# modulith-example

Példa alkalmazás a https://pbes.github.io/posts/spring-modulith cikkhez.

Az alkalmazás függőségei (PostgreSQL, Kafka) a `compose.yaml` fájlban definiáltak, a Spring Boot a `spring-boot-docker-compose` segítségével indítja azokat.

## Indítás

```shell
mvn clean spring-boot:run
```