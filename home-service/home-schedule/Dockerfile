#上amd64用 体积小 arm64需要转译速度慢
#FROM anapsix/alpine-java:8_server-jre_unlimited
#arm64原生支持 速度更快 体积大
#FROM openjdk:8-jre
FROM apache/skywalking-java-agent:8.14.0-java8
MAINTAINER hljzhangzhibo@126.com
EXPOSE 8706
EXPOSE 9706
RUN mkdir -p /app/home-schedule
WORKDIR /app/home-schedule
COPY /target/home-schedule-0.0.1-SNAPSHOT.jar ./app.jar
#ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=dev", "app.jar"]
#-Djava.security.egd=file:/dev/./urandom参数用于加速
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]