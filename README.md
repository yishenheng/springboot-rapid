# springboot-rapid
基于SpringBoot搭建的一个脚手架

# 背景
基于SpringBoot搭建的一个脚手架，方便自己学习其他框架能快速整合。

# 技术选型
1. 核心框架：SpringBoot2.2.7
2. 持久化框架：Mybatis、Mybatis-puls
3. 数据库连接池：Alibaba Druid
4. 日志管理：slf4j
5. AOP切面：SpringAOP
6. 数据库：MySQL

# 项目结构
单体架构 基于jdk8+开发，使用maven进行项目管理。具体目录如下：
```
springboot-rapid
  doc 用来存放sql文件
  src/main/
    java/
      config: 用来存放配置类 如swagger-ui
      constant: 存放常量
      common: 公共组件类
      controller: 控制层 与前端交互
      converter: 数据库bean转换dtobean
      dto: 返回给前端的bean
      entity: 数据库bean
      mapper: 数据访问层
      service: 业务逻辑处理层
      util: 工具类
      Application.java 启动类
    resources:
      mappers: mybatis xml文件
      application.yml: 配置文件
    test/java
      GenerateBean: 快速生成实体类、控制层、业务逻辑层、DAO层
```
