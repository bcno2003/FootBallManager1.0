package fm;

import java.util.ArrayList;

public class T_barcelona {
	Football_main main = new Football_main();

	ArrayList<String> players = new ArrayList<String>();
	Players[] mp = new Players[11];
	String name = "바르샤";
	int stat;
	static int a = 0;
	
	//초기 선수 설정 해놓고 나중에 이적시장이나 포지션 변경할때 선수간 이동 가능하도록
	//그리고 후보선수명단도 따로 만들어야됨? -일단 이건 패스
	
	
	void genPlayers() {
		mp[0] = new Players("L.메시",0,93,"공격수");
		mp[1] = new Players( "L.수아레즈",0,92,"공격수");
		mp[2] = new Players("데울로페우",0,82,"공격수");
		mp[3] = new Players("I.라키티치",0,87,"미드필더");
		mp[4] = new Players("이니에스타",0,87,"미드필더");
		mp[5] = new Players( "세르히오 부스케츠",0,86,"미드필더");
		mp[6] = new Players( "O.뎀벨레",0,83,"미드필더");
		mp[7] = new Players("피      케",0,87,"수비수");
		mp[8] = new Players("호르디 알바",0,85,"수비수");
		mp[9] = new Players("S.움티티",0,83,"수비수");
		mp[10] = new Players("M.테어 슈테겐",0,85,"골키퍼");
	}
	void teamInfo() {
		System.out.println("============"+name+"============");
		System.out.println("\t평균스탯 : "+playerAvg());
		for(Players i : main.bcnp) {
			System.out.println(i.name+"          \t"+i.stat+"\t"+i.position);
		}System.out.println();
	}
	
	int playerAvg() {
		if(a==1) {
			double sum=0;
			for(Players p : main.bcnp) {
				sum += p.stat;
			}
			stat = (int)sum/11;
		//	this.tstat = Math.round(this.tstat*100d) / 100d;
			return stat;
		} else {
			a++;
			return 86;
		}
	}

}
