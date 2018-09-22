# Temp

### 服务docker化  

Z：运行镜像``docker run -it user-thrift-service:latest --mysql.address=192.168.0.2``    

M：python怎么运行呢？

Z：1.拉取``docker pull python:3.6``

2.运行python``docker run -it --entrypoint bash python:3.6``  











  

1. 第一个运行服务，下一个运行什么？将所有的应用服务运行起来

2. 数据库分表有什么规律吗？










docker run -it --entrypoint bash python:3.6

uname -a

python

	print("aaa")



在python之上做一层基础镜像

```python
FROM hub.mooc.com:8080/micro-service/python:3.6
MAINTAINER xxx xxx@imooc.com

RUN pip install thrift
```

运行python的dockerfile

```python
FROM hub.mooc.com:8080/micro-service/python-base:latest
MAINTAINER xxx xxx@imooc.com

ENV PYTHONPATH /
COPY message /message

ENTRYPOINT ["python", "/message/message_service.py"]
```





