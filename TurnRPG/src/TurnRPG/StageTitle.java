package TurnRPG;

public class StageTitle extends Stage {
	private int count = 0;

	@Override
	public boolean update() {
		System.out.println("== TURN RPG 2024 ==");
		System.out.println("Press Enter to continue...\n");
		readStory();
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {

	}

	private void printStory(int order) {
		if (order == 0)
			System.out.println("먼 옛날 수호신들이 마계의 문을 봉인한 후...");
		else if (order == 1)
			System.out.println("수백 년간 평화롭게 살아온 판테온 대륙....");
		else if (order == 2)
			System.out.println("평화롭던 어느날 갑자기 나타나기 시작한 몬스터들...");
		else if (order == 3)
			System.out.println("원인불명으로 봉인이 풀리고 마계의 생물들이");
		else if (order == 4)
			System.out.println("평화롭던 대륙에 쏟아지기 시작했습니다....");
		else if (order == 5)
			System.out.println("이에 대비하여 대륙 각지에서 용감한 탐험가들이 모여");
		else if (order == 6)
			System.out.println("봉인이 풀인 원인을 찾고, 평화를 되찾고자");
		else if (order == 7)
			System.out.println("마계 던전탐사대를 결성하여");
		else if (order == 8)
			System.out.println("오늘도 험난한 모험을 떠납니다.");
		else if (order == 9)
			System.out.println("판테온 대륙은 다시 평화로운 땅이 될 수 있을 것 인가...");
	}

	private void waitForEnter() {
		Thread thread = new Thread(() -> {
			GameManager.scanner.nextLine();
			GameManager.nextStage = "LOBBY";
			count = 10;
		});
		thread.start();
	}

	private void readStory() {
		waitForEnter();
		while (count < 10) {
			try {
				printStory(count);
				Thread.sleep(1000);
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}