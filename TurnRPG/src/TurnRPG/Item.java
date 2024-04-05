package TurnRPG;

public class Item {
	public static final int WEAPON = 1; // 무기
	public static final int ARMOR = 2; // 갑옷
	public static final int RING = 3; // 장신구

	private int kind; // 종류
	private String name; // 이름
	private int power; // 능력
	private int price; // 가격
	
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

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setItem(int kind, String name, int power, int price) {
		this.kind = kind;
		this.name = name;
		this.power = power;
		this.price = price;
	}
}