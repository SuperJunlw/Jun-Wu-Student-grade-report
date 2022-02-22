package model;

//Jun Lin Wu

import java.io.*;

public class StudentGrade implements Serializable
{
	//data field
	private Student stu;
	private Statistics sta;
	
	//Constructor
	public StudentGrade()
	{}
	
	//overloaded constructor
	public StudentGrade(Student stu, Statistics sta)
	{
		this.stu = stu;
		this.sta = sta;
	}

	//setters and getters
	public Student getStu() 
	{
		return stu;
	}
	public void setStu(Student stu)
	{
		this.stu = stu;
	}
	public Statistics getSta() 
	{
		return sta;
	}
	public void setSta(Statistics sta) 
	{
		this.sta = sta;
	}
	
	//return the student ID
	public int getStuID()
	{
		return stu.getSID();
	}
	
	//print the statistics of the quiz
	public void printSta()
	{
		sta.print();
	}
	
	//print the scores of a student
	public void printScores()
	{
		stu.print();
	}
}
