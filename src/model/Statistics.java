package model;

//Jun Lin Wu

import util.*;
import java.io.*;

public class Statistics implements Serializable
{
	//private data
	private int[] lowscores = new int[5];
	private int[] highscores = new int[5];
	private float[] avgscores = new float[5];
	
	//default constructor
	public Statistics()
	{}

	//setters and getters
	public int[] getLowscores() 
	{
		return lowscores;
	}
	public void setLowscores(int[] lowscores) 
	{
		this.lowscores = lowscores;
	}
	public int[] getHighscores() 
	{
		return highscores;
	}
	public void setHighscores(int[] highscores) 
	{
		this.highscores = highscores;
	}
	public float[] getAvgscores() 
	{
		return avgscores;
	}
	public void setAvgscores(float[] avgscores) 
	{
		this.avgscores = avgscores;
	}
	
	//this method find the lowest score of each quiz
	//and store them to an array
	public void findlow(Student[] a)
	{
		for(int i = 0; i < lowscores.length; i++)
		{
			int[] tempA = a[0].getScores();
			int lowest = tempA[i];
			for(int j = 1; j < FileIO.count-1; j++)
			{
				int[] tempB = a[j].getScores();
					
				if(lowest > tempB[i])
				{
					lowest = tempB[i];
				}
			}
				lowscores[i] = lowest;
		}
	}
	
	//this method find the highest score of each quiz
	//and store them to an array
	public void findhigh(Student [] a) 
	{
		for(int i = 0; i < highscores.length; i++)
		{
			int[] tempA = a[0].getScores();
			int highest = tempA[i];
			for(int j = 1; j < FileIO.count-1; j++)
			{
				int[] tempB = a[j].getScores();
					
				if(tempB[i] > highest)
				{
					highest = tempB[i];
				}
			}
			highscores[i] = highest;
		}	
	}
	
	//this method find the average score of each quiz
	//and store them to an array
	public void findavg(Student [] a) 
	{
		//if there is no data in the file, set average score of each quiz to 0
		if(FileIO.count == 0)
		{
			for(int k = 0; k < avgscores.length; k++)
			{
				avgscores[k] = 0;
			}
		}
		else
		{
			for(int i = 0; i < avgscores.length; i++)
			{
				float sum = 0f;
				for(int j = 0; j < FileIO.count-1; j++)
				{
					int[] temp = a[j].getScores();
					sum += temp[i];
				}
				avgscores[i] = sum/(FileIO.count-1);
			}
		}
	}
	
	//print low, high and average score of each quiz
	public void print()
	{
		System.out.printf("\n%s", "Lowest scores: ");
		for(int i = 0; i < lowscores.length; i++)
		{
			System.out.printf("%1d\t", lowscores[i]);
		}
		
		System.out.printf("\n%s", "Highest scores: ");
		for(int i = 0; i < highscores.length; i++)
		{
			System.out.printf("%1d\t", highscores[i]);
		}
		
		System.out.printf("\n%s", "Averge scores: ");
		for(int i = 0; i < avgscores.length; i++)
		{
			System.out.printf("%1.1f\t", avgscores[i]);
		}
		System.out.printf("\n");
	}
}
