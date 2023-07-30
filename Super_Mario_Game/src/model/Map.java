package model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Map {
	private String name;
	private String mapType;
	private int coinCount = 0;
	private int xLenght;
	private int yLenght;
	private BaseCharacter[][] mapCoordinates;

	public Map(String name, String mapType, int xLenght, int yLenght) {
		this.name = name;
		this.mapType = mapType;
		this.xLenght = xLenght;
		this.yLenght = yLenght;
		this.mapCoordinates = new BaseCharacter[yLenght][xLenght];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMapType() {
		return mapType;
	}

	public void setMapType(String mapType) {
		this.mapType = mapType;
	}

	public int getCoinCount() {
		return coinCount;
	}

	public void setCoinCount(int coinCount) {
		this.coinCount = coinCount;
	}

	public int getxLenght() {
		return xLenght;
	}

	public void setxLenght(int xLenght) {
		this.xLenght = xLenght;
	}

	public int getyLenght() {
		return yLenght;
	}

	public void setyLenght(int yLenght) {
		this.yLenght = yLenght;
	}

	public BaseCharacter[][] getMapCoordinates() {
		return mapCoordinates;
	}

	public void setMapCoordinates(BaseCharacter[][] mapCoordinates) {
		this.mapCoordinates = mapCoordinates;
	}

	@Override
	public String toString() {
		return "Map{" +
				"name='" + name + '\'' +
				", mapType='" + mapType + '\'' +
				", xLenght=" + xLenght +
				", yLenght=" + yLenght +
				", mapCoordinates=" + Arrays.toString(mapCoordinates) +
				'}';
	}
}
