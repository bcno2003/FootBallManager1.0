package fm;

import java.util.ArrayList;

public class T_mancity  {
	Football_main main = new Football_main();
	ArrayList<String> players = new ArrayList<String>();
	Players[] mp = new Players[11];
	String name = "맨시티";
	int stat;
	static int a =0;
	
	//초기 선수 설정 해놓고 나중에 이적시장이나 포지션 변경할때 선수간 이동 가능하도록
	//그리고 후보선수명단도 따로 만들어야됨? -일단 이건 패스
	
	
	void genPlayers() {
		mp[0] = new Players("S.아구에로",0,90,"공격수");
		mp[1] = new Players("L.자네",0,83,"공격수");
		mp[2] = new Players("R.스털링",0,83,"공격수");
		mp[3] = new Players("K.더 브라위너",0,89,"미드필더");
		mp[4] = new Players("다비드 실바",0,87,"미드필더");
		mp[5] = new Players("I.귄도안",0,85,"미드필더");
		mp[6] = new Players("Y.투레",0,84,"미드필더");
		mp[7] = new Players("v.콤파니",0,86,"수비수");
		mp[8] = new Players("N.오타멘디",0,84,"수비수");
		mp[9] = new Players("K.워커",0,83,"수비수");
		mp[10] = new Players("에데르송",0,83,"골키퍼");
	}
	void teamInfo() {
		System.out.println("============"+name+"============");
		System.out.println("\t평균스탯 : "+playerAvg());
		for(Players i : main.mcp) {
			System.out.println(i.name+"          \t"+i.stat+"\t"+i.position);
		}System.out.println();
	}
	
	int playerAvg() {
		if(a==1) {
		double sum=0;
		for(Players p : main.mcp) {
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
