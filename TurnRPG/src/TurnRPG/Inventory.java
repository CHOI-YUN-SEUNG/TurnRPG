package TurnRPG;

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
			if (itemList.get(selEquip).getKind() == Item.WEAPON) {
				// 길드원에게 무기가 없으면 아이템리스트에 추가 후 무기 착용
				if (Player.getGuildUnit(selUnit).getWeapon() != null) {
					itemList.add(Player.getGuildUnit(selUnit).getWeapon());
				}
				Player.getGuildUnit(selUnit).setWeapon(itemList.get(selEquip)); 
			} // 입력한 아이템의 종류가 갑옷이면
			else if (itemList.get(selEquip).getKind() == Item.ARMOR) {
				// 길드원에게 무기가 없으면 아이템리스트에 추가 후 무기 착용
				if (Player.getGuildUnit(selUnit).getArmor() != null) {
					itemList.add(Player.getGuildUnit(selUnit).getArmor());
				}
				Player.getGuildUnit(selUnit).setArmor(itemList.get(selEquip));
			} // 입력한 아이템의 종류가 반지면
			else if (itemList.get(selEquip).getKind() == Item.RING) {
				if (Player.getGuildUnit(selUnit).getRing() != null) {
					itemList.add(Player.getGuildUnit(selUnit).getArmor());
				}
				Player.getGuildUnit(selUnit).setRing(itemList.get(selEquip));
			}
			itemList.remove(selEquip);
		}
	}


	public void printItemList() {
		System.out.println("============ [아이템리스트] ==============");
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print("[" + (i + 1) + "번] ");
			System.out.print("[이름 : " + itemList.get(i).getName() + "] ");
		//	System.out.print("[능력 : " + itemList.get(i).getPower() + "] ");
			System.out.print("[가격 : " + itemList.get(i).getPrice() + "] ");
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
			System.out.println(itemList.get(selSell).getName() + "을 판매합니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Player.money += (itemList.get(selSell).getPrice() / 2); // 50% 세금
			itemList.remove(selSell); // 아이템리스트에서 삭제
		}
	}

	// 아이템 추가 메서드
	void addItem(Item item) {
		itemList.add(item);
	}

}