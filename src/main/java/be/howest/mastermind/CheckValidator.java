package be.howest.mastermind;

import be.howest.entities.Scheme;
import be.howest.mastermind.exceptions.MasterMindCheckException;

final class CheckValidator {
	private final Scheme scheme;
	
	CheckValidator(Scheme scheme) {
		this.scheme = scheme;
	}
	
	void validateCheck(int[] colors) throws MasterMindCheckException {
		if (colors == null) {
			throw new MasterMindCheckException("Null as Color array is not allowed!");
		}
		if (colors.length > scheme.getPawnCount()) {
			throw new MasterMindCheckException("Checking more colors than expected is not allowed!");
		}
		if (colors.length < scheme.getPawnCount()) {
			throw new MasterMindCheckException("Checking less colors than expected is not allowed!");
		}
		if (! hasValidColors(colors, scheme.getColorCount())) {
			throw new MasterMindCheckException("Checking with invalid colors is not allowed!");
		}
		if (! hasDifferentColors(colors, true)) {
			throw new MasterMindCheckException("Checking with not different colors is not allowed!");
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
