package studentpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementStudent {
	Connection con;
	Statement stmt;
	public void createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","svecw@123");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void selectStudent() {
		try {
			String query="select * from student";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println("regd No:"+rs.getString(1));
				System.out.println("Name of the Student:"+rs.getString(2));
				System.out.println("Branch:"+rs.getString(3));
				System.out.println("Studying Semester:"+rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void insertStdData() {
		try {
			String regdno="1211";
			String name="than";
			String branch="ece";
			int sem=4;
			String qry="insert into student values('"+regdno+"','"+name+"','"+branch+"',"+sem+")";
			Statement stmt=con.createStatement();
			int res=stmt.executeUpdate(qry);
			System.out.println("Inserted Student data:"+res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateStdData() {
		try {
			int sem=7;
			String regdno="1780";
			String query="update student set sem="+sem+" where regdno="+regdno;
			Statement stmt=con.createStatement();
			int rows=stmt.executeUpdate(query);
			System.out.println("Updated Student Details:"+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
