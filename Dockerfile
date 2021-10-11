FROM maven:3.6-jdk-8-alpine
WORKDIR /Got-That-Note
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
COPY target/Got_That-1.0-SNAPSHOT.jar .
RUN mvn -e -B dependency:resolve
CMD ["java","-jar", "Got_That-1.0-SNAPSHOT.jar"]
