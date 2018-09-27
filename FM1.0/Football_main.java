package fm;

import java.util.*;

public class Football_main {
	static int ch;
	static int cash=5000;
	
	static int mta;
	static int bcna;
	static int ana;
	static int csa;
	static int lpa;
	static int mua;
	static int mca;
	static int reala;
	static int tha;
	
	static Players[] mtp;
	static Players[] bcnp;
	static Players[] anp;
	static Players[] csp;
	static Players[] lpp;
	static Players[] mup;
	static Players[] mcp;
	static Players[] realp;
	static Players[] thp;
	static Myteam mt = new Myteam();
	public static void main(String[] args) {
		Football_main main = new Football_main();
		T_arsenal an = new T_arsenal();
		T_barcelona bcn = new T_barcelona();
		T_chelsea cs = new T_chelsea();
		T_liverpool lp = new T_liverpool();
		T_manche mu = new T_manche();
		T_mancity mc = new T_mancity();
		T_real real = new T_real();
		T_tottenham th = new T_tottenham();
		bcn.genPlayers();
		an.genPlayers();
		cs.genPlayers();
		lp.genPlayers();
		mu.genPlayers();
		mc.genPlayers();
		real.genPlayers();
		th.genPlayers();
		
		bcnp = bcn.mp;
		anp = an.mp;
		csp = cs.mp;
		lpp = lp.mp;
		mup = mu.mp;
		mcp = mc.mp;
		realp = real.mp;
		thp = th.mp;
		
		bcna = bcn.playerAvg();
		ana = an.playerAvg();
		csa = cs.playerAvg();
		lpa = lp.playerAvg();
		mua = mu.playerAvg();
		mca = mc.playerAvg();
		reala = real.playerAvg();
		tha = th.playerAvg();
		
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);
		Market mk = new Market();
		Players pl = new Players("",0,0,"");
		//int mt;
		
		System.out.println("Foot-Ball Manager");
		System.out.println("-------------------");
		System.out.println("팀 생성");
		System.out.println("초기 플레이 하실 팀을 골라주세요.");
		int i=0;
		/*for(Team team : teams){
			System.out.println(++i+". "+team.tname+"   팀스텟: "+team.stat);
		}*/
		//T_mancity mc = new T_mancity();
		Team t2 = new Team();
		//mc.genPlayers();
		t2.tname();
		t2.tstat();
		for(i=0; i<t2.name.length; i++) {
			System.out.println(i+1+"."+t2.name[i]+"\t\t 팀스탯 : "+t2.stat[i]);
		}
		System.out.print("선택 > ");
		main.ch = sc.nextInt();
		mt.genTeam(main.ch);
		mtp = mt.mp;
		//Myteam mt = new Myteam(choice);
		Ingame ig = new Ingame();
		
		System.out.println();
		int choice;
		System.out.println("--------------게임을 시작합니다.");
		System.out.println();
		for(;;) {
		menu.menu();
			choice = sc.nextInt();
			System.out.println();
			System.out.println();
			System.out.println();
			switch(choice) {
			case 1 : 
				if(choice==1) {
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println("========팀 정보========");
					mt.teamInfo();
				}
				break;
			case 2 :
				mk.transfer();
				break;
			case 3 :
				ig.gameplay();
				break;
			case 4 :
				/*allplayer();*/
				pl.PlayersList(main.ch);
				break;
			case 5:
				ig.Rank();break;
			case 6 : 
				System.out.println("정말 종료 하시겠습니까? (y,n)");
				System.out.print("선택 >>");
				String end = sc.next();
				if(end.equals("y")) {
					System.out.println("Foot-Ball_Manager 를 종료 합니다.");
					System.exit(0);
				}else {
					System.out.println("종료를 취소했습니다.");
					System.out.println();
				}
			}
		}

	}

}
