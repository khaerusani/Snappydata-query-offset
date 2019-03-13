package edu.snappydata.offset.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnappyOffsetConfig {
	
	@Value("${snappy.url}")
	public String snappyUrl;

	@Value("${snappy.user}")
	public String snappyUser;
	
	@Value("${snappy.password}")
	public String snappyPassword;
	
	@Value("${snappy.database}")
	public String snappyDatabase;
	
	@Bean
	public Properties getProperties() {
        Properties properties = new Properties();
        
        properties.put("url", snappyUrl);
        properties.put("user", snappyUser);
        properties.put("password", snappyPassword);
        properties.put("databaseName", snappyDatabase);
        properties.put("driver", "io.snappydata.jdbc.ClientDriver");
        properties.put("route-query", "false");
        
		return properties;
	}
	
    @Bean
    public Connection connection() throws SQLException {
        return DriverManager.getConnection(snappyUrl, getProperties());
    }
}
