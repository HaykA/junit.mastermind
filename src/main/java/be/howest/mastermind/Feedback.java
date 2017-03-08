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
    	this.colorCount = colorCount;
    }

    public int getColorCount() {
    	return colorCount;
    }
    
    public int getTotalFoundAtValidPosition() {
		return totalFoundAtValidPosition;
	}
    
	public int getTotalFoundAtInvalidPosition() {
		throw new UnsupportedOperationException();
	}

	public void addFound(boolean atValidPosition) {
    	throw new UnsupportedOperationException();
    }
}
