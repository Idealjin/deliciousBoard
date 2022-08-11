package com.sangjin.delicious.common.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@MapperScan(value = "com.sangjin.delicious.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {
	
	@Bean(name="dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(
			@Qualifier("dataSource") DataSource dataSource,
			ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("com.sangjin.delicious.domain");
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:mapper/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Primary
	@Bean(name = "sessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(
			@Qualifier("sqlSessionFactory") SqlSessionFactory sessionFactory) {
		return new SqlSessionTemplate(sessionFactory);
	}
	
}
