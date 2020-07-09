#!/bin/bash
echo =================================
echo  自动化部署脚本启动
echo =================================

TOMCAT_PATH=/usr/local/apache-tomcat-8.5.56
CODE_PATH=/root/Documents/code/yeyingzan-love


echo 进入${CODE_PATH}
cd ${CODE_PATH}

echo 开始pull版本
git checkout master
git pull

echo 开始编译文件
mvn clean package -Dmaven.test.skip=true

echo 进入编译完成文件
cd ${CODE_PATH}/target

#echo 文件重命名
#mv ROOT.war ROOT.war

echo 关闭tomcat服务器
sh ${TOMCAT_PATH}/bin/shutdown.sh
pidlist=`ps -ef |grep tomcat  |grep -v "grep"|awk '{print $2}'`
kill -9 $pidlist

echo 删除以往文件
rm -rf ${TOMCAT_PATH}/webapps/ROOT
rm -rf ${TOMCAT_PATH}/webapps/ROOT.war

echo 移动文件
mv ROOT.war ${TOMCAT_PATH}/webapps/

echo 重启服务器
sh ${TOMCAT_PATH}/bin/startup.sh
