package studentpkg;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStudent {
	Connection con;
	CallableStatement cls;
	public void createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","svecw@123");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createCallable(String rNo) {
		try {
			cls=con.prepareCall("{call get_student_details(?,?,?,?)}");
			cls.setString(1, rNo);
			cls.registerOutParameter(2, Types.VARCHAR);
			cls.registerOutParameter(3, Types.VARCHAR);
			cls.registerOutParameter(4, Types.INTEGER);
			cls.execute();
			System.out.println("Name:"+cls.getString(2));
			System.out.println("Branch:"+cls.getString(3));
			System.out.println("Sem:"+cls.getInt(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void createFunction(String rNo) {
		try {
			cls=con.prepareCall("{?= call get_student_det_function(?)}");
			cls.setString(2, rNo);
			cls.registerOutParameter(1, Types.VARCHAR);
//			cls.registerOutParameter(2, Types.VARCHAR);
//			cls.registerOutParameter(3, Types.INTEGER);
			cls.execute();
			System.out.println("Name of the Student:"+cls.getString(1));
//			System.out.println("Branch:"+cls.getString(2));
//			System.out.println("Semester:"+cls.getInt(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
