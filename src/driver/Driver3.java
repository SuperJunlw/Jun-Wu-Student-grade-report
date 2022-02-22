package driver;

import java.io.IOException;

//Jun Lin Wu
//CIS 35A - Section 63Z - Assignment 6
import adapter.*;
import model.*;
import util.*;
import exception.*;

public class Driver3
{
	public static void main(String[] args) throws StudentGradingException, IOException 
	{
		//create an API object
		API stuAPI = new API();
		
		//print the statistics, same values for all the students
		stuAPI.printStatistics(1234);
		
		//print the scores of a student based on the ID
		stuAPI.printScore(2134);
		stuAPI.printScore(3124);
		
	}
}

