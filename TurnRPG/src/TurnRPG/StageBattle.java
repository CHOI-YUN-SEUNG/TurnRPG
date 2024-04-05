package TurnRPG;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage {
	private UnitManager unitManager = UnitManager.instance;
	private Vector<Monster> monList = null;
	private Random rNum = new Random();
	private int monDead = 0;
	private int playerDead = 0;

	@Override
	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;
		int count = 0;

		while (run) {
			if (turn) {
				print_character();
				if (p_index < Player.getPartySize()) {
					player_attack(p_index, count);
					System.out.println(count);
					p_index += 1;
				} else {
					turn = !turn;
					p_index = 0;
					count++;
				}
			} else if (!turn) {
				if (m_index < monList.size()) {
					monster_attack(m_index);
					m_index += 1;
				} else {
					turn = !turn;
					m_index = 0;
				}
			}

			check_live();
			if (playerDead <= 0) {
				System.out.println("탐사가 불가능하다. 강해져서 돌아오자");
				while (true) {
					if (p_index < Player.getPartySize()) {
						int now = Player.getGuildUnit(p_index).getAtt(); //디버프를 줘야하는데 뭐로하지
						Player.getGuildUnit(p_index).setAtt(now - 1000);
						Player.getGuildUnit(p_index).setHp(Player.getGuildUnit(p_index).getMaxHp());//풀피로 힐해주고
						p_index++;
					} else
						break;
				}
				break;
			}

			if (monDead <= 0) {
				p_index = 0;
				System.out.println("던전 클리어~");
				while (true) {
					if (p_index < Player.getPartySize()) {
						int now = Player.getGuildUnit(p_index).getAtt(); // 경험치로 바꿔야함
						Player.getGuildUnit(p_index).setAtt(now + 1000);
						p_index++;
					} else
						break;
				}
				break;
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
		unitManager.getMon_list().clear();
		unitManager.monster_rand_set(4);
		monList = unitManager.getMon_list();
		monDead = monList.size();
		playerDead = Player.getPartySize();
	}

	private void print_character() {
		System.out.println("======[BATTLE]======");
		System.out.println(playerDead + " : " + monDead);
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < Player.getPartySize(); i++) {
			Player.getGuildList().get(i).printData();
		}
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < monList.size(); i++) {
			monList.get(i).printData();
		}
	}

	private void player_attack(int index, int count) {
		Player p = Player.getGuildList().get(index);

		if (p.getHp() <= 0)
			return;

		System.out.println("======[메뉴 선택]=====");
		int sel = -1;
		while (!(sel > 0 && sel < 3))
			sel = GameManager.inputNumber("[" + p.getName() + "] [1.어택] [2.스킬]");

		if (sel == 1) {
			while (true) {
				int idx = rNum.nextInt(monList.size());
				if (monList.get(idx).getCurhp() > 0) {
					p.attack(monList.get(idx));
					break;
				}
			}
		} else if (sel == 2) {
			while (true) {
				int idx = rNum.nextInt(monList.size());
				if (monList.get(idx).getCurhp() > 0) {
					// int skillsel = GameManager.inputIndex("사용할 스킬을 선택하십시오.");
					// 스킬 창 출력 메소드
					// p.skill(skillsel,monList.get(idx),count);
					System.out.println("아직 미구현입니다");
					break;
				}
			}
		}
	}

	private void monster_attack(int index) {
		Monster m = monList.get(index);
		if (m.getCurhp() <= 0)
			return;
		while (true) {
			int idx = rNum.nextInt(Player.getPartySize());
			if (Player.getGuildUnit(idx).getHp() > 0) {
				m.attack(Player.getGuildUnit(idx));
				break;
			}
		}
	}

	public int getPlayerDead() {
		return playerDead;
	}

	private void check_live() {
		int num = 0;
		for (int i = 0; i < Player.getPartySize(); i++) {
			if (Player.getGuildUnit(i).getHp() <= 0) {
				num += 1;
			}
		}
		playerDead = Player.getPartySize() - num;

		num = 0;
		for (int i = 0; i < monList.size(); i++) {
			if (monList.get(i).getCurhp() <= 0) {
				num += 1;
			}
		}
		monDead = monList.size() - num;
	}
}