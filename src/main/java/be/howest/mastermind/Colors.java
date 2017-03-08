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
	
	public static boolean hasDifferentColors(int[] colors, boolean ignoreZeroes) {
		if (colors == null) {
			return false;
		}
		for (int i = 0; i < colors.length - 1; i++) {
			for (int j = i + 1; j < colors.length; j++) {
				if (colors[i] == colors[j]) {
					if (! ignoreZeroes) {
						return false;						
					}
					if (colors[i] != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static boolean hasValidColors(int[] colors) {
		return hasValidColors(colors, MAX);
	}
	
	public static boolean hasValidColors(int[] colors, int max) {
		if (colors == null) {
			return false;
		}
		boolean emptyArray = true;
		
		for(int color : colors) {
			if (color < 0 || color > max) {
				return false;
			}
			if (color >= MIN && color <= max) {
				emptyArray = false;
			}
		}
		if (emptyArray) {
			return false;
		}
		return true;
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
