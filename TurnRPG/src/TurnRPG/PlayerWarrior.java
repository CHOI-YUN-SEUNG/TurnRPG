package TurnRPG;

public class PlayerWarrior extends Player {
	public PlayerWarrior(String name, int level, int maxhp, int att, int def, int exp) {
		super(name, level, maxhp, att, def, exp);
	}

	public void skill(Monster target) {
		System.out.println("전사 스킬은 구현중이다");
	}
}
