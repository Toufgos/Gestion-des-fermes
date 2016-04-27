package si.smart.ferme.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import si.smart.ferme.dao.Dao;
import si.smart.ferme.dao.DaoImp;
import si.smart.ferme.metier.Metier;
import si.smart.ferme.metier.MetierImp;

@EnableTransactionManagement
@Configuration
public class ConfigClass {

	@Bean
	public Dao dao(){
		return new DaoImp();
	}
	
	@Bean
	public Metier metier(){
		return new MetierImp(dao());
	}
	

	
	@Bean
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource d=new DriverManagerDataSource();
		d.setUrl("jdbc:mysql://localhost:3306/Gestion_Fermes");
		d.setDriverClassName("com.mysql.jdbc.Driver");
		d.setUsername("root");
		d.setPassword("");
		return d;
	}
	
	@Bean
	public DefaultPersistenceUnitManager persistenceUnitManager(){
		DefaultPersistenceUnitManager persistenceUnitManager= new DefaultPersistenceUnitManager();
		persistenceUnitManager.setPersistenceXmlLocation("classpath*:META-INF/persistence.xml");
		persistenceUnitManager.setDefaultDataSource(dataSource());
		return persistenceUnitManager;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory= new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setPersistenceUnitManager(persistenceUnitManager());
		entityManagerFactory.setPersistenceUnitName("MYAPP");
		return entityManagerFactory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory( entityManagerFactory().getNativeEntityManagerFactory() );
		return transactionManager;
	}
	
	/*
	 * 
	 * <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
		<property name="url" value="jdbc:mysql://localhost:3306/Gestion_Fermes"></property>
		<property name="username" value="root"></property>
		<property name="password" value=""></property>
	</bean>
	
	<bean id="persistenceUnitManager" class="org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager">
		<property name="persistenceXmlLocations">
			<list>
				<value>classpath*:META-INF/persistence.xml</value>
			</list>
		</property>
		<property name="defaultDataSource" ref="dataSource"></property>
	</bean>
	<bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
		<property name="persistenceUnitManager" ref="persistenceUnitManager"></property>
		<property name="persistenceUnitName" value="MYAPP"></property>
	</bean>
	<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
		<property name="entityManagerFactory" ref="entityManagerFactory"></property>
	</bean>
	
	 * */
	
}
