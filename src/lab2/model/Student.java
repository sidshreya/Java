package lab2.model;

public class Student {
	private int SID;
	private int[] scores = new int[5];
	
	//public get and set methods for
	//SID and scores
	
	public int getSID() {
		return SID;
	}
	
	public void setSID(int SID) {
		this.SID = SID;
	}
	
	public int[] getScores() {
		return scores;
	}
	
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	//methods to print values of SID and scores
	
	public void printSID() {
		System.out.printf("%d", SID);
	}
	
	public void printScores() {
		for (int i = 0; i < 5; ++i)
			System.out.printf("%d\t", scores[i]);
		System.out.println();
	}
}