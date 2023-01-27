#上amd64用 体积小 arm64需要转译速度慢
#FROM anapsix/alpine-java:8_server-jre_unlimited
#arm64原生支持 速度更快 体积大
#FROM openjdk:8-jre-alpine
FROM apache/skywalking-java-agent:8.14.0-java8
MAINTAINER hljzhangzhibo@126.com
#RUN sed -i s@/archive.ubuntu.com/@/mirrors.aliyun.com/@g /etc/apt/sources.list
#RUN sed -i s@/security.ubuntu.com/@/mirrors.aliyun.com/@g /etc/apt/sources.list
#RUN apt update
ARG JAR_FILE
ARG APP_NAME
EXPOSE 8705
EXPOSE 9705
RUN mkdir -p /app/${APP_NAME}
WORKDIR /app/${APP_NAME}
COPY ${JAR_FILE} ./app.jar
#ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=dev", "app.jar"]
#-Djava.security.egd=file:/dev/./urandom参数用于加速
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]