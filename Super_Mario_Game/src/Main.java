import model.*;
import service.GameService;
import service.LoadService;
import service.MapService;
import service.interfaces.ILoad;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		GameService gameService = new GameService();
		gameService.startGame();
	}
}