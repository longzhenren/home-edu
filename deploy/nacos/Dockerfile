FROM nacos/nacos-server:v2.2.0-slim
MAINTAINER hljzhangzhibo@126.com
RUN sed -i "s@http://\(deb\|security\).debian.org@https://mirrors.ustc.edu.cn/@g" /etc/apt/sources.list
RUN apt update
RUN apt install curl -y
EXPOSE 8848
ENTRYPOINT ["bin/docker-startup.sh"]