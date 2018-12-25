package cn.tedu.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

public class HelloJDBC {

	//��Ԫ���Է�����@Test  +  void
	@Test
	public void hello(){
		Connection conn = null;//�������Ӷ���
		Statement st = null;//��������������
		ResultSet rs = null;//�������������
		
		try {
	//		1��ע������com.mysql.jdbc.Driver
			DriverManager.registerDriver(new Driver());
			
	//		2����ȡ���ݿ�����java.sql.Connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jtdb", 
					"root","root");
			
	//		3����ȡ������java.sql.Statement
			st = conn.createStatement();
			
	//		4��ִ��SQL��java.sql.ResultSet
			String sql ="select * from user";
			rs = st.executeQuery(sql);
			
	//		5�����������
			while(rs.next()){
				//�����е�������ȡ��һ�е�����
	//			String id = rs.getString(1);
				//�����е����ֻ�ȡ��һ�е�����
				String id = rs.getString("id");
	//			int id1  = rs.getInt(1);
				
				//�����е�������ȡ�ڶ��е�����
				String username = rs.getString(2);
				
				//�����е�������ȡ�����е�����
				String password = rs.getString(3);
				
				System.out.println(id+username+password);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{//��֤��Դһ���ᱻ�ͷ�
	//		6���ͷ���Դ
			//�ͷŽ������Դ
			if(rs!=null){//��ֹ��ָ���쳣
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					rs=null;//�ֶ��ͷ���Դ
				}
			}
			//�ͷŴ�������Դ
			if(st!=null){//��ֹ��ָ���쳣
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					st=null;//�ֶ��ͷ���Դ
				}
			}
			//�ͷ�������Դ
			if(conn!=null){//��ֹ��ָ���쳣
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					conn=null;//�ֶ��ͷ���Դ
				}
			}
		}
		
	}
	
	
}




