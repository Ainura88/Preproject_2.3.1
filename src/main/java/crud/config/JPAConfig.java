package crud.config;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("crud.model");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties prop = new Properties();
        prop.setProperty(Environment.HBM2DDL_AUTO, "create-drop");
        prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        emf.setJpaProperties(prop);
        return emf;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springbootdemo");
        dataSource.setUsername("Ainura");
        dataSource.setPassword("dfDQA_868");
        return dataSource;
    }
}