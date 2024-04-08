package TurnRPG;

public class PlayerPriest extends Player {
	public PlayerPriest(String name, int level, int maxhp, int att, int def, int exp) {
		super(name, level, maxhp, att, def, exp);
	}

	public void skill(Monster target) {
		System.out.println("프리스트 스킬은 구현중이다");
	}
}