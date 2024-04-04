package TunRPG;

import java.util.ArrayList;

public class Inventory {

	ArrayList<Item> itemList = new ArrayList<>();

	// 인벤토리 메뉴 메서드
	public void inventoryMenu() {
		while (true) {
			System.out.println("============ [인벤토리 메뉴] =============");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int sel = GameManager.scanner.nextInt();
			if (sel == 0)
				break;
			if (sel == 1) {
				equipMenu();
			}
			if (sel == 2) {
				sellMenu();
			}
		}
	}

	// 장비 착용 메서드
	public void equipMenu() {
		// 길드원 능력값 출력
		Player.guild.printAllUnitStaus();
		System.out.println("아이템 착용할 길드원을 선택하세요 ");
		int selUnit = GameManager.scanner.nextInt() - 1;
		while (true) {
			Player.guild.printUnitStaus(selUnit);
			Player.guild.printUnitItem(selUnit);
			printItemList();

			System.out.println("착용할 아이템 번호를 입력하세요 [0.뒤로가기]");
			int selEquip = GameManager.scanner.nextInt();
			if (selEquip == 0)
				break;
			selEquip -= 1;

			// 입력한 아이템의 종류가 무기면
			if (itemList.get(selEquip).kind == Item.WEAPON) {
				// 길드원에게 무기가 없으면 아이템리스트에 추가 후 무기 착용
				if (Player.getGuildUnit(selUnit).weapon != null) {
					itemList.add(Player.getGuildUnit(selUnit).weapon);
				}
				Player.getGuildUnit(selUnit).weapon = itemList.get(selEquip);
			} // 입력한 아이템의 종류가 갑옷이면
			else if (itemList.get(selEquip).kind == Item.ARMOR) {
				// 길드원에게 무기가 없으면 아이템리스트에 추가 후 무기 착용
				if (Player.getGuildUnit(selUnit).armor != null) {
					itemList.add(Player.getGuildUnit(selUnit).armor);
				}
				Player.getGuildUnit(selUnit).armor = itemList.get(selEquip);
			} // 입력한 아이템의 종류가 반지면
			else if (itemList.get(selEquip).kind == Item.RING) {
				// 길드원에게 무기가 없으면 아이템리스트에 추가 후 무기 착용
				if (Player.getGuildUnit(selUnit).ring != null) {
					itemList.add(Player.getGuildUnit(selUnit).ring);
				}
				Player.getGuildUnit(selUnit).ring = itemList.get(selEquip);
			}
			// 착용된 아이템은 아이템 리스트에서 삭제
			itemList.remove(selEquip);
		}
	}

	// 아이템리스트 출력 메서드
	public void printItemList() {
		System.out.println("============ [아이템리스트] ==============");
		// 총 아이템 출력
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print("[" + (i + 1) + "번] ");
			System.out.print("[이름 : " + itemList.get(i).name + "] ");
			System.out.print("[능력 : " + itemList.get(i).power + "] ");
			System.out.print("[가격 : " + itemList.get(i).price + "] ");
			System.out.println();
		}
	}

	// 아이템 판매 메서드
	public void sellMenu() {
		while (true) {
			printItemList();
			System.out.println("[골드 : " + Player.money + "]");
			System.out.println("판매할 아이템 번호를 입력하세요. (50% 세금) [0.뒤로가기]");
			int selSell = GameManager.scanner.nextInt() - 1;
			if (selSell == -1)
				break;
			System.out.println(itemList.get(selSell).name + "을 판매합니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Player.money += (itemList.get(selSell).price / 2); // 50% 세금
			itemList.remove(selSell); // 아이템리스트에서 삭제
		}
	}

	// 아이템 추가 메서드
	void addItem(Item item) {
		itemList.add(item);
	}

}