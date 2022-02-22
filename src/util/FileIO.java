package util;

//Jun Lin Wu


import java.util.*;
import java.io.*;
import model.*;
import exception.*;

public class FileIO 
{
	//keep track of how many student in the file
	public static int count=0;
	public static String header;
	
	public static Student [] readFile(String filename, Student[] stu) throws StudentGradingException
	{
		//int index = 0;
		try
		{
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);

			boolean eof = false;
			int numOfStu = 0;
			
			//while file still has line and number of student is not over 40
			while(!eof && numOfStu < 40)
			{
				String line = buff.readLine();
				if(line == null)
				{
					eof = true;
				}
				else
				{
					count++;
					numOfStu++;
					if(count == 1)
					{
						//read the first line of file which is the header
						header = line;
					}
					if(count>1)
					{
						stu[count-2] = new Student();
						StringTokenizer st = new StringTokenizer(line);
						while(st.hasMoreTokens())
						{
							//tokenize the lines
							String id = st.nextToken();
							
							//convert string to int
							int x = Integer.parseInt(id);
							
							//set ID 
							stu[count-2].setSID(x);
							
							//create a temp array to get all quiz score
							int[] array = new int[5];
							for(int i = 0; i < 5; i++)
							{
								String score = st.nextToken();
								int y = Integer.parseInt(score);
								array[i] = y;
							}
							//set the array
							stu[count-2].setScores(array);
						}
					}
				 }
				}
			buff.close();
		}
		catch(NoSuchElementException ex)
		{
			throw new StudentGradingException("StudentGradingException: Missing scores");
		}
		catch(IOException e)
		{
			throw new StudentGradingException(e.toString());
		}
		return stu;
	}
	
	//this method write the StudentGrade objects to serialized file
	public static void serialize(StudentGrade s1 []) throws StudentGradingException, IOException
	{
		try
		{
			for(int i = 0; i < count-1; i++)
			{
				//filename = student ID + .ser
				String filename = String.valueOf(s1[i].getStuID()) + ".ser";
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));
				output.writeObject(s1[i]);
				output.close();
				System.out.printf("Serialized file %s created\n", filename);
			}
		}
		catch(IOException e)
		{
			throw new StudentGradingException(102, e.toString());
		}
	}
	
	//this method deserialize the serialized file and return the StudentGrade object
	public static StudentGrade deserialize(int SID) throws StudentGradingException, IOException
	{
		ObjectInputStream in;
		String filename = String.valueOf(SID) + ".ser";
		StudentGrade stuGrade;
		try
		{
			in =  new ObjectInputStream(new FileInputStream(filename));
		}
		catch(FileNotFoundException ex)
		{
			throw new StudentGradingException(118, ex.toString());
		}
		catch(IOException e)
		{
			throw new StudentGradingException(117, e.toString());
		}
		try
		{
			stuGrade = (StudentGrade)in.readObject();
		}
		catch(ClassNotFoundException e)
		{
			in.close();
			throw new StudentGradingException(124, e.toString()); 
		}
		in.close();
		return stuGrade;
	}
}

