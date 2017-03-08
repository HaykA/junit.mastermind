package be.howest.mastermind;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hayk
 */
public class MasterMindTest {

	@Test(expected = IllegalArgumentException.class)
	public void new_game_with_negative_pawn_number_not_allowed() {
		int pawnCount = -3;
		int colorCount = 4;
		new MasterMind(pawnCount, colorCount);
	}

	@Test(expected = IllegalArgumentException.class)
	public void new_game_with_no_pawns_not_allowed() {
		int pawnCount = -3;
		int colorCount = 4;
		new MasterMind(pawnCount, colorCount);
	}

	@Test(expected = IllegalArgumentException.class)
	public void new_game_with_less_than_four_pawns_not_allowed() {
		int pawnCount = 3;
		int colorCount = 4;
		new MasterMind(pawnCount, colorCount);
	}

	@Test(expected = IllegalArgumentException.class)
	public void new_game_with_more_than_eight_pawns_not_allowed() {
		int pawnCount = 9;
		int colorCount = 4;
		new MasterMind(pawnCount, colorCount);
	}

	@Test(expected = IllegalArgumentException.class)
	public void new_game_with_negative_color_count_not_allowed() {
		int pawnCount = 4;
		int colorCount = -2;
		new MasterMind(pawnCount, colorCount);
	}

	@Test(expected = IllegalArgumentException.class)
	public void new_game_with_no_colors_not_allowed() {
		int pawnCount = 4;
		int colorCount = 0;
		new MasterMind(pawnCount, colorCount);
	}

	@Test(expected = IllegalArgumentException.class)
	public void new_game_with_less_than_four_colors_not_allowed() {
		int pawnCount = 4;
		int colorCount = 3;
		new MasterMind(pawnCount, colorCount);
	}

	@Test(expected = IllegalArgumentException.class)
	public void new_game_with_more_than_ten_colors_not_allowed() {
		int pawnCount = 4;
		int colorCount = 11;
		new MasterMind(pawnCount, colorCount);
	}

	@Test
	public void new_game_with_four_pawns_and_four_colors_does_not_throw_any_exception() {
		int pawnCount = 4;
		int colorCount = 4;
		new MasterMind(pawnCount, colorCount);
	}
	
	@Test
	public void new_game_with_eight_pawns_and_ten_colors_does_not_throw_any_exception() {
		int pawnCount = 8;
		int colorCount = 10;
		new MasterMind(pawnCount, colorCount);
	}

	@Test
	public void fifty_new_games_generate_correct_number_of_colors() {
		int pawnCount = 8;
		int colorCount = 10;
		MasterMind masterMind;
		for (int i = 0; i < 50; i++) {
			masterMind = new MasterMind(pawnCount, colorCount);
			assertEquals(colorCount, masterMind.getSecret().length);
		}
	}

	@Test
	public void fifty_new_games_generate_different_colors() {
		int pawnCount = 8;
		int colorCount = 10;
		MasterMind masterMind;
		for (int i = 0; i < 50; i++) {
			masterMind = new MasterMind(pawnCount, colorCount);
			assertTrue(masterMind.hasDifferentColors());
		}
	}

	@Test
	public void fifty_times_resetting_an_existing_game_regenerates_correct_number_of_colors() {
		int pawnCount = 8;
		int colorCount = 10;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		masterMind.reset();
		assertEquals(colorCount, masterMind.getColorCount());
	}

	@Test
	public void fifty_times_resetting_an_existing_game_regenerates_different_colors() {
		int pawnCount = 8;
		int colorCount = 10;
		MasterMind masterMind;
		for (int i = 0; i < 50; i++) {
			masterMind = new MasterMind(pawnCount, colorCount);
			masterMind.reset();
			assertTrue(masterMind.hasDifferentColors());
		}
	}

	@Test
	public void number_of_pawns_remain_unchainged_after_a_game_reset() {
		int pawnCount = 4;
		int colorCount = 4;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		masterMind.reset();
		assertEquals(pawnCount, masterMind.getPawnCount());
	}

	@Test
	public void new_game_initializes_tries_array_which_is_not_null() {
		int pawnCount = 4;
		int colorCount = 4;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		assertNotNull(masterMind.getTries());
	}

	@Test
	public void new_game_initializes_tries_array_of_correct_length_equal_to_pawn_count() {
		int pawnCount = 4;
		int colorCount = 4;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		assertEquals(pawnCount, masterMind.getTries().length);
	}

	@Test
	public void new_game_initializes_tries_array_containing_arrays_of_correct_length_equal_to_color_count_per_try() {
		int pawnCount = 4;
		int colorCount = 4;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		assertEquals(colorCount, masterMind.getTries()[0].length);
	}
	
	@Test
	public void new_game_is_not_over_if_not_resigned() {
		int pawnCount = 4;
		int colorCount = 8;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		assertFalse(masterMind.isGameOver());
	}
	
	@Test
	public void game_is_over_when_resigned() {
		int pawnCount = 4;
		int colorCount = 8;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		masterMind.resign();
		assertTrue(masterMind.isGameOver());
	}
	
	@Test
	public void player_has_lost_if_resigned() {
		int pawnCount = 4;
		int colorCount = 8;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		masterMind.resign();
		assertFalse(masterMind.hasWon());
	}
	
	@Test
	public void getSecret_method_returns_an_array_containing_zeroes_if_game_is_not_over() {
		int pawnCount = 4;
		int colorCount = 10;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		int[] negativeOneNumbers = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		assertArrayEquals(negativeOneNumbers, masterMind.getSecret());
	}
	
	@Test
	public void getSecret_method_returns_an_array_containing_no_zeroes_if_game_is_over() {
		int pawnCount = 4;
		int colorCount = 10;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		masterMind.resign();
		for(int color: masterMind.getSecret()) {
			assertNotEquals(0, color);
		}
	}
	
	@Test
	public void getSecret_method_returns_an_array_containing_valid_colors_if_game_is_over() {
		int pawnCount = 4;
		int colorCount = 10;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		masterMind.resign();
		for(int color: masterMind.getSecret()) {
			assertNotEquals(0, color);
		}
	}
	
	@Test
	public void getSecret_method_returns_an_array_containing_different_colors_if_game_is_over() {
		int pawnCount = 4;
		int colorCount = 10;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		masterMind.resign();
		boolean[] found = {true, false, false, false, false, false, false, false, false, false, false};
		for(int color: masterMind.getSecret()) {
			found[color] = true;
		}
		for(boolean isDifferentColor : found) {
			assertTrue(isDifferentColor);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checking_with_null_not_allowed() {
		int pawnCount = 4;
		int colorCount = 4;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		masterMind.check(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checking_with_empty_array_not_allowed() {
		int pawnCount = 4;
		int colorCount = 4;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		masterMind.check(new int[colorCount]);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checking_with_array_containing_more_colors_than_expected_not_allowed() {
		int pawnCount = 4;
		int colorCount = 4;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		masterMind.check(new int[colorCount + 1]);
	}
	
	@Test
	public void checking_with_array_containing_expected_count_of_colors_is_allowed() {
		int pawnCount = 4;
		int colorCount = 4;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		masterMind.check(new int[colorCount]);
	}
	
	@Test
	public void checking_with_array_containing_less_than_expected_count_of_colors_is_allowed() {
		int pawnCount = 4;
		int colorCount = 4;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		masterMind.check(new int[colorCount - 1]);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checking_with_array_containing_zero_values_not_allowed() {
		int pawnCount = 4;
		int colorCount = 4;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		int[] colors = {1, 0, 3, 2};
		masterMind.check(colors);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checking_with_array_containing_incorrect_color_values_not_allowed() {
		int pawnCount = 4;
		int colorCount = 4;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		int[] colors = {1, 5, 3, 2};
		masterMind.check(colors);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checking_with_array_containing_not_different_color_values_not_allowed() {
		int pawnCount = 4;
		int colorCount = 4;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		int[] colors = {1, 3, 3, 2};
		masterMind.check(colors);
	}
	
	@Test
	public void checking_with_array_containing_expected_count_of_different_correct_color_values_is_allowed_and_decrements_total_tries() {
		int pawnCount = 4;
		int colorCount = 4;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		int[] colors = {1, 4, 3, 2};
		masterMind.check(colors);
	}
	
}
