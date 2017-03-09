package be.howest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import be.howest.entities.Color;

public class ColorService {
	private static final Map<Long, Color> COLORS = new ConcurrentHashMap<>();
	static {
		COLORS.put(1L, new Color(1L, "red"));
		COLORS.put(2L, new Color(2L, "orange"));
		COLORS.put(3L, new Color(3L, "yellow"));
		COLORS.put(4L, new Color(4L, "green"));
		COLORS.put(5L, new Color(5L, "blue"));
		COLORS.put(6L, new Color(6L, "purple"));
		COLORS.put(7L, new Color(7L, "pink"));
		COLORS.put(8L, new Color(8L, "white"));
		COLORS.put(9L, new Color(9L, "brown"));
		COLORS.put(10L, new Color(10L, "black"));
	}
	
	public Color read(long id) {
		return COLORS.get(id);
	}
	
	public List<Color> findAll() {
		return new ArrayList<>(COLORS.values());
	}
}
