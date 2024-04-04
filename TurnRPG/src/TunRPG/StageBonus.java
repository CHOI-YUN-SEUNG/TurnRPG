package TunRPG;

public class StageBonus extends Stage {
	//플레이어 상태를 받고 갱신해주는 작업 필요
	private UnitManager unitManager = UnitManager.instance;
	
	
	public boolean update() {
	
		int a = 1;
		Player.getGuildUnit(a).att += 10;
		
		
		
		return false;
	}

	@Override
	public void init() {
		unitManager.player = new Player();
		
	}

}
