## 在线考试系统
###（一）系统说明
**制作试卷：**教师可以在线制作试卷，包括选择题，多选题，判断题，简答题。    
**学生：**学生可以搜索到试卷，然后参加考试，提交答案。    
**系统：**系统依据学生的作答，和老师给的答案自动判分，老师也可依据学生作答给出他的分数。    
**特点：**本系统还设计了一种新的评分方式，依据学生堆答案的确信度来评分。
###（二）技术
本系统采用spring开发，整合了springMVC，spring的IOC，hibernate。前台采用jquery validation做注册校验。

几个配置文件    
1. mvc-config.xml 配置spring MVC

	<?xml version="1.0" encoding="UTF-8"?>
	
	<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:context="http://www.springframework.org/schema/context"
		xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
			http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
			http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
		<mvc:annotation-driven />
	    <!-- Uncomment and your base-package here: -->
	         <context:component-scan base-package="com.hainan.cs.controller"/> 
	    <!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
		<!-- 让springmvc放过存放静态资源的请求 -->
		<mvc:resources mapping="/resources/**" location="/resources/" />
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		        <!-- Example: a logical view name of 'showMessage' is mapped to '/WEB-INF/jsp/showMessage.jsp' -->
		        <property name="prefix" value="/WEB-INF/view/"/>
		        <property name="suffix" value=".jsp"/>
		</bean>
	
	</beans>

2. application-config.xml 配置数据源等

	<?xml version="1.0" encoding="UTF-8"?>
	
	<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:context="http://www.springframework.org/schema/context"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
			http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
	    <!-- 配置数据源 -->
	    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
			destroy-method="close">
			<property name="driverClassName" value="com.mysql.jdbc.Driver" />
			<property name="url" value="jdbc:mysql://localhost:3306/examsys" />
			<property name="username" value="root" />
			<property name="password" value="root" />
		</bean>
	
		<!-- 配置session factory -->
		<!-- Hibernate 4 SessionFactory Bean definition -->
		<bean id="hibernate4SessionFactory"
			class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
			<property name="dataSource" ref="dataSource" />
			<property name="hibernateProperties">
				<props>
					<prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
					<prop key="hibernate.hbm2ddl.auto">update</prop>
					<prop key="hibernate.show_sql">true</prop>
					<prop key="hibernate.format_sql">true</prop>
				</props>
			</property>
			<property name="mappingLocations">
				<list>
					<value>classpath:/com/hainan/cs/hbm/*.hbm.xml</value>
				</list>
			</property>
		</bean>
		<bean id="userdao" class="com.hainan.cs.dao.UserDaoImp">
			<property name="sessionFactory" ref="hibernate4SessionFactory"></property>
		</bean>
		<bean id="judgedao" class="com.hainan.cs.dao.JudgeDaoImp">
			<property name="sessionfactory" ref="hibernate4SessionFactory"></property>
		</bean>
		<bean id="answerdao" class="com.hainan.cs.dao.AnswerDaoImp">
			<property name="sessionfactory" ref="hibernate4SessionFactory"></property>
		</bean>
		<bean id="choicedao" class="com.hainan.cs.dao.ChoiceDaoImp">
			<property name="sessionfactory" ref="hibernate4SessionFactory"></property>
		</bean>
		<bean id="mcqdao" class="com.hainan.cs.dao.MCQDaoImp">
			<property name="sessionfactory" ref="hibernate4SessionFactory"></property>
		</bean>
		<bean id="paperdao" class="com.hainan.cs.dao.PaperDaoImp">
			<property name="sessionfactory" ref="hibernate4SessionFactory"></property>
		</bean>
		<bean id="questiondao" class="com.hainan.cs.dao.QuestionDaoImp">
			<property name="sessionfactory" ref="hibernate4SessionFactory"></property>
		</bean>
		<bean id="testdao" class="com.hainan.cs.dao.TestDaoImp">
			<property name="sessionfactory" ref="hibernate4SessionFactory"></property>
		</bean>
			<bean id="newtestdao" class="com.hainan.cs.dao.NewTestDaoImp">
			<property name="sessionfactory" ref="hibernate4SessionFactory"></property>
		</bean>
			<bean id="newanswerdao" class="com.hainan.cs.dao.NewAnswerDaoImp">
			<property name="sessionfactory" ref="hibernate4SessionFactory"></property>
		</bean>
	</beans>

3. web.xml

	<?xml version="1.0" encoding="ISO-8859-1"?>
	<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	         xmlns="http://java.sun.com/xml/ns/javaee"
	         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
	         id="WebApp_ID" version="2.5">
	
	    <display-name>examsys</display-name>
	    
	   <!--
			- Location of the XML file that defines the root application context.
			- Applied by ContextLoaderListener.
		-->
	    <context-param>
	        <param-name>contextConfigLocation</param-name>
	        <param-value>classpath:spring/application-config.xml</param-value>
	    </context-param>
	
	    <listener>
	        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	    </listener>
	    
	    
	    <!--
			- Servlet that dispatches request to registered handlers (Controller implementations).
		-->
	    <servlet>
	        <servlet-name>dispatcherServlet</servlet-name>
	        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	        <init-param>
	            <param-name>contextConfigLocation</param-name>
	            <param-value>/WEB-INF/mvc-config.xml</param-value>
	        </init-param>
	        <load-on-startup>1</load-on-startup>
	    </servlet>
	
	    <servlet-mapping>
	        <servlet-name>dispatcherServlet</servlet-name>
	        <url-pattern>/</url-pattern>
	    </servlet-mapping>
	
	</web-app>

###(三)截图

1. 主页

![](http://i.imgur.com/yxpEyRw.jpg)

2. 登陆和注册

![](http://i.imgur.com/wESKrQh.jpg)

![](http://i.imgur.com/kRybw6n.jpg)

3. 个人信息

![](http://i.imgur.com/r8bxUOH.jpg)

4. 创建试卷

![](http://i.imgur.com/TOOIESE.jpg)

![](http://i.imgur.com/rA5VPpW.jpg)

![](http://i.imgur.com/IN9olbt.jpg)

5. 参加考试

![](http://i.imgur.com/7vPSppu.jpg)

![](http://i.imgur.com/p6giLCl.jpg)

![](http://i.imgur.com/tzX4Hb9.jpg)

6. 搜索考试

![](http://i.imgur.com/sPulzwU.jpg)