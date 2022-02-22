package adapter;

//Jun Lin Wu


import java.io.*;
import model.*;
import util.*;
import exception.*;

public abstract class StudentAPIImpl implements StudentAPI
{
	//data field
	private Statistics stat;
	private Student[] stuArray;
	
	//Constructor. load text file, compute statistics, create StudentGrade array and serialize StudentGradeArray
	public StudentAPIImpl() throws StudentGradingException, IOException
	{
		stuArray = new Student[40];
		
		try
		{
			stuArray = FileIO.readFile("test_data.txt", stuArray);
		}
		catch (StudentGradingException ex) 
		{
			ex.writeErrMsgToFile();	
		}
	
		stat = new Statistics();
		stat.findlow(stuArray);
		stat.findhigh(stuArray);
		stat.findavg(stuArray);	
		
		StudentGrade[] stuGrade = new StudentGrade[FileIO.count-1];
		
		for(int i = 0; i < FileIO.count-1; i++)
		{
			stuGrade[i] = new StudentGrade(stuArray[i], stat);
		}
		FileIO.serialize(stuGrade);
		
	}
	
	//this method accept a student ID and deserialize a ser file based on the ID
	//then print the statistics of quiz in that file
	public void printStatistics(int SID)
	{
		StudentGrade stuGrade;
		try
		{
			stuGrade = FileIO.deserialize(SID);
			System.out.printf("\n%s", "Statistics of the quizs: ");
			stuGrade.printSta();
		}
		catch(Exception e)
		{
			System.out.printf("%s", e.toString());
		}
	}
	
	//this method accept a student ID and deserialize a ser file based on the ID
	//then print the scores of quiz of that student
	public void printScore(int SID)
	{
		StudentGrade stuGrade;
		try
		{
			stuGrade = FileIO.deserialize(SID);
			System.out.printf("\nThe score of student %d:\n", SID);
			System.out.printf("\t%s\n", FileIO.header);
			stuGrade.printScores();
		}
		catch(Exception e)
		{
			System.out.printf("%s", e.toString());
		}
	}
}
