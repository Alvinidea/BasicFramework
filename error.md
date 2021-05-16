
> Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'cacheManager' available
>
>

- 查看 bean 是否注入成功
```xml
    <bean id="BookServiceImpl" class="com.alvin.service.BookServiceImpl">
        <property name="bookMapper" ref="bookMapper"/>
        <!-- ref="bookMapper" 标红时候的解决方案：
        application-context.xml中增添如下代码：
            <import resource="classpath:spring-dao.xml"/>
            <import resource="classpath:spring-service.xml"/>
         -->
    </bean>
```
- Junit 单元测试，查看代码是否可以得出结果
- 注意spring 和 jdk 的版本问题
- web.xml 配置
```xml
<param-name>contextConfigLocation</param-name>
<!-- 本项目中applicationContext.xml是 SpringMVC 的配置： Dao, Service, Controller -->
<param-value>classpath:applicationContext.xml</param-value>
```
- ApplicationContext.xml

