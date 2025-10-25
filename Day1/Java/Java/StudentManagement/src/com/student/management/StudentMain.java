package com.student.management;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentMain {
	public static void main(String[] args) {
		List<Student> slist = new ArrayList();

        //10 student objects
        slist.add(new Student(1, "Aarav", "Java", 85, 92));
        slist.add(new Student(2, "Riya", "Python", 58, 80));
        slist.add(new Student(3, "Karan", "C++", 76, 70));
        slist.add(new Student(4, "Neha", "Java", 64, 88));
        slist.add(new Student(5, "Arjun", "C#", 95, 91));
        slist.add(new Student(6, "Meera", "JavaScript", 45, 60));
        slist.add(new Student(7, "Vikram", "Java", 83, 85));
        slist.add(new Student(8, "Simran", "Python", 72, 66));
        slist.add(new Student(9, "Rahul", "C++", 90, 75));
        slist.add(new Student(10, "Priya", "Java", 61, 82));
        
        
        //Serialize Students
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("students.dat"))) {
			for(Student s: slist) {
				oos.writeObject(s);
			}
			System.out.println("Student data serialized to students.dat");
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        //De-Serialize Students
        List<Student> dlist = new ArrayList<Student>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            while (true) {
                try {
                    Student s = (Student) ois.readObject();
                   dlist.add(s);
                } catch (EOFException e) {
                    break; 
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
        //Display Grade or Exception Message
        System.out.println("---Student Grades---");
        for(Student s:dlist) {
        	try {
				String grade=s.calculateGrade();
				System.out.println(s+ "| Grade: " +grade);
			} catch (AttendanceException e) {
				System.out.println(s+ " : " + e.getMessage());
			}
        }
        
        //Sort in decreasing order of attendance
        dlist.sort(new CompareStudent());
        
        System.out.println("---Students Sorted by Attendance in Descending Order---");
        for(Student s: dlist) {
        	System.out.println(s);
        }
        
	}
}
