package TunRPG;

import java.util.Random;

public class StageSetting extends Stage {
	private Random ran = new Random();
	private UnitManager unitManager = null;
	private Shop shop;
	private FileManager fileManager;

	@Override
	public boolean update() {
		while (true) {
			System.out.println("=============== [메인메뉴] ================");
			System.out.println("[1.길드관리]\t\t[2.상점]\t\t[3.인벤토리]");
			System.out.println("[4.저장]\t\t[5.로드]\t\t[0.종료]");
			int sel = -1;
			while (0 >= sel || sel < 6)
				sel = GameManager.inputNumber("입력>> ");

			if (sel == 1) {
				// um.player.guildMenu();
			} else if (sel == 2) {
				// shop.shopMng();
			} else if (sel == 3) {
				// um.player.inventoryMenu();
			} else if (sel == 4) {
				fileManager.saveData();
			} else if (sel == 5) {
				fileManager.loadData();
			} else {
				GameManager.nextStage = "";
				break;
			}
		}
		return false;
	}

	@Override
	public void init() {
		unitManager = UnitManager.instance;
		shop = new Shop();
		fileManager = new FileManager();
	}
}