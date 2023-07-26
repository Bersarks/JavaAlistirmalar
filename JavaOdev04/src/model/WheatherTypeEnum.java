package model;

public enum WheatherTypeEnum {
	RAINY(0), SUNNY(1), WINDY(2), CLOUDY(3);
	private final int value;
	WheatherTypeEnum(int value) {
		this.value = value;
	}
}
