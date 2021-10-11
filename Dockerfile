FROM maven:3.6-jdk-8-alpine
WORKDIR /Got-That-Note
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B dependency:resolve
