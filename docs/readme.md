# 基于微服务的远程家教系统

## 项目简介

### 开发环境
> 系统: Macos 13.1
> 硬件: 16G内存 Apple Silicon M1 Pro
> IDE: IDEA 2022.2.3
> JDK: Corretto-1.8_352
> Maven: 3.8.6
> Docker: 20.10.21
> Docker-compose: 2.13.0
> MySQL: 8.0.26
> Nacos: 2.1.0
> SpringBoot: 2.6.11
> SpringCloud: 2021.0.4
> SpringCloudAlibaba: 2021.0.4.0
> MybatisPlus: 3.5.2
> sa-token: 

## 服务地址

| 服务名                                      | HTTP接口       | gRPC接口 |
| ------------------------------------------- | -------------- | -------- |
| 用户服务 **[home-service/home-user]**       | 8701           | 9701     |
| 认证服务 **[home-service/home-auth]**       | 8705           | 9705     |
| 分布式ID生成 **[home-service/home-tinyid]** | 8700           | 8700     |
| 网关服务 **[home-gateway]**                 | 8080           | 9080     |
| 健康监控 **[home-ops/home-sba]**            | 8801           | 9801     |
| 链路日志ui **[home-ops/skywalking-ui]**     | 8888           | 无       |
| Skywalking-OAP                              | 12800[grqphQL] | 11800    |
| 服务注册中心nacos                           | 8848           | 9848     |
| MySQL                                       | 3306           | 无       |
| Redis                                       | 6379           | 无       |
| ElasticSearch                               | 9200           | 无       |
| portainer                                   | 8890           | 无       |
|                                             |                |          |
|                                             |                |          |
|                                             |                |          |



## 二次开发说明

### 配置基础软件

安装jdk1.8、maven3.6+、nacos2.0.3+、docker、proto-compiler、minio、MySQL8.0+、SRS4.0+

### 添加api模块

在home-service-api模块下新建maven子模块，继承home-service-api

在/src/main/proto下新建ptoto文件，确定远程调用RPC接口

proto文件编写规范

在/src/main/java下新建包存放Entity、DTO、VO等

如果添加了ptoto文件用于RPC调用，执行`mvn protobuf:compile`生成Proto数据结构，执行`mvn protobuf:custom` 在/src/main/java/rpc下生成对应的java代码，不添加到git

生成代码后，执行`mvn clean install`将jar包安装到本地maven仓库中

### 添加业务模块

在home-service模块下新建maven子模块，继承home-service，并在pom.xml的dependency中引用对应的api模块

在service中添加对应的组件包

### 配置网关