package TurnRPG;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> itemList = new ArrayList<>();

	public void inventoryMenu() {
		while (true) {
			System.out.println("============ [인벤토리 메뉴] =============");
			int sel = -1;

			while (!(sel >= 0 && sel < 3))
				sel = GameManager.inputNumber("[1.착용] [2.판매] [0.뒤로가기]");

			if (sel == 0)
				break;
			else if (sel == 1)
				equipMenu();
			else if (sel == 2)
				sellMenu();
		}
	}

	public void equipMenu() {
		Player.guild.printAllUnitStaus();
		int selUnit = -1;
		while (!(selUnit >= 0 && selUnit < Player.getGuildList().size()))
			selUnit = GameManager.inputIndex("아이템 착용할 길드원을 선택하세요");

		while (true) {
			Player.guild.printUnitStaus(selUnit);
			Player.guild.printUnitItem(selUnit);
			printItemList();

			int selEquip = GameManager.inputIndex("착용할 아이템 번호를 입력하세요 [0.뒤로가기]");
			if (selEquip == -1)
				break;

			if (itemList.size() > selEquip) {
				System.out.println("해당하는 번호의 아이템이 없습니다.");
			} else if (itemList.get(selEquip).getKind() == Item.WEAPON) {
				if (Player.getGuildUnit(selUnit).getWeapon() != null) {
					itemList.add(Player.getGuildUnit(selUnit).getWeapon());
				}
				Player.getGuildUnit(selUnit).setWeapon(itemList.get(selEquip));

			} else if (itemList.get(selEquip).getKind() == Item.PROTECTION) {
				if (Player.getGuildUnit(selUnit).getProtection() != null) {
					itemList.add(Player.getGuildUnit(selUnit).getProtection());
				}
				Player.getGuildUnit(selUnit).setProtection(itemList.get(selEquip));

			} else if (itemList.get(selEquip).getKind() == Item.RING) {
				if (Player.getGuildUnit(selUnit).getRing() != null) {
					itemList.add(Player.getGuildUnit(selUnit).getRing());
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
			System.out.print("[능력 : ");
			if (itemList.get(i).getAtt() != 0) {
				System.out.print("공격력 +" + itemList.get(i).getAtt());
			}
			if (itemList.get(i).getHp() != 0) {
				System.out.print(" 체력 +" + itemList.get(i).getHp());
			}
			if (itemList.get(i).getDef() != 0) {
				System.out.print(" 방어력 +" + itemList.get(i).getDef());
			}
			if (itemList.get(i).getDex() != 0) {
				System.out.print(" 회피력 +" + itemList.get(i).getDex());
			}
			if (itemList.get(i).getCri() != 0) {
				System.out.print(" 치명타확률 +" + itemList.get(i).getCri());
			}
			System.out.print("] ");
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
			itemList.remove(selSell);
		}
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void addItem(Item item) {
		itemList.add(item);
	}

}