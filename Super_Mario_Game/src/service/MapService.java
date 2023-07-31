package service;

import model.*;
import service.interfaces.IMap;

import java.util.List;

public class MapService implements IMap {

	@Override
	public void putVillainsToMap(List<Villain> villains, Map map) {
		int x = 2;
		for (int i = 0; i < villains.size(); i++) {
			villains.get(i).getCoordinate().setxAxis(villains.get(i).getCoordinate().getxAxis() + x);
			if (villains.get(i).getCoordinate().getxAxis() + x < map.getxLenght())
				map.getMapCoordinates()[villains.get(i).getCoordinate().getyAxis()][villains.get(i).getCoordinate().getxAxis() + x] = villains.get(i);
			else
				break;
			x += 2;
		}
	}

	public void putCollectiblesToMap(List<Collectible> collectibles, Map map) {
		int x = 1;
		for (int i = 0; i < map.getxLenght(); i++) {
			collectibles.get(2).getCoordinate().setxAxis(collectibles.get(2).getCoordinate().getxAxis() + x);
			if (collectibles.get(2).getCoordinate().getxAxis() + x < map.getxLenght())
			{
				map.getMapCoordinates()[collectibles.get(2).getCoordinate().getyAxis()][collectibles.get(2).getCoordinate().getxAxis() + x] = collectibles.get(2);
				map.setCoinCount(map.getCoinCount() + 1);
			}
			else
				break;;
			x += 2;
		}
		map.getMapCoordinates()[2][3] = collectibles.get(0);
		map.getMapCoordinates()[2][11] = collectibles.get(0);
		map.getMapCoordinates()[2][5] = collectibles.get(1);
	}

	public void putMarioToMap(MarioBaseCharacter mario, Map map) {
		map.getMapCoordinates()[mario.getCoordinate().getyAxis()][mario.getCoordinate().getxAxis()] = mario;
	}

	@Override
	public void printMap(Map map) {
		System.out.println("****************************************************************************");
		for (int i = 0; i < map.getMapCoordinates().length; i++) {
			for (int j = 0; j < map.getMapCoordinates()[i].length; j++) {
				if (map.getMapCoordinates()[i][j] == null) {
					System.out.print("0 ");
				} else {
					System.out.print(map.getMapCoordinates()[i][j].getName() + " ");
				}
			}
			System.out.println("");
		}
		System.out.println("****************************************************************************");
	}

	public int checkMap(Map map, int x, int y){
		if (map.getMapCoordinates()[y][x] == null){
			return 0;
		} else if (map.getMapCoordinates()[y][x] instanceof Villain){
			return 1;
		} else if (map.getMapCoordinates()[y][x] instanceof Collectible){
			return 2;
		} else {
			return 3;
		}
	}

	public boolean checkMapBorder(Map map, int x, int y, String direction){
		if (direction.equals("right")){
			if (x + 1 < map.getxLenght()){
				return true;
			} else {
				return false;
			}
		} else if (direction.equals("left")){
			if (x - 1 >= 0){
				return true;
			} else {
				return false;
			}
		} else if (direction.equals("jumpB")){
			if (x - 2 >= 0){
				return true;
			} else {
				return false;
			}
		} else if (direction.equals("jumpF")){
			if (x + 2 < map.getxLenght()){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
