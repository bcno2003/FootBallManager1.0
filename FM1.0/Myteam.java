package fm;

import java.util.ArrayList;

public class Myteam {
	Football_main main = new Football_main();
	Ingame ig = new Ingame();
	Players[] mp = new Players[11];
	Market mk = new Market();
	String mtname;
	static int id;
	
	
	int stat;
	
	
	//										MyTeam을 선정하고 생성한는 메소드
	void genTeam(int ch) {
		if(ch==1) {
			this.mp = main.anp;
			this.mtname="My_Team_(아스널)";
			}
		else if(ch==2){
			this.mp = main.bcnp;
			this.mtname="My_Team_(바르샤)";
			}
		else if(ch==3){
			this.mp = main.csp;
			this.mtname="My_Team_(첼시)";
			}
		else if(ch==4){
			this.mp = main.lpp;
			this.mtname="My_Team_(리버풀)";
			}
		else if(ch==5){
			this.mp = main.mup;
			this.mtname="My_Team_(맨유)";
			}
		else if(ch==6){
			this.mp = main.mcp;
			this.mtname="My_Team_(맨시티)";
			}
		else if(ch==7){
			this.mp = main.realp;
			this.mtname="My_Team_(레알)";
			}
		else{
			this.mp = main.thp;
			this.mtname="My_Team_(토트넘)";
		}
		//}
	}
	int getscore() {
		int sc=0;
		if(ig.p==0)sc=0;
		else {
			for(int i=0; i<8; i++) {
				if(main.mt.mtname.equals(ig.teamname[id]))break;
				id++;
			}
			sc = ig.teamscore[id];
			id=0;
		}
		return sc;
	}
	int getrank() {
		int rk=0;
		if(ig.p==0)rk=0;
		else {
			ig.rank();
			for(int i=0; i<8; i++) {
				if(main.mt.mtname.equals(ig.teamname[id]))break;
				id++;
			}
			rk = ig.ranking[id];
			id=0;
		}
		return rk;
	}
	void teamInfo() {
		int j= 1;
		System.out.println("============"+main.mt.mtname+"============");
		System.out.println();
		System.out.println("평균스탯 : "+playerAvg()+"\t자금 : "+main.cash+"\t승점 : " + getscore()+"\t순위 : "+(getrank()+1));
		//여기다가 승점, 순위 현재 캐쉬 정보 띄움
		
		System.out.println();
		for(Players i : main.mtp) {
			System.out.println(j+")"+i.name+"+"+i.grade+"          \t"+i.stat+"\t"+i.position);
			j++;
		}System.out.println();
		System.out.println();
	}
	
	int playerAvg() {
		double sum=0;
		for(Players p : main.mtp) {
			sum += p.stat;
		}
		stat = (int)sum/11;
		//this.tstat = Math.round(this.tstat*100d) / 100d;
		return stat;
	}
	

}
