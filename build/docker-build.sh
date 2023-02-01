#!/bin/zsh
cd ../
export DOCKER_HOST=${DOCKER_HOST:-192.168.2.166}
export DOCKER_REGISTRY=${DOCKER_REGISTRY:-registry.cn-beijing.aliyuncs.com/amur}
docker buildx create --use
dirs=($(find . -name Dockerfile))

for dir in $dirs; do
  pwd=$(pwd)
  if [[ $dir == "tmp" ]] || [[ $dir == "target" ]]; then
    continue
  fi
  cd $(dirname $dir)
  dir_name=${PWD##*/}
  if [[ $@ == "all" ]]; then
    echo "Building: $dir_name"
    docker buildx build -t $DOCKER_REGISTRY/$dir_name:latest --push --platform linux/amd64,linux/arm64 .
    cd $pwd
    continue
  fi
  if [[ $@ == *"$dir_name"* ]] || [[ $dir_name == *"home-"* ]] && [[ $@ == *${dir_name#*home-}* ]]; then
    echo "Building: $dir_name"
    docker buildx build -t $DOCKER_REGISTRY/$dir_name:latest --push --platform linux/amd64,linux/arm64 .
    cd $pwd
  fi
  cd $pwd
done
