package be.howest.mastermind;

/**
 *
 * @author hayk
 */
public final class Colors {
	public final static int MIN = 1;
	public final static int RED = MIN;
	public final static int ORANGE = 2;
	public final static int YELLOW = 3;
	public final static int GREEN = 4;
	public final static int BLUE = 5;
	public final static int PURPLE = 6;
	public final static int PINK = 7;
	public final static int WHITE = 8;
	public final static int GREY = 9;
	public final static int MAX = 10;
	public final static int BLACK = MAX;

	private Colors() {}
	
	public static boolean hasDifferentColors(int[] colors) {
		throw new UnsupportedOperationException();
	}
	
	public static boolean hasValidColors(int[] colors) {
		throw new UnsupportedOperationException();
	}

	public static String getColorName(int colorId) {
		switch (colorId) {
		case RED:
			return "Red";
		case ORANGE:
			return "Orange";
		case YELLOW:
			return "Yellow";
		case GREEN:
			return "Green";
		case BLUE:
			return "Blue";
		case PURPLE:
			return "Purple";
		case PINK:
			return "Pink";
		case WHITE:
			return "White";
		case GREY:
			return "Grey";
		case BLACK:
			return "Black";
		}
		return "Unknown";
	}
}
