package TurnRPG;

import java.util.Random;

public abstract class Unit {
	private String name; // 이름
	private int level; // 레벨
	private int hp;
	private int maxHp; // 최대 HP
	private int att; // 공격
	private int def; // 방어
	private int exp; // 경험치
	private int dex; // 회피
	private int cri;
	private boolean party; // 파티 가입 여부
	private Item weapon; // 무기
	private Item protection; // 갑옷
	private Item ring; // 장신구

	
	public int getCri() {
		return cri;
	}

	public int getDex() {
		return dex;
	}

	public Item getProtection() {
		return protection;
	}

	public int getAtt() {
		return att;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public boolean isParty() {
		return party;
	}

	public void setParty(boolean party) {
		this.party = party;
	}

	public Item getWeapon() {
		return weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public Item getRing() {
		return ring;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public void setProtection(Item protection) {
		this.protection = protection;
	}

// 생성자

	Unit() {
	}

	public Unit(String name, int level, int hp, int att, int def, int exp) {
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.hp = maxHp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		party = false;
		weapon = null;
		protection = null;
		ring = null;
	}

// 생성자 오버로딩
	public Unit(String name, int level, int hp, int att, int def, int exp, boolean party) {
		super();
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.hp = maxHp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		this.party = party;
		weapon = null;
		protection = null;
		ring = null;
	}

	public Unit(String name, int level, int hp, int att, int def, int dex, int cri, int exp) {
		super();
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.hp = maxHp;
		this.att = att;
		this.def = def;
		this.dex = dex;
		this.cri = cri;
		this.exp = exp;

		party = false;
		weapon = null;
		protection = null;
		ring = null;
	}

	public void setItem(Item weapon, Item protection, Item ring) {
		this.weapon = weapon;
		this.protection = protection;
		this.ring = ring;
	}

	// 아이템의 능력치를 확인하는 메소드를 만들어서 처리해야겠다.

// 능력값 출력 메서드
	public void printStatus() {
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + level + "]");

		// 체력 : hp + 장신구
		if (ring != null) {
			// System.out.print(" [체력 : " + hp + " + " + ring.getPower());
		} else {
			System.out.print(" [체력 : " + hp);
		}
		if (ring != null) {
//			System.out.println(" / " + maxHp + " + " + ring.getPower() + "]");
		} else {
			System.out.println(" / " + maxHp + "]");
		}
		if (weapon != null) {
			System.out.print("[공격력 : " + att + " + " + weapon.getAtt() + "]");
		} else {
			System.out.print("[공격력 : " + att + "]");
		}
		// 방어력 : 방어 : 갑옷
		if (protection != null) {
			// System.out.print(" [방어력 : " + def + " + " + armor.getPower() + "]");
		} else {
			System.out.print(" [방어력 : " + def + "]");
		}
		System.out.println(" [파티중 : " + party + "]");
	}

// 가지고 있는 아이템 출력 메서드
	public void printEquitedItem() {
		if (weapon == null) {
			System.out.println("[무기 : 없음 ]");
		} else {
			System.out.println("[무기 : " + weapon.getName() + "]");
		}
		if (protection == null) {
			System.out.println("[방어구 : 없음 ]");
		} else {
			System.out.println("[방어구 : " + protection.getName() + "]");
		}
		if (ring == null) {
			System.out.println("[반지 : 없음 ]");
		} else {
			System.out.println("[반지 : " + ring.getName() + "]");
		}
	}

	public void skill(Monster target) {
		System.out.println("스킬은 구현중이다");
	}

	public void attack(Monster target) {
		System.out.println("-------------------------------------------------");
		int demage = att;

		if (weapon != null)
			demage += weapon.getAtt();

		Random random = new Random();
		int rNum = random.nextInt(100);
		if (rNum < cri) {
			System.out.print("치명타!");
			demage *= 2;
		}

		target.setCurhp(target.getCurhp() - demage);

		System.out.println("[" + name + "] 가 " + "[" + target.getName() + "] 에게 " + demage + "의 데미지를 입힙니다. ");

		if (target.getCurhp() <= 0) {
			System.out.println("[" + target.getName() + "] 을 처치했습니다.");
			target.setCurhp(0);
		}

	}

	public void printData() { // 11은 테스트용
		System.out.println("[" + name + "][" + hp + "/" + maxHp + "][" + att + "(" + 11 + ")" + "]" + "["
				+ def + "]" + "[" + dex + "]" + "[" + cri + "]" + "[" + level + "][" + exp + "]");
	}
}