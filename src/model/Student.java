package model;

//Jun Lin Wu

import java.io.*;

public class Student implements Serializable
{
	//private data
	private int SID;
	private int[] scores = new int [5];
	
	//default constructor
	public Student()
	{}

	//setters and getters
	public int getSID() 
	{
		return SID;
	}
	public void setSID(int sID) 
	{
		SID = sID;
	}
	public int[] getScores()
	{
		return scores;
	}
	public void setScores(int[] scores) 
	{
		this.scores = scores;
	}
	
	//print the properties
	public void print()
	{
		System.out.printf("\t%d ", SID);
		for(int i = 0; i < scores.length; i++)
		{
			System.out.printf("%3d ", scores[i]);
		}
		System.out.printf("\n");
	}
	
}
