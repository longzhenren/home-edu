#!/bin/zsh
cd ../
export DOCKER_HOST=192.168.2.205
cd home-gateway
docker buildx build -t registry.cn-beijing.aliyuncs.com/amur/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
cd ../home-service
# 遍历所有目录并切换到目录下执行docker build
for dir in $(ls); do
  if [ -d $dir ]; then
    cd $dir
    docker buildx build -t registry.cn-beijing.aliyuncs.com/amur/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
    cd ..
  fi
done
cd ../deploy/skywalking-ui
docker buildx build -t registry.cn-beijing.aliyuncs.com/amur/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
cd ../mysql
docker buildx build -t registry.cn-beijing.aliyuncs.com/amur/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
cd ../home-ops/home-sba
# 遍历所有目录并切换到目录下执行docker build
docker buildx build -t registry.cn-beijing.aliyuncs.com/amur/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
