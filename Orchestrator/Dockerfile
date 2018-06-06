FROM openjdk:8-jdk-alpine AS base
EXPOSE 8080

FROM maven AS build
VOLUME /root/.m2
WORKDIR /app
COPY pom.xml .
RUN mvn clean verify --fail-never
COPY . .
RUN mvn package

FROM base AS final
WORKDIR /app
COPY --from=build /app/target/orchestrator-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "orchestrator-0.0.1-SNAPSHOT.jar" ]
