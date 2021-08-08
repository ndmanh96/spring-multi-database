package com.manhcode.jpa.demo.config;


import com.manhcode.jpa.demo.product.entity.Product;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "productEntityManagerFactory",
        transactionManagerRef = "productTransactionManager",
        basePackages = "com.manhcode.jpa.demo.product")
public class ProductConfig {

    @Primary
    @Bean(name = "productDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource-product")
    public DataSourceProperties productDataSourceProperties() {
        return  new DataSourceProperties();
    }

    @Primary
    @Bean(name = "productDataSource")
    public DataSource productDataSource() {
        return productDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "productEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean productEntityManagerFactory(EntityManagerFactoryBuilder builder) {
//        HashMap<String, String> productJpaProperties = new HashMap<>();
//        productJpaProperties.put("")
        return builder.dataSource(productDataSource()).packages(Product.class)
                .persistenceUnit("productDataSource")
//                .properties(new )
                .build();
    }

    @Primary
    @Bean(name= "productTransactionManager")
    public PlatformTransactionManager productTransactionManager(@Qualifier("productEntityManagerFactory") EntityManagerFactory productEntityManagerFactory) {
        return  new JpaTransactionManager(productEntityManagerFactory);
    }
}
