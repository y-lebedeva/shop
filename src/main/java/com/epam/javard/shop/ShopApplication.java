package com.epam.javard.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;
import java.util.Hashtable;
import java.util.Map;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}




//	@Bean
//	public DataSource userDataSource()
//	{
//		JndiDataSourceLookup lookup = new JndiDataSourceLookup();
//		return lookup.getDataSource("myapp/user");
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
//	{
//		Map<String, Object> properties = new Hashtable<>();
//		properties.put("javax.persistence.schema-generation.database.action",
//				"none");
//		properties.put("hibernate.ejb.use_class_enhancer", "true");
//
//		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
//
//		LocalContainerEntityManagerFactoryBean factory =
//				new LocalContainerEntityManagerFactoryBean();
//		factory.setJpaVendorAdapter(adapter);
//		factory.setDataSource(this.userDataSource());
//		factory.setPackagesToScan("com.wrox.site.entities",
//				"com.wrox.site.converters");
//		factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
//		factory.setValidationMode(ValidationMode.NONE);
//		factory.setJpaPropertyMap(properties);
//		return factory;
//	}
//
//	@Bean
//	public PlatformTransactionManager jpaTransactionManager()
//	{
//		return new JpaTransactionManager(
//				this.entityManagerFactoryBean().getObject()
//		);
//	}
}
