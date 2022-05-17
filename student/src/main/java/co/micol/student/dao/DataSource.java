package co.micol.student.dao;

import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.io.Reader;
import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource { //싱글톤 class 패턴
	private static DataSource dataSource = new DataSource();//자신을 객체로 만들고(자기자신을 생성)
	private DataSource() {}; //praivate로 생성자를 만든다 외부에서 자기자신을 생성하지 못하게
	
	private Connection conn;
	private String driver;
	private String url;
	private String user; //유저는 url에 저장된 url
	private String password; //패스워드는 유저가 가지고 있는 패스워드
	
	public static DataSource getInstance() {
		return dataSource;
	}
	
	public Connection getConnction() { //인스턴스를 
		dbconfiguration();
		try {
			Class.forName(driver); //jdbc드라이버를 내 드라이버와 연결한다 DBMS에서 사용할 driver
			conn = DriverManager.getConnection(url, user, password); //
			System.out.println("DB 연결성공!!!@@@@");
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결실패 ~!");
		}
		return conn;
	}
	
	private void dbconfiguration() {
		Properties properties = new Properties(); // Properties 객체를 통해서 외부에 있는 파일(/db.properties)을 읽어서 내가 쓰겠다 라는 뜻
		String resource = getClass().getResource("/db.properties").getPath();
		try {
			properties.load(new FileReader(resource)); //그냥 getClass().getResource("db.properties").getPath();이거일때는 FileReader로 읽으면 됨
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}

}
