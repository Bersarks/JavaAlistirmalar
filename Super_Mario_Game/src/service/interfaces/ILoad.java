package service.interfaces;

import model.*;

import java.util.List;

public interface ILoad {
	public List<Villain> loadVillains();
	public List<Collectible> loadCollectibles();
	public MarioBaseCharacter loadMario();
	public MarioBaseCharacter loadLuigi();
	public Map loadMap();
}
