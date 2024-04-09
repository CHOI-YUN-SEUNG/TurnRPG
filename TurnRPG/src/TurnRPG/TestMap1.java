package TurnRPG;

import java.util.ArrayList;
import java.util.List;

public class TestMap1 extends GameMap {
	private UnitManager unitManager = UnitManager.instance;

	public TestMap1(String name, boolean visitable) {
		super(name, visitable);
	}

	@Override
	public String getName() {
		return "고블린 부락";
	}

	@Override
	public List<String> generateSubMaps() {
		List<String> subMaps = new ArrayList<>();
		subMaps.add("테스트 지역 A");
		subMaps.add("테스트 지역 B");
		subMaps.add("테스트 지역 C");
		return subMaps;
	}

	public void spawnMonsters() {
		unitManager.spawnMonsters(this.getName(), 3); 
		unitManager.spawnMonsters(this.getName(), 2); 
	}
}
