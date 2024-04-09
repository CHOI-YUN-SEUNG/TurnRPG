package TurnRPG;

import java.util.ArrayList;
import java.util.List;

public abstract class GameMap {
	private String name;
	private boolean visitable;
	private List<String> subMaps;
	private List<Boolean> subAreasVisited;
	private String clazzName = "";

	public GameMap(String name, boolean visitable) {
		this.name = name;
		this.visitable = visitable;
		this.subMaps = generateSubMaps();
		this.subAreasVisited = new ArrayList<>();
		for (int i = 0; i < subMaps.size(); i++) {
			subAreasVisited.add(false);
		}
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
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

	public int findSubMapIndex(String submapName) {
		for (int i = 0; i < subMaps.size(); i++) {
			if (submapName.equals(subMaps.get(i)))
				return i;
		}
		return -1;
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

	public abstract List<String> generateSubMaps();

	public abstract String[] getMons();
}