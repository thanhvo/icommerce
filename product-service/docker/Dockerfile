FROM adoptopenjdk/openjdk15

RUN apt-get update && apt-get install -y maven
COPY . /product-service
RUN  cd /product-service && mvn clean package -DskipTests

#run the spring boot application
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dblabla", "-jar","/product-service/target/product-service-0.0.1-SNAPSHOT.jar"]