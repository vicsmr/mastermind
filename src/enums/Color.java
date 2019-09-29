package enums;

public enum Color {
	RED("r"), BLUE("b"), YELLOW("y"), GREEN("g"), ORANGE("o"), PURPLE("p");
	
	private final String color;

	Color(final String color) {
        this.color = color;
    }
	
	public static Color valueOfLabel(String color) {
	    for (Color enumValue : values()) {
	        if (enumValue.color.equals(color)) {
	            return enumValue;
	        }
	    }
	    return null;
	}

    @Override
    public String toString() {
        return color;
    }
}
