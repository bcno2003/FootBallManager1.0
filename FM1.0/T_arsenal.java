package fm;

import java.util.ArrayList;

public class T_arsenal {
	Football_main main = new Football_main();
	ArrayList<String> players = new ArrayList<String>();
	Players[] mp = new Players[11];
	String name = "아스널";
	int stat;
	static int a=0;
	
	//초기 선수 설정 해놓고 나중에 이적시장이나 포지션 변경할때 선수간 이동 가능하도록
	//그리고 후보선수명단도 따로 만들어야됨? -일단 이건 패스
	
	
	void genPlayers() {
		mp[0] = new Players("A.라카제트",0,82,"공격수");
		mp[1] = new Players( "O.지루",0,81,"공격수");
		mp[2] = new Players("D.웰벡",0,74,"공격수");
		mp[3] = new Players("A.산체스",0,89,"미드필더");
		mp[4] = new Players("M.외질",0,86,"미드필더");
		mp[5] = new Players( "산티 카소를라",0,85,"미드필더");
		mp[6] = new Players( "L.코시엘니",0,85,"수비수");
		mp[7] = new Players("엑토르베예린",0,83,"수비수");
		mp[8] = new Players("P.메르데사커",0,75,"수비수");
		mp[9] = new Players("S.무스타피",0,85,"수비수");
		mp[10] = new Players("P.체흐",0,90,"골키퍼");
	}
	
	void teamInfo() {
		System.out.println("============"+name+"============");
		System.out.println("\t평균스탯 : "+playerAvg());
		for(Players i : main.anp) {
			System.out.println(i.name+"          \t"+i.stat+"\t"+i.position);
		}System.out.println();
	}
	
	
	int playerAvg() {
		double sum=0;
		for(Players p : main.anp) {
			sum += p.stat;
		}
		stat = (int)sum/11;
		//this.tstat = Math.round(this.tstat*100d) / 100d;
		return stat;
	}

}
