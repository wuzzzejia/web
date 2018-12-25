package cn.tedu.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 这个类用来完成jdbc的增删改查业务
 */
public class JdbcCrud {
	// 单元测试方法 @Test + void + public
	// 利用jdbc的技术，向account表中插入一条记录。账户名是王海涛，余额1000。
	@Test
	public void add() {
		Connection conn = null;// 声明连接对象
		Statement st = null;// 声明传输器对象

		try {
			// 1，注册驱动
			Class.forName("com.mysql.jdbc.Driver");

			// 2，获取数据库连接java.sql.Connection
			String url = "jdbc:mysql:///jtdb";// 数据库的连接地址
			String user = "root";
			String password = "root";

			conn = DriverManager.getConnection(url, user, password);

			// 3，获取传输器java.sql.Statement
			st = conn.createStatement();

			// 4，执行SQL
			String sql = "insert into account values(null,'taoge',1000)";
			int rows = st.executeUpdate(sql);

			// 5，遍历结果集
			System.out.println(rows);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6，释放资源st,conn
			if (st != null) {// 非空判断
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					st = null;// 手动置空
				}
			}

			if (conn != null) {// 非空判断
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					conn = null;// 手动置空
				}
			}
		}
	}

	/*
	 * 需求：利用jdbc的技术， 修改account表里name是taoge的记录， 将money值改为1001
	 */
	// 单元测试方法update
	@Test
	public void update() {
		Connection conn = null;// 声明连接对象
		Statement st = null;// 声明传输器对象

		try {
			// 1，注册驱动
			Class.forName("com.mysql.jdbc.Driver");

			// 2，获取数据库连接
			String url = "jdbc:mysql:///jtdb";// 声明数据库连接
			String user = "root";// 声明用户名
			String password = "root";// 声明密码

			conn = DriverManager.getConnection(url, user, password);

			// 3，获取传输器
			st = conn.createStatement();

			// 4，执行SQL
			String sql = "update account set money=1001 where name='taoge'";
			int rows = st.executeUpdate(sql);

			// 5，遍历结果集
			System.out.println(rows);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6，释放资源st,conn
			if (st != null) {// 非空判断
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					st = null;// 手动置空
				}
			}
			if (conn != null) {// 非空判断
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					conn = null;// 手动置空
				}
			}
		}
	}

	/*
	 * 利用jdbc技术，删除account表中id为3的记录
	 */
	@Test
	public void del() {
		Connection conn = null;//声明连接对象
		Statement st = null;//声明传输器对象
		
		try {
			// 1，注册驱动
			Class.forName("com.mysql.jdbc.Driver");

			// 2，获取数据库连接
			String url="jdbc:mysql:///jtdb";
			String user="root";
			String password="root";
			conn = DriverManager.getConnection(
					url, user, password);
			
			// 3，获取传输器
			st = conn.createStatement();
			
			// 4，执行SQL
			String sql =
			  "delete from account where id=3";
			int rows = st.executeUpdate(sql);
			
			// 5，遍历结果集
			System.out.println(rows);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 6，释放资源st,conn
			if(st!=null){//非空判断
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					st=null;//手动置空
				}
			}
			if(conn!=null){//非空判断
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					conn=null;//手动置空
				}
			}
			
			
		}

		
	}

}
