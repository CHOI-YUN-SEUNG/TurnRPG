package TurnRPG;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class GameManager {
	static GameManager instance = new GameManager();
	static Scanner scanner = new Scanner(System.in);
	static String nextStage = "";

	private String curStage = "";
	private Map<String, Stage> stageList = new HashMap<String, Stage>();

	private GameManager() {

	}

	public void init() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("MAP", new StageMap());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("BONUS", new StageBonus());
		stageList.put("SETTING", new StageSetting());
		nextStage = "TITLE";
	}

	public boolean changeStage() {
		System.out.println("==========================");
		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);
		System.out.println("==========================");

		if (curStage.equals(nextStage))
			return true;

		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();

		boolean run = true;
		while (run) {
			run = stage.update();
			if (run == false)
				break;
		}
		if (nextStage.equals(""))
			return false;
		else
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
	
	public static int inputIndex(String message) {
		return inputNumber(message)-1;
	}
}