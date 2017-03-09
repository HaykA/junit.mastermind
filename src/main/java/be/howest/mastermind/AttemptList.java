package be.howest.mastermind;

import be.howest.entities.Scheme;

public class AttemptList {
	private final int[][] attempts;
	
	AttemptList(Scheme scheme) {
		attempts = new int[scheme.getTotalAllowedAttempts()][scheme.getPawnCount()];
	}
	
	int[][] getAttempts() {
		return attempts;
	}
	
	int[][] getReverseSortedAttempts() {
		if (attempts.length > 1) {
			int[][] reversedAttempts = new int[attempts.length][attempts[0].length];
			for (int i = attempts.length - 1; i >= 0; i--) {
				for (int j = 0; j < attempts[i].length; j++) {
					reversedAttempts[attempts.length - i - 1][j] = attempts[i][j];
				}
			}			
			return reversedAttempts;
		}
		return attempts;
	}
	
	boolean add(int[] colors) {
		boolean added = false;
		int nextIndex = getCurrentAttemptIndex();
		if (nextIndex >= 0) {
			for (int i = 0; i < colors.length; i++) {
				attempts[nextIndex][i] = colors[i];
			}				
			added = true;
		}
		return added;
	}
	
	boolean hasNext() {
		return getCurrentAttemptIndex() >= 0;
	}
	
	int getCurrentAttemptIndex() {
		int nextIndex = -1;
		boolean emptyLine;
		for (int i = 0; i < attempts.length; i++) {
			emptyLine = true;
			for (int attempt : attempts[i]) {
				if (attempt > 0) {
					emptyLine = false;
					break;
				}
			}
			if (emptyLine) {
				nextIndex = i;
				break;
			}
		}
		return nextIndex;
	}
	
	void reset() {
		for (int[] attempt : attempts) {
			for (int i = 0; i < attempt.length; i++) {
				attempt[i] = 0;
			}
		}
	}
	
}
