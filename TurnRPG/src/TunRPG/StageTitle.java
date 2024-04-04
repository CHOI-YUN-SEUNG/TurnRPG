package TunRPG;

public class StageTitle extends Stage {
	private int count = 0;

	@Override
	public boolean update() {
		System.out.println("== TURN RPG 2024 ==");
		System.out.println("Press Enter to continue...\n");
		readStory();
		return false;
	}

	@Override
	public void init() {

	}

	private void printStory(int order) {
		if (order == 0)
			System.out.println("마왕이");
		else if (order == 1)
			System.out.println("어쩌구");
		else if (order == 2)
			System.out.println("저쩌구");
		else if (order == 3)
			System.out.println("용사가");
		else if (order == 4)
			System.out.println("어쩌구");
		else if (order == 5)
			System.out.println("저쩌구");
		else if (order == 6)
			System.out.println("모험이");
		else if (order == 7)
			System.out.println("어쩌구");
		else if (order == 8)
			System.out.println("저쩌구");
		else if (order == 9)
			System.out.println("시작된다~");
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