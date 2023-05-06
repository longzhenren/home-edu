FROM mysql:8.0.32
ADD init/nacos-mysql.sql /docker-entrypoint-initdb.d/nacos-mysql.sql
ADD init/amur-mysql.sql /docker-entrypoint-initdb.d/amur-mysql.sql
ADD init/tinyid-mysql.sql /docker-entrypoint-initdb.d/tinyid-mysql.sql
ADD init/seata-mysql.sql /docker-entrypoint-initdb.d/seata-mysql.sql
RUN chown -R mysql:mysql /docker-entrypoint-initdb.d/*.sql
EXPOSE 3306
CMD ["mysqld", "--character-set-server=utf8mb4", "--collation-server=utf8mb4_unicode_ci"]