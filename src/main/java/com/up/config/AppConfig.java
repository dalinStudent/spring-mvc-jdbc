package com.up.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.up.dao.EmployeeDAO;
import com.up.dao.EmployeeDAOImpl;

@Configuration
@ComponentScan({"com.up"})
public class AppConfig {
	@Bean
	public InternalResourceViewResolver viewResource() {
		InternalResourceViewResolver viewer = new InternalResourceViewResolver();
		viewer.setPrefix("WEB-INF/views/");
		viewer.setSuffix(".jsp");
		return viewer;
	}
	
	@Bean
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/db_emps");
		ds.setUsername("root");
		ds.setPassword("");
		System.out.println(ds);
		return ds;
	}

	@Bean
	public EmployeeDAO getEmployeeDao() {
		return new EmployeeDAOImpl(getDataSource());
	}
}
