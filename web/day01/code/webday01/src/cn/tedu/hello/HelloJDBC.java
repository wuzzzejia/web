package cn.tedu.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

public class HelloJDBC {

	//单元测试方法：@Test  +  void
	@Test
	public void hello(){
		Connection conn = null;//声明连接对象
		Statement st = null;//声明传输器对象
		ResultSet rs = null;//声明结果集对象
		
		try {
	//		1，注册驱动com.mysql.jdbc.Driver
			DriverManager.registerDriver(new Driver());
			
	//		2，获取数据库连接java.sql.Connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jtdb", 
					"root","root");
			
	//		3，获取传输器java.sql.Statement
			st = conn.createStatement();
			
	//		4，执行SQL。java.sql.ResultSet
			String sql ="select * from user";
			rs = st.executeQuery(sql);
			
	//		5，遍历结果集
			while(rs.next()){
				//根据列的索引获取第一列的数据
	//			String id = rs.getString(1);
				//根据列的名字获取第一列的数据
				String id = rs.getString("id");
	//			int id1  = rs.getInt(1);
				
				//根据列的索引获取第二列的数据
				String username = rs.getString(2);
				
				//根据列的索引获取第三列的数据
				String password = rs.getString(3);
				
				System.out.println(id+username+password);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{//保证资源一定会被释放
	//		6，释放资源
			//释放结果集资源
			if(rs!=null){//防止空指针异常
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					rs=null;//手动释放资源
				}
			}
			//释放传输器资源
			if(st!=null){//防止控指针异常
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					st=null;//手动释放资源
				}
			}
			//释放连接资源
			if(conn!=null){//防止控指针异常
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					conn=null;//手动释放资源
				}
			}
		}
		
	}
	
	
}




