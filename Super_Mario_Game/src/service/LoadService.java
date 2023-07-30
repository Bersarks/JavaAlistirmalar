package service;

import model.*;
import service.interfaces.ILoad;

import java.util.ArrayList;
import java.util.List;

public class LoadService implements ILoad {

	@Override
	public List<Villain> loadVillains() {
		List<Villain> villains = new ArrayList<Villain>();
		Villain reptile = new Reptile("Reptile", true, 100, MoveTypeEnum.WALK, new Coordinate(0, 2));
		Villain fireChain = new FireChain("Fire Chain", true, 100, MoveTypeEnum.STATIONARY, new Coordinate(0, 2));
		Villain flyingTurtle = new FlyingTurtle("Flyin Turtle", true, 100, MoveTypeEnum.FLY, new Coordinate(0, 2));
		Villain turtle = new Turtle("Turtle", true, 100, MoveTypeEnum.FLY, new Coordinate(0, 2));
		villains.add(reptile);
		villains.add(fireChain);
		villains.add(flyingTurtle);
		villains.add(turtle);
		return villains;
	}

	@Override
	public List<Collectible> loadCollectibles() {
		List<Collectible> collectibles = new ArrayList<Collectible>();
		Collectible mushroom = new Mushroom("Mushroom", CollectibleTypeEnum.MUSHROOM, new Coordinate(0, 2));
		Collectible fireFlower = new FireFlower("Fire Flower", CollectibleTypeEnum.FIRE_FLOWER, new Coordinate(0, 2));
		Collectible coin = new Coin("Coin", CollectibleTypeEnum.COIN, new Coordinate(0, 2));
		collectibles.add(mushroom);
		collectibles.add(fireFlower);
		collectibles.add(coin);
		return collectibles;
	}

	@Override
	public MarioBaseCharacter loadMario() {
		return new Mario("Mario", 3, GrowthCycleEnum.LITTLE, new Coordinate(0, 2));
	}

	@Override
	public MarioBaseCharacter loadLuigi() {
		return new Luigi("Luigi", 3, GrowthCycleEnum.LITTLE, new Coordinate(0, 2));
	}

	@Override
	public Map loadMap() {
		return new AmazonMap("Amazonia", "Jungle", 20, 3);
	}
}
