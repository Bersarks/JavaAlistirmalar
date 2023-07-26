package service;

import model.BaseCharacter;
import model.Coordinate;
import model.Map;
import model.Villain;
import service.interfaces.IMap;

import java.util.List;

public class MapService implements IMap {

	@Override
	public void putVillainsToMap(List<Villain> villains, Map map) {
		int x = 2;
		for (int i = 0; i < villains.size(); i++) {
			villains.get(i).getCoordinate().setxAxis(villains.get(i).getCoordinate().getxAxis() + x);
			;
			map.getMapCoordinates()[villains.get(i).getCoordinate().getyAxis()][villains.get(i).getCoordinate().getxAxis() + x] = villains.get(i);
			x += 2;
		}
	}

	@Override
	public void printMap(Map map) {
		for (int i = 0; i < map.getMapCoordinates().length; i++) {
			for (int j = 0; j < map.getMapCoordinates()[i].length; j++) {
				if (map.getMapCoordinates()[i][j] == null) {
					System.out.print("0");
				} else {
					System.out.print(map.getMapCoordinates()[i][j].getName());
				}
			}
			System.out.println("");
		}
	}
}
