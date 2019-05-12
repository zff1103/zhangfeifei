package abcd;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
	 public static void main(String[] args){
	   	  Connection con=null;
	   	  try{
	   		  Class.forName("com.mysql.jdbc.Driver");
	   		  System.out.println("加载成功");
	   		  
	   		  
	   		  con=(Connection)DriverManager.getConnection
	   				  ("jdbc:mysql://127.0.0.1:3306/studb", "root","123456");
	   		  System.out.println("创建成功");
	   		  
	   		  
	   		   // 添加
	   		   
	   		  Statement sta=(Statement) con.createStatement();
	   		  int n=((java.sql.Statement) sta).executeUpdate("insert studentinfo values('张三','10001')");
	   		  if(n>0){
	   			  System.out.println("添加成功");
	   		  }
	   		  
	   		   // 修改
	   		   
	   		  Statement sc=(Statement)con.createStatement();
	   		  int m=((java.sql.Statement) sc).executeUpdate("update studentinfo set age=21 where stuid=10001");
	   		  if(m>0){
	   			  System.out.println("修改成功");
	   		  }
	   		  
	   		   // 删除
	   		   
	   		  Statement sar=(Statement)con.createStatement();
	   		  int t=((java.sql.Statement) sar).executeUpdate("delete from studentinfo where stuid=10001");
	   		  if(t>0){
	   			  System.out.println("删除成功");
	   		  }
	   		  
	   		   // 查询
	   		   
	   		  Statement tri=(Statement)con.createStatement();
	   		  ResultSet rs=(ResultSet)((java.sql.Statement) tri).executeQuery("select * from studentinfo");
	   		  while(rs.next()){
	   			  String xh=rs.getString(1);
	   			  System.out.println("学号"+xh);
	   			  String name=rs.getString(2);
	   			  System.out.println("姓名"+name);
	   			  int age=rs.getInt(3);
	   			  System.out.println("姓名"+age);
	   		  }
	   	  }catch(ClassNotFoundException e){
	   		  
	   		  System.out.println("沒有找到");
	   	  }catch(SQLException sqle){
	   		  System.out.println("連接異常");
	   	  }
	     }
	}


