FROM anapsix/alpine-java:8_server-jre_unlimited
MAINTAINER hljzhangzhibo@126.com
RUN mkdir -p /app/user
WORKDIR /app/user
ADD ./target/${JAR_FILE} ./app.jar
EXPOSE 8701
#ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=dev", "app.jar"]
ENTRYPOINT ["java", "-jar", "app.jar"]