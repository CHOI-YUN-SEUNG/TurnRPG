package TunRPG;

import java.util.ArrayList;
import java.util.Vector;

public class Player extends Unit {
	static int money; // 소지금

	// 다른 클래스에서도 접근 가능
	static Guild guild = new Guild();
	static Inventory inven = new Inventory();

	void init() {
		money = 100000; // 소지금
		guild.setGuild(); // 길드 설정
	}

	public Player(String name, int level, int maxhp, int att, int def, int exp) {
		super(name, level, maxhp, att, def, exp);
	}

	public Player(String name, int level, int maxhp, int att, int def, int exp, boolean party) {
		super(name, level, maxhp, att, def, exp, false);
	}

	public Player() {
		
	}

	void skill() {

	}

	public static int getPartySize() {
		// TODO Auto-generated method stub
		return 0;
	}

	// 길드 메뉴 메서드
	public void guildMenu() {
		guild.guildMenu();
	}

	// 인벤토리 메뉴 메서드
	public void inventoryMenu() {
		inven.inventoryMenu();
	}

	// 길드 리스트 반환 메서드
	static public Vector<Player> getGuildList() {
		return guild.guildList;
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
	static public int getGuildSize() {
		return guild.guildList.size();
	}

	// 아이템 크기 반환 메서드
	static public int getItemSize() {
		return inven.itemList.size();
	}

}