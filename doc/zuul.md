# zuul路由

## 介绍

Z：添加APi网关之后，所有的url请求就都需要通过一道墙，这道墙可以对请求进行权限控制。API Gateway是微服务轻量级网关。   

   ![img](../imgs/g01.png)  

## 路由跳转   

M：怎么实现路由跳转呢？

Z：步骤如下：

1.  引入pom依赖

   ```xml
   <dependency>
   	<groupId>org.springframework.cloud</groupId>
   	<artifactId>spring-cloud-starter-zuul</artifactId>
   </dependency>
   ```

2. 添加跳转路径配置

   ```properties
   spring.application.name=gateway-service-zuul
   server.port=8888
   
   zuul.routes.baidu.path=/baidu/** 
   zuul.routes.baidu.url=http://www.baidu.com/
   ```

3. 添加``@EnableZuulProxy``注解，启动。访问/test/**路径，将会自动跳转到百度页面

Z：一般情况下是路由到其他服务的页面上，还可以带参数跳转

1. 配置路径跳转

   ```properties
   zuul.routes.hello.path=/hello/**
   zuul.routes.hello.url=http://localhost:9000/
   ```

2. 访问路径为``http://127.0.0.1:8888/hello/hello?name=sky``

   相当于将路径进行替换``http://127.0.0.1:9000/hello?name=sky``后访问  

## 服务化   

M：路径跳转是直接配置zuul的url，而url是不固定的，怎么处理？

Z：将zuul注册到Eureka，通过serviceId的方式调用目标服务

1. 修改配置文件

   ```properties
   spring.application.name=gateway-service-zuul
   server.port=8888
   
   zuul.routes.api-a.path=/producer/**
   zuul.routes.api-a.serviceId=spring-cloud-producer
   
   eureka.client.serviceUrl.defaultZone=http://localhost:8000/eureka/
   ```

   将原先的url改为serviceId，指向目标服务。注册zuul到eureka

Z：serviceId对应的不一定只是一个服务，可能是多个同名的服务，从而实现负载均衡。

Z：zuul还提供了默认的跳转路径，格式为：``http://ZUUL_HOST:ZUUL_PORT/微服务在Eureka上的serviceId/**``

,访问``http://localhost:8888/spring-cloud-producer/hello?name=sky``也可以实现路由跳转。