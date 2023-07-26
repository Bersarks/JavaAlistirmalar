package service;

import model.*;
import service.interfaces.ILoad;

import java.util.ArrayList;
import java.util.List;

public class LoadService implements ILoad {

	@Override
	public List<Villain> loadVillains() {
		List<Villain> villains = new ArrayList<Villain>();
		Villain reptile = new Reptile("Reptile", 10, true, 100, MoveTypeEnum.WALK, new Coordinate(0, 0));
		Villain fireChain = new FireChain("Fire Chain", 10, true, 100, MoveTypeEnum.STATIONARY, new Coordinate(0, 0));
		Villain flyinTurtle = new FlyingTurtle("Flyin Turtle", 10, true, 100, MoveTypeEnum.FLY, new Coordinate(0, 0));
		Villain turtle = new Turtle("Turtle", 10, true, 100, MoveTypeEnum.FLY, new Coordinate(0, 0));
		villains.add(reptile);
		villains.add(fireChain);
		villains.add(flyinTurtle);
		villains.add(turtle);
		return villains;
	}

	@Override
	public MarioBaseCharacter loadMario() {
		return new Mario("Mario", 100, 3, GrowthCycleEnum.LITTLE, 1, false, new Coordinate(0, 0));
	}

	@Override
	public MarioBaseCharacter loadLuigi() {
		return new Luigi("Luigi", 100, 3, GrowthCycleEnum.LITTLE, 1, false, new Coordinate(0, 0));
	}

	@Override
	public Map loadMap() {
		return new AmazonMap("Amazonia", "Jungle", 20, 10);
	}
}
