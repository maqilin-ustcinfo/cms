1.RBAC（Role-Based Access Control）基于角色的权限访问控制
2.利用eclipse绘制ER图
   将org.insightech.er_1.0.0.v20150619-0219.jar复制到eclispe安装目录的plugins下，重启。
   新建ERmaster类型文件db.erm，选择数据库类型。
   生成java实体类和可以执行的DDL语句。
3.搭建SSM框架
  引包,web.xml spring-beans.xml spring-mvc.xml mybatis-cfg.xml
  jdbc.properties log4j.properties
4.spring
  4.1 重要的容器 ApplicationContext：ClassPathXmlApplicationContext和WebXmlApplicationContext
  4.2 声明bean的方式：可以在spring配置文件中声明bean或者用注解；
        描述bean之间的依赖关系，可以在xml中配置，也可注解。不推荐使用autowire byName或者byType
  4.3 spring jdbcTemplate 是spring封装对数据库的访问。
  4.4 AOP将业务逻辑(某个类的某个方法本身要实现的功能)和系统级的服务（系统的日志、事务、权限验证）分离开。
      底层实现通过动态代理：jdk动态代理（只能代理有实现的接口类）/cglib动态代理（包括没有实现的接口类）
      通知可以将切面织入某些类的所有方法中，顾问将切面织入某些类的某些方法中。
      AOP目标就是将切面（系统系的服务）织入某些类的某些方法中。
      异常通知：捕获到方法抛出的异常之后才会执行，如果方法里面try-catch了不会执行异常通知的方法。