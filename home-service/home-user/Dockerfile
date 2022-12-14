FROM alpine-java
MAINTAINER hljzhangzhibo@126.com
RUN mkdir -p /app/user
WORKDIR /app/user
ADD ./target/home-user-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8701
#ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=dev", "app.jar"]
ENTRYPOINT ["java", "-jar", "app.jar"]