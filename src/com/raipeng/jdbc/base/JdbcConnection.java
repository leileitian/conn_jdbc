package com.raipeng.jdbc.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {
	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://192.168.1.107:5432/mydb";
	private static String user = "postgres";
	private static String password = "2022236";
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static void main(String[] args) {
		int id_count = 8;
		//String sql = "select t.* from app_customer t";
		String insert_sql = "insert into app_customer(id,name,password) values (?,?,?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			//设置事务
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(insert_sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id_count);
			ps.setString(2, "java");
			ps.setString(3, "android");
			ps.executeUpdate();
			//获得插入的主键值
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
			    long id = generatedKeys.getLong(1);
			    System.out.println("insert id :" + id);
			}
			/*while(rs.next()){
				System.out.println("1:"+rs.getInt(1));
				System.out.println("2:"+rs.getString(2));
				System.out.println("3:"+rs.getString(3));
			}*/
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
