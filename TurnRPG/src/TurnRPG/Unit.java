package TurnRPG;

//플레이어가 상속받을 추상클래스
public abstract class Unit {
	private String name; // 이름
	private int level; // 레벨
	private int hp;
	private int maxHp; // 최대 HP
	private int att; // 공격
	private int def; // 방어
	private int exp; // 경험치
	private int dex; // 회피
	private int critical;
	private int code;
	private boolean party; // 파티 가입 여부
	private Item weapon; // 무기
	private Item armor; // 갑옷
	
	public int getDex() {
		return dex;
	}
	
	public Item getArmor() {
		return armor;
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
	public void setArmor(Item armor) {
		this.armor = armor;
	}

	private Item ring; // 장신구

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
		armor = null;
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
		armor = null;
		ring = null;
	}

	public void setItem(Item w, Item a, Item r) {
		weapon = w;
		armor = a;
		ring = r;
	}

// 능력값 출력 메서드
	public void printStatus() {
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + level + "]");

		// 체력 : hp + 장신구
		if (ring != null) {
			System.out.print(" [체력 : " + hp + " + " + ring.power);
		} else {
			System.out.print(" [체력 : " + hp);
		}
		if (ring != null) {
			System.out.println(" / " + maxHp + " + " + ring.power + "]");
		} else {
			System.out.println(" / " + maxHp + "]");
		}
		// 공격력 : 공격 + 무기
		if (weapon != null) {
			System.out.print("[공격력 : " + att + " + " + weapon.power + "]");
		} else {
			System.out.print("[공격력 : " + att + "]");
		}
		// 방어력 : 방어 : 갑옷
		if (armor != null) {
			System.out.print(" [방어력 : " + def + " + " + armor.power + "]");
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
			System.out.println("[무기 : " + weapon.name + "]");
		}
		if (armor == null) {
			System.out.println("[방어구 : 없음 ]");
		} else {
			System.out.println("[방어구 : " + armor.name + "]");
		}
		if (ring == null) {
			System.out.println("[반지 : 없음 ]");
		} else {
			System.out.println("[반지 : " + ring.name + "]");
		}
	}

// 공격 메서드
	public void attack(Monster target) {
		target.setCurhp(target.getCurhp() - att);
		System.out.println("-------------------------------------------------");
		System.out.println("[" + name + "] 가 " + "[" + target.getName() + "] 에게 " + att + "의 데미지를 입힙니다. ");
		if (target.getCurhp() <= 0) {
			System.out.println("[" + target.getName() + "] 을 처치했습니다.");
			target.setCurhp(0);
		}
	}

	public void printData() {
		System.out.println("[" + name + "] [" + hp + "/" + maxHp + "] [" + att + "]");
	}
}