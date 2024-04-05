package TurnRPG;

public class Item {
	public static final int WEAPON = 1; // 무기
	public static final int PROTECTION = 2; // 갑옷
	public static final int HELMET = 1;
	public static final int SHOULDER = 2;
	public static final int ARMOR = 3;
	public static final int BOTTOMS = 4;
	public static final int GLOVE = 5;
	public static final int RING = 3; // 장신구

	private int kind;
	private String name;
	private int code;
	private int att;
	private int cri;
	private int def;
	private int hp;
	private int dex;
	private int price;

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getCri() {
		return cri;
	}

	public void setCri(int cri) {
		this.cri = cri;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setWeapon(int weapon2, int i, String string, int j, int k) {

	}
	
	public void setProtection() {

	}
	
	public void setRing() {

	}
}