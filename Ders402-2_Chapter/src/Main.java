import model.*;
import service.LoadService;
import service.MapService;
import service.interfaces.ILoad;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		ILoad load = new LoadService();
		MapService mapService = new MapService();
		List<Villain> villains = load.loadVillains();
		Map map = load.loadMap();
		MarioBaseCharacter mario = load.loadMario();
		MarioBaseCharacter luigi = load.loadLuigi();
		mapService.putVillainsToMap(villains, map);
		mapService.printMap(map);


		System.out.println(map);
		System.out.println(mario);
		System.out.println(luigi);
		System.out.println(villains);
	}
}