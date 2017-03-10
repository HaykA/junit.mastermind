package be.howest.mastermind;

import java.io.Serializable;

import be.howest.entities.Scheme;
import be.howest.mastermind.exceptions.InvalidAttemptException;

public final class MasterMind implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Scheme scheme;
	private final AttemptFactory attemptFactory;
	private boolean resigned;
	private boolean won;
	private final AttemptList attemptList;
	private int[] secret;

	MasterMind(Scheme scheme) {
		this.scheme = scheme;
		attemptList = new AttemptList(scheme);
		attemptFactory = new AttemptFactory(scheme);
		reset();
	}

	public void reset() {
		resigned = false;
		won = false;
		secret = (new SecretGenerator(scheme)).createSecret();
		attemptList.reset();
	}
	
	public boolean hasWon() {
		return won;
	}

	public int getPawnCount() {
		return scheme.getPawnCount();
	}

	public int getColorCount() {
		return scheme.getColorCount();
	}

	public Attempt[] getAttempts() {
		return attemptList.getAttempts();
	}
	
	public Attempt[] getReverseSortedAttempts() {
		return attemptList.getReverseSortedAttempts();
	}
	
	public int getCurrentAttemptIndex() {
		return attemptList.getCurrentAttemptIndex();
	}

	public int getTotalAllowedAttempts() {
		return scheme.getTotalAllowedAttempts();
	}

	public void resign() {
		resigned = true;
		won = false;
	}

	public Feedback check(int[] colors) throws InvalidAttemptException {
		Attempt attempt = attemptFactory.createAttempt(colors);
		Feedback feedback = null;
		if (!isGameOver()) {
			feedback = generateFeedback(attempt);
			attempt.setFeedback(feedback);
			attemptList.add(attempt);
			checkIfWon(feedback);
		}
		return feedback;
	}
	

	protected Feedback generateFeedback(Attempt attempt) {
		Feedback feedback = new Feedback(getColorCount());
		for (int i = 0; i < attempt.size(); i++) {
			for (int j = 0; j < secret.length; j++) {
				if (attempt.get(i) == secret[j]) {
					boolean foundAtValidPosition = i == j;
					feedback.addFound(foundAtValidPosition);
				}
			}
		}
		return feedback;
	}

	protected void checkIfWon(Feedback feedback) {
		won = feedback.isComplete();
	}

	public boolean isGameOver() {
		return resigned || won || ! attemptList.hasNext();
	}

	public int[] getSecret() {
		if (!isGameOver()) {
			int[] mask = new int[getColorCount()];
			return mask;
		}
		return secret;
	}

}
