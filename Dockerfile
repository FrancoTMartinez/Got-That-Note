FROM maven:3.6-jdk-8-alpine
WORKDIR /Got-That-Note
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn clean install -DskipTests
CMD ["java","-jar","Got_That-1.0-SNAPSHOT.jar"]
