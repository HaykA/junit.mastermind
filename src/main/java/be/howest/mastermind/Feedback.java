package be.howest.mastermind;

/**
 *
 * @author hayk
 */
public class Feedback {
    private int totalFoundAtValidPosition;
    private int totalFound;
    private final int colorCount;
    
    public Feedback(int colorCount) {
    	if (colorCount <= 0) {
    		throw new IllegalArgumentException("@Feedback: Color count may not be negative or zero!");
    	}
    	this.colorCount = colorCount;
    }

    public int getColorCount() {
    	return colorCount;
    }
    
    public int getTotalFoundAtValidPosition() {
		return totalFoundAtValidPosition;
	}
    
	public int getTotalFoundAtInvalidPosition() {
		if (totalFound == 0) {
			return -1;
		}
		return totalFound - totalFoundAtValidPosition;
	}
	
	public int getTotalFound() {
		return totalFound;
	}

	public void addFound(boolean atValidPosition) {
		if (!isComplete()) {
			if (atValidPosition) {
	    		totalFoundAtValidPosition++;
	    	}
	    	totalFound++;			
		}
    	
    }
	
	boolean isComplete() {
		return totalFound == colorCount;
	}
}
