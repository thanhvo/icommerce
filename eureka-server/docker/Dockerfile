FROM adoptopenjdk/openjdk15

RUN apt-get update && apt-get install -y maven
COPY . /eureka-server
RUN  cd /eureka-server && mvn clean package -DskipTests

#run the spring boot application
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dblabla", "-jar","/eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar"]