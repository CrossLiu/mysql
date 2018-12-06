package mysql_demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operation_mysql {

	public static void test() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//驱动程序名
		String driver="com.mysql.jdbc.Driver";
		//访问的数据库地址
		String url="jdbc:mysql://localhost:3306/jeeplatform?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8";
		//数据库用户名和密码
		String user="root";
		String pwd="newrootpassword";
		
		
		//加载驱动程序
		Class.forName(driver);
		//1.getConnection方法，连接MySQL数据库
		//声明Connection对象
		Connection con=DriverManager.getConnection(url,user,pwd);
		if (!con.isClosed()) {
			System.out.println("成功连接到数据库！");
		}
		//2.创建statement类对象，用来执行SQL语句
		Statement statement=con.createStatement();
		//要执行的sql语句
		String sql="select * from sys_menu";
		//3.ResultSet类，用来存放获取的结果集
		ResultSet rSet=statement.executeQuery(sql);
		System.out.println("-----------------");
		System.out.println("执行结果如下所示:");  
		System.out.println("-----------------");  
		System.out.println("MenuID" + "\t" + "Menuname");  
		System.out.println("-----------------");  
		//System.out.println(rSet.toString());
		//声明menuId menuName来存储数据库对应的列
		String id = null;
		String name=null;
		while(rSet.next()) {
			//获取数据库menuId这列数据
			id=rSet.getString("menuId");
			//获取menuName这列数据
			name=rSet.getString("menuName");
			
			System.out.println(id+"\t"+name);
		}
		
		rSet.close();
		con.close();

	}

}
