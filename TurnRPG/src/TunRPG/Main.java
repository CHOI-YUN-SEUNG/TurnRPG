package TunRPG;

public class Main {
	public static void main(String[] args) {
		boolean run = true;
		GameManager.instance.init();
		while (run) {
			run = GameManager.instance.changeStage();
		}
		System.out.println("게임 종료");
	}
}