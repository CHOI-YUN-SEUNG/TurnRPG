package TurnRPG;

public class MapManager {
	static MapManager instance = new MapManager();
	
	private MapManager() {
	

	}

	public static MapManager getInstance() {
		return instance;
	}	
}