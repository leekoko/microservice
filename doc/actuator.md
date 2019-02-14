# actuator  



## 环境搭建

M：怎么查看项目中有哪些bean？

Z：操作方式如下：

1. 添加actuator的pom依赖

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-actuator</artifactId>
   </dependency>
   ```

2. application.properties配置文件中添加配置

   ```properties
   management.endpoints.web.exposure.include=*
   ```

3. 访问actuator的beans端点

   如``http://localhost:8080/actuator/beans``（安装jsonview可以格式化json数据）  


