package fm;

import java.util.ArrayList;

public class T_manche {
	Football_main main = new Football_main();
	ArrayList<String> players = new ArrayList<String>();
	Players[] mp = new Players[11];
	String name = "맨유";
	int stat;
	static int a =0;
	
	//초기 선수 설정 해놓고 나중에 이적시장이나 포지션 변경할때 선수간 이동 가능하도록
	//그리고 후보선수명단도 따로 만들어야됨? -일단 이건 패스
	
	
	void genPlayers() {
		mp[0] = new Players("Z.이브라히모비치",0,88,"공격수");
		mp[1] = new Players( "R.루카쿠",0,86,"공격수");
		mp[2] = new Players("M.래시포드",0,85,"공격수");
		mp[3] = new Players("P.포그바",0,87,"미드필더");
		mp[4] = new Players("H.미키타리안",0,85,"미드필더");
		mp[5] = new Players( "안데르 에레라",0,84,"미드필더");
		mp[6] = new Players( "후안 마타",0,84,"미드필더");
		mp[7] = new Players("E.바이",0,84,"수비수");
		mp[8] = new Players("A.발렌시아",0,83,"수비수");
		mp[9] = new Players("M.로호",0,82,"수비수");
		mp[10] = new Players("데 헤아",0,90,"골키퍼");
	}
	void teamInfo() {
		System.out.println("============"+name+"============");
		System.out.println("\t평균스탯 : "+playerAvg());
		for(Players i : main.mup) {
			System.out.println(i.name+"          \t"+i.stat+"\t"+i.position);
		}System.out.println();
	}
	
	int playerAvg() {
		if(a==1) {
		double sum=0;
		for(Players p : main.mup) {
			sum += p.stat;
		}
		stat = (int)sum/11;
		//this.tstat = Math.round(this.tstat*100d) / 100d;
		return stat;}
		else {
			a++;
			return 85;
		}
	}

}
