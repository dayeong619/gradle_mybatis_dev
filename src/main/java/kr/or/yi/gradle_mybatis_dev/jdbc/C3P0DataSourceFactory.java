package kr.or.yi.gradle_mybatis_dev.jdbc;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0DataSourceFactory implements DataSourceFactory {

	private ComboPooledDataSource dataSource; //기본적으로 null초기화 되어 있음.
	
	
	@Override
	public void setProperties(Properties props) { //application.properties에 정보가 넘어온다.
		dataSource = new ComboPooledDataSource();
		dataSource.setPassword(props.getProperty("password"));
		dataSource.setJdbcUrl(props.getProperty("url"));
		dataSource.setUser(props.getProperty("username"));
		try {
			dataSource.setDriverClass(props.getProperty("driver"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public DataSource getDataSource() {
		return dataSource; 
	}

}
