package TunRPG;

public class Monster {
	private int curhp;
	private int maxhp;
	private int power;
	private String name;

	public Monster() {
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

	public void attack(Player target) {
		int test = 0;
		if (test == 0) {// !회피설정 해줄것) {
			target.hp -= (power - target.def);
			System.out.println("-------------------------------------------------");
			System.out.println(
					"[" + name + "] 가 " + "[" + target.name + "] 에게 " + (power - target.def) + "의 데미지를 입힙니다. ");
			if (target.hp <= 0) {
				System.out.println("[" + target.name + "] 을 처치했습니다.");
				target.hp = 0;
			}

		} else
			System.out.println("[" + name + "] 의 공격을 " + "[" + target.name + "] 가 회피했다. ");

	}

	public void skill() {// 스킬은 각각의 몹에게 개별 설정 확률로 발동하게 할것

	}

	public void printData() {
		System.out.println("[" + name + "] [" + curhp + "/" + maxhp + "] [" + power + "]");
	}
}
