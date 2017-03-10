package be.howest.mastermind;

import be.howest.entities.Scheme;

public class AttemptList {
	private final Attempt[] attempts;
	
	AttemptList(Scheme scheme) {
		attempts = new Attempt[scheme.getTotalAllowedAttempts()];
	}
	
	Attempt[] getAttempts() {
		return attempts;
	}
	
	Attempt[] getReverseSortedAttempts() {
		if (attempts.length > 1) {
			Attempt[] reversedAttempts = new Attempt[attempts.length];
			for (int i = 0; i < attempts.length; i++) {
				reversedAttempts[attempts.length - i - 1] = attempts[i];
			}			
			return reversedAttempts;
		}
		return copyOf(attempts);
	}
	
	private Attempt[] copyOf(Attempt[] attempts) {
		if (attempts != null) {
			Attempt[] copyOfAttempts = new Attempt[attempts.length];
			for (int i = 0; i < attempts.length; i++) {
				copyOfAttempts[i] = attempts[i];
			}
			return copyOfAttempts;
		}
		return attempts;
	}
	
	boolean add(Attempt attempt) {
		int nextIndex = getCurrentAttemptIndex();
		if (nextIndex >= 0) {
			attempts[nextIndex] = attempt;				
			return true;
		}
		return false;
	}
	
	boolean hasNext() {
		return getCurrentAttemptIndex() >= 0;
	}
	
	int getCurrentAttemptIndex() {
		for (int i = 0; i < attempts.length; i++) {
			if (attempts[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	void reset() {
		for (int i = 0; i < attempts.length; i++) {
			attempts[i] = null;
		}
	}
	
}
