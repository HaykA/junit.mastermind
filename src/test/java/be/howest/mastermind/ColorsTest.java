package be.howest.mastermind;

import org.junit.Test;
import static org.junit.Assert.*;

public class ColorsTest {
	
	@Test
	public void checking_different_colors_as_null_returns_false() {
		assertFalse(Colors.hasDifferentColors(null, false));
	}
	
	@Test
	public void checking_different_colors_returns_true() {
		int[] colors = {1, 2, 3, 4};
		assertTrue(Colors.hasDifferentColors(colors, false));
	}
	
	@Test
	public void checking_not_different_colors_returns_false() {
		int[] colors = {1, 2, 2, 4};
		assertFalse(Colors.hasDifferentColors(colors, false));
	}
	
	@Test
	public void checking_valid_colors_returns_true() {
		int[] colors = {1, 2, 3, 4};
		assertTrue(Colors.hasValidColors(colors));
	}
	
	@Test
	public void checking_invalid_colors_returns_false() {
		int[] colors = {1, 2, 3, 12};
		assertFalse(Colors.hasValidColors(colors));
	}
	
	@Test
	public void checking_valid_colors_as_null_returns_false() {
		assertFalse(Colors.hasValidColors(null));
	}
}
