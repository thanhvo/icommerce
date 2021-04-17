#!/usr/bin/env bash

#eureka-server
cd ../eureka-server
mvn clean package -DskipTests
cp target/*.jar docker

#order-service
cd ../order-service
./mvnw clean package -DskipTests
cp target/*.jar docker

#product-service
cd ../product-service
./mvnw clean package -DskipTests
cp target/*.jar docker

# build docker containers
cd ../docker
docker-compose up
