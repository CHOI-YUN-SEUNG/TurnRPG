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
	private String mons[] = { "MonsterTest" };
	private Map<String, Class<? extends Monster>> mapMonsters = new HashMap<>();
	// mon 배열은 맵으로 부터 받아오는걸로 변경해야 맵 테마에 맞는 몹을 소환하기 편할것같다
	// 미믹은 그냥 따로 메소드를 만드는게 편할 것 같다
	private Random random = new Random();
	private Player player = new Player();

	private UnitManager() {
		mapMonsters.put("TestMap1", MonsterTest.class);
		mapMonsters.put("TestMap1", TEST2.class);
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
		if (mapMonsters.containsKey(mapName)) {
			Class<? extends Monster> monsterClass = mapMonsters.get(mapName);
			try {
				for (int i = 0; i < size; i++) {
					Monster monster = monsterClass.getDeclaredConstructor().newInstance();
					monster.init(random.nextInt(100) + 100, random.nextInt(10) + 100000);
					mon_list.add(monster);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("해당 맵에 등록된 몬스터 클래스가 없습니다.");
		}
	}

//	// 몬스터 생성 메서드
//	public void monster_rand_set(int size) {
//		for (int i = 0; i < size; i++) {
//			int num = r.nextInt(mons.length);
//			try {
//				Class<?> clazz = Class.forName(pate + mons[num]);
//				Object obj = clazz.getDeclaredConstructor().newInstance();
//				Monster temp = (Monster) obj;
//				int hp = r.nextInt(100) + 100;
//				int pw = r.nextInt(10) + 100000;
//				temp.init(hp, pw);
//				mon_list.add(temp);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
}