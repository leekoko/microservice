# Eureka  

## 创建Serve项目

M：Eureka是什么？

Z：Eureka是SpringCloud服务的注册中心，可以管理服务。

M：Eureka怎么创建呢？

Z：新建Spring Initiallizr项目，选择idea自带的Cloud Discovery - Eureka Discovery，完成创建即可 

M：怎么启动Eureka报错呢？

Z：需要在Application上添加注解``@EnableEurekaServer``。

Eureka自己也是个服务，需要注册自我才不会报错。在application.yml中添加以下代码

```yaml
server:
 port: 8761 # 8761是eureka server的默认端口
eureka:
 server:
  enable-self-preservation: false #防止由于Eureka的机制导致Client被错误显示在线 仅在开发环境使用
 client:
  service-url:
   defaultZone: http://localhost:8761/eureka/ #这便是此eureka server的应用注册地址
  register-with-eureka: false #不显示对server应用的注册
spring:
 application:
  name: eureka-demo
```

（注意使用的是空格，否则会报错）

M：怎么通过命令行启动Eureka呢？

Z：将Eureka用package打包之后，用``java -jar``启动。

## 创建Client项目   

Z：步骤如下：

1. client的创建选择Eurake Discovery，需要保持版本跟SpringClound一致

2. Application添加注解``@EnableDiscoveryClient``   

3. 配置连接到Eureka

   ```yaml
   server:
    port: 8081
   eureka:
    client:
     service-url:
      defaultZone: http://localhost:8761/eureka/  #注册到刚才那台Eureka Server地址
   spring:
    application:
     name: client-0
   ```











视频3-4,重新创建eruake和client端