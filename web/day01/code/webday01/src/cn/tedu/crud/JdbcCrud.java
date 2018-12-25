package cn.tedu.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * ������������jdbc����ɾ�Ĳ�ҵ��
 */
public class JdbcCrud {
	// ��Ԫ���Է��� @Test + void + public
	// ����jdbc�ļ�������account���в���һ����¼���˻����������Σ����1000��
	@Test
	public void add() {
		Connection conn = null;// �������Ӷ���
		Statement st = null;// ��������������

		try {
			// 1��ע������
			Class.forName("com.mysql.jdbc.Driver");

			// 2����ȡ���ݿ�����java.sql.Connection
			String url = "jdbc:mysql:///jtdb";// ���ݿ�����ӵ�ַ
			String user = "root";
			String password = "root";

			conn = DriverManager.getConnection(url, user, password);

			// 3����ȡ������java.sql.Statement
			st = conn.createStatement();

			// 4��ִ��SQL
			String sql = "insert into account values(null,'taoge',1000)";
			int rows = st.executeUpdate(sql);

			// 5�����������
			System.out.println(rows);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6���ͷ���Դst,conn
			if (st != null) {// �ǿ��ж�
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					st = null;// �ֶ��ÿ�
				}
			}

			if (conn != null) {// �ǿ��ж�
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					conn = null;// �ֶ��ÿ�
				}
			}
		}
	}

	/*
	 * ��������jdbc�ļ����� �޸�account����name��taoge�ļ�¼�� ��moneyֵ��Ϊ1001
	 */
	// ��Ԫ���Է���update
	@Test
	public void update() {
		Connection conn = null;// �������Ӷ���
		Statement st = null;// ��������������

		try {
			// 1��ע������
			Class.forName("com.mysql.jdbc.Driver");

			// 2����ȡ���ݿ�����
			String url = "jdbc:mysql:///jtdb";// �������ݿ�����
			String user = "root";// �����û���
			String password = "root";// ��������

			conn = DriverManager.getConnection(url, user, password);

			// 3����ȡ������
			st = conn.createStatement();

			// 4��ִ��SQL
			String sql = "update account set money=1001 where name='taoge'";
			int rows = st.executeUpdate(sql);

			// 5�����������
			System.out.println(rows);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6���ͷ���Դst,conn
			if (st != null) {// �ǿ��ж�
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					st = null;// �ֶ��ÿ�
				}
			}
			if (conn != null) {// �ǿ��ж�
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					conn = null;// �ֶ��ÿ�
				}
			}
		}
	}

	/*
	 * ����jdbc������ɾ��account����idΪ3�ļ�¼
	 */
	@Test
	public void del() {
		Connection conn = null;//�������Ӷ���
		Statement st = null;//��������������
		
		try {
			// 1��ע������
			Class.forName("com.mysql.jdbc.Driver");

			// 2����ȡ���ݿ�����
			String url="jdbc:mysql:///jtdb";
			String user="root";
			String password="root";
			conn = DriverManager.getConnection(
					url, user, password);
			
			// 3����ȡ������
			st = conn.createStatement();
			
			// 4��ִ��SQL
			String sql =
			  "delete from account where id=3";
			int rows = st.executeUpdate(sql);
			
			// 5�����������
			System.out.println(rows);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 6���ͷ���Դst,conn
			if(st!=null){//�ǿ��ж�
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					st=null;//�ֶ��ÿ�
				}
			}
			if(conn!=null){//�ǿ��ж�
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					conn=null;//�ֶ��ÿ�
				}
			}
			
			
		}

		
	}

}
