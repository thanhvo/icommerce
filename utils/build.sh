#!/usr/bin/env bash
./mvnw clean package -DskipTests
cp target/*.jar docker
