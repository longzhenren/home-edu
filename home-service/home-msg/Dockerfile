FROM anapsix/alpine-java:8_server-jre_unlimited
MAINTAINER hljzhangzhibo@126.com
ARG JAR_FILE
ARG APP_NAME
EXPOSE 8703
RUN mkdir -p /app/${APP_NAME}
WORKDIR /app/${APP_NAME}
COPY ${JAR_FILE} ./app.jar
#ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=dev", "app.jar"]
#-Djava.security.egd=file:/dev/./urandom参数用于加速
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]