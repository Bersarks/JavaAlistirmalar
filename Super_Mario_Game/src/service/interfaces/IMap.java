package service.interfaces;

import model.Map;
import model.Villain;

import java.util.List;

public interface IMap {
	public void putVillainsToMap(List<Villain> villains, Map map);
	public void printMap(Map map);
}
