package Section1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicUpdateApp {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter id");
		int id=s.nextInt();
		System.out.println("Enter salary");
		double salary=s.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
			PreparedStatement ps=con.prepareStatement("update emp set salary=? where id=?");
			ps.setDouble(1, salary);
			ps.setInt(2, id);
			int row=ps.executeUpdate();
			System.out.println(row+" : Row Updated");
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
