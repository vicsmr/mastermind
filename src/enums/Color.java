package enums;

public enum Color {
	RED("r"), BLUE("b"), YELLOW("y"), GREEN("g"), ORANGE("o"), PURPLE("p");
	
	private final String COLOR;

	Color(final String color) {
        this.COLOR = color;
    }
	
	public static Color valueOfLabel(String color) {
	    for (Color enumValue : values()) {
	        if (enumValue.COLOR.equals(color)) {
	            return enumValue;
	        }
	    }
	    return null;
	}

    @Override
    public String toString() {
        return COLOR;
    }
}
