package TurnRPG;

import java.util.ArrayList;
import java.util.List;

public class StageMap extends Stage {
	private List<GameMap> availableMaps;
	private static GameMap selectedMap;
	private static String selectedSubmap;
	
	
	static public String getSelectedSubmap() {
		return selectedSubmap;
	}
	
	static public GameMap getSelectedMap() {
		return selectedMap;
	}
	
	@Override
	public boolean update() {
		exploreMap();
		return false;
	}

	@Override
	public void init() {
		availableMaps = generateAvailableMaps();
	}

	public void exploreMap() {
		while (GameManager.nextStage == "MAP") {
			printAvailableMaps();
			int selectedMapIndex = GameManager.inputIndex("탐험할 던전을 선택해주십시오.(0: 뒤로가기)");
			if (selectedMapIndex == -1) {
				GameManager.nextStage = "LOBBY";
				return;
			} else {
				selectedMap = availableMaps.get(selectedMapIndex);
				if (selectedMap.isVisitable()) {
					System.out.println("선택한 던전은 " + selectedMap.getName() + "입니다.");
					exploreSubMaps(selectedMap);
				} else {
					System.out.println(selectedMap.getName() + "은(는) 현재 방문할 수 없습니다. 다른 던전을 선택하세요.");
				}
			}
		}
	}

	private void exploreSubMaps(GameMap selectedMap) {
		while (true) {
			selectedMap.printAvailableSubMaps();
			int selectedSubMapIndex = GameManager.inputIndex("탐험할 지역을 선택하세요. (0: 뒤로가기)");

			if (selectedSubMapIndex == -1) {
				return;
			} else if (selectedSubMapIndex <= selectedMap.getSubMaps().size()) {
				if (selectedMap.canVisit(selectedSubMapIndex)) {
					selectedSubmap = selectedMap.getSubMaps().get(selectedSubMapIndex);
					//selectedMap.visitSubMap(selectedSubMapIndex); 이걸 몬스터를 다 잡고 해줘야할듯하다..
					System.out.println("탐험 중입니다...");
					try {
						Thread.sleep(500);
						System.out.println("적을 만났습니다!");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					GameManager.nextStage = "BATTLE";
					break;
				} else {
					System.out.println("이전 지역 탐험이 완료되지 않았습니다.");
				}
			} else {
				System.out.println("잘못된 선택입니다.");
			}
		}
	}

	private void printAvailableMaps() {
		System.out.println("====== 탐험 가능한 지역 ======");
		for (int i = 0; i < availableMaps.size(); i++) {
			GameMap map = availableMaps.get(i);
			System.out.print((i + 1) + ". " + map.getName());
			if (map.isVisitable()) {
				System.out.println(" [방문 가능]");
			} else {
				System.out.println(" [방문 불가능]");
			}
		}
	}

	private List<GameMap> generateAvailableMaps() {
		List<GameMap> availableMaps = new ArrayList<>();
		availableMaps.add(new TestMap1("테스트1", true));
		availableMaps.add(new TestMap2("테스트2", true));
		return availableMaps;
	}
}