package be.howest.mastermind;

import java.io.Serializable;

import be.howest.entities.Scheme;
import be.howest.mastermind.exceptions.MasterMindCheckException;

public final class MasterMind implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Scheme scheme;
	private boolean resigned;
	private boolean won;
	private final AttemptList attemptList;
	private int[] secret;

	MasterMind(Scheme scheme) {
		this.scheme = scheme;
		attemptList = new AttemptList(scheme);
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

	public int[][] getAttempts() {
		return attemptList.getAttempts();
	}
	
	public int[][] getReverseSortedAttempts() {
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

	public Feedback check(int[] colors) throws MasterMindCheckException {
		(new CheckValidator(scheme)).validateCheck(colors);
		Feedback feedback = null;
		if (!isGameOver()) {
			attemptList.add(colors);
			feedback = generateFeedback(colors);
			checkIfWon(feedback);
		}
		return feedback;
	}
	

	protected Feedback generateFeedback(int[] colors) {
		Feedback feedback = new Feedback(getColorCount());
		for (int i = 0; i < colors.length; i++) {
			for (int j = 0; j < secret.length; j++) {
				if (colors[i] == secret[j]) {
					boolean foundAtValidPosition = i == j;
					feedback.addFound(foundAtValidPosition);
				}
			}
		}
		return feedback;
	}

	protected void checkIfWon(Feedback feedback) {
		won = feedback.getTotalFoundAtValidPosition() == getPawnCount();
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
