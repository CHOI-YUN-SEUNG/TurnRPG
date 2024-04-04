package TunRPG;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	static UnitManager instance = new UnitManager();
	private Vector<Player> player_list = new Vector<Player>();
	private	Vector<Monster> mon_list = new Vector<>();
	private String pate = "TunRPG.";
	private String mons[] = { "MonsterTest" }; 
	//mon 배열은 맵으로 부터 받아오는걸로 변경해야 맵 테마에 맞는 몹을 소환하기 편할것같다
	//미믹은 그냥 따로 메소드를 만드는게 편할 것 같다
	private Random r = new Random();
	private Player player = new Player();

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

	// 몬스터 생성 메서드
	public void monster_rand_set(int size) {
		for (int i = 0; i < size; i++) {
			int num = r.nextInt(mons.length);
			try {
				Class<?> clazz = Class.forName(pate + mons[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Monster temp = (Monster) obj;
				int hp = r.nextInt(100) + 100;
				int pw = r.nextInt(10) + 10;
				temp.init(hp, pw);
				mon_list.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}