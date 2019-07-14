package org.lba.spring4.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"org.lba.spring4"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"org.lba.spring4.db.repository"})
public class DatabaseConfig {

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:mydatabase;DB_CLOSE_DELAY=-1");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		/**/
		/**/
		return dataSource;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource());
		emf.setPackagesToScan("org.lba.spring4.db.model");
		emf.setJpaVendorAdapter(getHibernateAdapter());
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");
		jpaProperties.put("hibernate.show_sql", "true");
		jpaProperties.put("hibernate.format_sql","true");
		emf.setJpaProperties(jpaProperties);
		return emf;
	}
	@Bean
	public JpaVendorAdapter getHibernateAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean(initMethod="start",destroyMethod="stop")
	public org.h2.tools.Server h2WebConsonleServer () throws SQLException {
		return org.h2.tools.Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "9010");
	}
}
