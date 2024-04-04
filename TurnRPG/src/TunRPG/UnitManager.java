package TunRPG;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	static UnitManager instance = new UnitManager();

	Vector<Player> player_list = new Vector<Player>();
	Vector<Monster> mon_list = new Vector<>();
	String pate = "TunRPG.";
	String mons[] = { "MonsterTest" }; 
	//mon 배열은 맵으로 부터 받아오는걸로 변경해야 맵 테마에 맞는 몹을 소환하기 편할것같다
	//미믹은 그냥 따로 메소드를 만드는게 편할 것 같다
	Random r = new Random();
	Player player = new Player();

	void init() {
		player.init();
	}

	// 몬스터 생성 메서드
	void monster_rand_set(int size) {
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