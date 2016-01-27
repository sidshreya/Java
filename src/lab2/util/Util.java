package lab2.util;

import lab2.exception.TooManyRecordsException;
import lab2.model.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


@SuppressWarnings("resource")

public class Util {
	
	/**
	 * Read student information from file and set the ids and scores for
	 * each student
	 * @param filename: record file name
	 * @param students: Student array
	 */
	public static Student[] readFile(String filename, Student[] students) {		
		int i = 0;
		boolean eof;
		FileReader file;
		BufferedReader buff;
		String line;
		
		try {
			file = new FileReader(filename);
			buff = new BufferedReader(file);
			eof = false;
			while (!eof) {
				// Read line from file everytime
				line = buff.readLine();
				
				if (line == null)
					eof = true;
				
				// the first line is header so skip
				else if (line.startsWith("Stud")) 
					continue;
				
				// More than 40 entries throw exception
				else if (i >= 40) { 
					throw new TooManyRecordsException();
				}
				
				else {
					students[i] = parseLine(line);
					++i;
				}
			}
			buff.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error нн " + e.toString());
		} catch (IOException e) {
			System.out.println("Error нн " + e.toString());
		} catch (TooManyRecordsException e) {
			e.exceptionHandler();
		}
		return students;
	}
	
	/**
	 * Read a line of student information and create 
	 * student instance
	 */
	private static Student parseLine(String line) {
		int SID;
		int i = 0;
		int[] scores = new int[5];
		Student student = new Student();
		StringTokenizer tokenizer = new StringTokenizer(line);
		
		//student id
		SID = Integer.parseInt(tokenizer.nextToken());
		
		// student scores
		while (i < 5 && tokenizer.hasMoreTokens()) {
			scores[i] = Integer.parseInt(tokenizer.nextToken());
			++i;
		}
		
		student.setScores(scores);
		student.setSID(SID);
		
		
		// return student information
		return student;
	}
}