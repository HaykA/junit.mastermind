package be.howest.mastermind;

import be.howest.entities.Scheme;
import be.howest.mastermind.exceptions.InvalidAttemptException;

final class AttemptFactory {
	private final Scheme scheme;
	
	AttemptFactory(Scheme scheme) {
		this.scheme = scheme; 
	}
	
	Attempt createAttempt(int[] colors) throws InvalidAttemptException {
		(new AttemptValidator(scheme)).validate(colors);
		return new Attempt(colors);
	}
	
	
}
