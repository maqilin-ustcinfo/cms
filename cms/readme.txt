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
  4.5 spring 事务：原子性atomicity，一致性consistency，隔离性isolation，持久性durability
      传播属性：PROPAGATION_REQUIRED PROPAGATION_REQUIED_NEW
      隔离级别：事务并发的问题（脏读，不可重复读，幻读）事务的隔离级别要得到底层数据库引擎的支持isolation
      @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
5.mybatis
    parameterType 输入参数
    * 简单类型的单个参数
    需求:根据用户id查询用户信息
    * 简单类型的多个参数
    需求:通过登录名和密码验证用户是否存在
    * 包装类对象作为输入参数进行查询
    需求:根据界面输入的用户名称或者登录名称来查询符合条件的用户列表

    resultType/resultMap对象
    * 简单类型的输出  Integer String  Long
    * 对象的输出
    * HashMap的输出
    * resultMap对象输出
     #{}: 解析为一个 JDBC 预编译语句（prepared statement）的参数标记符,一个 #{} 被解析为一个参数占位符,防止sql注入。
     ${}: 仅仅为一个纯碎的 string 替换,在动态 SQL 解析阶段将会进行变量替换
     传入一个不改变的字符串或者传入数据库字段(列名)，例如要传入order by 后边的参数
          这种情况下必须使用${}。
     * <association property="dept" javaType="dept"> 一对一
       <collection property="emps" ofType="employee"> 一对多
     * 在resultMap中使用association或者collection，即可使用延迟加载。
     * mybatis一级缓存在和spring整合的时候不存在，每次关闭sqlsession
       二级：以namespace为单位
      <!--开启二级缓存  -->
      <setting name="cacheEnabled" value="true"/>
      需要在mapper映射文件加入<cache/>标签才可以触发此映射文件开启二级缓存。
      在映射文件用到的查询对象必须序列化。
      	如果需要禁用某个statment的缓存，可以在这个statement里面单独设置 <useCache = "false">
     *  分页在service层这样写。
        PageHelper.startPage(1, 10);
        List<User> userList = userMapper.getUserList();
        PageInfo<User> pageInfo = new PageInfo<User>(userList) ;
        return pageInfo;
6 springmvc
    6.1Restful风格的URL，对应的CRUD分别为：
       创建：http://www.tz.edu/emp   method: POST
       获取：http://www.tz.edu/emp/id   method: GET
       修改：http://www.tz.edu/emp    method: PUT
       删除：http://www.tz.edu/emp/id    method: DELETE