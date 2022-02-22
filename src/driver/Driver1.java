package driver;

//Jun Lin Wu


import exception.*;
import model.*;
import util.FileIO;

public class Driver1 
{
	public static void main(String[] args) throws StudentGradingException
	{
		//create an array of Student object
		Student stuArray [] = new Student[40];
		
		try
		{
			stuArray = FileIO.readFile("test_data.txt", stuArray);
		}
		catch (StudentGradingException ex) 
		{
			//if the file has missing score, call the fixProblem method in StudentGadingException to fix it
			//then write that error message to a file
			if(ex.getErrMsg()=="StudentGradingException: Missing scores")
			{
				ex.fixProblem(stuArray, FileIO.count-2);
				ex.writeErrMsgToFile();
			}
		}
		
		Statistics stat = new Statistics();

		//print data and statistics
		System.out.printf("\t%s\n", FileIO.header);
		for(int j = 0; j < FileIO.count-1; j++)
		{
			stuArray[j].print();
		}
		stat.findlow(stuArray);
		stat.findhigh(stuArray);
		stat.findavg(stuArray);	
		
		stat.print();
	}
}
