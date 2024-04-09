package TurnRPG;

import java.util.HashMap;
import java.util.Map;

public class MapManager {
	static MapManager instance = new MapManager();
	private Map<String, GameMap> maps = new HashMap<>();

	private MapManager() {
		// 맵 생성 및 등록
		maps.put("TestMap", new TestMap1("고블린 부락", true));
		// 다른 맵들도 필요에 따라 등록 가능
	}

	public static MapManager getInstance() {
		return instance;
	}

	public GameMap getMap(String mapName) {
		return maps.get(mapName);
	}

	public boolean isMapVisited(String mapName) {
		GameMap map = maps.get(mapName);
		return map != null && map.isVisitable();
	}

	public boolean isMapCleared(String mapName) {
		GameMap map = maps.get(mapName);
		return map != null && map.allSubMapExplored();
	}
}