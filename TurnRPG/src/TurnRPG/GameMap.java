package TurnRPG;

import java.util.ArrayList;
import java.util.List;

abstract class GameMap {
	private String name;
	private boolean visitable;
	private List<String> subMaps;
	private List<Boolean> subAreasVisited;

	public GameMap(String name, boolean visitable) {
		this.name = name;
		this.visitable = visitable;
		this.subMaps = generateSubMaps();
		this.subAreasVisited = new ArrayList<>();
		for (int i = 0; i < subMaps.size(); i++) {
			subAreasVisited.add(false);
		}
	}

	public String getName() {
		return name;
	}

	public List<String> getSubMaps() {
		return subMaps;
	}

	public void printAvailableSubMaps() {
		for (int i = 0; i < subMaps.size(); i++) {
			if (canVisit(i)) {
				if (subAreasVisited.get(i)) {
					System.out.println((i + 1) + ". [방문함] " + subMaps.get(i));
				} else {
					System.out.println((i + 1) + ". [미방문] " + subMaps.get(i));
				}
			} else {
				System.out.println((i + 1) + ". [방문불가] " + subMaps.get(i));
			}
		}
	}

	public boolean isVisitable() {
		return visitable;
	}

	public boolean canVisit(int index) {
		if (index == 0) {
			return true;
		}
		for (int i = 0; i < index; i++) {
			if (!subAreasVisited.get(i)) {
				return false;
			}
		}
		return true;
	}

	public void visitSubMap(int index) {
		if (index >= 0 && index < subAreasVisited.size()) {
			subAreasVisited.set(index, true);
		}
	}

	public boolean allSubMapExplored() {
		for (Boolean visited : subAreasVisited) {
			if (!visited) {
				return false;
			}
		}
		return true;
	}

	private List<String> generateSubMaps() {
		List<String> subMaps = new ArrayList<>();
		for (int i = 1; i <= 7; i++) {
			subMaps.add("세부지역 " + i);
		}
		return subMaps;
	}
}