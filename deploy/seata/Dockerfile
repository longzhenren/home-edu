#FROM ubuntu:22.04
FROM openjdk:8-jre-slim
MAINTAINER hljzhangzhibo@126.com
#RUN sed -i s@/archive.ubuntu.com/@/mirrors.aliyun.com/@g /etc/apt/sources.list
#RUN sed -i s@/security.ubuntu.com/@/mirrors.aliyun.com/@g /etc/apt/sources.list
ADD seata-server-1.6.0.tar.gz /
#RUN apt update && apt install openjdk-8-jre-headless python3 -y
#ADD https://hub.nuaa.cf/seata/seata/releases/download/v1.6.0/seata-server-1.6.0.tar.gz /
WORKDIR /seata
ADD resources/application.yml /seata/conf/
#ADD config/config.txt /seata/script/config-center/
RUN #chmod +x /seata/script/config-center/nacos/nacos-config.py
EXPOSE 8091
EXPOSE 7091
ENV LOADER_PATH="/seata/lib"
#ENTRYPOINT ["bash","-c","cd /seata/script/config-center/nacos && ./nacos-config.py -g DEFAULT_GROUP -u nacos -w nacos && cd /seata/bin && ./seata-server.sh && tail -f /dev/null"]
ENTRYPOINT ["bash","-c","cd /seata/bin && ./seata-server.sh && tail -f /dev/null"]