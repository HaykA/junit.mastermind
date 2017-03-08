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
		for (int i = 0; i < colorCount; i++) {
			secret[i] = -1;
		}
		generateSecret();
	}
	
	private void generateSecret() {
		Random random = new Random(/* TODO remove seed */50L);
		for (int i = 0; i < colorCount; i++) {
			int color = random.nextInt(colorCount);
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
		for (int i = 0; i < secret.length - 1; i++) {
			for (int j = i + 1; j < secret.length; j++) {
				if (secret[i] == secret[j]) {
					return false;
				}
			}
		}
		return true;
	}

	public void reset() {
		init();
	}

	public void resign() {
		resigned = true;
		won = false;
	}

	public Feedback check(int[] colors) {
		throw new UnsupportedOperationException();
	}

	public boolean hasWon() {
		return won;
	}

	public boolean isGameOver() {
		return resigned || won || /* TODO if no tries anymore */ false;  
	}

	public int[] getSecret() {
		if (! isGameOver()) {
			int[] mask = new int[colorCount];
			for (int i = 0; i < mask.length; i++) {
				mask[i] = -1;
			}
			return mask;
		}
		return secret;
	}
}
