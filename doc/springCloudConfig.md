# Spring Cloud Config

## 服务端   

Z：Spring Cloud Config就是将配置文件存放在git上，以接口的方式将内容提供给client端调用。

Z：Spring Cloud Config的使用步骤如下：

1. 添加maven依赖，使用的是``spring-cloud-config-server``   

   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-config-server</artifactId>
   </dependency>
   ```

2. 添加配置文件

   ```yaml
   server:
     port: 8001
   spring:
     application:
       name: spring-cloud-config-server
     cloud:
       config:
         server:
           git:
             uri: https://github.com/leekoko/microservice/     # 配置git仓库的地址
             search-paths: config-repo   # git仓库地址下的相对地址，可以配置多个，用,分割。
             username: leekoko                                      # git仓库的账号
             password:                                              # git仓库的密码
   ```

3. 启动类添加``@EnableConfigServer``注解

   完成以上配置之后，启动项目就会将git上的配置文件获取到。通过web接口的方式返回json数据。访问地址为：``http://localhost:8001/配置文件名称.properties``     

M：配置文件名称有什么要求吗？neo-config-dev.properties

Z：格式如：/{应用名}-{profile}.properties。这里的{应用名}是neo-config，{profile}可以用来区分配置文件的使用场景：例如dev是开发环境，test是测试环境，pro是生产环境。

## 客户端   

M：服务端已经将配置文件信息通过接口暴露出来了，客户端怎么请求获取它的配置文件呢？

Z：操作步骤如下

1. 添加pom依赖，使用的是``spring-cloud-starter-config``

   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-config</artifactId>
   </dependency>
   ```

2. 添加bootstrap.yml配置文件，指明获取配置文件的地址

   ```yaml
   spring:
     cloud:
       config:
         name: neo-config
         profile: dev
         uri: http://localhost:8001/
         label: master
   ```

   这个地址可以拼凑成url访问地址：``http://localhost:8001/配置文件名称.properties``，指明了获取master分支       

## 配置中心服务化   

