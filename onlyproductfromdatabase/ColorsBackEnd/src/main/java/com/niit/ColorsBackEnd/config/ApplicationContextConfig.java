package com.niit.ColorsBackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ColorsBackEnd.dao.CartDao;
import com.niit.ColorsBackEnd.dao.CartDaoImpl;
import com.niit.ColorsBackEnd.dao.CategoryDao;
import com.niit.ColorsBackEnd.dao.CategoryDaoImpl;

//import com.niit.ColorsBackEnd.dao.CategoryDAO;

import com.niit.ColorsBackEnd.dao.ProductDao;
import com.niit.ColorsBackEnd.dao.ProductDaoImpl;
import com.niit.ColorsBackEnd.dao.ShippingDao;
import com.niit.ColorsBackEnd.dao.ShippingDaoImpl;
import com.niit.ColorsBackEnd.dao.SupplierDao;
import com.niit.ColorsBackEnd.dao.SupplierDaoImpl;
import com.niit.ColorsBackEnd.dao.UserDao;
import com.niit.ColorsBackEnd.dao.UserDaoImpl;
import com.niit.ColorsBackEnd.model.Cart;
import com.niit.ColorsBackEnd.model.Category;
//import com.niit.ColorsBackEnd.model.Category;
import com.niit.ColorsBackEnd.model.Product;
import com.niit.ColorsBackEnd.model.Shipping;
import com.niit.ColorsBackEnd.model.Supplier;
import com.niit.ColorsBackEnd.model.Users;



@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement

public class ApplicationContextConfig {
	
	 @Bean(name = "dataSource")
	    public DataSource getDataSource() {
	    	BasicDataSource dataSource = new BasicDataSource();
	    	dataSource.setDriverClassName("org.h2.Driver");
	    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/cosmaticDb");
	    	dataSource.setUsername("sa");
	    	dataSource.setPassword("");
	    	
	    	return dataSource;
	    }
	    
	  private Properties getHibernateProperties() {
	    	Properties properties = new Properties();
	    	properties.put("hibernate.show_sql", "true");
	    	properties.put("hibernate.format_sql", "true");
	    	properties.put("hibernate.hbm2ddl.auto", "update");
	    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    	return properties;
	    }
	    
	    @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    	sessionBuilder.addProperties(getHibernateProperties());
	    	sessionBuilder.addAnnotatedClasses(Category.class);
	    	sessionBuilder.addAnnotatedClasses(Product.class);
	    	sessionBuilder.addAnnotatedClasses(Supplier.class);
	    	sessionBuilder.addAnnotatedClasses(Users.class);
	    	sessionBuilder.addAnnotatedClasses(Cart.class);
	    	sessionBuilder.addAnnotatedClasses(Shipping.class);
	    	return sessionBuilder.buildSessionFactory();
	    }
	    
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
				SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(
					sessionFactory);

			return transactionManager;
		}
	    
	    @Autowired
	    @Bean(name = "productDao")
	    public ProductDao geProductDao(SessionFactory sessionFactory) {
	    	return new ProductDaoImpl(sessionFactory);
	    }
	    
	    @Autowired
	    @Bean(name="categoryDao")
	    public CategoryDao getCategoryDao(SessionFactory sessionFactory)
	    {
	    	return new CategoryDaoImpl(sessionFactory);
	    }
	    
	    @Autowired
	    @Bean(name="supplierDao")
	    public SupplierDao getSuplierDao(SessionFactory sessionFactory)
	    {
	    	return new SupplierDaoImpl(sessionFactory);
	    }
	    @Autowired
	    @Bean(name="userDao")
	    public UserDao getUserDao(SessionFactory sessionFactory)
	    {
	    	return new UserDaoImpl(sessionFactory);
	    }

	    @Autowired
	    @Bean(name="cartDao")
	    public CartDao getCartDao(SessionFactory sessionFactory)
	    {
			return new CartDaoImpl(sessionFactory);
	    	
	    }
	    @Autowired
	    @Bean(name="shippingDao")
	    public ShippingDao getshDao(SessionFactory sessionFactory)
	    {
			return new ShippingDaoImpl(sessionFactory);
	    	
	    }

}
