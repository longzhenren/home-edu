#上amd64用 体积小 arm64需要转译速度慢
#FROM anapsix/alpine-java:8_server-jre_unlimited
#arm64原生支持 速度更快 体积大
FROM openjdk:8-jre
MAINTAINER hljzhangzhibo@126.com
ARG JAR_FILE
ARG APP_NAME
EXPOSE 8701
RUN mkdir -p /app/${APP_NAME}
WORKDIR /app/${APP_NAME}
COPY ${JAR_FILE} ./app.jar
#ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=dev", "app.jar"]
#-Djava.security.egd=file:/dev/./urandom参数用于加速
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]