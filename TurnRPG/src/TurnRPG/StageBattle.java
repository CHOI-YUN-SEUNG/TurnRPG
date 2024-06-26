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
				if (p_index < Player.getPartySize()) {
					print_character();
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
						int now = Player.getGuildUnit(p_index).getAtt(); // 디버프를 줘야하는데 뭐로하지
						Player.getGuildUnit(p_index).setAtt(now - 1000);
						Player.getGuildUnit(p_index).setHp(Player.getGuildUnit(p_index).getMaxHp());// 풀피로 힐해주고
						p_index++;
					} else
						break;
				}
				break;
			}

			if (monDead <= 0) {
				p_index = 0;
				System.out.println("던전 클리어~");
				
				
				//몹을 다 잡았을 때 던전 방문 정보를 갱신하고...
				// 다음 맵을 여는 조건을 어떻게하지 .....
				while (true) {
					if (p_index < Player.getPartySize()) {
						int now = Player.getPartyUnit(p_index).getExp(); 
						Player.getPartyUnit(p_index).setExp(100);
						Player.getPartyUnit(p_index).checkExp();
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
		unitManager.spawnMonsters(StageMap.getSelectedMap().getClazzName(), rNum.nextInt(3)+3);
		monList = unitManager.getMon_list();
		monDead = monList.size();
		playerDead = Player.getPartySize();
	}

	private void print_character() {
		System.out.println("======[BATTLE]======");
		System.out.println(playerDead + " : " + monDead);
		System.out.println("현재 맵: " + StageMap.getSelectedMap().getName() + "/" + StageMap.getSelectedSubmap());
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < Player.getPartySize(); i++) {
			Player.getPartyUnit(i).printData();
		}
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < monList.size(); i++) {
			monList.get(i).printData();
		}
	}

	private void player_attack(int index, int count) {
		Player p = Player.getPartyUnit(index);

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
					p.skill(monList.get(idx));
					// int skil lsel = GameManager.inputIndex("사용할 스킬을 선택하십시오."); //스킬이 여러개인 친구들을
					// 만들면
					// 스킬 메소드 내에 추가하는게 더 나을듯
					// 턴 값도 보내 줘야 턴을 이용해 나누기를 하고 스킬 쿨을 조정 할듯,
					// p.skill(skillsel,monList.get(idx),count);
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