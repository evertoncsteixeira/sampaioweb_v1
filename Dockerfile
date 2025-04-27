FROM ubuntu:latest AS build

RUN apt-get update 
RUN apt-get install -y openjdk-21-jdk wget tar

# Instalar Maven manualmente
RUN wget https://downloads.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.tar.gz
RUN tar -xvzf apache-maven-3.9.5-bin.tar.gz -C /opt/
RUN ln -s /opt/apache-maven-3.9.5/bin/mvn /usr/bin/mvn

WORKDIR /app
COPY . .

RUN mvn clean install

FROM openjdk:21-jdk-slim

EXPOSE 8080

COPY --from=build /app/target/sampaio-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]