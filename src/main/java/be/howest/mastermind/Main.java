package be.howest.mastermind;

/**
 *
 * @author hayk
 */
public class Main {
    public static void main(String args[]) {
    	MasterMind masterMind = new MasterMind(4, 10);
    	masterMind.resign();
    	masterMind.reset();
    	masterMind.resign();
    	printIntArr(masterMind.getSecret());
        //System.out.println("•~~~~×");
    }
    
    private static void printIntArr(int[] arr) {
    	for (int i : arr) {
    		System.out.printf("%s   ", Colors.getColorName(i));
    	}
    	System.out.println();
    }
}
