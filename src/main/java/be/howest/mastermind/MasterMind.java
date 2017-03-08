package be.howest.mastermind;

public final class MasterMind {

	private final int pawnCount;
	private final int colorCount;
	private boolean resined = false;
	private int[] secret;
	private int[][] tries;

	public MasterMind(int pawnCount, int colorCount) {
		this.pawnCount = pawnCount;
		this.colorCount = colorCount;
		init();
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

	protected void init() {
		initSecret();
		initTries();
	}

	protected void initSecret() {
		throw new UnsupportedOperationException(); // TODO
	}

	protected void initTries() {
		throw new UnsupportedOperationException(); // TODO
	}

	protected boolean hasDifferentColors() {
		throw new UnsupportedOperationException(); // TODO
	}

	public void reset() {
		throw new UnsupportedOperationException(); // TODO
	}

	public void resign() {
		throw new UnsupportedOperationException(); // TODO
	}

	public Feedback check(int[] colors) {
		throw new UnsupportedOperationException();
	}

	public boolean hasWon() {
		throw new UnsupportedOperationException();
	}

	public boolean isGameOver() {
		throw new UnsupportedOperationException();
	}

	public int[] getSecret() {
		throw new UnsupportedOperationException();
	}
}
