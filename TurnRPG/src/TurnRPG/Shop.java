package TurnRPG;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Item> itemList = new ArrayList<>();

	public Shop() {
		Item temp = new Item();
		temp.setWeapon(Item.WEAPON, 1, "테스트검", 1000, 100, 1000);
		itemList.add(temp);

		temp = new Item();
		temp.setWeapon(Item.WEAPON, 1, "테스트검2", 1000, 100, 1000);
		itemList.add(temp);

		temp = new Item();
		temp.setProtection(Item.PROTECTION, Item.GLOVE, "테스트헬멧", 100, 0, 0, 0, 0, 1000);
		itemList.add(temp);

		temp = new Item();
		temp.setProtection(Item.PROTECTION, Item.GLOVE, "테스트헬멧2", 100, 0, 0, 0, 0, 1000);
		itemList.add(temp);

		temp = new Item();
		temp.setProtection(Item.PROTECTION, Item.SHOULDER, "테스트견갑", 0, 100, 0, 0, 0, 1000);
		itemList.add(temp);

		temp = new Item();
		temp.setProtection(Item.PROTECTION, Item.SHOULDER, "테스트견갑2", 0, 100, 0, 0, 0, 1000);
		itemList.add(temp);

		temp = new Item();
		temp.setProtection(Item.PROTECTION, Item.ARMOR, "테스트상의", 0, 0, 100, 0, 0, 1000);
		itemList.add(temp);

		temp = new Item();
		temp.setProtection(Item.PROTECTION, Item.ARMOR, "테스트상의2", 0, 0, 100, 0, 0, 1000);
		itemList.add(temp);

		temp = new Item();
		temp.setProtection(Item.PROTECTION, Item.BOTTOMS, "테스트하의", 0, 0, 0, 100, 0, 1000);
		itemList.add(temp);

		temp = new Item();
		temp.setProtection(Item.PROTECTION, Item.BOTTOMS, "테스트하의2", 0, 0, 0, 100, 0, 1000);
		itemList.add(temp);

		temp = new Item();
		temp.setProtection(Item.PROTECTION, Item.GLOVE, "테스트장갑", 0, 0, 0, 0,100, 1000);
		itemList.add(temp);

		temp = new Item();
		temp.setProtection(Item.PROTECTION, Item.GLOVE, "테스트장갑2",  0, 0, 0, 0, 100, 1000);
		itemList.add(temp);

		temp = new Item();
		temp.setRing(Item.RING, "테스트반지", 100, 100, 100, 100, 100, 1000);
		itemList.add(temp);

		temp = new Item();
		temp.setRing(Item.RING, "테스트반지2", 100, 100, 100, 100, 100, 1000);
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
				} else if (selKind == Item.PROTECTION) {
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
			// System.out.print("[능력 : " + itemList.get(i).getPower() + "] ");
			System.out.print("[가격 : " + itemList.get(i).getPrice() + "] ");
			System.out.println();
			count += 1;
		}
	}

}