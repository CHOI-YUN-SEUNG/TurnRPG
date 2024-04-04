package TunRPG;

//플레이어가 상속받을 추상클래스
public abstract class Unit {
	String name; // 이름
	int level; // 레벨
	int hp;
	int maxHp; // 최대 HP
	int att; // 공격
	int def; // 방어
	int exp; // 경험치
	boolean party; // 파티 가입 여부
	Item weapon; // 무기
	Item armor; // 갑옷
	Item ring; // 장신구
	String state = "노말";

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
//
//		// 체력 : hp + 장신구
//		if (ring != null) {
//			System.out.print(" [체력 : " + hp + " + " + ring.power);
//		} else {
//			System.out.print(" [체력 : " + hp);
//		}
//		if (ring != null) {
//			System.out.println(" / " + maxHp + " + " + ring.power + "]");
//		} else {
//			System.out.println(" / " + maxHp + "]");
//		}
//		// 공격력 : 공격 + 무기
//		if (weapon != null) {
//			System.out.print("[공격력 : " + att + " + " + weapon.power + "]");
//		} else {
//			System.out.print("[공격력 : " + att + "]");
//		}
//		// 방어력 : 방어 : 갑옷
//		if (armor != null) {
//			System.out.print(" [방어력 : " + def + " + " + armor.power + "]");
//		} else {
//			System.out.print(" [방어력 : " + def + "]");
//		}
//		System.out.println(" [파티중 : " + party + "]");
	}

// 가지고 있는 아이템 출력 메서드
	public void printEquitedItem() {
//		if (weapon == null) {
//			System.out.println("[무기 : 없음 ]");
//		} else {
//			System.out.println("[무기 : " + weapon.name + "]");
//		}
//		if (armor == null) {
//			System.out.println("[방어구 : 없음 ]");
//		} else {
//			System.out.println("[방어구 : " + armor.name + "]");
//		}
//		if (ring == null) {
//			System.out.println("[반지 : 없음 ]");
//		} else {
//			System.out.println("[반지 : " + ring.name + "]");
//		}
	}

// 공격 메서드
	void attack(Monster target) {
//		target.curhp -= att;
//		System.out.println("-------------------------------------------------");
//		System.out.println("[" + name + "] 가 " + "[" + target.name + "] 에게 " + att + "의 데미지를 입힙니다. ");
//		if (target.curhp <= 0) {
//			System.out.println("[" + target.name + "] 을 처치했습니다.");
//			target.curhp = 0;
//		}
	}

	void printData() {
		System.out.println("[" + name + "] [" + hp + "/" + maxHp + "] [" + att + "]");
	}
}