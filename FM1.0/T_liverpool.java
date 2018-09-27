package fm;

import java.util.*;

public class T_liverpool {
	Football_main main = new Football_main();
	ArrayList<String> players = new ArrayList<String>();
	Players[] mp = new Players[11];
	String name = "리버풀";
	int stat;
	static int a =0;
	
	//초기 선수 설정 해놓고 나중에 이적시장이나 포지션 변경할때 선수간 이동 가능하도록
	//그리고 후보선수명단도 따로 만들어야됨? -일단 이건 패스
	
	
	void genPlayers() {
		mp[0] = new Players("S.마네",0,84 ,"공격수");
		mp[1] = new Players( "R.피르미누",0,83 ,"공격수");
		mp[2] = new Players("M.살라",0,83 ,"공격수");
		mp[3] = new Players("A.랠리나",0,83 ,"미드필더");
		mp[4] = new Players("J.헨더슨",0,82 ,"미드필더");
		mp[5] = new Players( "G.바이날둠",0,82 ,"미드필더");
		mp[6] = new Players( "J.마티프",0,83 ,"수비수");
		mp[7] = new Players("N.클라인",0,81 ,"수비수");
		mp[8] = new Players("D.로브렌",0,81 ,"수비수");
		mp[9] = new Players("J.밀너",0,80 ,"수비수");
		mp[10] = new Players("s.미뇰레",0,81 ,"골키퍼");
	}
	void teamInfo() {
		System.out.println("============"+name+"============");
		System.out.println("\t평균스탯 : "+playerAvg());
		for(Players i : main.lpp) {
			System.out.println(i.name+"          \t"+i.stat+"\t"+i.position);
		}System.out.println();
	}
	
	int playerAvg() {
		if(a==1) {
		double sum=0;
		for(Players p : main.lpp) {
			sum += p.stat;
		}
		stat = (int)sum/11;
		//this.tstat = Math.round(this.tstat*100d) / 100d;
		return stat;}
		else {
			a++;
			return 82;
		}
	}
	/*void tname() {
		this.tname = 
	}*/

}
