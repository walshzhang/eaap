# 在 jdk8 镜像的基础上进行构建
FROM openjdk:11
# 把 hello.jar 放到容器的根目录下并改名为 app.jar
ADD hello.jar /app.jar
# 在容器中运行应用
ENTRYPOINT ["java", "-jar", "app.jar"]