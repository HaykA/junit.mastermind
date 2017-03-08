package be.howest.mastermind;

import java.util.Random;

public final class MasterMind {

	private static final int MIN_COLOR_COUNT = 4;
	private static final int MAX_COLOR_COUNT = 10;
	private static final int MIN_PAWN_COUNT = 4;
	private static final int MAX_PAWN_COUNT = 8;
	
	private final int pawnCount;
	private final int colorCount;
	private boolean resigned;
	private boolean won;
	private int[] secret;
	private int[][] tries;

	public MasterMind(int pawnCount, int colorCount) {
		validateConstructorParameters(pawnCount, colorCount);
		this.pawnCount = pawnCount;
		this.colorCount = colorCount;
		init();
	}
	
	private void validateConstructorParameters(int pawnCount, int colorCount) {
		if (colorCount < MIN_COLOR_COUNT || colorCount > MAX_COLOR_COUNT) {
    		throw new IllegalArgumentException("Wrong Color Count");
    	}
    	if (pawnCount < MIN_PAWN_COUNT || pawnCount > MAX_PAWN_COUNT) {
    		throw new IllegalArgumentException("Wrong Pawn Count");
    	}
	}
	
	public int getPawnCount() {
		return pawnCount;
	}

	public int getColorCount() {
		return colorCount;
	}

	public int[][] getTries() {
		return tries;
	}

	private void init() {
		resigned = false;
		won = false;
		initSecret();
		initTries();
	}

	private void initSecret() {
		secret = new int[colorCount];
		generateSecret();
	}
	
	private void generateSecret() {
		Random random = new Random(/* TODO remove seed */50L);
		for (int i = 0; i < colorCount; i++) {
			int color = random.nextInt(colorCount) + 1;
			if (secretContains(color)) {
				i--;
			} else {
				secret[i] = color;
			}
		}
	}
	
	private boolean secretContains(int color) {
		for (int i = 0; i < colorCount; i++) {
			if (secret[i] == color) {
				return true;
			}
		}
		return false;
	}

	protected void initTries() {
		tries = new int[pawnCount][colorCount];
	}

	protected boolean hasDifferentColors() {
		return Colors.hasDifferentColors(secret, false);
	}

	public void reset() {
		init();
	}

	public void resign() {
		resigned = true;
		won = false;
	}

	public Feedback check(int[] colors) {
		validateColors(colors);
		Feedback feedback = null;
		if (! isGameOver()) {
			addColorsToTries(colors);
			feedback = generateFeedback(colors);
			checkIfWon(feedback);			
		}
		return feedback;
	}
	
	private void validateColors(int[] colors) {
		if (colors == null) {
			throw new IllegalArgumentException("Null as Color array is not allowed!");
		}
		if (colors.length > colorCount) {
			throw new IllegalArgumentException("Checking more colors than expected is not allowed!");
		}
		if (colors.length < colorCount) {
			throw new IllegalArgumentException("Checking more colors than expected is not allowed!");
		}
		if (! Colors.hasValidColors(colors, colorCount)) {
			throw new IllegalArgumentException("Checking with invalid colors is not allowed!");
		}
		if (! Colors.hasDifferentColors(colors, true)) {
			throw new IllegalArgumentException("Checking with not different colors is not allowed!");
		}
	}
	
	protected void addColorsToTries(int[] colors) {
		int nextTry = getNextTry();
		for (int i = 0; i < colors.length; i++) {
			tries[nextTry][i] = colors[i];			
		}
	}
	
	protected Feedback generateFeedback(int[] colors) {
		Feedback feedback = new Feedback(colorCount);
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
		won = feedback.getTotalFoundAtValidPosition() == colorCount;
	}
	
	protected int getNextTry() {
		int nextTry = -1;
		boolean emptyLine;
		for (int i = 0; i < tries.length; i++) {
			emptyLine = true;
			for (int _try : tries[i]) {
				if (_try > 0) {
					emptyLine = false;
					break;
				}
			}
			if (emptyLine) {
				nextTry = i;
				break;
			}
		}
		return nextTry;
	}
	
	public boolean hasWon() {
		return won;
	}

	public boolean isGameOver() {
		return resigned || won || getNextTry() == -1;  
	}

	public int[] getSecret() {
		if (! isGameOver()) {
			int[] mask = new int[colorCount];
			return mask;
		}
		return secret;
	}
}
