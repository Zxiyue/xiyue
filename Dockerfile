# 选择构建用基础镜像
FROM maven:3.6.0-jdk-13-slim as bulid

# 指定构建过程中的工作目录
WORKDIR /app

# 将src目录下所有文件拷贝到工作目录中src下
COPY src /app/src

#将pom.xml文件拷贝到工作目录下
COPY setting.xml pom.xml /app/

#执行代码编译
#自定义setting.xml，选用国内镜像以提高下载速度
RUN mvn -s /app/seting.xml -f /app/pom.xml clean package

#选择运行时基础镜像
FROM alpine:3.13

#安装依赖包
#选用国内镜像以提高下载速度
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.tencent.com/g' /etc/apk/repositories \
    && apk add --update --no-cache openjdk13-jre-base \
    && rm -f /var/cache/apk/*

#指定运行时的工作目录
WORKDIR /app

#将构建产物jar包拷贝到运行目录中
COPY --from=bulid /app/target/xiyue-1.0.0-SNAPSHOT.jar .

#暴露端口
EXPOSE 80

#执行启动命令
CMD ["java", "-jar","/app/xiyue-1.0.0-SNAPSHOT.jar"]
