FROM maven:3.6-jdk-8-alpine AS builder
WORKDIR /Got-That-Note
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn clean install -DskipTests

FROM openjdk:8-jre-alpine
COPY --from=builder /Got-That-Note/target/Got_That-1.0-SNAPSHOT.jar
CMD ["java","-jar", "Got_That-1.0-SNAPSHOT.jar"]
