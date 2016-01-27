package lab2.driver;

import lab2.model.Statistics;
import lab2.model.Student;
import lab2.util.Util;

public class Main {
	public static void main(String[] args) {
		Student[] students = new Student[40];
		// read scores from file
		students = Util.readFile("C:/Users/Shreyanshi/Desktop/Shreyank_Assignment2/Test_Data/Scores45.txt", students);
		
		Statistics statlab2 = new Statistics(5);		
		
		int i = 0; 		
		
		// Each student quiz score
		System.out.println("Stud\t\tQ1\tQ2\tQ3\tQ4\tQ5");
		while (i < 40 && students[i] != null) {
			students[i].printSID();
			System.out.print("\t\t");
			students[i].printScores();
			++i;
		}
		System.out.println();
		
		// find low, high and avg score
		statlab2.findlow(students);
		statlab2.findhigh(students);
		statlab2.findavg(students);
		
		// print low, high, and avg scores
		System.out.print("High Score\t");
		statlab2.printHighScores();
		System.out.print("Low Score\t");
		statlab2.printLowScores();
		System.out.print("Avg Score\t");
		statlab2.printAvgScores();
		
	}
}