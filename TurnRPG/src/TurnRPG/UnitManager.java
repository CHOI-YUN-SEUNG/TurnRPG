package TurnRPG;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

public class UnitManager {
	static UnitManager instance = new UnitManager();
	private Vector<Player> player_list = new Vector<Player>();
	private Vector<Monster> mon_list = new Vector<>();
	private String pate = "TurnRPG.";
	private Random random = new Random();
	private Player player = new Player();

	private UnitManager() {
	}

	public void init() {
		player.init();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Vector<Player> getPlayer_list() {
		return player_list;
	}

	public void setPlayer_list(Vector<Player> player_list) {
		this.player_list = player_list;
	}

	public Vector<Monster> getMon_list() {
		return mon_list;
	}

	public void setMon_list(Vector<Monster> mon_list) {
		this.mon_list = mon_list;
	}

	public void spawnMonsters(String mapName, int size) {
		try {
			Class<?> mapClass = Class.forName(pate + mapName);
			GameMap map = (GameMap) mapClass.getDeclaredConstructor(String.class, boolean.class).newInstance(mapName,
					true);
			String[] mapMonsters = map.getMons();
			for (int i = 0; i < size; i++) {
				int num = random.nextInt(mapMonsters.length);
				Class<?> clazz = Class.forName(pate + mapMonsters[num]);
				Monster monster = (Monster) clazz.getDeclaredConstructor().newInstance();
				monster.init(random.nextInt(100) + 100, random.nextInt(10) + 100000);
				mon_list.add(monster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}