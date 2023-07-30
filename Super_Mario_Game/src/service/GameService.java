package service;

import model.*;
import service.interfaces.ILoad;

import java.util.List;
import java.util.Scanner;

public class GameService {
	ILoad load = new LoadService();
	MapService mapService = new MapService();
	Scanner scn = new Scanner(System.in);

	public void startGame() {

		List<Villain> villains = load.loadVillains();
		List<Collectible> collectibles = load.loadCollectibles();
		Map map = load.loadMap();
		MarioBaseCharacter mario = load.loadMario();
		MarioBaseCharacter luigi = load.loadLuigi();

		mapService.putCollectiblesToMap(collectibles, map);
		mapService.putVillainsToMap(villains, map);
		mapService.putMarioToMap(mario, map);
		System.out.println("Game started");
		gameLoop(villains, map, mario, luigi);
	}

	public void gameLoop(List<Villain> villains, Map map, MarioBaseCharacter mario, MarioBaseCharacter luigi) {
		int status = 1;
		while (status > 0) {
			mapService.printMap(map);
			System.out.println("Press a to move left and d to move right \n" +
					"Press w to jump forward \n" +
					"Press e to jump backward \n" +
					"Press f to send fireball \n" +
					"Press q to quit");
			String input = scn.nextLine();
			if (input.equals("q")) {
				System.out.println("Game ended");
				break;
			} else if (input.equals("a")) {
				status = playerMovement(map, mario, "left");
			} else if (input.equals("d")) {
				status = playerMovement(map, mario, "right");
			} else if (input.equals("w")) {
				status = playerMovement(map, mario, "jumpF");
			} else if (input.equals("e")) {
				status = playerMovement(map, mario, "jumpB");
			} else if (input.equals("f")) {
				sendFireBall(map, mario);
			} else {
				System.out.println("Invalid input");
			}
			status = checkGameStatus(map, mario, status);
		}
	}

	public void sendFireBall(Map map, MarioBaseCharacter mario) {
		if (mario.getGrowthCycle() == GrowthCycleEnum.BIG && mario.isHasFireFlower()) {
			System.out.println("Fireball sent");
			if (map.getMapCoordinates()[mario.getCoordinate().getyAxis()][mario.getCoordinate().getxAxis() + 1] instanceof Villain) {
				System.out.println("You killed " + (map.getMapCoordinates()[mario.getCoordinate().getyAxis()][mario.getCoordinate().getxAxis() + 1]).getName());
				map.getMapCoordinates()[mario.getCoordinate().getyAxis()][mario.getCoordinate().getxAxis() + 1] = null;
			} else {
				System.out.println("There is nothing to kill");
			}
		} else {
			System.out.println("You don't have Fire Flower upgrade. You can not send fireball");
		}
	}

	public int getDamageOnVillain(MarioBaseCharacter mario, Villain character) {
		if (mario.getGrowthCycle() == GrowthCycleEnum.MEDIUM) {
			mario.setGrowthCycle(GrowthCycleEnum.LITTLE);
			System.out.println("You hit an enemy. You are now little size");
			return 1;
		} else if (mario.getGrowthCycle() == GrowthCycleEnum.BIG) {
			mario.setGrowthCycle(GrowthCycleEnum.MEDIUM);
			System.out.println("You hit an enemy. You are now medium size");
			return 1;
		}
		if (mario.getGrowthCycle() == GrowthCycleEnum.LITTLE) {
			if (mario.getLifeCount() > 0) {
				mario.setLifeCount(mario.getLifeCount() - 1);
				System.out.println("You lost a life");
				return 1;
			} else {
				System.out.println("You are dead. Game over");
				System.exit(0);
			}
		}
		return 0;
	}

	public void getCollectible(MarioBaseCharacter mario, Collectible collectible) {
		if (collectible.getCollectibleType() == CollectibleTypeEnum.COIN) {
			mario.setCollectedCoins(mario.getCollectedCoins() + 1);
			System.out.println("You got a coin");
		} else if (collectible.getCollectibleType() == CollectibleTypeEnum.MUSHROOM) {
			if (mario.getGrowthCycle() == GrowthCycleEnum.LITTLE) {
				mario.setGrowthCycle(GrowthCycleEnum.MEDIUM);
				System.out.println("You got a mushroom. You grow up to medium size now");
			} else if (mario.getGrowthCycle() == GrowthCycleEnum.MEDIUM) {
				mario.setGrowthCycle(GrowthCycleEnum.BIG);
				System.out.println("You got a mushroom. You grow up to big size now");
			}
		} else if (collectible.getCollectibleType() == CollectibleTypeEnum.FIRE_FLOWER) {
			if (mario.getGrowthCycle() == GrowthCycleEnum.MEDIUM || mario.getGrowthCycle() == GrowthCycleEnum.LITTLE) {
				System.out.println("You got a flower but you can't fire enemies with fireball. You need to be big size to get this upgrade");
			} else if (mario.getGrowthCycle() == GrowthCycleEnum.BIG) {
				mario.setHasFireFlower(true);
				System.out.println("You got a flower, you can fire enemies with fireball");
			}
		}
	}

	public int playerMovement(Map map, MarioBaseCharacter mario, String direction) {
		int playerX = mario.getCoordinate().getxAxis();
		int playerY = mario.getCoordinate().getyAxis();
		int status = 1, i = 0;
		if (!(mapService.checkMapBorder(map, playerX, playerY, direction))) {
			System.out.println("You can't move out of the map");
			return status;
		}
		if (direction.equals("left")) {
			if (map.getMapCoordinates()[playerY][playerX - 1] == null) {
				map.getMapCoordinates()[playerY][playerX - 1] = mario;
				map.getMapCoordinates()[playerY][playerX] = null;
				mario.getCoordinate().setxAxis(playerX - 1);
			} else {
				i = mapService.checkMap(map, playerX - 1, playerY);
				if (i == 1) {
					status = getDamageOnVillain(mario, (Villain) map.getMapCoordinates()[playerY][playerX - 1]);
					if (status == 1) {
						map.getMapCoordinates()[playerY][playerX - 1] = mario;
						map.getMapCoordinates()[playerY][playerX] = null;
						mario.getCoordinate().setxAxis(playerX - 1);
					}
				}
				if (i == 2) {
					getCollectible(mario, (Collectible) map.getMapCoordinates()[playerY][playerX - 1]);
					map.getMapCoordinates()[playerY][playerX - 1] = mario;
					map.getMapCoordinates()[playerY][playerX] = null;
					mario.getCoordinate().setxAxis(playerX - 1);
				}
			}
		} else if (direction.equals("right")) {
			if (map.getMapCoordinates()[playerY][playerX + 1] == null) {
				map.getMapCoordinates()[playerY][playerX + 1] = mario;
				map.getMapCoordinates()[playerY][playerX] = null;
				mario.getCoordinate().setxAxis(playerX + 1);
			} else {
				i = mapService.checkMap(map, playerX + 1, playerY);
				if (i == 1) {
					status = getDamageOnVillain(mario, (Villain) map.getMapCoordinates()[playerY][playerX + 1]);
					if (status == 1) {
						map.getMapCoordinates()[playerY][playerX + 1] = mario;
						map.getMapCoordinates()[playerY][playerX] = null;
						mario.getCoordinate().setxAxis(playerX + 1);
					}
				}
				if (i == 2) {
					getCollectible(mario, (Collectible) map.getMapCoordinates()[playerY][playerX + 1]);
					map.getMapCoordinates()[playerY][playerX + 1] = mario;
					map.getMapCoordinates()[playerY][playerX] = null;
					mario.getCoordinate().setxAxis(playerX + 1);
				}
			}
		} else if (direction.equals("jumpF")) {
			if (map.getMapCoordinates()[playerY - 1][playerX + 1] == null
					&& map.getMapCoordinates()[playerY][playerX + 2] == null) {
				map.getMapCoordinates()[playerY][playerX + 2] = mario;
				map.getMapCoordinates()[playerY][playerX] = null;
				mario.getCoordinate().setxAxis(playerX + 2);
				status = 1;
			} else if (map.getMapCoordinates()[playerY - 1][playerX + 1] == null) {
				i = mapService.checkMap(map, playerX + 2, playerY);
				if (i == 1) {
					map.getMapCoordinates()[playerY][playerX + 2] = mario;
					map.getMapCoordinates()[playerY][playerX] = null;
					mario.getCoordinate().setxAxis(playerX + 2);
				}
				if (i == 2) {
					getCollectible(mario, (Collectible) map.getMapCoordinates()[playerY][playerX + 2]);
					map.getMapCoordinates()[playerY][playerX + 2] = mario;
					map.getMapCoordinates()[playerY][playerX] = null;
					mario.getCoordinate().setxAxis(playerX + 2);
				}
			}
		} else if (direction.equals("jumpB")) {
			if (map.getMapCoordinates()[playerY - 1][playerX - 1] == null
					&& map.getMapCoordinates()[playerY][playerX - 2] == null) {
				map.getMapCoordinates()[playerY][playerX - 2] = mario;
				map.getMapCoordinates()[playerY][playerX] = null;
				mario.getCoordinate().setxAxis(playerX - 2);
				status = 1;
			} else if (map.getMapCoordinates()[playerY - 1][playerX - 1] == null) {
				i = mapService.checkMap(map, playerX - 2, playerY);
				if (i == 1) {
					map.getMapCoordinates()[playerY][playerX - 2] = mario;
					map.getMapCoordinates()[playerY][playerX] = null;
					mario.getCoordinate().setxAxis(playerX - 2);
				}
				if (i == 2) {
					getCollectible(mario, (Collectible) map.getMapCoordinates()[playerY][playerX - 2]);
					map.getMapCoordinates()[playerY][playerX - 2] = mario;
					map.getMapCoordinates()[playerY][playerX] = null;
					mario.getCoordinate().setxAxis(playerX - 2);
				}
			}
		}
		return status;
	}

	public int checkGameStatus(Map map, MarioBaseCharacter mario, int status) {
		if (mario.getCollectedCoins() == map.getCoinCount()) {
			System.out.println("You won");
			System.exit(0);
			status = 0;
		}
		return status;
	}

}
