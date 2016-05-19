package si.smart.ferme.controllers;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class ConfigMail {
	/*
	@Bean
	public JavaMailSenderImpl mailSender(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("projet.gestion.fermes@gmail.com");
		mailSender.setPassword("SI-SMART1970");
		Properties p = new Properties();
		p.setProperty("mail.transport.protocol", "stmp");
		p.setProperty("mail.smtp.auth", "true");
		p.setProperty("mail.smtp.starttls.enable", "true");
		p.setProperty("mail.debug", "true");
		mailSender.setJavaMailProperties(p);
		return mailSender;
	}
	
	*/
	
	@Bean
	public TestCron test(){
		return new TestCron();
	}
}

/*
<bean id="mailSender" class="org.springframework.mail.javamail.JavaMailSenderImpl">
		<property name="host" value="smtp.gmail.com" />
		<property name="port" value="587" />
		<property name="username" value="projet.gestion.fermes@gmail.com" />
		<property name="password" value="SI-SMART1970" />
		 
		<!-- The name of the property, following JavaBean naming conventions -->
		<property name="javaMailProperties">
		<props>
		<prop key="mail.transport.protocol">smtp</prop>
		<prop key="mail.smtp.auth">true</prop>
		<prop key="mail.smtp.starttls.enable">true</prop>
		<prop key="mail.debug">true</prop>
		</props>
		</property>
	</bean> 



*/