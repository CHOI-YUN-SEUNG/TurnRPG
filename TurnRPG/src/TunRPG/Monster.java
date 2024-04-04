package TunRPG;

public class Monster {
	private int curhp;
	private int maxhp;
	private int power;
	private String name;
	private String state = "노말";

	Monster() {
	}

	public String getName() {
		return name;
	}
	
	public int getCurhp() {
		return curhp;
	}

	public int getMaxhp() {
		return maxhp;
	}
	
	public int getPower() {
		return power;
	}
	
	public String getState() {
		return state;
	}
	
	public void setCurhp(int curhp) {
		this.curhp = curhp;
	}
	
	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public Monster(String name, int max, int pw) {
		this.name = name;
		this.curhp = max;
		this.maxhp = max;
		this.power = pw;
	}

	public void init(int max, int pw) {
		this.curhp = max;
		this.maxhp = max;
		this.power = pw;
	}

	public void init(String name, int max, int pw) {
		this.name = name;
		this.curhp = max;
		this.maxhp = max;
		this.power = pw;
	}

	// 몬스터가 플레이어에게 공격하는 메서드
	public void attack(Unit target) {
		target.hp -= (power - target.def);
		System.out.println("-------------------------------------------------");
		System.out.println("[" + name + "] 가 " + "[" + target.name + "] 에게 " + (power - target.def) + "의 데미지를 입힙니다. ");
		if (target.hp <= 0) {
			System.out.println("[" + target.name + "] 을 처치했습니다.");
			target.hp = 0;
		}
	}

	public void skill() {

	}

	public void printData() {
		System.out.println("[" + name + "] [" + curhp + "/" + maxhp + "] [" + power + "]");
	}
}
