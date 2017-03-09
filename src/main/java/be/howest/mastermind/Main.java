package be.howest.mastermind;

import be.howest.entities.Color;
import be.howest.mastermind.exceptions.MasterMindCheckException;
import be.howest.services.ColorService;
import be.howest.services.SchemeService;

/**
 *
 * @author hayk
 */
public class Main {
    public static void main(String args[]) {
    	int totalTries = (7 * 3 + 10) / 2;
		totalTries += totalTries % 2;
		System.out.println(totalTries);
//    	Feedback feedback;
//    	int[] colors =  {1, 4, 6, 2}; // 8 9 4 3 2 7 1 6 5 10
//    	MasterMindFactory factory = new MasterMindFactory();
//    	MasterMind masterMind = factory.createMasterMind(SchemeService.readDefault());
//    	try {
//			feedback = masterMind.check(colors);
//			printFeedbackRow(colors, feedback);
//	    	colors = new int[] {4, 5, 3, 2}; // 8 9 4 3 2 7 1 6 5 10
//	    	feedback = masterMind.check(colors);
//	    	printFeedbackRow(colors, feedback);
//	    	colors = new int[] {4, 1, 3, 2}; // 8 9 4 3 2 7 1 6 5 10
//	    	feedback = masterMind.check(colors);
//	    	printFeedbackRow(colors, feedback);
//	    	colors = new int[] {4, 0, 3, 2}; // 8 9 4 3 2 7 1 6 5 10
//	    	feedback = masterMind.check(colors);
//	    	printFeedbackRow(colors, feedback);
//	    	colors = new int[] {1, 5, 4, 3}; // 8 9 4 3 2 7 1 6 5 10
//	    	//colors = new int[] {8, 9, 4, 3, 2, 7, 1, 0, 5, 10}; // 8 9 4 3 2 7 1 6 5 10
//	    	feedback = masterMind.check(colors);
//	    	printFeedbackRow(colors, feedback);
//	    	if (masterMind.isGameOver()) {
//	    		System.out.println("GAME OVER");
//	    	}
//	    	if (masterMind.hasWon()) {
//	    		System.out.println("YOU WON");
//	    	} else {
//	    		System.out.println("YOU LOST");
//	    	}
//		} catch (MasterMindCheckException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
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
    	ColorService service = new ColorService();
    	for (long i : arr) {
    		Color color = service.read(i);
    		String name;
    		if (color == null) {
    			name = "Unknown";
    		} else {
    			name = color.getName();
    		}
    		
    		System.out.printf("%-10s", name, i);
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
