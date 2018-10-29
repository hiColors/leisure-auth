# 项目简介

> 人员管理服务，对基础的人员信息进行维护。

- 人员可独立存在，同时可加入平台（公司，组织，团队）作为员工。

- 平台必须由某一人员创建，创建人默认为管理员角色，平台下的0级组织机构默认为平台名相同的组织机构，只可维护1级以后的组织机构。

## UML 图

![ UML 图](https://raw.githubusercontent.com/hiColors/resources/master/20181029224129.png)



## 数据库 DDL

[ 数据库结构 ](./leisure-member-application/src/main/resources/sql/ddl.sql)






# 分页示例

```
-- 示例
http://127.0.0.1:8080/leisure-member/role?page=0&size=1&sort=name,desc&EQ_id=100001
```
