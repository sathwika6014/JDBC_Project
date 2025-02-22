package Section1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicInsertApp {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter id");
		int id=s.nextInt();
		System.out.println("Enter name");
		String name=s.next();
		System.out.println("Enter salary");
		double salary=s.nextDouble();
		System.out.println("Enter deptno");
		int deptno=s.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
			PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, salary);
			ps.setInt(4,deptno);
			int row=ps.executeUpdate();
			System.out.println(row+" : Row inserted");
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
