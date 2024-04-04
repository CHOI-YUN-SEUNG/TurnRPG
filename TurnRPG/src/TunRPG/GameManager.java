package TunRPG;

import java.util.Scanner;

public class GameManager {

	static GameManager instance = new GameManager();
	static Scanner scanner = new Scanner(System.in);
	
	public static String nextStage;

	public void init() {

	}

	public boolean changeStage() {
		return false;
	}

}
