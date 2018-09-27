package fm;

import java.util.ArrayList;

public class T_chelsea {
	Football_main main = new Football_main();
	ArrayList<String> players = new ArrayList<String>();
	Players[] mp = new Players[11];
	String name = "첼시";
	int stat;
	static int a = 0;
	
	//초기 선수 설정 해놓고 나중에 이적시장이나 포지션 변경할때 선수간 이동 가능하도록
	//그리고 후보선수명단도 따로 만들어야됨? -일단 이건 패스
	
	
	void genPlayers() {
		mp[0] = new Players( "E.아자르",0,90,"공격수");
		mp[1] = new Players( "디에고 코스타",0,86,"공격수");
		mp[2] = new Players( "페드로",0,84,"공격수");
		mp[3] = new Players("모라타",0,84,"공격수");
		mp[4] = new Players("N.캉테",0,87,"미드필더");
		mp[5] = new Players( "S.파브레가스",0,86,"미드필더");
		mp[6] = new Players("T.바카요코",0,82,"미드필더");
		mp[7] = new Players( "다비드 루이스",0,86,"수비수");
		mp[8] = new Players( "아스필리쿠에타",0,85,"수비수");
		mp[9] = new Players("G.케이힐",0,84,"수비수");
		mp[10] = new Players( "T.쿠르투아",0,89,"골키퍼");
	}
	void teamInfo() {
		System.out.println("============"+name+"============");
		System.out.println("\t평균스탯 : "+playerAvg());
		for(Players i : main.csp) {
			System.out.println(i.name+"          \t"+i.stat+"\t"+i.position);
		}System.out.println();
	}
	
	int playerAvg() {
		if(a==1) {
		double sum=0;
		for(Players p : main.csp) {
			sum += p.stat;
		}
		stat = (int)sum/11;
		//this.tstat = Math.round(this.tstat*100d) / 100d;
		return stat;
		} else {
			a++;
			return 85;
		}
	}

}
