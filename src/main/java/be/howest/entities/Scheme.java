package be.howest.entities;

import java.io.Serializable;

public final class Scheme implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final long id;
	private final int pawnCount;
	private final int colorCount;
	
	public Scheme(long id, int pawnCount, int colorCount) {
		this.id = id;
		this.pawnCount = pawnCount;
		this.colorCount = colorCount;
	}
	
	public long getId() {
		return id;
	}
	
	public int getPawnCount() {
		return pawnCount;
	}
	
	public int getColorCount() {
		return colorCount;
	}
	
	public int getTotalAllowedAttempts() {
		int totalTries = (pawnCount * 3 + colorCount) / 2;
		totalTries += totalTries % 2;
		return totalTries;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colorCount;
		result = prime * result + pawnCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scheme other = (Scheme) obj;
		if (colorCount != other.colorCount)
			return false;
		if (pawnCount != other.pawnCount)
			return false;
		return true;
	}
	
	
}
