package model.types;

public enum Rarity {

	Common(5, "grey"), Uncommon(10, "green"), Rare(15, "blue"), Epic(25,
			"violet"), Legendary(50, "gold");

	private final int value;
	private final String color;

	private Rarity(int value, String color) {
		this.value = value;
		this.color = color;
	}

	public int getValue() {
		return value;
	}

	public String getColor() {
		return color;
	}

}
