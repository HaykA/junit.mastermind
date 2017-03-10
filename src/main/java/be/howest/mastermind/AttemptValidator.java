package be.howest.mastermind;

import be.howest.entities.Scheme;
import be.howest.mastermind.exceptions.InvalidAttemptException;

final class AttemptValidator {
	private final Scheme scheme;
	
	AttemptValidator(Scheme scheme) {
		this.scheme = scheme;
	}
	
	void validate(int[] colors) throws InvalidAttemptException {
		if (colors == null) {
			throw new InvalidAttemptException("Null as Color array is not allowed!");
		}
		if (colors.length > scheme.getPawnCount()) {
			throw new InvalidAttemptException("Checking more colors than expected is not allowed!");
		}
		if (colors.length < scheme.getPawnCount()) {
			throw new InvalidAttemptException("Checking less colors than expected is not allowed!");
		}
		if (! hasValidColors(colors, scheme.getColorCount())) {
			throw new InvalidAttemptException("Checking with invalid colors is not allowed!");
		}
		if (! hasDifferentColors(colors, true)) {
			throw new InvalidAttemptException("Checking with not different colors is not allowed!");
		}
	}
	
	private static boolean hasValidColors(int[] colors, int max) {
		boolean emptyArray = true;

		for (int color : colors) {
			if (color < 0 || color > max) {
				return false;
			}
			if (color >= 0 && color <= max) {
				emptyArray = false;
			}
		}
		if (emptyArray) {
			return false;
		}
		return true;
	}
	
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

}
