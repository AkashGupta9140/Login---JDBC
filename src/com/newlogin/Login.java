package com.newlogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Scanner sc = new Scanner(System.in);
		String userId=null;
		String pass=null;
		int result=0;
		
		try {
			System.out.println("\t\t\t******** Welcome to Login Panel **********");
			System.out.print("\t\t\tEnter UserId : ");
			userId = sc.next();
			System.out.print("\t\t\tEnter Pass : ");
			pass = sc.next();
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AkashGupta","AkashGupta");
			String query="select count (*) from Login where userId = ? and pass = ?";
			ps=con.prepareStatement(query);
			ps.setString(1, userId);
			ps.setString(2,pass);
			rs=ps.executeQuery();
			if(rs!=null)
			{
				if(rs.next()!=false)
				{
					result=rs.getInt(1);
				}
			}
			if(result==0)
			{
				System.out.println("Invalid Credentials");
			}
			else
			{
				System.out.println("Valid Credentials");
			}
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
