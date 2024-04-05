package TurnRPG;

import java.util.ArrayList;
import java.util.Vector;

public class Player extends Unit {
	static int money; // 소지금

	// 다른 클래스에서도 접근 가능
	static Guild guild = Guild.instance;
	static Inventory inven = new Inventory();

	public void init() {
		money = 100000; // 소지금
	}

	public Player(String name, int level, int maxhp, int att, int def, int exp) {
		super(name, level, maxhp, att, def, exp);
	}

	public Player(String name, int level, int maxhp, int att, int def, int exp, boolean party) {
		super(name, level, maxhp, att, def, exp, false);
	}

	public Player() {

	}

	// 길드 메뉴 메서드
	public void guildMenu() {
		guild.guildMenu();
	}

	// 인벤토리 메뉴 메서드
	public void inventoryMenu() {
		inven.inventoryMenu();
	}

	static public Vector<Player> getPartyList() {
		return guild.getPartyList();
	}

	// 아이템 리스트 반환 메서드
	static public ArrayList<Item> getItemList() {
		return inven.itemList;
	}

	// 길드원 반환 메서드
	static public Player getGuildUnit(int num) {
		return guild.getGuildUnit(num);
	}

	// 길드 크기 반환 메서드
	static public int getPartySize() {
		return getPartyList().size();
	}

	// 아이템 크기 반환 메서드
	static public int getItemSize() {
		return inven.itemList.size();
	}
}