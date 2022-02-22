package exception;

//Jun Lin Wu


import java.util.*;
import java.io.*;
import model.*;

public class StudentGradingException extends Exception
{
	//data field
	private int errNum;
	private String errMsg;
	
	//Constructors
	public StudentGradingException()
	{
		super();
		printProblem();
	}
	public StudentGradingException(String errMsg) 
	{
		super();
		this.errMsg = errMsg;
		printProblem();
	}
	public StudentGradingException(int errNum) 
	{
		super();
		this.errNum = errNum;
		printProblem();
	}
	public StudentGradingException(int errNum, String errMsg) 
	{
		super();
		this.errNum = errNum;
		this.errMsg = errMsg;
		printProblem();
	}

	//setters and getters
	public int getErrNum() 
	{
		return errNum;
	}
	public void setErrNum(int errNum) 
	{
		this.errNum = errNum;
	}
	public String getErrMsg() 
	{
		return errMsg;
	}
	public void setErrMsg(String erMsg) 
	{
		this.errMsg = errMsg;
	}
	
	//print the error message
	public void printProblem()
	{
		System.out.printf("StudentGradingException [errNum = %d, errMsg = %s]\n", errNum, errMsg);
	}
	
	//fix the "missing scores" problem by allowing user to manually enter the scores
	public void fixProblem(Student[] stuArr, int count)
	{
		Scanner in = new Scanner(System.in);
		int num;
		int[] newScores = new int[5];
		
		System.out.printf("\nSome scores of student %d are missing. Please enter all 5 scores of this student manually\n", stuArr[count].getSID());
		for(int i = 0; i < newScores.length; i++)
		{
			num = in.nextInt();
			newScores[i]=num;
		}
		stuArr[count].setScores(newScores);
	}
	
	//write the error message to a file
	public void writeErrMsgToFile()
	{
		try 
		{
		    BufferedWriter output = new BufferedWriter(new FileWriter("Driver1Outfile.txt"));
		    output.write(errMsg);
		    output.close();
		    System.out.printf("\n%s\n\n", "Error Message wrote to the file.");
		}
		catch (IOException e) 
		{
			System.out.printf("Error -- %s", e.toString());
		}
	}
}
