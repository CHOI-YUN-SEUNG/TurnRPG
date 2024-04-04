package TunRPG;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Item> itemList = new ArrayList<>();

	// 생성자
	public Shop() {
		Item temp = new Item();
		temp.kind = Item.WEAPON;
		temp.name = "나무검";
		temp.power = 3;
		temp.price = 1000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.WEAPON;
		temp.name = "철검";
		temp.power = 5;
		temp.price = 2000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.WEAPON;
		temp.name = "레이피어";
		temp.power = 7;
		temp.price = 2500;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.ARMOR;
		temp.name = "티셔츠";
		temp.power = 1;
		temp.price = 300;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.ARMOR;
		temp.name = "가죽갑옷";
		temp.power = 4;
		temp.price = 800;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.ARMOR;
		temp.name = "강철갑옷";
		temp.power = 7;
		temp.price = 1500;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.RING;
		temp.name = "은반지";
		temp.power = 7;
		temp.price = 3000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.RING;
		temp.name = "금반지";
		temp.power = 17;
		temp.price = 6000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.RING;
		temp.name = "다이아반지";
		temp.power = 35;
		temp.price = 20000;
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
				if (selKind == Item.WEAPON) { // 무기
					System.out.println("=========== [무기] ============");
				} else if (selKind == Item.ARMOR) { // 갑옷
					System.out.println("========== [방어구] ===========");
				} else if (selKind == Item.RING) { // 반지
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
					// i번째 종류가 선택한 종류와 같다면 카운트 증가
					if (itemList.get(i).kind == selKind) {
						count += 1;
						// 카운트와 구입할 아이템 번호가 같다면
						if (count == selNum) {
							// 플레이어 인벤토리에 아이템 추가
							Player.inven.addItem(itemList.get(i));
							// 플레이어 소지금 감소
							Player.money -= itemList.get(i).price;
							System.out.println("[" + itemList.get(i).name + "] 을 구입했습니다.");
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
			if (itemList.get(i).kind != kind)
				continue; // 종류가 다르면 넘어가기
			System.out.print("[" + (count + 1) + "번] ");
			System.out.print("[이름 : " + itemList.get(i).name + "] ");
			System.out.print("[능력 : " + itemList.get(i).power + "] ");
			System.out.print("[가격 : " + itemList.get(i).price + "] ");
			System.out.println();
			count += 1;
		}
	}

}