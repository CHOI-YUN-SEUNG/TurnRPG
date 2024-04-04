package TunRPG;

public class Monster {
	int curhp;
	int maxhp;
	int power;
	String name;
	String state = "노말";

	Monster() {
	}

	Monster(String name, int max, int pw) {
		this.name = name;
		this.curhp = max;
		this.maxhp = max;
		this.power = pw;
	}

	public void init(int hp, int pw) {
		// TODO Auto-generated method stub

	}

}
