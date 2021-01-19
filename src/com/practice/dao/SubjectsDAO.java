package com.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.practice.connection.JdbcPostgresConnection;
import com.practice.model.Subjects;


public class SubjectsDAO {
	public void addSubjects(Subjects obj) throws SQLException
	{
		JdbcPostgresConnection con=new JdbcPostgresConnection();
		Connection cnt=con.connect();
		String query="insert into subjects values(?,?)";
		PreparedStatement st=cnt.prepareStatement(query);
		st.setString(1,obj.getId());
		st.setString(2,obj.getName());
		int count=st.executeUpdate();
		System.out.println(count+"row/s affected");
		st.close();
		cnt.close();
	}
	public void deleteSubjects(String id) throws SQLException
	{
		JdbcPostgresConnection con=new JdbcPostgresConnection();
		Connection cnt=con.connect();
		String query="delete from subjects where id=?";
		PreparedStatement st=cnt.prepareStatement(query);
		st.setString(1,id);
		int count=st.executeUpdate();
		System.out.println(count+"row/s affected");
		st.close();
		cnt.close();
	}
	public Subjects getSubjects(String id) throws SQLException, ClassNotFoundException
	{
		Subjects s=new Subjects();
		s.setId(id);
		String query="select * from subjects where id='"+id+"'";
		JdbcPostgresConnection con=new JdbcPostgresConnection();
		Connection cnt=con.connect();
		Class.forName("org.postgresql.Driver");
		Statement st=cnt.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		s.setId(rs.getString(1));
		s.setName(rs.getString(2));
		return s;
	}
	public void updateSubjects() throws SQLException
	{
		System.out.println("Enter which column you want to update : ");
		Scanner sc=new Scanner(System.in);
		String input=sc.next();
		JdbcPostgresConnection con=new JdbcPostgresConnection();
		Connection cnt=con.connect();
		String query=" ";
		int count=0;
		String id=" ";
		String name=" ";
		PreparedStatement st=null;
		switch(input)
		{
			case "id": System.out.println("Enter id");
					   id=sc.next();
					   System.out.println("Enter new id");
					   String nid=sc.next();
					   query="update student set id=? where id=?";
					   st=cnt.prepareStatement(query);
					   st.setString(1,id);
					   st.setString(2,nid);
					   count=st.executeUpdate();
					   System.out.println(count+"row/s affected");
					   st.close();
				       cnt.close();
					   break;
			case "name": System.out.println("Enter name");
						 name=sc.next();
						 System.out.println("Enter id in which you want to update");
						 id=sc.next();
						 query="update student set name=? where id=?";
						 st=cnt.prepareStatement(query);
						 st.setString(1,name);
						 st.setString(2,id);
						 count=st.executeUpdate();
						 System.out.println(count+"row/s affected");
						 st.close();
					     cnt.close();
						 break;
		}
	}
}
