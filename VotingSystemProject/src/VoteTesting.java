import java.sql.*;

import javafx.scene.control.TextField;

public class VoteTesting {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/votesystem", "root", "jumantara");
			System.out.println("Database connected");
			
			
			Statement statementVerify = connection.createStatement();
			
			ResultSet resultSetVerify = statementVerify.executeQuery("select Name, MatricNo, FacultyName, CollegeName from voters natural join (faculty, college) where matricNo = '" + 211003 + "'");
				
			while(resultSetVerify.next()) {
				System.out.println(resultSetVerify.getString(1) + " " + resultSetVerify.getString(2) + " " + resultSetVerify.getString(3) + " " + resultSetVerify.getString(4));
		
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
