#上amd64用 体积小 arm64需要转译速度慢
#FROM anapsix/alpine-java:8_server-jre_unlimited
#arm64原生支持 速度更快 体积大
FROM openjdk:8-jre-alpine
MAINTAINER hljzhangzhibo@126.com
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories
RUN set -xe \
&& apk --no-cache add ttf-dejavu fontconfig
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