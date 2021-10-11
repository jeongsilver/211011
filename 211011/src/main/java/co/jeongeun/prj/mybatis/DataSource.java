package co.jeongeun.prj.mybatis;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class DataSource {
	private static SqlSessionFactory sqlSessionFactory;
	
	
	private DataSource() {}
	
	public static SqlSessionFactory getInstance() {
		String resource = "/mybatisConfig.xml";
		InputStream inputStream ;
		try {
			
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	
	}
}
