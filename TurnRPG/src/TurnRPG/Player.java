package TurnRPG;

import java.util.ArrayList;
import java.util.Vector;

public class Player extends Unit {
	public final int WARRIOR = 1;
	public final int MAGE = 2;
	public final int ARCHOR = 3;
	public final int ASSASSIN = 4;
	public final int PRIEST = 5;
	
	public static int money;
	public static Guild guild = Guild.instance;
	public static Inventory inventory = Inventory.instance;
	public static Inventory inven = new Inventory();

	public void init() {
		money = 100000; // 소지금
	}

	public void checkExp() {
		if(getExp() >= 100) {
			setLevel(getLevel() + getExp()/100);
			setExp(getExp() % 100);
			System.out.println("레벨업");
		}
	}


	public Player(String name, int level, int maxhp, int att, int def, int exp) {
		super(name, level, maxhp, att, def, exp);
	}

	public Player(String name, int level, int maxhp, int att, int def, int exp, boolean party) {
		super(name, level, maxhp, att, def, exp, false);
	}

	public Player(String name, int level, int maxhp, int att, int def, int dex, int cri, int exp) {
		super(name, level, maxhp, att, def, dex, cri, exp);
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

	static public Vector<Player> getGuildList() {
		return guild.getGuildList();
	}

	static public Player[] getPartyList() {
		return guild.getPartyList();
	}

	static public Player getPartyUnit(int num) {
		return guild.getPartyUnit(num);
	}

	// 아이템 리스트 반환 메서드
	static public ArrayList<Item> getItemList() {
		return inven.getItemList();
	}

	// 길드원 반환 메서드
	static public Player getGuildUnit(int num) {
		return guild.getGuildUnit(num);
	}

	// 길드 크기 반환 메서드
	static public int getPartySize() {
		return guild.getPartySize();
	}

	// 아이템 크기 반환 메서드
	static public int getItemSize() {
		return inven.getItemList().size();
	}

}