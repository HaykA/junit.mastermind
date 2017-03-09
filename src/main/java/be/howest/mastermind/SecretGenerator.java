package be.howest.mastermind;

import java.util.Random;

import be.howest.entities.Scheme;

final class SecretGenerator {
	private final Scheme scheme;
	
	SecretGenerator(Scheme scheme) {
		this.scheme = scheme;
	}

	int[] createSecret() {
		int[] secret = new int[scheme.getPawnCount()];
		Random random = new Random(/* TODO remove seed */50L);
		for (int i = 0; i < secret.length; i++) {
			int color = random.nextInt(scheme.getColorCount());
			if (secretContainsColor(secret, color)) {
				i--;
			} else {
				secret[i] = color;
			}
		}
		for(int color : secret) {
			System.out.printf("%-3s", color); // TODO remove secret printout
		}
		System.out.println();
		return secret;
	}

	private boolean secretContainsColor(int[] secret, int color) {
		for (int i = 0; i < secret.length; i++) {
			if (secret[i] == color) {
				return true;
			}
		}
		return false;
	}
}