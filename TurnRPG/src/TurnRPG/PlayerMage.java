package TurnRPG;

public class PlayerMage extends Player {
	private int code = MAGE;

	public int getCode() {
		return code;
	}
	
	
	public PlayerMage(String name, int level, int maxhp, int att, int def, int dex, int cri, int exp) {
		super(name, level, maxhp, att, def, dex, cri, exp);
	}

	public void skill(Monster target) {
		System.out.println("메이지 스킬은 구현중이다");
	}
}
