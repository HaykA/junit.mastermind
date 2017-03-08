package be.howest.mastermind;

import java.util.Random;

/**
 *
 * @author hayk
 */
public class Main {
    public static void main(String args[]) {
    	Random random = new Random(50L);
    	for (int i = 0; i < 75; i++) {
    		System.out.println(random.nextInt(4));
    	}
        System.out.println("•~~~~×");
    }
}
