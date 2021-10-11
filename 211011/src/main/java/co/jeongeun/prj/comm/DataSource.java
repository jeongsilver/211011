package co.jeongeun.prj.comm;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;

public class DataSource { //DAO (Data Access object) 데이터를 접근할 수 있는 객체
	private static DataSource dataSource = new DataSource();//싱글톤
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private DataSource() {
		//Singleton Class로 외부에서 날 생성하지 못하게 함
		config(); //생성될 때 한번만 실행 
	}
	public static DataSource getInstance() {
		return dataSource;
		
	}
	
	private void config() {
		Properties properties = new Properties(); //얘가 뭐지
		String resource = getClass().getResource("/db.properties").getFile(); //소스를 읽겠다
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
//		config();//파일을 읽는 메소드를 수행
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password); //getdriver??
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn; 
	}
}
