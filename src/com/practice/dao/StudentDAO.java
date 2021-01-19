package com.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.practice.connection.JdbcPostgresConnection;
import com.practice.model.Student;
import com.practice.model.Subjects;

public class StudentDAO {
	public void addStudent(Student obj) throws SQLException, ClassNotFoundException 
	{
		JdbcPostgresConnection con=new JdbcPostgresConnection();
		Connection cnt=con.connect();
		String query="insert into student values(?,?,?,?)";
		PreparedStatement st=cnt.prepareStatement(query);
		st.setInt(1,obj.getRoll());
		st.setString(2,obj.getName());
		st.setString(3,obj.getStandard());
		st.setString(4,obj.getGender());
		int count=st.executeUpdate();
		List<Subjects>sub=obj.getSubjects();
		for(int i=0;i<sub.size();i++) {
			String query2="select id from subjects where id='"+sub.get(i).getId()+"'";
			Class.forName("org.postgresql.Driver");
			Statement stm=cnt.createStatement();
			ResultSet rs=stm.executeQuery(query2);
			if(rs.next()==false)
				System.out.println("Wrong Subjects");
			else {
				String query1="insert into stud_sub values(?,?)";
				st=cnt.prepareStatement(query1);
				st.setInt(1, obj.getRoll());
				st.setString(2, sub.get(i).getId());
				st.executeUpdate();
			}
		}
		System.out.println(count+"row/s affected");
		st.close();
		cnt.close();
	}
	public Student getStudent(int roll) throws ClassNotFoundException, SQLException
	{
		JdbcPostgresConnection con=new JdbcPostgresConnection();
		Connection cnt=con.connect();
		String query="select * from student where roll="+roll;
		Student s=new Student();
		s.setRoll(roll);
		Class.forName("org.postgresql.Driver");
		Statement st=cnt.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		s.setName(rs.getString(2));
		s.setStandard(rs.getString(3));
		s.setGender(rs.getString(4));
		String query1="select * from subjects where id in (select id from stud_sub where roll="+roll+")";
		st=cnt.createStatement();
		rs=st.executeQuery(query1);
		List<Subjects>sub=new ArrayList<Subjects>();
		while(rs.next()) {
			Subjects sb=new Subjects();
			sb.setId(rs.getString(1));
			sb.setName(rs.getString(2));
			sub.add(sb);
		}
		s.setSubjects(sub);
		return s;
	}
	public void deleteStudent(int roll) throws SQLException
	{
		JdbcPostgresConnection con=new JdbcPostgresConnection();
		Connection cnt=con.connect();
		String query="delete from student where roll=?";
		PreparedStatement st=cnt.prepareStatement(query);
		st.setInt(1,roll);
		int count=st.executeUpdate();
		System.out.println(count+"row/s affected");
		query="delete from stud_sub where roll=?";
		st=cnt.prepareStatement(query);
		st.setInt(1,roll);
		count=st.executeUpdate();
		System.out.println(count+"row/s affected");
		st.close();
		cnt.close();
	}
	public void updateStudent() throws SQLException
	{
		JdbcPostgresConnection con=new JdbcPostgresConnection();
		Connection cnt=con.connect();
		System.out.print("Enter which row you want to update : ");
		Scanner sc=new Scanner(System.in);
		String input=sc.next();
		int roll=0;
		int count=0;
		String query=" ";
		PreparedStatement st=null;
		switch(input)
		{
			case "roll": System.out.print("Enter old roll : ");
						 roll=sc.nextInt();
						 System.out.print("Enter new roll : ");
						 int nroll=sc.nextInt();
						 query="update Student set roll=? where roll=?";
						 st=cnt.prepareStatement(query);
						 st.setInt(1,roll);
						 st.setInt(2,nroll);
						 count=st.executeUpdate();
						 System.out.println(count+"row/s affected");
						 st.close();
						 cnt.close();
						 break;
			case "name": System.out.println("Enter name : ");
						 String name=sc.next();
						 System.out.println("Enter roll for which you want to update : ");
						 roll=sc.nextInt();
						 query="update Student set name=? where roll=?";
						 st=cnt.prepareStatement(query);
						 st.setString(1,name);
						 st.setInt(2,roll);
						 count=st.executeUpdate();
						 System.out.println(count+"row/s affected");
						 st.close();
						 cnt.close();
						 break;
			case "standard": System.out.println("Enter standard : ");
							 String standard=sc.next();
							 System.out.println("Enter roll for which you want to update : ");
							 roll=sc.nextInt();
							 query="update Student set standard=? where roll=?";
							 st=cnt.prepareStatement(query);
							 st.setString(1,standard);
							 st.setInt(2,roll);
							 count=st.executeUpdate();
							 System.out.println(count+"row/s affected");
							 st.close();
							 cnt.close();
							 break;
			case "gender":  System.out.println("Enter gender : ");
							String gender=sc.next();
							System.out.println("Enter roll for which you want to update : ");
							roll=sc.nextInt();
							query="update Student set gender=? where roll=?";
							st=cnt.prepareStatement(query);
							st.setString(1,gender);
							st.setInt(2,roll);
							count=st.executeUpdate();
							System.out.println(count+"row/s affected");
							st.close();
							cnt.close();
							break;
		}
	}
	
}
