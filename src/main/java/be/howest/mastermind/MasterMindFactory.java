package be.howest.mastermind;

import be.howest.entities.Scheme;
import be.howest.services.SchemeService;

public final class MasterMindFactory {
	
	public MasterMind createMasterMind(Scheme scheme) {
		if (scheme == null) {
			return new MasterMind(SchemeService.readDefault());
		}
		return new MasterMind(scheme);
	}
}
