package TurnRPG;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class Guild {
	private final int PARTY_SIZE = 3;
	private Vector<Player> guildList = new Vector<>();
	private Random r = new Random();
	private Unit[] partyList;

	public Vector<Player> getGuildList() {
		return guildList;
	}

	// 길드원 설정 메서드
	public void setGuild() {
		guildList.add(new Player("전사", 5, 1000, 45, 5, 0));
		guildList.add(new Player("마법사", 8, 800, 60, 5, 0));
		guildList.add(new Player("힐러", 3, 500, 70, 5, 0));

		// 파티 참여 여부
		for (int i = 0; i < PARTY_SIZE; i++) {
			guildList.get(i).setParty(true);
		}

		partyList = new Unit[PARTY_SIZE];

		// 길드원의 파티 참가 유무가 참이면 파티 추가
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).isParty() == true) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}
	}

	// 해당 길드원 가져오기 메서드
	public Player getGuildUnit(int num) {
		return guildList.get(num);
	}

	// 모든 길드원 능력치 출력 메서드
	public void printAllUnitStaus() {
		System.out.println("======================================");
		System.out.println("[골드 : " + Player.money + "]");
		System.out.println("============= [길드원] =================");
		for (int i = 0; i < guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + guildList.get(i).getName() + "]");
			System.out.print(" [레벨 : " + guildList.get(i).getLevel() + "]");
			System.out.print(" [체력 : " + guildList.get(i).hashCode());
			System.out.println(" / " + guildList.get(i).getMaxHp() + "]");
			System.out.print("[공격력 : " + guildList.get(i).getAtt() + "]");
			System.out.print(" [방어력 : " + guildList.get(i).getDef() + "]");
			System.out.println(" [파티중 : " + guildList.get(i).isParty() + "]");
			System.out.println();
		}
		System.out.println("======================================");
	}

	// 해당 길드원 능력치 출력 메서드
	public void printUnitStaus(int selUnit) {
		guildList.get(selUnit).printStatus();
	}

	// 해당 길드원 아이템 출력 메서드
	public void printUnitItem(int selUnit) {
		guildList.get(selUnit).printEquitedItem();
	}

	// 길드 메뉴 메서드
	public void guildMenu() {
		while (true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println("[1.길드 목록]\t\t[2.길드원 추가]\t\t[3.길드원 삭제]");
			System.out.println("[4.파티원 교체]\t\t[5.정렬]\t\t\t[0.뒤로가기]");
			int sel = GameManager.scanner.nextInt();
			if (sel == 1) {
				printAllUnitStaus();
			} else if (sel == 2) {
				buyUnit();
			} else if (sel == 3) {
				removeUnit();
			} else if (sel == 4) {
				partyChange();
			} else if (sel == 5) {
				unitSort();
			} else if (sel == 0) {
				break;
			}
		}
	}

	public void buyUnit() {
		// 플레이어 소지금이 5000골드 이하면 길드원 추가 불가
		if (Player.money < 5000)
			return;
		String[] n1 = { "박", "이", "김", "최", "유", "지", "오" };
		String[] n2 = { "명", "기", "종", "민", "재", "석", "광" };
		String[] n3 = { "수", "자", "민", "수", "석", "민", "철" };

		// 랜덤 이름 정하기
		String name = n1[r.nextInt(n1.length)];
		name += n2[r.nextInt(n2.length)];
		name += n3[r.nextInt(n3.length)];

		// 랜덤 능력값 정하기
		int rNum = r.nextInt(8) + 2; // 2~10까지
		int hp = rNum * 11;
		int att = rNum + 1;
		int def = rNum / 2 + 1;

		// 길드원 추가하기
		Player temp = new Player(name, 1, hp, att, def, 0);
		System.out.println("=====================================");
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + 1 + "]");
		System.out.print(" [체력 : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[공격력 : " + att + "]");
		System.out.println(" [방어력 : " + def + "]");
		System.out.println("길드원을 추가합니다.");
		System.out.println("=====================================");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		guildList.add(temp);
		Player.money -= 5000;

	}

	public void removeUnit() {
		printAllUnitStaus();
		System.out.println("삭제할 번호를 입력하세요 ");
		int sel = GameManager.scanner.nextInt() - 1;

		// 파티중인 길드원은 삭제 불가
		if (guildList.get(sel).isParty()) {
			System.out.println("파티중인 멤버는 삭제할수 없습니다.");
		} else {
			System.out.println("=================================");
			System.out.print("[이름 : " + guildList.get(sel).getName() + "]");
			System.out.println("길드원을 삭제합니다.");
			System.out.println("=================================");
			guildList.remove(sel);
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 파티원 출력 메서드
	public void printParty() {
		System.out.println("================ [파티원] ===============");
		for (int i = 0; i < PARTY_SIZE; i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + partyList[i].getName() + "]");
			System.out.print(" [레벨 : " + partyList[i].getLevel() + "]");
			System.out.print(" [체력 : " + partyList[i].getHp());
			System.out.println(" / " + partyList[i].getMaxHp() + "]");
			System.out.print("[공격력 : " + partyList[i].getAtt() + "]");
			System.out.print(" [방어력 : " + partyList[i].getDef() + "]");
			System.out.println(" [파티중 : " + guildList.get(i).isParty() + "]");
			System.out.println();
		}
		System.out.println("=====================================");
	}

	// 레벨 기준 정렬 메서드
	public void unitSort() {
		for (int i = 0; i < guildList.size(); i++) {
			Player temp = guildList.get(i);
			int index = i;
			for (int j = i; j < guildList.size(); j++) {
				if (temp.getLevel() < guildList.get(j).getLevel()) {
					temp = guildList.get(j);
					index = j;
				}
			}
			Player temp2 = guildList.get(index);
			guildList.set(index, guildList.get(i));
			guildList.set(i, temp2);
		}
		printAllUnitStaus();
	}

	// 파티원 교체 메서드
	public void partyChange() {
		printParty();
		System.out.println("교체할 번호를 입력하세요 ");
		int partyNum = GameManager.scanner.nextInt() - 1;

		// 길드원 능력값 출력
		printAllUnitStaus();
		System.out.println("참가할 번호를 입력하세요 ");
		int guildNum = GameManager.scanner.nextInt() - 1;

		// 교체 당한 파티원
		partyList[partyNum].setParty(false);

		// 교체된 파티원
		guildList.get(guildNum).setParty(true);

		System.out.println("====================================");
		System.out.print("[이름 : " + partyList[partyNum].getName() + "]");
		System.out.print("에서 [이름 : " + guildList.get(guildNum).getName() + "]");
		System.out.println("으로 교체 합니다. ");
		System.out.println("====================================");

		// 파티 재정의
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).isParty()) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}