package fm;

import java.util.ArrayList;

public class T_tottenham {
	Football_main main = new Football_main();
	ArrayList<String> players = new ArrayList<String>();
	Players[] mp = new Players[11];
	String name = "토트넘";
	int stat;
	static int a =0;
	
	//초기 선수 설정 해놓고 나중에 이적시장이나 포지션 변경할때 선수간 이동 가능하도록
	//그리고 후보선수명단도 따로 만들어야됨? -일단 이건 패스
	
	
	void genPlayers() {
		mp[0] = new Players( "H.케인",0,86,"공격수");
		mp[1] = new Players( "C.에릭센",0,87,"미드필더");
		mp[2] = new Players( "D.알리",0,84,"미드필더");
		mp[3] = new Players( "M.뎀벨레",0,82,"미드필더");
		mp[4] = new Players("V.완야마",0,82,"미드필더");
		mp[5] = new Players("손흥민",0,82,"미드필더");
		mp[6] = new Players( "T.알더웨이럴트",0,86,"수비수");
		mp[7] = new Players("J.베르통언",0,85,"수비수");
		mp[8] = new Players( "E.다이어",0,82,"수비수");
		mp[9] = new Players("D.로즈",0,82,"수비수");
		mp[10] = new Players( "H.요리스",0,88,"골키퍼");
	}
	void teamInfo() {
		System.out.println("============"+name+"============");
		System.out.println("\t평균스탯 : "+playerAvg());
		for(Players i : main.thp) {
			System.out.println(i.name+"          \t"+i.stat+"\t"+i.position);
		}System.out.println();
	}
	
	int playerAvg() {
		if(a==1) {
		double sum=0;
		for(Players p : main.thp) {
			sum += p.stat;
		}
		stat = (int)sum/11;
		//this.tstat = Math.round(this.tstat*100d) / 100d;
		return stat;}
		else {
			a++;
			return 84;
		}
	}

}
