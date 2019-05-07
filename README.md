# 基础设施依赖

## MySQL && Redis && RabbitMQ

- MySQL

```
docker run --name mysql --restart=always -p 3306:3306 -v ~/Workspaces/docker/mysql/5.7:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7
```

- Redis

```
docker run --name redis --restart=always -p 6379:6379  -v ~/Workspaces/docker/redis/4.x:/data -d redis:4 redis-server --appendonly yes
```

- RabbitMQ

```
docker run --name rabbitmq --restart=always -d -p 5672:5672 -p 15672:15672 -v ~/Workspaces/docker/rabbitmq:/var/lib/rabbitmq  -e RABBITMQ_DEFAULT_USER=root -e RABBITMQ_DEFAULT_PASS=root rabbitmq:3-management
```


# 项目简介

> 人员管理服务，对基础的人员信息进行维护。

- 人员可独立存在，同时可加入平台（公司，组织，团队）作为员工。

- 平台必须由某一人员创建，创建人默认为管理员角色，平台下的0级组织机构默认为平台名相同的组织机构，只可维护1级以后的组织机构。

## UML 图

![ UML 图](https://raw.githubusercontent.com/hiColors/resources/master/20181029225138.png)



## 数据库 DDL

[ 数据库结构 ](./leisure-member-application/src/main/resources/sql/ddl.sql)






# 分页示例

```
-- 示例
http://127.0.0.1:8080/leisure-member/role?page=0&size=1&sort=name,desc&EQ_id=100001
```
