package com.iu.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

public class DBConnection {

	//getConnection
	public static Connection getConnection() throws Exception{
		//멤버 메서드 (X)
		//클래스 메서드 (접근지정자 = static)
		//객체를 만들지 않고 호출, 클래스명.메소드명
		//localhost는 127.0.0.1 또는 자신의 실제 ip주소 써도 된다
		
		//1. 연결 정보
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String driver ="oracle.jdbc.driver.OracleDriver";
		
		//2.Driver를 메모리에 로딩
		Class.forName(driver);
		
		//3. DB 연결
		return DriverManager.getConnection(url, user, password);	
	}
	
	//배포 전 삭제 하세요
//	public static void main(String[] args){
//		try {
//			Connection connection = DBConnection.getConnection();
//			System.out.println(connection != null);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public static void disConnection(ResultSet rs, PreparedStatement st, Connection connection) throws Exception{
		rs.close();
		st.close();
		connection.close();
	}
	
	public static void disConnection(PreparedStatement st, Connection connection) throws Exception{
		st.close();
		connection.close();
	}
	
}
