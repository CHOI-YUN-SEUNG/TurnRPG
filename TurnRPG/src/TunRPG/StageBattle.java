package TunRPG;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage {
	private UnitManager unitManager = UnitManager.instance;
	private Vector<Monster> monList = null;
	private Random ran = new Random();
	private int monDead = 0;
	private int playerDead = 0;

	@Override
	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;

		while (run) {
			if (turn) {
				print_character();
				// 플레이어 수만큼 공격 가능
				if (p_index < Player.getPartySize()) {
					player_attack(p_index);
					p_index += 1;
				} else {
					turn = !turn;
					p_index = 0;
				}
			} else if (!turn) {
				// 몬스터 수만큼 공격 가능
				if (m_index < monList.size()) {
					monster_attack(m_index);
					m_index += 1;
				} else {
					turn = !turn;
					m_index = 0;
				}
			}

			check_live();
			if (monDead <= 0 || playerDead <= 0)
				break;
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {

//		unitManager.mon_list.clear();
//		unitManager.monster_rand_set(4);
//		unitManager.player = null;
//		unitManager.player = new Player();
//		monList = null;
//		monList = um.mon_list;
//		monDead = monList.size();
//		playerDead = Player.getGuildSize();

	}

	void print_character() {
//		System.out.println("======[BATTLE]======");
//		System.out.println(playerDead + " : " + monDead);
//		System.out.println("======[PLAYER]======");
//		for (int i = 0; i < Player.getGuildSize(); i++) {
//			Player.getGuildUnit(i).printData();
//		}
//		System.out.println("======[MONSTER]======");
//		for (int i = 0; i < monList.size(); i++) {
//			monList.get(i).printData();
//		}
	}

	void player_attack(int index) {
//		Player p = Player.getGuildUnit(index);
//
//		if (p.hp <= 0)
//			return;
//
//		System.out.println("======[메뉴 선택]=====");
//		System.out.println("[" + p.name + "] [1.어택] [2.스킬]");
//
//		int sel = GameManager.sc.nextInt();
//		if (sel == 1) {
//			while (true) {
//				// 몬스터들 중 한마리에게 랜덤 공격
//				int idx = r.nextInt(monList.size());
//				if (monList.get(idx).curhp > 0) {
//					p.attack(monList.get(idx));
//					break;
//				}
//			}
//		} else if (sel == 2) {
//
//		}
	}

	void monster_attack(int index) {
//		Monster m = monList.get(index);
//		if (m.curhp <= 0)
//			return;
//		while (true) {
//			int idx = r.nextInt(Player.getGuildSize());
//			if (Player.getGuildUnit(idx).hp > 0) {
//				m.attack(Player.getGuildUnit(idx));
//				break;
//			}
//		}
	}

	void check_live() {
//		int num = 0;
//		for (int i = 0; i < Player.getGuildSize(); i++) {
//			if (Player.getGuildUnit(i).hp <= 0) {
//				num += 1;
//			}
//		}
//		playerDead = Player.getGuildSize() - num;
//
//		num = 0;
//		for (int i = 0; i < monList.size(); i++) {
//			if (monList.get(i).curhp <= 0) {
//				num += 1;
//			}
//		}
//		monDead = monList.size() - num;
	}

}