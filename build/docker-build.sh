#!/bin/zsh
cd ../
# 如果环境变量中未设定DOCKER_HOST,则默认为
if [[ -z "$DOCKER_HOST" ]]; then
  export DOCKER_HOST=192.168.2.166
fi
# 如果环境变量中未设定DOCKER_REGISTRY,则默认为$DOCKER_REGISTRY
if [[ -z "$DOCKER_REGISTRY" ]]; then
  export DOCKER_REGISTRY=$DOCKER_REGISTRY
fi
docker buildx create --use
for dir in $(find . -name Dockerfile); do
  pwd=$(pwd)
  if [[ $dir != *"tmp"* ]] && [[ $dir != *"target"* ]]; then
    continue
  fi
  # 如果参数中有"all"
  if [[ $@ == *"all"* ]]; then
    cd $(dirname $dir)
    echo Building: ${PWD##*/}
    docker buildx build -t $DOCKER_REGISTRY/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
    cd $pwd
  fi
  # 如果参数中有gateway,auth,course,msg,rtc,tinyid,user,sba,skywalking-ui,db,nacos中的一个或多个,则只构建对应目录下的Dockerfile
  if [[ $@ == *"gateway"* ]] || [[ $@ == *"auth"* ]] || [[ $@ == *"course"* ]] || [[ $@ == *"msg"* ]] || [[ $@ == *"rtc"* ]] || [[ $@ == *"tinyid"* ]] || [[ $@ == *"user"* ]] || [[ $@ == *"sba"* ]] || [[ $@ == *"swui"* ]] || [[ $@ == *"db"* ]] || [[ $@ == *"nacos"* ]]; then
    if [[ $dir != *"tmp"* ]] && [[ $dir != *"target"* ]]; then
      if [[ $@ == *"gateway"* ]] && [[ $dir == *"home-gateway"* ]]; then
        cd $(dirname $dir)
        echo Building: ${PWD##*/}
        docker buildx build -t $DOCKER_REGISTRY/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
        cd $pwd
      fi
      if [[ $@ == *"auth"* ]] && [[ $dir == *"home-auth"* ]]; then
        cd $(dirname $dir)
        echo Building: ${PWD##*/}
        docker buildx build -t $DOCKER_REGISTRY/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
        cd $pwd
      fi
      if [[ $@ == *"course"* ]] && [[ $dir == *"home-course"* ]]; then
        cd $(dirname $dir)
        echo Building: ${PWD##*/}
        docker buildx build -t $DOCKER_REGISTRY/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
        cd $pwd
      fi
      if [[ $@ == *"msg"* ]] && [[ $dir == *"home-msg"* ]]; then
        cd $(dirname $dir)
        echo Building: ${PWD##*/}
        docker buildx build -t $DOCKER_REGISTRY/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
        cd $pwd
      fi
      if [[ $@ == *"rtc"* ]] && [[ $dir == *"home-rtc"* ]]; then
        cd $(dirname $dir)
        echo Building: ${PWD##*/}
        docker buildx build -t $DOCKER_REGISTRY/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
        cd $pwd
      fi
      if [[ $@ == *"tinyid"* ]] && [[ $dir == *"home-tinyid"* ]]; then
        cd $(dirname $dir)
        echo Building: ${PWD##*/}
        docker buildx build -t $DOCKER_REGISTRY/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
        cd $pwd
      fi
      if [[ $@ == *"user"* ]] && [[ $dir == *"home-user"* ]]; then
        cd $(dirname $dir)
        echo Building: ${PWD##*/}
        docker buildx build -t $DOCKER_REGISTRY/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
        cd $pwd
      fi
      if [[ $@ == *"sba"* ]] && [[ $dir == *"home-sba"* ]]; then
        cd $(dirname $dir)
        echo Building: ${PWD##*/}
        docker buildx build -t $DOCKER_REGISTRY/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
        cd $pwd
      fi
      if [[ $@ == *"skywalking-ui"* ]] && [[ $dir == *"skywalking-ui"* ]]; then
        cd $(dirname $dir)
        echo Building: ${PWD##*/}
        docker buildx build -t $DOCKER_REGISTRY/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
        cd $pwd
      fi
      if [[ $@ == *"db"* ]] && [[ $dir == *"db"* ]]; then
        cd $(dirname $dir)
        echo Building: ${PWD##*/}
        docker buildx build -t $DOCKER_REGISTRY/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
        cd $pwd
      fi
      if [[ $@ == *"nacos"* ]] && [[ $dir == *"nacos"* ]]; then
        cd $(dirname $dir)
        echo Building: ${PWD##*/}
        docker buildx build -t $DOCKER_REGISTRY/${PWD##*/}:latest --push --platform linux/amd64,linux/arm64 .
        cd $pwd
      fi
    fi
  fi
done