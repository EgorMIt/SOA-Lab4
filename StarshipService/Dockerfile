#define base docker image
FROM openjdk:17
LABEL maintainer="Egor Mitrofanov"
ADD target/StarshipService-1.0-SNAPSHOT.jar StarshipService.jar
ENTRYPOINT ["java", "-jar", "StarshipService.jar"]