package TurnRPG;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Item> itemList = new ArrayList<>();
	
	public Shop() {
		Item temp = new Item();
		temp.setWeapon(Item.WEAPON, 1,"나무검", 3, 1000);
		itemList.add(temp);

	}

	public void shopMng() {
		while (true) {
			System.out.println("=============== [상점] ===============");
			System.out.println("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기]");
			int selKind = GameManager.scanner.nextInt();
			if (selKind == 0)
				return;

			while (true) {
				if (selKind == Item.WEAPON) {
					System.out.println("=========== [무기] ============");
				} else if (selKind == Item.ARMOR) {
					System.out.println("========== [방어구] ===========");
				} else if (selKind == Item.RING) {
					System.out.println("=========== [반지] ============");
				}
				printItems(selKind);
				System.out.println("------------------------------------");
				System.out.println("[골드 : " + Player.money + "]");
				System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
				int selNum = GameManager.scanner.nextInt();
				if (selNum == 0)
					break;
				int count = 0;
				for (int i = 0; i < itemList.size(); i++) {
					if (itemList.get(i).getKind() == selKind) {
						count += 1;
						if (count == selNum) {
							Player.inven.addItem(itemList.get(i));
							Player.money -= itemList.get(i).getPrice();
							System.out.println("[" + itemList.get(i).getName() + "] 을 구입했습니다.");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							break;
						}
					}
				}
			}
		}
	}

	// 해당 종류의 아이템 출력 메서드
	public void printItems(int kind) {
		int count = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getKind() != kind)
				continue; // 종류가 다르면 넘어가기
			System.out.print("[" + (count + 1) + "번] ");
			System.out.print("[이름 : " + itemList.get(i).getName() + "] ");
			//System.out.print("[능력 : " + itemList.get(i).getPower() + "] ");
			System.out.print("[가격 : " + itemList.get(i).getPrice() + "] ");
			System.out.println();
			count += 1;
		}
	}

}