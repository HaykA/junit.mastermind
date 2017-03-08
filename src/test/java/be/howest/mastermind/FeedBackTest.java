package be.howest.mastermind;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
*
* @author hayk
*/
public class FeedBackTest {
	private Feedback feedback;
	
	@Before
	public void setUp() {
		feedback = new Feedback(4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void new_feedback_with_negative_color_count_not_allowed() {
		new Feedback(-2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void new_feedback_with_no_colors_not_allowed() {
		new Feedback(0);
	}
	
	@Test
	public void total_found_at_invalid_position_of_a_new_feedback_is_minus_one() {
		assertEquals(-1, feedback.getTotalFoundAtInvalidPosition());
	}
	
	@Test
	public void total_found_at_valid_position_of_a_new_feedback_is_zero() {
		assertEquals(0, feedback.getTotalFoundAtValidPosition());
	}
	
	@Test
	public void total_found_at_invalid_position_becomes_one_after_accepting_first_found_color_at_invalid_position() {
		feedback.addFound(false);
		assertEquals(1, feedback.getTotalFoundAtInvalidPosition());
	}
	
	@Test
	public void total_found_at_invalid_position_increases_by_one_after_accepting_found_colors_at_invalid_position_three_times() {
		int comparatorInt = 1;
		for (int i = 0; i < 3; i++) {
			feedback.addFound(false);
			assertEquals(comparatorInt++, feedback.getTotalFoundAtInvalidPosition());			
		}
	}
	
	@Test
	public void total_found_at_valid_position_increases_by_one_after_accepting_found_colors_at_valid_position_three_times() {
		int comparatorInt = 1;
		for (int i = 0; i < 3; i++) {
			feedback.addFound(true);
			assertEquals(comparatorInt++, feedback.getTotalFoundAtValidPosition());			
		}
	}

	@Test
	public void color_count_remains_same_after_increasing_total_found_color_number_at_valid_position() {
		int colorCount = 5;
		Feedback feedbackForFiveColors = new Feedback(colorCount);
		feedbackForFiveColors.addFound(true);
		assertEquals(colorCount, feedbackForFiveColors.getColorCount());
	}
	
	@Test
	public void color_count_remains_same_after_increasing_total_found_color_number_at_invalid_position() {
		int colorCount = 5;
		Feedback feedbackForFiveColors = new Feedback(colorCount);
		feedbackForFiveColors.addFound(false);
		assertEquals(colorCount, feedbackForFiveColors.getColorCount());
	}
	
	@Test
	public void adding_more_colors_found_at_valid_position_than_initial_color_count_does_not_increment_total_colors_found_at_valid_position() {
		int colorCount = 3;
		Feedback feedbackForThreeColors = new Feedback(colorCount);
		for (int i = 0; i < 10; i++) {
			feedbackForThreeColors.addFound(true);
			assertTrue(feedbackForThreeColors.getTotalFoundAtValidPosition() <= colorCount);
		}
	}
	
	@Test
	public void adding_more_colors_found_at_invalid_position_than_initial_color_count_does_not_increment_total_colors_found_at_invalid_position() {
		int colorCount = 3;
		Feedback feedbackForThreeColors = new Feedback(colorCount);
		for (int i = 0; i < 10; i++) {
			feedbackForThreeColors.addFound(false);
			assertTrue(feedbackForThreeColors.getTotalFoundAtInvalidPosition() <= colorCount);
		}
	}
	
	@Test
	public void adding_more_colors_found_than_initial_color_count_does_not_increment_total_colors_found() {
		int colorCount = 8;
		Feedback feedbackForEightColors = new Feedback(colorCount);
		for (int i = 0; i < 30; i++) {
			feedbackForEightColors.addFound(i % 2 == 0);
			assertTrue(feedbackForEightColors.getTotalFoundAtValidPosition()
					+ feedbackForEightColors.getTotalFoundAtInvalidPosition() <= colorCount);
		}
	}
}
