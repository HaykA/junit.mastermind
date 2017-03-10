package be.howest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import be.howest.entities.Scheme;

public class SchemeService {
	private static final Map<Long, Scheme> SCHEMES = new ConcurrentHashMap<>();
	static {
		SCHEMES.put(0L, new Scheme(0L, 4, 6, 1));
		SCHEMES.put(1L, new Scheme(1L, 4, 8, 2));
		SCHEMES.put(2L, new Scheme(2L, 5, 8, 3));
		SCHEMES.put(3L, new Scheme(3L, 5, 10, 5));
		SCHEMES.put(4L, new Scheme(4L, 6, 8, 5));
		SCHEMES.put(5L, new Scheme(5L, 6, 10, 7));
		SCHEMES.put(6L, new Scheme(6L, 7, 10, 8));
		SCHEMES.put(7L, new Scheme(7L, 8, 10, 9));
	}
	
	public Scheme read(long id) {
		if (SCHEMES.containsKey(id)) {
			return SCHEMES.get(id);
		}
		return readDefault();
	}
	
	public static Scheme readDefault() {
		return SCHEMES.get(0L);
	}
	
	public List<Scheme> findAll() {
		return new ArrayList<>(SCHEMES.values());
	}
}
