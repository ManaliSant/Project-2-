package com.coll.dbconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coll.models.Blog;
import com.coll.models.Forum;
import com.coll.models.Job;
import com.coll.models.UserDetail;

@Configuration
@ComponentScan("com.coll")
@EnableTransactionManagement
public class DBConfig {

	@Bean(name="datasource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("system");
		dataSource.setPassword("password");
		System.out.println("--Created the DataSource -----");
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		/*hibernateProp.put("hibernate.hbm2ddl.auto", "create");*/
		hibernateProp.put("hibernate.show_sql","true");

		LocalSessionFactoryBuilder factoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
		factoryBuilder.addProperties(hibernateProp);

		factoryBuilder.addAnnotatedClass(Blog.class);
		factoryBuilder.addAnnotatedClass(Forum.class);
		factoryBuilder.addAnnotatedClass(UserDetail.class);
		factoryBuilder.addAnnotatedClass(Job.class);

		SessionFactory sessionFactory = factoryBuilder.buildSessionFactory();
		System.out.println("--Created the sessionFactory -----");
		return sessionFactory;
	}

	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		System.out.println("--Created the TranactionManager -----");
		return new HibernateTransactionManager(sessionFactory);
	}
}