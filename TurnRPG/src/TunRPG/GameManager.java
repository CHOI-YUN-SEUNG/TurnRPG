package TunRPG;

import java.util.Scanner;

public class GameManager {

	static GameManager instance = new GameManager();
	static Scanner scanner = new Scanner(System.in);

	public static String nextStage;

	public void init() {

	}

	public boolean changeStage() {
		return true;
	}

	public static int inputNumber(String message) {
		int number = -1;
		while (number < 0) {
			try {
				System.out.print(message);
				String input = scanner.nextLine();
				number = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.err.println("숫자를 입력해주시길 바랍니다.");
			}
		}
		return number;
	}

}
