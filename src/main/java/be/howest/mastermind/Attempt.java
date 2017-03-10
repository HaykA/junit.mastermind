package be.howest.mastermind;

public class Attempt {
	private final int[] colors;
	private Feedback feedback;
	
	Attempt(int[] colors) {
		this.colors = colors;
	}
	
	public void setFeedback(Feedback feedback) {
		if (this.feedback == null && feedback != null) {
			this.feedback = feedback;			
		}
	}
	
	int size() {
		return colors.length;
	}
	
	public Feedback getFeedback() {
		return feedback;
	}
	
	public int[] getColors() {
		return colors;
	}
	
	int get(int id) {
		return colors[id];
	}
	
}
