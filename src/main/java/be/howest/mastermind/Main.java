package be.howest.mastermind;

/**
 *
 * @author hayk
 */
public class Main {
    public static void main(String args[]) {
    	Feedback feedback = new Feedback(2);
    	feedback.addFound(true);
    	feedback.addFound(true);
    	feedback.addFound(true);
    	System.out.println(feedback.getTotalFoundAtValidPosition() <= feedback.getColorCount());
        //System.out.println("•~~~~×");
    }
}
