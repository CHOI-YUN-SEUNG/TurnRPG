package TurnRPG;

public class PlayerArchor extends Player {

	public PlayerArchor(String name, int level, int maxhp, int att, int def, int exp) {
		super(name, level, maxhp, att, def, exp);
	}

	public void skill(Monster target) {
		System.out.println("아처스킬은 구현중이다");
	}
}
