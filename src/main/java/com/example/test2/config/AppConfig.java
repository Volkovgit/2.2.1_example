package com.example.test2.config;

import java.util.Properties;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.test2.model.Car;
import com.example.test2.model.User;
import com.example.test2.service.UserService;
import com.example.test2.service.UserServiceImpl;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.example.test2")
public class AppConfig {

   @Autowired
   private Environment env;


   @Bean
   public DataSource getDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      System.out.println(env);
      dataSource.setDriverClassName(env.getProperty("pg.driver_class"));
      dataSource.setUrl(env.getProperty("pg.url"));
      dataSource.setUsername(env.getProperty("pg.username"));
      dataSource.setPassword(env.getProperty("pg.password"));
      return dataSource;
   }

   @Bean
   public LocalSessionFactoryBean getSessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
      factoryBean.setDataSource(getDataSource());

      Properties props=new Properties();
      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
      props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
      props.put("hibernate.dialect",env.getProperty("hibernate.dialect"));

      factoryBean.setAnnotatedClasses(User.class,Car.class);
//      factoryBean.setAnnotatedClasses(Car.class);

      factoryBean.setHibernateProperties(props);

      return factoryBean;
   }

   @Bean
   public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      return transactionManager;
   }
}
