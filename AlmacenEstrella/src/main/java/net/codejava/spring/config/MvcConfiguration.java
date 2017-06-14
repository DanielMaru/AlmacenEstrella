package net.codejava.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import net.codejava.spring.dao.ProductoDAO;
import net.codejava.spring.dao.ProductoDAOImpl;
import net.codejava.spring.dao.ReporteDao;
import net.codejava.spring.dao.ReporteDaoImpl;
import net.codejava.spring.dao.VentasDAO;
import net.codejava.spring.dao.VentasDAOImpl;

@Configuration
@ComponentScan(basePackages="net.codejava.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/estrella");
		dataSource.setUsername("root");
		dataSource.setPassword("Admin");
		
		return dataSource;
	}
	
	@Bean
	public VentasDAO getVentasDao() {
		return new VentasDAOImpl(getDataSource());
	}
	
	@Bean
	public ReporteDao getReporteDao() {
		return new ReporteDaoImpl(getDataSource());
	}
	
	@Bean
	public ProductoDAO getProductoDao(){
		return new ProductoDAOImpl(getDataSource());
	}
}
	