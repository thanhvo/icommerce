FROM adoptopenjdk/openjdk15

RUN apt-get update && apt-get install -y maven
COPY . /order-service
RUN  cd /order-service && mvn clean package -DskipTests

#run the spring boot application
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dblabla", "-jar","/order-service/target/order-service-0.0.1-SNAPSHOT.jar"]