/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
	public void new_game_with_more_than_eight_colors_not_allowed() {
		int pawnCount = 4;
		int colorCount = 8;
		new MasterMind(pawnCount, colorCount);
	}

	@Test
	public void new_game_with_four_pawns_and_four_colors_does_not_throw_any_exception() {
		int pawnCount = 4;
		int colorCount = 4;
		new MasterMind(pawnCount, colorCount);
	}

	@Test
	public void fifty_new_games_generate_correct_number_of_colors() {
		int pawnCount = 8;
		int colorCount = 8;
		MasterMind masterMind;
		for (int i = 0; i < 50; i++) {
			masterMind = new MasterMind(pawnCount, colorCount);
			assertEquals(colorCount, masterMind.getColorCount());
		}
	}

	@Test
	public void fifty_new_games_generate_different_colors() {
		int pawnCount = 8;
		int colorCount = 8;
		MasterMind masterMind;
		for (int i = 0; i < 50; i++) {
			masterMind = new MasterMind(pawnCount, colorCount);
			assertTrue(masterMind.hasDifferentColors());
		}
	}

	@Test
	public void fifty_times_resetting_an_existing_game_regenerates_correct_number_of_colors() {
		int pawnCount = 8;
		int colorCount = 8;
		MasterMind masterMind = new MasterMind(pawnCount, colorCount);
		masterMind.reset();
		assertEquals(colorCount, masterMind.getColorCount());
	}

	@Test
	public void fifty_times_resetting_an_existing_game_regenerates_different_colors() {
		int pawnCount = 8;
		int colorCount = 8;
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
}
