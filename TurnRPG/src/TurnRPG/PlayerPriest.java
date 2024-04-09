package TurnRPG;

public class PlayerPriest extends Player {

	private int code = PRIEST;

	public int getCode() {
		return code;
	}

	public PlayerPriest(String name, int level, int maxhp, int att, int def, int dex, int cri, int exp) {
		super(name, level, maxhp, att, def, dex, cri, exp);
	}

	public void skill(Monster target) {
		System.out.println("프리스트 스킬은 구현중이다");
	}
}