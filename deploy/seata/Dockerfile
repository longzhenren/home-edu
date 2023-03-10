FROM seataio/seata-server:1.6.0
MAINTAINER hljzhangzhibo@126.com
ADD resources/application.yml /seata-server/resources/
EXPOSE 8091
EXPOSE 7091
ENV LOADER_PATH="/seata-server/lib"
CMD ["bash","-c","/seata-server/script/config-center/nacos/nacos-config.sh -h localhost -p 8848 -g SEATA_GROUP -t 5a3c7d6c-f497-4d68-a71a-2e5e3340b3ca -u nacos -w nacos && /seata-server/bin/seata-server.sh && tail -f /dev/null"]