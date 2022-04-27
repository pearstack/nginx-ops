#!/bin/sh
# author lihao3
# ./nginx-ops.sh start 启动
# ./nginx-ops.sh stop 停止
# ./nginx-ops.sh restart 重启
# ./nginx-ops.sh status 状态
AppName=nginx-ops-server.jar
APP_HOME=/www/server/nginx-ops
LOG_PATH=$APP_HOME/logs

if [ "$1" = "" ]; then
  echo -e "\033[0;31m 未输入操作名 \033[0m  \033[0;34m {start|stop|restart|status} \033[0m"
  exit 1
fi

if [ "$AppName" = "" ]; then
  echo -e "\033[0;31m 未输入应用名 \033[0m"
  exit 1
fi

# shellcheck disable=SC2112
function start() {
  PID=$(ps -ef | grep java | grep $AppName | grep -v grep | awk '{print $2}')

  if [ x"$PID" != x"" ]; then
    echo "$AppName is running..."
  else
    export DISPLAY=:0
    nohup java -jar -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$LOG_PATH -Xms512m -Xmx512m -Xmn256m -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=10086 $APP_HOME/$AppName > /dev/null 2>&1 &
    echo "Start $AppName success..."
  fi
}

# shellcheck disable=SC2112
function stop() {
  echo "Stop $AppName"

  PID=""
  query() {
    PID=$(ps -ef | grep java | grep $AppName | grep -v grep | awk '{print $2}')
  }

  query
  if [ x"$PID" != x"" ]; then
    kill -9 $PID
    echo "$AppName (pid:$PID) exiting..."
    while [ x"$PID" != x"" ]; do
      sleep 1
      query
    done
    echo "$AppName exited."
  else
    echo "$AppName already stopped."
  fi
}

# shellcheck disable=SC2112
function restart() {
  stop
  sleep 2
  start
}

# shellcheck disable=SC2112
function status() {
  PID=$(ps -ef | grep java | grep $AppName | grep -v grep | wc -l)
  if [ $PID != 0 ]; then
    echo "$AppName is running..."
  else
    echo "$AppName is not running..."
  fi
}

case $1 in
start)
  start
  ;;
stop)
  stop
  ;;
restart)
  restart
  ;;
status)
  status
  ;;
*) ;;

esac
