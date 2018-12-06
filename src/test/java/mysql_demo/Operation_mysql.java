package mysql_demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operation_mysql {

	public static void test() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//����������
		String driver="com.mysql.jdbc.Driver";
		//���ʵ����ݿ��ַ
		String url="jdbc:mysql://localhost:3306/jeeplatform?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8";
		//���ݿ��û���������
		String user="root";
		String pwd="newrootpassword";
		
		
		//������������
		Class.forName(driver);
		//1.getConnection����������MySQL���ݿ�
		//����Connection����
		Connection con=DriverManager.getConnection(url,user,pwd);
		if (!con.isClosed()) {
			System.out.println("�ɹ����ӵ����ݿ⣡");
		}
		//2.����statement���������ִ��SQL���
		Statement statement=con.createStatement();
		//Ҫִ�е�sql���
		String sql="select * from sys_menu";
		//3.ResultSet�࣬������Ż�ȡ�Ľ����
		ResultSet rSet=statement.executeQuery(sql);
		System.out.println("-----------------");
		System.out.println("ִ�н��������ʾ:");  
		System.out.println("-----------------");  
		System.out.println("MenuID" + "\t" + "Menuname");  
		System.out.println("-----------------");  
		//System.out.println(rSet.toString());
		//����menuId menuName���洢���ݿ��Ӧ����
		String id = null;
		String name=null;
		while(rSet.next()) {
			//��ȡ���ݿ�menuId��������
			id=rSet.getString("menuId");
			//��ȡmenuName��������
			name=rSet.getString("menuName");
			
			System.out.println(id+"\t"+name);
		}
		
		rSet.close();
		con.close();

	}

}
