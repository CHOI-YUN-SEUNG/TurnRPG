package TurnRPG;

import java.util.ArrayList;
import java.util.List;

public class TestMap1 extends GameMap {
	private String mons[] = { "MonsterTest","TEST2" }; 
	public TestMap1(String name, boolean visitable) {
		super(name, visitable);
		this.setClazzName("TestMap1");
	}
	
	public String[] getMons() {
		return mons;
	}
	
	@Override
	public List<String> generateSubMaps() {
		List<String> subMaps = new ArrayList<>();
		subMaps.add("테스트 지역 A");
		subMaps.add("테스트 지역 B");
		subMaps.add("테스트 지역 C");
		return subMaps;
	}
}
