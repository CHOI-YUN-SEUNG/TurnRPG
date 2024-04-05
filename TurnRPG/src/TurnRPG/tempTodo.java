//콘솔을 통한 턴제 rpg 콘솔 게임
//맵 진행단계 저장해결해야함
//
//0.메인(완)
//
//1. 파일 매니저 - 후순위 마지막에 추가예정
//
//2. 게임 매니저 (반완)
//ㄴ 맵 스테이지 추가부분만들기
//
//3. 스테이지(추상 클래스)(완)
//ㄴ 타이틀(완) 
//
//ㄴ 로비(완)
//
//ㄴ맵스테이지 수정 필요 - 맵을 인스턴스로 만들어서 공유하게 해야겠다
//맵을 맵 매니저를 통해 관리해야함
//- 각 스테이지 테마에 맞는 몬스터 등장 - 몬스터 리스트 여기에서 생성해두기
//- 일반4-보상-1-?1-보스1 - 보스 스테이지 클리어시 모든 파티원 체력회복
//
//ㄴ 배틀 
//ㄴ 배틀시 턴 세기 구현 스킬 쿨 타임 구현용. 
//ㄴ 침묵은 턴을 -1 시키는 것으로 대체.
//ㄴ 사망시 드랍템 주는 메소드 추가 - 드랍템을 각 몬스터에 미리 넣어주고 받아와서 처리
//ㄴ 캐릭터 사망시 보유 경험치 혹은 레벨 다운 추가
//
//ㄴ 보너스 스테이지 -일정 확률로 미믹과 배틀 or (회복,공버프,방버프,보스라운드3라운드 이상 남았을때 다음 라운드 스킵 버프,버프인척하는 디버프) 
// - 미믹 몹을 담아둔 미믹 맵을 일정 확률로 불러오기로 구현.
//
//ㄴ 세팅 (반완) - 이스터 에그 추가 예정
//
//4. 유닛매니저 - 몬스터 생성시 스텟과 드랍 경험치 수치 조정하는 부분 추가
//
//5 .몬스터(추상 클래스)  기본 스텟 - 체/공 (1차) ../코드를 또 만들어야하나
//테마 별로 타입종류라고 생각 
//처치시 돈 드랍. 경험치 조정은 추후 생각
//몬스터 스텟은 현재 스테이지*라운드에 비례해서 연산 처리
//보스 처치시 보스템 드랍 - 죽을 시에 new Item 후 add하는 메소드 추가 
//몬스터 유닛 정보 
//1스테이지 일반몹 고블린테마 보스몹 킹고블린
//2스테이지 일반몹 거미테마  보스몹 거미여왕 
//3스테이지 일반몹 언데드테마 보스몹 리치 체/공/방
//4스테이지 일반몹 슬라임테마 보스몹 도플갱어  체/공/회
//5스테이지 일반몹 악마테마 보스몹 마왕 체/공/방/회
//
//6. 플레이어(추상 클래스)  
//ㄴ기본 스텟- 이름/레벨/체력/공/방/회/치/파티여부/직업코드/(속성)
//ㄴ 기본 직업- 전사,마법사,성직자,도적,궁수            
//ㄴ뽑기 용병은 스킬,패시브.디버프 인터페이스 빼두고 랜덤으로 차이 두기
//ㄴ직업 코드 별로 보정이 붙은 스텟이 다르게 설정
//ㄴ조건부 해금 직업- ....추후 생성 예정 (네크로멘서를 위해서는 플레이어 리스트대신  유닛리스트로 받으면 되려나,,,,)
//ㄴ 각 직업별로 하위 클래스 생성해서 직업 코드 및 보유 가능 스킬 차이 두기
//ㄴ 공유 소지금있음 - 길드원 추가 및 아이템 구매에 사용
//ㄴ 스킬은 쿨타임재로 하자. 스킬코드 등을 통해 2개까지 스킬 지원
//ㄴ 몬스터와 함께 플레이어 수정하여 속성 스텟 부여 가위바위보 추가 
//
//7. 길드 - 파티원 3명, 파티원 추가시 레벨 조정 설정 추가 
//     싱글톤처리하자
//    특정 직업 코드 수 n이상 버프 제공하고 싶다. 유사도감
//    삭제시 보유 아이템도 삭제됩니다. 안내 메세지 추가
//    직업 코드 리스트를... 어디에 넣어야하지.
//
//8. 아이템-세트템 효과 만들고 싶다...
//ㄴ방어구 투구,견갑,상의,하의.장갑.       방어력/공격력/ 체력/회피/치명 
//ㄴ무기-종류별 직업코드와 다른 무기는 착용불가   공격력/치명/방어력
//         포함하는지로 처리해서 여러 직업 착용할 수 있게 하자
//ㄴ반지-특정 스텟 (방어력/공격력/ 체력/회피/치명) 증가
//         비싼 반지-파티원 수 증가 반지
//ㄴ???템 추가
//ㄴ해당 템이 보유 스텟을 확인하는 메소드 추가
//
//9. 인벤토리 착용,판매 - 싱글톤처리하자
//
//10. 상점 - 아이템 테마별로 메뉴 세분화 하기.
//ㄴ보스스테이지 클리어 이후에는 할인 품목 하나씩
//
//11. 꾸미기 클래스 추가 - 글씨체, 폰트색, 출력 조정 등등
//package TurnRPG;
//
