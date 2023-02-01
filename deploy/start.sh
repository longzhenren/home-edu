#!/bin/zsh
port_list=(8890 3306 6379 8848 9848 9849 9555 8700 8701 8702 8703 8704 8705 9701 9702 9703 9704 9705 8080 9090 9200 11800 12800 8888)

for port in ${port_list[@]}; do
  (echo >/dev/tcp/localhost/$port) &>/dev/null
  if [ $? -eq 0 ]; then
    pid=$(lsof -i:$port | awk 'NR==2{print $2}')
    process_name=$(ps -p $pid -o comm=)
    echo "Port $port is occupied by [PID:$pid] $process_name, please free up the port and try again."
    exit 1
  fi
done

if [ ! -x "$(command -v docker)" ]; then
  echo "Docker is not installed."
  exit 1
fi

if [ ! -x "$(command -v docker-compose)" ]; then
  echo "Docker-compose is not installed."
  exit 1
fi

# 通过/compose目录下docker-compose.yml启动docker-compose
cd /compose
echo "Pulling docker-images..."
docker-compose pull
echo "Starting docker-compose..."
docker-compose up -d
