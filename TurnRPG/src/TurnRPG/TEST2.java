package TurnRPG;

public class TEST2 extends Monster {
	public TEST2() {
		setName("테스트 몬스터2");
	}

	@Override
	public void skill(Player target) {
		System.out.println("테스트몬스터2가 스킬을 쓰는 척했다!");
		
	}
}
