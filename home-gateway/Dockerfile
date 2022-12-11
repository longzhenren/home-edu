FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER hljzhangzhibo@126.com

RUN mkdir -p /amur/home/gateway

WORKDIR /amur/home/gateway

EXPOSE 80

ADD ./target/home-gateway.jar ./app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]

CMD ["--spring.profiles.active=test"]
