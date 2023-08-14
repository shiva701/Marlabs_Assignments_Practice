package com.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.demo.dao.LoginFormDAO;
import com.demo.dao.LoginFormDAOImpl;

/**
 * The Class MVCConfiguration.
 */
@Configuration
@ComponentScan("com.demo")
@EnableWebMvc
public class MVCConfiguration {

	/**
	 * Gets the view resolver.
	 *
	 * @return the view resolver
	 */
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

	/**
	 * Gets the data source.
	 *
	 * @return the data source
	 */
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/tasks");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("admin1234");
		return driverManagerDataSource;
	}
	
	
	/**
	 * Gets the login form DAO.
	 *
	 * @return the login form DAO
	 */
	@Bean
	public LoginFormDAO getLoginForm() {
		System.out.println("creating the bean login form DAO");
		return new LoginFormDAOImpl(getDataSource());
	}

}
