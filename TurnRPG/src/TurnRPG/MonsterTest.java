package TurnRPG;

public class MonsterTest extends Monster {
	public MonsterTest() {
		setName("테스트 몬스터");
	}

	@Override
	public void skill(Player target) {
		System.out.println("테스트몬스터가 스킬을 쓰는 척했다!");

	}
}