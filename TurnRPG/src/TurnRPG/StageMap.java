package TurnRPG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StageMap extends Stage {
	private List<GameMap> availableMaps;

	@Override
	public boolean update() {
		exploreMap();
		return false;
	}

	@Override
	public void init() {
		this.availableMaps = generateAvailableMaps();
	}

	public void exploreMap() {
		System.out.println("탐험할 던전을 선택해주십시오.");
		printAvailableMaps();

		int selectedMapIndex = selectMap();

		GameMap selectedMap = availableMaps.get(selectedMapIndex);

		if (selectedMap.isVisitable()) {
			System.out.println("선택한 지역은 " + selectedMap.getName() + "입니다.");
			exploreSubMaps(selectedMap);
		} else {
			System.out.println(selectedMap.getName() + "은(는) 현재 방문할 수 없습니다. 다른 던전을 선택하세요.");
			exploreMap();
		}
	}

	private void exploreSubMaps(GameMap selectedMap) {
		while (true) {
			System.out.println("탐험할 세부지역을 선택하세요. (0: 뒤로가기)");
			selectedMap.printAvailableSubAreas();

			int selectedSubAreaIndex = scanner.nextInt();

			if (selectedSubAreaIndex == 0) {
				return;
			} else if (selectedSubAreaIndex <= selectedMap.getSubAreas().size()) {
				if (selectedMap.canVisit(selectedSubAreaIndex - 1)) {
					selectedMap.visitSubArea(selectedSubAreaIndex - 1);
					System.out.println("탐험 중입니다...");
					if (selectedMap.allSubAreasExplored()) {
						System.out.println(selectedMap.getName() + "의 모든 세부지역을 탐험했습니다.");
						if (availableMaps.size() > 1) {
							System.out.println("다음 지역으로 이동합니다.");
							GameManager.nextStage = "BATTLE"; // 다음 스테이지로 이동
							break;
						} else {
							System.out.println("마지막 지역입니다.");
							return;
						}
					}
				} else {
					System.out.println("순서대로 세부지역을 방문해야 합니다.");
				}
			} else {
				System.out.println("잘못된 선택입니다.");
			}
		}
	}
}
