* 前提
  * 安装 nodejs, @vue/cli, jdk, maven
  * 设置环境变量 JAVA_HOME, MAVEN_HOME
* 打包
  ```powershell
  PS> cd ch2-docker-container\deploy
  PS> .\build.ps1
  ```
  * 执行结束会在 deploy 前后端对应目录下放置打包文件
* 构建镜像
  ```powershell
  PS> cd vue-hello
  PS> docker build -t vue-hello .
  PS> cd ../spring-hello
  PS> docker build -t spring-hello .
  ```
  * 构建成功后可使用 `docker images` 查看生成的镜像
* 启动应用
  ```powershel
  PS> cd deploy
  PS> docker-compose up
  ```
* 停止应用：`docker-compose down`
  