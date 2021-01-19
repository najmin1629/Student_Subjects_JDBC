package com.practice.implement;

import java.sql.SQLException;
import java.util.Scanner;

import com.practice.dao.SubjectsDAO;
import com.practice.model.Subjects;

public class SubjectsImplement {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		while(true)
		{
			System.out.println("1.Insert\n2.Delete\n3.Update\n4.View");
			System.out.println("Enter choice : ");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			String id="";
			if(choice<=0)
				break;
			SubjectsDAO subjectsdao=new SubjectsDAO();
			switch(choice)
			{
				case 1: Subjects subjects=new Subjects();
						System.out.println("Enter id,name : ");
						subjects.setId(sc.next());
						subjects.setName(sc.next());
						subjectsdao.addSubjects(subjects);
						break;
				case 2: System.out.println("Enter id which you want to delete : ");
						id=sc.next();
						subjectsdao.deleteSubjects(id);
						break;
				case 3: subjectsdao.updateSubjects();
						break;
				case 4: System.out.println("Enter id for which details you want to view : ");
						id=sc.next();
						System.out.println(subjectsdao.getSubjects(id));
						break;
				
			}
		}
	}
}
