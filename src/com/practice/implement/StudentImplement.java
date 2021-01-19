package com.practice.implement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.practice.dao.StudentDAO;
import com.practice.model.Student;
import com.practice.model.Subjects;

public class StudentImplement {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		while(true) {
			System.out.println("1.Insert\n2.Delete\n3.Update\n4.View");
			System.out.print("Enter choice: ");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			if(choice<=0)
				break;
			StudentDAO studentdao=new StudentDAO();
			switch(choice) {
				case 1: 
					Student student=new Student();
					List<Subjects>subjects=new ArrayList<Subjects>();
					System.out.println("Enter roll,name,standard,gender: ");
					student.setRoll(sc.nextInt());
					student.setName(sc.next());
					student.setStandard(sc.next());
					student.setGender(sc.next());
					System.out.println("Enter number of subjects: ");
					int num=sc.nextInt();
					for(int i=0;i<num;i++) {
						System.out.println("Enter id and name of subjects: ");
						subjects.add(new Subjects(sc.next(),sc.next()));
					}
					student.setSubjects(subjects);
					studentdao.addStudent(student);
					break;
				case 2:
					System.out.println("Enter the roll: ");
					studentdao.deleteStudent(sc.nextInt());
					break;
				case 3:
					studentdao.updateStudent();
					break;
				case 4:
					System.out.println("Enter the roll: ");
					System.out.println(studentdao.getStudent(sc.nextInt()));
			}
		}
	}
}
