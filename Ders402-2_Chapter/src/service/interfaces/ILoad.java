package service.interfaces;

import model.Map;
import model.Mario;
import model.MarioBaseCharacter;
import model.Villain;

import java.util.List;

public interface ILoad {
	public List<Villain> loadVillains();
	public MarioBaseCharacter loadMario();
	public MarioBaseCharacter loadLuigi();
	public Map loadMap();
}
