package TurnRPG;

import java.util.ArrayList;
import java.util.List;

public class TestMap2 extends GameMap {
	private String mons[] = { "MonsterTest" }; 
	public TestMap2(String name, boolean visitable) {
		super(name, visitable);
		this.setClazzName("TestMap2");
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
		subMaps.add("테스트 지역 D");
		return subMaps;
	}
}