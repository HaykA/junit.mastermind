package be.howest.mastermind;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author hayk
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	be.howest.mastermind.MasterMindTest.class,
	be.howest.mastermind.FeedBackTest.class,
	be.howest.mastermind.ColorsTest.class
	})
public class MasterMindSuite {}
