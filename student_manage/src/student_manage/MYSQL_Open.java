package student_manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MYSQL_Open {

	//"static"" is useful using directly in main function
	//public static JFrame frame;
	//private static JPanel panel;

    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	public static final String DBUSER = "root";
	public static final String DBPASS = "";
	Connection con;
	PreparedStatement pstmt;
	String sql;

	public MYSQL_Open() {

		sql = "insert into student_information values(?,?)";

		try {
			con = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
			pstmt = con.prepareStatement(sql);
		} 

		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}

	public void setData_IntoSQL(int ID, String name) {

		try {
		pstmt = con.prepareStatement(sql); 
		pstmt.setInt(1, ID); 
		pstmt.setString(2, name); 
		pstmt.executeUpdate();
		}

		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}

	@Override
	public String toString() {
		try {
			pstmt.close();
			con.close();

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "MYSQL is already closed";

	}
}
