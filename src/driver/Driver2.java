package driver;

import java.io.IOException;

//Jun Lin Wu
//CIS 35A - Section 63Z - Assignment 6
import exception.*;
import model.*;
import util.FileIO;

public class Driver2 {

	public static void main(String[] args) throws StudentGradingException, IOException 
	{
		//create a array of Student objects
		Student stuArray [] = new Student[40];
		
		//read the file and store the data to the stuArray
		try
		{
			stuArray = FileIO.readFile("test_data.txt", stuArray);
		}
		catch (StudentGradingException ex) 
		{
			if(ex.getErrMsg()=="StudentGradingException: Missing scores")
			{
				ex.fixProblem(stuArray, FileIO.count-2);
				ex.writeErrMsgToFile();
			}
		}
		
		//print data and statistics
		System.out.printf("\t%s\n", FileIO.header);
		for(int j = 0; j < FileIO.count-1; j++)
		{
			stuArray[j].print();
		}
		Statistics stat = new Statistics();
		stat.findlow(stuArray);
		stat.findhigh(stuArray);
		stat.findavg(stuArray);	
		stat.print();
		
		//create an array of StudentGrade objects with the number of student in the file
		StudentGrade[] stuGrade = new StudentGrade[FileIO.count-1];
		
		//populate the stuGrade array with the student scores and the statistics
		for(int i = 0; i < FileIO.count-1; i++)
		{
			stuGrade[i] = new StudentGrade(stuArray[i], stat);
		}
		
		//serialize each object in the stuGrade array
		FileIO.serialize(stuGrade);
		
		//deserialize the serialized file
		for(int j = 0; j < FileIO.count-1; j++)
		{
			FileIO.deserialize(stuGrade[j].getStuID());
		}
	}

}
