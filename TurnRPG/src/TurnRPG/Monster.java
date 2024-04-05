package TurnRPG;

import java.util.Random;

public class Monster {
	private int curhp;
	private int maxhp;
	private int power;
	private String name;
	private Random random = new Random();

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
		int sample = random.nextInt(100);
		int test = target.getDex() * 100; // 회피율 설정 어캐하지.....
		
		if (sample > test) {// !회피설정 해줄것) {
			int damage = power - target.getDef();
			if(damage<0)
				damage = 0;
			target.setHp((target.getHp() - damage));
			System.out.println("-------------------------------------------------");
			System.out.println("[" + name + "] 가 " + "[" + target.getName() + "] 에게 " + damage
					+ "의 데미지를 입힙니다. ");
			if (target.getHp() <= 0) {
				System.out.println("[" + target.getName() + "] 을 처치했습니다.");
				target.setHp(0);
			}
		} else
			System.out.println("[" + name + "] 의 공격을 " + "[" + target.getName() + "] 가 회피했다. ");

	}

	public void skill() {// 스킬은 각각의 몹에게 개별 설정 확률로 발동하게 할것

	}
	
	public void skill(Player target) {// 스킬은 각각의 몹에게 개별 설정 확률로 발동하게 할것

	}

	public void skill(int num, Player target) {// 스킬은 각각의 몹에게 개별 설정 확률로 발동하게 할것

	}
	
	public void printData() {
		System.out.println("[" + name + "] [" + curhp + "/" + maxhp + "] [" + power + "]");
	}
}
