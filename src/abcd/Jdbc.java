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
	   		  System.out.println("���سɹ�");
	   		  
	   		  
	   		  con=(Connection)DriverManager.getConnection
	   				  ("jdbc:mysql://127.0.0.1:3306/studb", "root","123456");
	   		  System.out.println("�����ɹ�");
	   		  
	   		  
	   		   // ���
	   		   
	   		  Statement sta=(Statement) con.createStatement();
	   		  int n=((java.sql.Statement) sta).executeUpdate("insert studentinfo values('����','10001')");
	   		  if(n>0){
	   			  System.out.println("��ӳɹ�");
	   		  }
	   		  
	   		   // �޸�
	   		   
	   		  Statement sc=(Statement)con.createStatement();
	   		  int m=((java.sql.Statement) sc).executeUpdate("update studentinfo set age=21 where stuid=10001");
	   		  if(m>0){
	   			  System.out.println("�޸ĳɹ�");
	   		  }
	   		  
	   		   // ɾ��
	   		   
	   		  Statement sar=(Statement)con.createStatement();
	   		  int t=((java.sql.Statement) sar).executeUpdate("delete from studentinfo where stuid=10001");
	   		  if(t>0){
	   			  System.out.println("ɾ���ɹ�");
	   		  }
	   		  
	   		   // ��ѯ
	   		   
	   		  Statement tri=(Statement)con.createStatement();
	   		  ResultSet rs=(ResultSet)((java.sql.Statement) tri).executeQuery("select * from studentinfo");
	   		  while(rs.next()){
	   			  String xh=rs.getString(1);
	   			  System.out.println("ѧ��"+xh);
	   			  String name=rs.getString(2);
	   			  System.out.println("����"+name);
	   			  int age=rs.getInt(3);
	   			  System.out.println("����"+age);
	   		  }
	   	  }catch(ClassNotFoundException e){
	   		  
	   		  System.out.println("�]���ҵ�");
	   	  }catch(SQLException sqle){
	   		  System.out.println("�B�Ӯ���");
	   	  }
	     }
	}


