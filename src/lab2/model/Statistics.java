package lab2.model;

public class Statistics extends CalculateStatistics implements OutputStatistics {
	private int quizNumber;
	private int[] lowscores;
	private int[] highscores;
	private float[] avgscores;
	
	public Statistics(int quizNumber) {
		this.quizNumber = quizNumber;
		this.lowscores = new int[quizNumber];
		this.highscores = new int[quizNumber];
		this.avgscores = new float[quizNumber];
	}
	
	
	 // Calculate the number of students according to the array
	
	 
	private int studentsNumber(Student[] students) {
		int i = 0;
		while (i < students.length && students[i] != null)
			++i;
		return i;
	}
	
	@Override
	/*This method will find the lowest score and store it in
	an array names lowscores. */

	public void findlow(Student[] students) {
		int i;
		int j;
		int lowest = 0;
		int size = studentsNumber(students);
		
		if (size == 0) return;
		
		for (i = 0; i < quizNumber; ++i) {
			lowest = students[0].getScores()[i];
			for (j = 1; j < size; ++j) {
				if (students[j].getScores()[i] < lowest)
					lowest = students[j].getScores()[i];
			}
			lowscores[i] = lowest;
		}
	}
	
	@Override
	/* This method will find the highest score and store it in
	an array names highscores. */
	
	public void findhigh(Student[] students) {
		int i;
		int j;
		int highest = 0;
		int size = studentsNumber(students);
		
		if (size == 0) return;
		
		for (i = 0; i < quizNumber; ++i) {
			highest = students[0].getScores()[i];
			for (j = 1; j < size; ++j) {
				if (students[j].getScores()[i] > highest)
					highest = students[j].getScores()[i];
			}
			highscores[i] = highest;
		}
	}
	
	@Override
	
	/* This method will find avg score for each quiz and store
	it in an array names avgscores. */

	public void findavg(Student[] students) {
		int i;
		int j;
		int size = studentsNumber(students);
		float average;
		
		if (size == 0) return;
		
		for (i = 0; i < quizNumber; ++i) {
			average = 0;
			for (j = 0; j < size; ++j) {
				average += students[j].getScores()[i];
			}
			avgscores[i] = average / (float)size;
		}
	}
	
	@Override
	/* This method will print the lowest score for each quiz */

	public void printLowScores() {
		for (int i = 0; i < quizNumber; ++i)
			System.out.printf("%d\t", lowscores[i]);
		System.out.println();
	}
	
	@Override
	/* This method will print the highest score for each quiz */
	public void printHighScores() {
		for (int i = 0; i < quizNumber; ++i)
			System.out.printf("%d\t", highscores[i]);
		System.out.println();
	}
	
	@Override
	/* This method will print the average score for each quiz */
	public void printAvgScores() {
		for (int i = 0; i < quizNumber; ++i)
			System.out.printf("%.1f\t", avgscores[i]);
		System.out.println();
	}
}
