package be.howest.mastermind;

/**
 *
 * @author hayk
 */
public class Main {
    public static void main(String args[]) {

    	Feedback feedback;
    	int[] colors =  {4, 9, 3, 2, 1, 0, 6, 0, 10, 0}; // 8 9 4 3 2 7 1 6 5 10
    	
    	MasterMind masterMind = new MasterMind(5, 10);
    	feedback = masterMind.check(colors);
    	printFeedbackRow(colors, feedback);
    	colors = new int[] {4, 9, 3, 2, 1, 0, 6, 0, 5, 10}; // 8 9 4 3 2 7 1 6 5 10
    	feedback = masterMind.check(colors);
    	printFeedbackRow(colors, feedback);
    	colors = new int[] {4, 9, 3, 2, 1, 7, 6, 0, 5, 10}; // 8 9 4 3 2 7 1 6 5 10
    	feedback = masterMind.check(colors);
    	printFeedbackRow(colors, feedback);
    	colors = new int[] {4, 9, 3, 2, 8, 7, 1, 0, 5, 10}; // 8 9 4 3 2 7 1 6 5 10
    	feedback = masterMind.check(colors);
    	printFeedbackRow(colors, feedback);
    	colors = new int[] {8, 9, 4, 3, 2, 7, 1, 6, 5, 10}; // 8 9 4 3 2 7 1 6 5 10
    	//colors = new int[] {8, 9, 4, 3, 2, 7, 1, 0, 5, 10}; // 8 9 4 3 2 7 1 6 5 10
    	feedback = masterMind.check(colors);
    	printFeedbackRow(colors, feedback);
    	if (masterMind.isGameOver()) {
    		System.out.println("GAME OVER");
    	}
    	if (masterMind.hasWon()) {
    		System.out.println("YOU WON");
    	} else {
    		System.out.println("YOU LOST");
    	}
    	//printIntArr(masterMind.getSecret());
        //System.out.println("вЂў~~~~Г—");
    }
    
    private static void printFeedbackRow(int[] colors, Feedback feedback) {
    	if (feedback != null) {
    		printIntArr(colors);
        	printFeedback(feedback);
        	System.out.println();    		
    	}
    	
    }
    
    private static void printIntArr(int[] arr) {
    	for (int i : arr) {
    		System.out.printf("%-10s", Colors.getColorName(i), i);
    	}
    }
    
    private static void printFeedback(Feedback feedback) {
    	for (int i = 0; i < feedback.getTotalFoundAtValidPosition(); i++) {
    		System.out.print("●  ");
    	}
    	
    	for (int i = 0; i < feedback.getTotalFoundAtInvalidPosition(); i++) {
    		System.out.print("○  ");
    	}
    	
    	for (int i = feedback.getTotalFoundAtInvalidPosition()
    			+ feedback.getTotalFoundAtValidPosition();
    			i < feedback.getColorCount(); i++) {
    		System.out.print("·  ");
    	}
    }
    
    
}
