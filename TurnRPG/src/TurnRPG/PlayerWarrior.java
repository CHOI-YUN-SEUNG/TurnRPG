package TurnRPG;

public class PlayerWarrior extends Player {
	private int code = WARRIOR;

	public int getCode() {
		return code;
	}

	public PlayerWarrior(String name, int level, int maxhp, int att, int def, int dex, int cri, int exp) {
		super(name, level, maxhp, att, def, dex, cri, exp);
	}

	public void skill(Monster target) {
		System.out.println("전사 스킬은 구현중이다");
	}

}
