package TunRPG;

public class StageLobby extends Stage {

	@Override
	public boolean update() {
		System.out.println("=====[LOBBY]=====");
		System.out.println("[1. 전투] [2. 설정] [3. 종료]");
		int sel = -1;
		while (!(sel > 0 && sel < 4))
			sel = GameManager.inputNumber("입력>> ");

		if (sel == 1) {
			GameManager.nextStage = "BATTLE";
		} else if (sel == 2) {
			GameManager.nextStage = "SETTING";
		} else if (sel == 3) {
			GameManager.nextStage = "";
		}
		return false;
	}

	@Override
	public void init() {
		UnitManager.instance.init();

	}
}