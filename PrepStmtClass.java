package studentpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepStmtClass {
	Connection con;
	PreparedStatement psmt;
	public void createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","svecw@123");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createStudentDet(String regdno,String name,String branch,int sem) {
		try {
			String query="insert into student values(?,?,?,?)";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1,regdno);
			psmt.setString(2,name);
			psmt.setString(3,branch);
			psmt.setInt(4,sem);
			int rows=psmt.executeUpdate();
			System.out.println(rows+"Rows inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateStudentDet(String regdno,String name) {
		try {
			String query="update student set name=? where regdno=?";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1,"nissy");
			psmt.setString(2,"1210");
			int rows=psmt.executeUpdate();
			System.out.println(rows+"Rows Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteStudentDet(String regdno) {
		try {
			String query="delete from student where regdno=?";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1,regdno);
			int rows=psmt.executeUpdate();
			System.out.println(rows+"Rows deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void readStudentDet() {
		try {
			String query="select * from student";
			PreparedStatement psmt=con.prepareStatement(query);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
				System.out.println("Registration Number:"+rs.getString(1));
				System.out.println("Name of the Student:"+rs.getString(2));
				System.out.println("Branch of the Student:"+rs.getString(3));
				System.out.println("Student Studying Semester:"+rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
