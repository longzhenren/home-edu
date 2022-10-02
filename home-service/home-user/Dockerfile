#上amd64用 体积小 arm64需要转译速度慢
#FROM anapsix/alpine-java:8_server-jre_unlimited
#arm64原生支持 速度更快 体积大
#FROM openjdk:8-jre
FROM apache/skywalking-java-agent:8.14.0-java8
MAINTAINER hljzhangzhibo@126.com
EXPOSE 8701
EXPOSE 9701
RUN mkdir -p /app/home-user
WORKDIR /app/home-user
COPY /target/home-user-0.0.1-SNAPSHOT.jar ./app.jar
#ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=dev", "app.jar"]
#-Djava.security.egd=file:/dev/./urandom参数用于加速
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]