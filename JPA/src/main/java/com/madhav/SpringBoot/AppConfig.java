package com.madhav.SpringBoot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;


@Configuration
@ComponentScan("com.madhav.SpringBoot")
@EnableJpaRepositories("com.madhav.SpringBoot")
@EnableTransactionManagement
public class AppConfig {
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/user");
		dataSource.setUsername("root");
		dataSource.setPassword("madh");
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entity = new LocalContainerEntityManagerFactoryBean();
		//set the connection string of the database.
		entity.setDataSource(dataSource());
		//set the entity class to persist in the database
		entity.setPackagesToScan("com.madhav.SpringBoot");
		//provide the implementation for the JPA interface in this case Hibernate
		entity.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entity.setPersistenceUnitName("mysql");
		return entity;
	}
	
	//we can autowire the requirements of an object directly into arguments of another function with/without @Autowired
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory factory) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(factory);
		return manager;
	}
	
	
//	@Bean
//	public EntityManager entityManager(@Autowired EntityManagerFactory entityManagerFactory) {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		return entityManager;
//	}
}
