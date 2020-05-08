# ssm
ssm简单整合
# ssm整合

### 背景:

Springmvc + Spring + Mybatis 整合

三层架构:持久层,业务层,表现层

项目构建:使用maven进行构建,web项目war运行

版本:Spring5.0.7版本,Mybatis3.4.5版本,

日志和测试相关:log4j的日志,Junit4.12单元测试和mock测试

数据库:Mysql数据库

### 思路:

目的:将工程项目中的JavaBean使用Spring进行管理(通过xml+注解方式)

1.整合持久层Mapper,包括数据源(c3p0,dbcp,druid等),SqlSessionFactory,Mapper代理对象的整合

2.整合业务层Service,包括事务Bean以及Service的bean的配置

3.整合表现层Controller,使用Springmvc.xml配置文件

4.web.xml加载Spring容器(包括多个Spring的xml配置文件,还分为父子容器)

核心配置文件

springContext-dao.xml

springContext-service.xml

springContext-mvc.xml

web.xml

### 流程

1.创建maven工程,编写pom文件,导入需要的依赖

2.编写核心的配置文件

3.编写demo测试ssm基础工程搭建是否可以正常运行

### 问题

在使用maven文件进行打包的时候会出现无法将资源文件比如:*Mapper.xml文件和\*mapper.java文件在同一个目录下的时候无法打包进去的问题.

解决方法:

1.在pom,build中配置resources插件来解决

```
 <!--扫描配置文件-->
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
```

2.可以把资源文件放置到resources目录下,比如:将*Mapper.xml放置到resources/mapper目录下

需要更改持久层的配置文件,需要在SqlSessionFactory中配置*Mapper.xml文件的位置

```
  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--配置数据源-->
        <property name="dataSource" ref="dataSource"/>
        <!--指定扫描的*Mapper文件的位置-->
        <property name="mapperLocations" value="classpath:mapper/*Mapper.xml"/>
    </bean>

    <!--配置mapper扫描器-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--指定扫描包-->
        <property name="basePackage" value="com.aaron.mapper"/>
    </bean>
```




