package fm;

import java.util.ArrayList;

public class T_real {
	Football_main main = new Football_main();
	ArrayList<String> players = new ArrayList<String>();
	Players[] mp = new Players[11];
	String name = "레알";
	int stat;
	static int a =0;
	
	//초기 선수 설정 해놓고 나중에 이적시장이나 포지션 변경할때 선수간 이동 가능하도록
	//그리고 후보선수명단도 따로 만들어야됨? -일단 이건 패스
	
	
	void genPlayers() {
		mp[0] = new Players("C.호날두",0,94,"공격수");
		mp[1] = new Players( "G.베일",0,89,"공격수");
		mp[2] = new Players("K.벤제마",0,86,"공격수");
		mp[3] = new Players("T.크로스",0,90,"미드필더");
		mp[4] = new Players("L.모드리치",0,89,"미드필더");
		mp[5] = new Players( "이스코",0,86,"미드필더");
		mp[6] = new Players( "카세미루",0,86,"미드필더");
		mp[7] = new Players("세르히오 라모스",0,90,"수비수");
		mp[8] = new Players("마르셀루",0,87,"수비수");
		mp[9] = new Players("R.바란",0,85,"수비수");
		mp[10] = new Players("K.나바스",0,85,"골키퍼");
	}
	void teamInfo() {
		System.out.println("============"+name+"============");
		System.out.println("\t평균스탯 : "+playerAvg());
		for(Players i : main.realp) {
			System.out.println(i.name+"          \t"+i.stat+"\t"+i.position);
		}System.out.println();
	}
	
	int playerAvg() {
		if(a==1) {
		double sum=0;
		for(Players p : main.realp) {
			sum += p.stat;
		}
		stat = (int)sum/11;
		//this.tstat = Math.round(this.tstat*100d) / 100d;
		return stat;}
	else {
		a++;
		return 87;
	}
	}

}
