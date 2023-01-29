#!/bin/zsh
cd ../
export DOCKER_HOST=192.168.2.205
cd home-gateway
# 定义变量,值为当前最后一级目录名
docker buildx build -t registry.cn-beijing.aliyuncs.com/amur/${PWD##*/}:latest --build-arg --push --platform linux/amd64,linux/arm64 .
cd ../home-service
# 遍历所有目录并切换到目录下执行docker build
for dir in $(ls); do
  if [ -d $dir ]; then
    cd $dir
    docker buildx build -t registry.cn-beijing.aliyuncs.com/amur/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
    cd ..
  fi
done
cd ../home-ops
# 遍历所有目录并切换到目录下执行docker build
for dir in $(ls); do
  if [ -d $dir ]; then
    cd $dir
    docker buildx build -t registry.cn-beijing.aliyuncs.com/amur/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
    cd ..
  fi
done