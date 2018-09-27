package fm;

import java.util.*;

import fm.score;

public class Ingame extends Football_main{
	static int machenum = 14;	//한 시즌동안의 경기 수
	static int years = 1;		//시즌
	static int a=0;
	static Team t2 = new Team();
	static Football_main main = new Football_main();
	static Myteam mt = new Myteam();
	static T_arsenal an = new T_arsenal();
	static T_barcelona bcn = new T_barcelona();
	static T_chelsea cs = new T_chelsea();
	static T_liverpool lp = new T_liverpool();
	static T_manche mu = new T_manche();
	static T_mancity mc = new T_mancity();
	static T_real real = new T_real();
	static T_tottenham th = new T_tottenham();
	static String tn[] = new String[8];
	static int rk[] = new int[8];
	static int ts[] = new int[8];
	static int ranking[] =new int[8];
	static int win[] = new int [8];
	static int lose[] = new int [8];
	static int draw[] = new int [8];
	static int w[] = new int [8];
	static int l[] = new int [8];
	static int d[] = new int [8];
	static int p = 0;	//맨처음 팀정보 눌렀을때 되게하려고
	
	
	static int[] matching = {									//선수단 스탯 변경되었을 시 적용 가능하도록 그때마다 팀스탯 재설정 하는 메소드 생성해야함.
			main.ana,//Arsenaltamstat;	//"아스날팀스텟"
			main.bcna,//Barcelonateamstat; //"바르셀로나팀스텟"
			main.csa,//Chelseateamstat;	//"첼시팀스텟"
			main.lpa,//RPteamstat;		//"리버풀팀스텟"
			main.mua,//MUteamstat;		//"맨유팀스텟"
			main.mca,//MCteamstat;		//"맨시티팀스텟"
			main.reala,//RMteamstat;		//"레알팀스텟"
			main.tha//Tottenhamteamstat;	//"토트넘팀스텟"
	};
	
	
	static String[] teamname = {
			"아     스     날",
			"바 르 셀 로 나",
			"첼	시",
			"리     버     풀",
			"맨	유",
			"맨     시     티",
			"레알  마드리드",
			"토     트     넘"
	};
	
	static int[] teamscore = {
			0,0,0,0,0,0,0,0
	};
	
	//static int totalmoney = 0; //구단의 초기자금 (미정)
	//구단 초기자금은 main에 있다.
	
	public static void gameplay() {
		//Football_main main = new Football_main();
		
		//내가 고른 팀은 myteam이라고 수정하는 코드
		if(a==0) {a++;
			for(int i=0; i<8; i++) {
				if(main.ch==i+1)teamname[i]=main.mt.mtname;
			}
		}
		
		if(machenum==0) { //한시즌은 14경기로 이루어져있다
			rank();
			System.out.println("시즌이 끝났습니다. 랭킹로 이동하여 시즌성적을 확인해주시길 바랍니다");
			System.out.println();
			System.out.println(years + "번째 " +"시즌 결산");
			System.out.println();
			replace();
		
			System.out.println();
			System.out.println("----------"+years + "번째 " +"시즌 결산"+"----------");
			System.out.println();
				for(int i = 0; i<8; i++) {
					System.out.println((rk[i]+1) + "위\t" + "   " + tn[i] + "\t" + "승점" + "   " + ts[i] + "점  " + w[i] + "승" + l[i] + "패" + d[i] + "무");
				}
			System.out.println();
			main.cash += 3000;
			System.out.println("시즌 마무리 상금으로 3000이 지급됩니다.");
			
			for(int i = 0; i<8; i++) {
				if(main.mt.mtname.equals(teamname[i])) {
					if(ranking[i]+1 == 1) {
						main.cash += 5000;
					}
					else if(ranking[i]+1 == 2) {
						main.cash += 3000;
					}
					else if(ranking[i]+1 == 3) {
						main.cash += 1500;
					}
					else {
						
					}
				}
				win[i] = 0;
				lose[i] = 0;
				draw[i] = 0;
				
			}
			System.out.println("시즌 순위 보상입니다 순위보상은 1등 5000, 2등 3000, 3등 1500이 추가됩니다");
			
			
			System.out.println("시즌 결산을 종료하시려면 y를 눌러주십시요");
			Scanner scan = new Scanner(System.in);
			String agree=scan.next();
			for(;;) {
				if(agree.equals("y") || agree.equals("Y")) {
					for(int i = 0; i<8 ; i++) {
						teamscore[i] = 0;
						ranking[i] = 0;
					}
					break;
				}
				else {
					System.out.println("잘못입력하셨습니다");
					System.out.println();
					System.out.println("시즌 결산을 종료하시려면 y를 눌러주십시요");
				}
			}
		
		years += 1;
		machenum = 14;
			
			
		}
		else {
		machenum--; //경기수를 카운트한다
		
		//승점은 한경기당   승리시 3점, 패배시 0점, 무승부는 각 1점씩분배 
		System.out.println("-------------경기일정--------------");
		System.out.println(teamname[0] + "\t VS \t" + teamname[1]);
		System.out.println();
		System.out.println(teamname[2] + "\t VS \t" + teamname[3]);
		System.out.println();
		System.out.println(teamname[4] + "\t VS \t" + teamname[5]);
		System.out.println();
		System.out.println(teamname[6] + "\t VS \t" + teamname[7]);
		System.out.println();
		System.out.println();
		
		System.out.println("경기를 진행합니까? Y/N");
		Scanner scan = new Scanner(System.in);
		String agree=scan.next();
		
		
		if(agree.equals("y") || agree.equals("Y")) {
			System.out.println();
			System.out.println("-------------경기결과--------------");
			
			if(matching[0]>matching[1]) {
				if(matching[0]-matching[1]<=2) {
					if(new Random().nextInt(100) < 45){ //내팀 스텟이 상대스텟보다 높으면 승률 45퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[0] +  "(이)가 승리했습니다 / " + teamname[1] + "(은)는 패배했습니다");
						System.out.println(matching[0]+"\t"+matching[1]);
						teamscore[0] += 3;
						if(main.mt.mtname.equals(teamname[0])) main.cash+=300;
						win[0] += 1;
						lose[1] += 1;
					}
					
					else if(new Random().nextInt(100) > 73){ //상대팀의 승률 약 40퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[1] + "(이)가 승리했습니다 / " + teamname[0] + "(은)는 패배했습니다");
						teamscore[1] += 3;
						if(main.mt.mtname.equals(teamname[1])) main.cash+=300;
						win[1] += 1;
						lose[0] += 1;
					}
					
					else {	//무승부 약 15퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[0] + ", " + teamname[1] + "(은)는 비겼습니다");
						teamscore[0] += 1;
						teamscore[1] += 1;
						if(main.mt.mtname.equals(teamname[0])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[1])) main.cash+=150;
						draw[0] += 1;
						draw[1] += 1;
					}
				}
				
				else if (matching[0]-matching[1]<=5) {
					if(new Random().nextInt(100) < 60){ //내팀 스텟이 상대스텟보다 높으면 승률 60퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[0] +  "(이)가 승리했습니다 / " + teamname[1] + "(은)는 패배했습니다");
						teamscore[0] += 3; 
						if(main.mt.mtname.equals(teamname[0])) main.cash+=300;
						win[0] += 1;
						lose[1] += 1;
					}
					
					else if(new Random().nextInt(100) > 90){ //상대팀의 승률 36퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[1] + "(이)가 승리했습니다 / " + teamname[0] + "(은)는 패배했습니다");
						teamscore[1] += 3;
						if(main.mt.mtname.equals(teamname[1])) main.cash+=300;
						win[1] += 1;
						lose[0] += 1;
					}
					
					else {	//무승부 14퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[0] + ", " + teamname[1] + "(은)는 비겼습니다");
						teamscore[0] += 1;
						teamscore[1] += 1;
						if(main.mt.mtname.equals(teamname[0])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[1])) main.cash+=150;
						draw[0] += 1;
						draw[1] += 1;
					}
				}
				
				else {
					if(new Random().nextInt(100) < 80){ //내팀 스텟이 상대스텟보다 높으면 승률 80퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[0] +  "(이)가 승리했습니다 / " + teamname[1] + "(은)는 패배했습니다");
						teamscore[0] += 3; 
						if(main.mt.mtname.equals(teamname[0])) main.cash+=300;
						win[0] += 1;
						lose[1] += 1;
					}
					
					else if(new Random().nextInt(100) > 80){ //상대팀의 승률 약 15퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[1] + "(이)가 승리했습니다 / " + teamname[0] + "(은)는 패배했습니다");
						teamscore[1] += 3;
						if(main.mt.mtname.equals(teamname[1])) main.cash+=300;
						win[1] += 1;
						lose[0] += 1;
					}
					
					else {	//무승부 약 5퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[0] + ", " + teamname[1] + "(은)는 비겼습니다");
						teamscore[0] += 1;
						teamscore[1] += 1;
						if(main.mt.mtname.equals(teamname[0])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[1])) main.cash+=150;
						draw[0] +=1;
						draw[1] +=1;
					}
				}
			}
			
			else if(matching[0]<matching[1]) {
				if(matching[1]-matching[0]<=2) {
					if(new Random().nextInt(100) < 45){ //내팀 스텟이 상대스텟보다 높으면 승률 45퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[1] +  "(이)가 승리했습니다 / " + teamname[0] + "(은)는 패배했습니다");
						teamscore[1] += 3; 
						if(main.mt.mtname.equals(teamname[1])) main.cash+=300;
						win[1] += 1;
						lose[0] += 1;
					}
					
					else if(new Random().nextInt(100) > 73){ //상대팀의 승률 약 40퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[0] + "(이)가 승리했습니다 / " + teamname[1] + "(은)는 패배했습니다");
						teamscore[0] += 3;
						if(main.mt.mtname.equals(teamname[0])) main.cash+=300;
						win[0] += 1;
						lose[1] += 1;
					}
					
					else {	//무승부 약 15퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[0] + ", " + teamname[1] + "(은)는 비겼습니다");
						teamscore[0] += 1;
						teamscore[1] += 1;
						if(main.mt.mtname.equals(teamname[0])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[1])) main.cash+=150;
						draw[0] += 1;
						draw[1] += 1;
					}
				}
				
				else if (matching[1]-matching[0]<=5) {
					if(new Random().nextInt(100) < 60){ //내팀 스텟이 상대스텟보다 높으면 승률 60퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[1] +  "(이)가 승리했습니다 / " + teamname[0] + "(은)는 패배했습니다");
						teamscore[1] += 3; 
						if(main.mt.mtname.equals(teamname[1])) main.cash+=300;
						win[1] += 1;
						lose[0] += 1;

					}
					
					else if(new Random().nextInt(100) > 90){ //상대팀의 승률 36퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[0] + "(이)가 승리했습니다 / " + teamname[1] + "(은)는 패배했습니다");
						teamscore[0] += 3;
						if(main.mt.mtname.equals(teamname[0])) main.cash+=300;
						win[0] += 1;
						lose[1] += 1;

					}
					
					else {	//무승부 14퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[0] + ", " + teamname[1] + "(은)는 비겼습니다");
						teamscore[0] += 1;
						teamscore[1] += 1;
						if(main.mt.mtname.equals(teamname[0])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[1])) main.cash+=150;
						draw[0] += 1;
						draw[1] += 1;
					}
				}
				
				else {
					if(new Random().nextInt(100) < 80){ //내팀 스텟이 상대스텟보다 높으면 승률 80퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[1] +  "(이)가 승리했습니다 / " + teamname[0] + "(은)는 패배했습니다");
						teamscore[1] += 3; 
						if(main.mt.mtname.equals(teamname[1])) main.cash+=300;
						win[1] += 1;
						lose[0] += 1;

					}
					
					else if(new Random().nextInt(100) > 80){ //상대팀의 승률 약 15퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[0] + "(이)가 승리했습니다 / " + teamname[1] + "(은)는 패배했습니다");
						teamscore[0] += 3;
						if(main.mt.mtname.equals(teamname[0])) main.cash+=300;
						win[0] += 1;
						lose[1] += 1;

					}
					
					else {	//무승부 약 5퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[0] + ", " + teamname[1] + "(은)는 비겼습니다");
						teamscore[0] += 1;
						teamscore[1] += 1;
						if(main.mt.mtname.equals(teamname[0])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[1])) main.cash+=150;
						draw[0] += 1;
						draw[1] += 1;
					}
				}
			}
			
			
			else {
				
				if(new Random().nextInt(100) < 40){ //내팀 스텟이 상대스텟보다 높으면 승률 40퍼센트
					score sc = new score();
					sc.score1();
					System.out.println(teamname[0] +  "(이)가 승리했습니다 / " + teamname[1] + "(은)는 패배했습니다");
					teamscore[0] += 3; 
					if(main.mt.mtname.equals(teamname[0])) main.cash+=300;
					win[0] += 1;
					lose[1] += 1;

				}
				
				else if(new Random().nextInt(100) < 68){ //상대팀의 승률 약 40퍼센트
					score sc = new score();
					sc.score1();
					System.out.println(teamname[1] + "(이)가 승리했습니다 / " + teamname[0] + "(은)는 패배했습니다");
					teamscore[1] += 3;
					if(main.mt.mtname.equals(teamname[1])) main.cash+=300;
					win[1] += 1;
					lose[0] += 1;

				}
				
				else {	//무승부 약 20퍼센트
					score sc = new score();
					sc.score2();
					System.out.println(teamname[0] + ", " + teamname[1] + "(은)는 비겼습니다");
					teamscore[0] += 1;
					teamscore[1] += 1;
					if(main.mt.mtname.equals(teamname[0])) main.cash+=150;
					if(main.mt.mtname.equals(teamname[1])) main.cash+=150;
					draw[0] += 1;
					draw[1] += 1;
				}
			}

			
			if(matching[2]>matching[4]) {
				
				if(matching[2]-matching[4]<=2) {
					if(new Random().nextInt(100) < 45){ //내팀 스텟이 상대스텟보다 높으면 승률 45퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[2] +  "(이)가 승리했습니다 / " + teamname[4] + "(은)는 패배했습니다");
						teamscore[2] += 3; 
						if(main.mt.mtname.equals(teamname[2])) main.cash+=300;
						win[2] += 1;
						lose[4] += 1;

					}
					
					else if(new Random().nextInt(100) > 73){ //상대팀의 승률 약 40퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[4] + "(이)가 승리했습니다 / " + teamname[2] + "(은)는 패배했습니다");
						teamscore[4] += 3;
						if(main.mt.mtname.equals(teamname[4])) main.cash+=300;
						win[4] += 1;
						lose[2] += 1;

					}
					
					else {	//무승부 약 15퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[2] + ", " + teamname[4] + "(은)는 비겼습니다");
						teamscore[2] += 1;
						teamscore[4] += 1;
						if(main.mt.mtname.equals(teamname[2])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[4])) main.cash+=150;
						draw[2] += 1;
						draw[4] += 1;
					}
				}
				
				else if (matching[2]-matching[4]<=5) {
					if(new Random().nextInt(100) < 60){ //내팀 스텟이 상대스텟보다 높으면 승률 60퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[2] +  "(이)가 승리했습니다 / " + teamname[4] + "(은)는 패배했습니다");
						teamscore[2] += 3; 
						if(main.mt.mtname.equals(teamname[2])) main.cash+=300;
						win[2] += 1;
						lose[4] += 1;

					}
					
					else if(new Random().nextInt(100) > 90){ //상대팀의 승률 36퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[4] + "(이)가 승리했습니다 / " + teamname[2] + "(은)는 패배했습니다");
						teamscore[4] += 3;
						if(main.mt.mtname.equals(teamname[4])) main.cash+=300;
						win[4] += 1;
						lose[2] += 1;

					}
					
					else {	//무승부 14퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[2] + ", " + teamname[4] + "(은)는 비겼습니다");
						teamscore[2] += 1;
						teamscore[4] += 1;
						if(main.mt.mtname.equals(teamname[2])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[4])) main.cash+=150;
						draw[2] += 1;
						draw[4] += 1;
						

					}
				}
				
				else {
					if(new Random().nextInt(100) < 80){ //내팀 스텟이 상대스텟보다 높으면 승률 80퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[2] +  "(이)가 승리했습니다 / " + teamname[4] + "(은)는 패배했습니다");
						teamscore[2] += 3; 
						if(main.mt.mtname.equals(teamname[2])) main.cash+=300;
						win[2] += 1;
						lose[4] += 1;

					}
					
					else if(new Random().nextInt(100) > 80){ //상대팀의 승률 약 15퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[4] + "(이)가 승리했습니다 / " + teamname[2] + "(은)는 패배했습니다");
						teamscore[4] += 3;
						if(main.mt.mtname.equals(teamname[4])) main.cash+=300;
						win[4] += 1;
						lose[2] += 1;

					}
					
					else {	//무승부 약 5퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[2] + ", " + teamname[4] + "(은)는 비겼습니다");
						teamscore[2] += 1;
						teamscore[4] += 1;
						if(main.mt.mtname.equals(teamname[2])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[4])) main.cash+=150;
						draw[2] += 1;
						draw[4] += 1;
					}
				}
			}
			
			else if(matching[2]<matching[4]) {
				
				if(matching[4]-matching[2]<=2) {
					if(new Random().nextInt(100) < 45){ //내팀 스텟이 상대스텟보다 높으면 승률 45퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[4] +  "(이)가 승리했습니다 / " + teamname[2] + "(은)는 패배했습니다");
						teamscore[4] += 3; 
						if(main.mt.mtname.equals(teamname[4])) main.cash+=300;
						win[4] += 1;
						lose[2] += 1;

					}
					
					else if(new Random().nextInt(100) > 73){ //상대팀의 승률 약 40퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[2] + "(이)가 승리했습니다 / " + teamname[4] + "(은)는 패배했습니다");
						teamscore[2] += 3;
						if(main.mt.mtname.equals(teamname[2])) main.cash+=300;
						win[2] += 1;
						lose[4] += 1;

					}
					
					else {	//무승부 약 15퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[2] + ", " + teamname[4] + "(은)는 비겼습니다");
						teamscore[2] += 1;
						teamscore[4] += 1;
						if(main.mt.mtname.equals(teamname[2])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[4])) main.cash+=150;
						draw[2] += 1;
						draw[4] += 1;
					}
				}
				
				else if (matching[4]-matching[2]<=5) {
					if(new Random().nextInt(100) < 60){ //내팀 스텟이 상대스텟보다 높으면 승률 60퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[4] +  "(이)가 승리했습니다 / " + teamname[2] + "(은)는 패배했습니다");
						teamscore[4] += 3; 
						if(main.mt.mtname.equals(teamname[4])) main.cash+=300;
						win[4] += 1;
						lose[2] += 1;

					}
					
					else if(new Random().nextInt(100) > 90){ //상대팀의 승률 36퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[2] + "(이)가 승리했습니다 / " + teamname[4] + "(은)는 패배했습니다");
						teamscore[2] += 3;
						if(main.mt.mtname.equals(teamname[2])) main.cash+=300;
						win[2] += 1;
						lose[4] += 1;

					}
					
					else {	//무승부 14퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[2] + ", " + teamname[4] + "(은)는 비겼습니다");
						teamscore[2] += 1;
						teamscore[4] += 1;
						if(main.mt.mtname.equals(teamname[2])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[4])) main.cash+=150;
						draw[2] += 1;
						draw[4] += 1;
					}
				}
				
				else {
					if(new Random().nextInt(100) < 80){ //내팀 스텟이 상대스텟보다 높으면 승률 80퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[4] +  "(이)가 승리했습니다 / " + teamname[2] + "(은)는 패배했습니다");
						teamscore[4] += 3; 
						if(main.mt.mtname.equals(teamname[4])) main.cash+=300;
						win[4] += 1;
						lose[2] += 1;

					}
					
					else if(new Random().nextInt(100) > 80){ //상대팀의 승률 약 15퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[2] + "(이)가 승리했습니다 / " + teamname[4] + "(은)는 패배했습니다");
						teamscore[2] += 3;
						if(main.mt.mtname.equals(teamname[2])) main.cash+=300;
						win[2] += 1;
						lose[4] += 1;

					}
					
					else {	//무승부 약 5퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[2] + ", " + teamname[4] + "(은)는 비겼습니다");
						teamscore[2] += 1;
						teamscore[4] += 1;
						if(main.mt.mtname.equals(teamname[2])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[4])) main.cash+=150;
						draw[2] += 1;
						draw[4] += 1;
					}
				}
			}
			
			else {
				
				if(new Random().nextInt(100) < 40){ //내팀 스텟이 상대스텟보다 높으면 승률 40퍼센트
					score sc = new score();
					sc.score1();
					System.out.println(teamname[2] +  "(이)가 승리했습니다 / " + teamname[4] + "(은)는 패배했습니다");
					teamscore[2] += 3; 
					if(main.mt.mtname.equals(teamname[2])) main.cash+=300;
					win[2] += 1;
					lose[4] += 1;

				}
				
				else if(new Random().nextInt(100) < 68){ //상대팀의 승률 약 40퍼센트
					score sc = new score();
					sc.score1();
					System.out.println(teamname[4] + "(이)가 승리했습니다 / " + teamname[2] + "(은)는 패배했습니다");
					teamscore[4] += 3;
					if(main.mt.mtname.equals(teamname[4])) main.cash+=300;
					win[4] += 1;
					lose[2] += 1;

				}
				
				else {	//무승부 약 20퍼센트
					score sc = new score();
					sc.score2();
					System.out.println(teamname[2] + ", " + teamname[4] + "(은)는 비겼습니다");
					teamscore[2] += 1;
					teamscore[4] += 1;
					if(main.mt.mtname.equals(teamname[2])) main.cash+=150;
					if(main.mt.mtname.equals(teamname[4])) main.cash+=150;
					draw[2] += 1;
					draw[4] += 1;
				}
			}
			
			if(matching[3]>matching[7]) {
				
				if(matching[3]-matching[7]<=2) {
					if(new Random().nextInt(100) < 45){ //내팀 스텟이 상대스텟보다 높으면 승률 45퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[3] +  "(이)가 승리했습니다 / " + teamname[7] + "(은)는 패배했습니다");
						teamscore[3] += 3; 
						if(main.mt.mtname.equals(teamname[3])) main.cash+=300;
						win[3] += 1;
						lose[7] += 1;

					}
					
					else if(new Random().nextInt(100) > 73){ //상대팀의 승률 약 40퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[7] + "(이)가 승리했습니다 / " + teamname[3] + "(은)는 패배했습니다");
						teamscore[7] += 3;
						if(main.mt.mtname.equals(teamname[7])) main.cash+=300;
						win[7] += 1;
						lose[3] += 1;

					}
					
					else {	//무승부 약 15퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[3] + ", " + teamname[7] + "(은)는 비겼습니다");
						teamscore[3] += 1;
						teamscore[7] += 1;
						if(main.mt.mtname.equals(teamname[3])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[7])) main.cash+=150;
						draw[3] += 1;
						draw[7] += 1;
					}
				}
				
				else if (matching[3]-matching[7]<=5) {
					if(new Random().nextInt(100) < 60){ //내팀 스텟이 상대스텟보다 높으면 승률 60퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[3] +  "(이)가 승리했습니다 / " + teamname[7] + "(은)는 패배했습니다");
						teamscore[3] += 3; 
						if(main.mt.mtname.equals(teamname[3])) main.cash+=300;
						win[3] += 1;
						lose[7] += 1;

					}
					
					else if(new Random().nextInt(100) > 90){ //상대팀의 승률 36퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[7] + "(이)가 승리했습니다 / " + teamname[3] + "(은)는 패배했습니다");
						teamscore[7] += 3;
						if(main.mt.mtname.equals(teamname[7])) main.cash+=300;
						win[7] += 1;
						lose[3] += 1;

					}
					
					else {	//무승부 14퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[3] + ", " + teamname[7] + "(은)는 비겼습니다");
						teamscore[3] += 1;
						teamscore[7] += 1;
						if(main.mt.mtname.equals(teamname[3])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[7])) main.cash+=150;
						draw[3] += 1;
						draw[7] += 1;
					}
				}
				
				else {
					if(new Random().nextInt(100) < 80){ //내팀 스텟이 상대스텟보다 높으면 승률 80퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[3] +  "(이)가 승리했습니다 / " + teamname[7] + "(은)는 패배했습니다");
						teamscore[3] += 3; 
						if(main.mt.mtname.equals(teamname[3])) main.cash+=300;
						win[3] += 1;
						lose[7] += 1;

					}
					
					else if(new Random().nextInt(100) > 80){ //상대팀의 승률 약 15퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[7] + "(이)가 승리했습니다 / " + teamname[3] + "(은)는 패배했습니다");
						teamscore[7] += 3;
						if(main.mt.mtname.equals(teamname[7])) main.cash+=300;
						win[7] += 1;
						lose[3] += 1;

					}
					
					else {	//무승부 약 5퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[3] + ", " + teamname[7] + "(은)는 비겼습니다");
						teamscore[3] += 1;
						teamscore[7] += 1;
						if(main.mt.mtname.equals(teamname[3])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[7])) main.cash+=150;
						draw[3] += 1;
						draw[7] += 1;
					}
				}
			}
			
			else if(matching[3]<matching[7]) {
				
				if(matching[7]-matching[3]<=2) {
					if(new Random().nextInt(100) < 45){ //내팀 스텟이 상대스텟보다 높으면 승률 45퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[7] +  "(이)가 승리했습니다 / " + teamname[3] + "(은)는 패배했습니다");
						teamscore[7] += 3; 
						if(main.mt.mtname.equals(teamname[7])) main.cash+=300;
						win[7] += 1;
						lose[3] += 1;

					}
					
					else if(new Random().nextInt(100) > 73){ //상대팀의 승률 약 40퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[3] + "(이)가 승리했습니다 / " + teamname[7] + "(은)는 패배했습니다");
						teamscore[3] += 3;
						if(main.mt.mtname.equals(teamname[3])) main.cash+=300;
						win[3] += 1;
						lose[7] += 1;

					}
					
					else {	//무승부 약 15퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[3] + ", " + teamname[7] + "(은)는 비겼습니다");
						teamscore[3] += 1;
						teamscore[7] += 1;
						if(main.mt.mtname.equals(teamname[3])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[7])) main.cash+=150;
						draw[3] += 1;
						draw[7] += 1;
					}
				}
				
				else if (matching[7]-matching[3]<=5) {
					if(new Random().nextInt(100) < 60){ //내팀 스텟이 상대스텟보다 높으면 승률 60퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[7] +  "(이)가 승리했습니다 / " + teamname[3] + "(은)는 패배했습니다");
						teamscore[7] += 3; 
						if(main.mt.mtname.equals(teamname[7])) main.cash+=300;
						win[7] += 1;
						lose[3] += 1;

					}
					
					else if(new Random().nextInt(100) > 90){ //상대팀의 승률 36퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[3] + "(이)가 승리했습니다 / " + teamname[7] + "(은)는 패배했습니다");
						teamscore[3] += 3;
						if(main.mt.mtname.equals(teamname[3])) main.cash+=300;
						win[3] += 1;
						lose[7] += 1;

					}
					
					else {	//무승부 14퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[3] + ", " + teamname[7] + "(은)는 비겼습니다");
						teamscore[3] += 1;
						teamscore[7] += 1;
						if(main.mt.mtname.equals(teamname[3])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[7])) main.cash+=150;
						draw[3] += 1;
						draw[7] += 1;
					}
				}
				
				else {
					if(new Random().nextInt(100) < 80){ //내팀 스텟이 상대스텟보다 높으면 승률 80퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[7] +  "(이)가 승리했습니다 / " + teamname[3] + "(은)는 패배했습니다");
						teamscore[7] += 3; 
						if(main.mt.mtname.equals(teamname[7])) main.cash+=300;
						win[7] += 1;
						lose[3] += 1;

					}
					
					else if(new Random().nextInt(100) > 80){ //상대팀의 승률 약 15퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[3] + "(이)가 승리했습니다 / " + teamname[7] + "(은)는 패배했습니다");
						teamscore[3] += 3;
						if(main.mt.mtname.equals(teamname[3])) main.cash+=300;
						win[3] += 1;
						lose[7] += 1;

					}
					
					else {	//무승부 약 5퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[3] + ", " + teamname[7] + "(은)는 비겼습니다");
						teamscore[3] += 1;
						teamscore[7] += 1;
						if(main.mt.mtname.equals(teamname[3])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[7])) main.cash+=150;
						draw[3] += 1;
						draw[7] += 1;
					}
				}
			}
			
			else {
				
				if(new Random().nextInt(100) < 40){ //내팀 스텟이 상대스텟보다 높으면 승률 40퍼센트
					score sc = new score();
					sc.score1();
					System.out.println(teamname[3] +  "(이)가 승리했습니다 / " + teamname[7] + "(은)는 패배했습니다");
					teamscore[3] += 3; 
					if(main.mt.mtname.equals(teamname[3])) main.cash+=300;
					win[3] += 1;
					lose[7] += 1;

				}
				
				else if(new Random().nextInt(100) < 68){ //상대팀의 승률 약 40퍼센트
					score sc = new score();
					sc.score1();
					System.out.println(teamname[7] + "(이)가 승리했습니다 / " + teamname[3] + "(은)는 패배했습니다");
					teamscore[7] += 3;
					if(main.mt.mtname.equals(teamname[7])) main.cash+=300;
					win[7] += 1;
					lose[3] += 1;

				}
				
				else {	//무승부 약 20퍼센트
					score sc = new score();
					sc.score2();
					System.out.println(teamname[3] + ", " + teamname[7] + "(은)는 비겼습니다");
					teamscore[3] += 1;
					teamscore[7] += 1;
					if(main.mt.mtname.equals(teamname[3])) main.cash+=150;
					if(main.mt.mtname.equals(teamname[7])) main.cash+=150;
					draw[3] += 1;
					draw[7] += 1;
				}
			}
			
			if(matching[5]>matching[6]) {
				
				if(matching[5]-matching[6]<=2) {
					if(new Random().nextInt(100) < 45){ //내팀 스텟이 상대스텟보다 높으면 승률 45퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[5] +  "(이)가 승리했습니다 / " + teamname[6] + "(은)는 패배했습니다");
						teamscore[5] += 3; 
						if(main.mt.mtname.equals(teamname[5])) main.cash+=300;
						win[5] += 1;
						lose[6] += 1;

					}
					
					else if(new Random().nextInt(100) > 73){ //상대팀의 승률 약 40퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[6] + "(이)가 승리했습니다 / " + teamname[5] + "(은)는 패배했습니다");
						teamscore[6] += 3;
						if(main.mt.mtname.equals(teamname[6])) main.cash+=300;
						win[6] += 1;
						lose[5] += 1;

					}
					
					else {	//무승부 약 15퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[5] + ", " + teamname[6] + "(은)는 비겼습니다");
						teamscore[5] += 1;
						teamscore[6] += 1;
						if(main.mt.mtname.equals(teamname[5])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[6])) main.cash+=150;
						draw[5] += 1;
						draw[6] += 1;
					}
				}
				
				else if (matching[5]-matching[6]<=5) {
					if(new Random().nextInt(100) < 60){ //내팀 스텟이 상대스텟보다 높으면 승률 60퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[5] +  "(이)가 승리했습니다 / " + teamname[6] + "(은)는 패배했습니다");
						teamscore[5] += 3; 
						if(main.mt.mtname.equals(teamname[5])) main.cash+=300;
						win[5] += 1;
						lose[6] += 1;

					}
					
					else if(new Random().nextInt(100) > 90){ //상대팀의 승률 36퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[6] + "(이)가 승리했습니다 / " + teamname[5] + "(은)는 패배했습니다");
						teamscore[6] += 3;
						if(main.mt.mtname.equals(teamname[6])) main.cash+=300;
						win[6] += 1;
						lose[5] += 1;

					}
					
					else {	//무승부 14퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[5] + ", " + teamname[6] + "(은)는 비겼습니다");
						teamscore[5] += 1;
						teamscore[6] += 1;
						if(main.mt.mtname.equals(teamname[5])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[6])) main.cash+=150;
						draw[5] += 1;
						draw[6] += 1;
					}
				}
				
				else {
					if(new Random().nextInt(100) < 80){ //내팀 스텟이 상대스텟보다 높으면 승률 80퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[5] +  "(이)가 승리했습니다 / " + teamname[6] + "(은)는 패배했습니다");
						teamscore[5] += 3; 
						if(main.mt.mtname.equals(teamname[5])) main.cash+=300;
						win[5] += 1;
						lose[6] += 1;

					}
					
					else if(new Random().nextInt(100) > 80){ //상대팀의 승률 약 15퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[6] + "(이)가 승리했습니다 / " + teamname[5] + "(은)는 패배했습니다");
						teamscore[6] += 3;
						if(main.mt.mtname.equals(teamname[6])) main.cash+=300;
						win[6] += 1;
						lose[5] += 1;

					}
					
					else {	//무승부 약 5퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[5] + ", " + teamname[6] + "(은)는 비겼습니다");
						teamscore[5] += 1;
						teamscore[6] += 1;
						if(main.mt.mtname.equals(teamname[5])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[6])) main.cash+=150;
						draw[5] += 1;
						draw[6] += 1;
					}
				}
			}
			
			else if(matching[5]<matching[6]) {
				
				if(matching[6]-matching[5]<=2) {
					if(new Random().nextInt(100) < 45){ //내팀 스텟이 상대스텟보다 높으면 승률 45퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[6] +  "(이)가 승리했습니다 / " + teamname[5] + "(은)는 패배했습니다");
						teamscore[6] += 3; 
						if(main.mt.mtname.equals(teamname[6])) main.cash+=300;
						win[6] += 1;
						lose[5] += 1;

					}
					
					else if(new Random().nextInt(100) > 73){ //상대팀의 승률 약 40퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[5] + "(이)가 승리했습니다 / " + teamname[6] + "(은)는 패배했습니다");
						teamscore[5] += 3;
						if(main.mt.mtname.equals(teamname[5])) main.cash+=300;
						win[5] += 1;
						lose[6] += 1;

					}
					
					else {	//무승부 약 15퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[5] + ", " + teamname[6] + "(은)는 비겼습니다");
						teamscore[5] += 1;
						teamscore[6] += 1;
						if(main.mt.mtname.equals(teamname[5])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[6])) main.cash+=150;
						draw[5] += 1;
						draw[6] += 1;
					}
				}
				
				else if (matching[6]-matching[5]<=5) {
					if(new Random().nextInt(100) < 60){ //내팀 스텟이 상대스텟보다 높으면 승률 60퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[6] +  "(이)가 승리했습니다 / " + teamname[5] + "(은)는 패배했습니다");
						teamscore[6] += 3; 
						if(main.mt.mtname.equals(teamname[6])) main.cash+=300;
						win[6] += 1;
						lose[5] += 1;

					}
					
					else if(new Random().nextInt(100) > 90){ //상대팀의 승률 36퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[5] + "(이)가 승리했습니다 / " + teamname[6] + "(은)는 패배했습니다");
						teamscore[5] += 3;
						if(main.mt.mtname.equals(teamname[5])) main.cash+=300;
						win[5] += 1;
						lose[6] += 1;

					}
					
					else {	//무승부 14퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[5] + ", " + teamname[6] + "(은)는 비겼습니다");
						teamscore[5] += 1;
						teamscore[6] += 1;
						if(main.mt.mtname.equals(teamname[5])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[6])) main.cash+=150;
						draw[5] += 1;
						draw[6] += 1;
					}
				}
				
				else {
					if(new Random().nextInt(100) < 80){ //내팀 스텟이 상대스텟보다 높으면 승률 80퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[6] +  "(이)가 승리했습니다 / " + teamname[5] + "(은)는 패배했습니다");
						teamscore[6] += 3; 
						if(main.mt.mtname.equals(teamname[6])) main.cash+=300;
						win[6] += 1;
						lose[5] += 1;

					}
					
					else if(new Random().nextInt(100) > 80){ //상대팀의 승률 약 15퍼센트
						score sc = new score();
						sc.score1();
						System.out.println(teamname[5] + "(이)가 승리했습니다 / " + teamname[6] + "(은)는 패배했습니다");
						teamscore[5] += 3;
						if(main.mt.mtname.equals(teamname[5])) main.cash+=300;
						win[5] += 1;
						lose[6] += 1;

					}
					
					else {	//무승부 약 5퍼센트
						score sc = new score();
						sc.score2();
						System.out.println(teamname[5] + ", " + teamname[6] + "(은)는 비겼습니다");
						teamscore[5] += 1;
						teamscore[6] += 1;
						if(main.mt.mtname.equals(teamname[5])) main.cash+=150;
						if(main.mt.mtname.equals(teamname[6])) main.cash+=150;
						draw[5] += 1;
						draw[6] += 1;
					}
				}
			}
			
			else {
				
				if(new Random().nextInt(100) < 40){ //내팀 스텟이 상대스텟보다 높으면 승률 40퍼센트
					score sc = new score();
					sc.score1();
					System.out.println(teamname[5] +  "(이)가 승리했습니다 / " + teamname[6] + "(은)는 패배했습니다");
					teamscore[5] += 3; 
					if(main.mt.mtname.equals(teamname[5])) main.cash+=300;
					win[5] += 1;
					lose[6] += 1;

				}
				
				else if(new Random().nextInt(100) < 68){ //상대팀의 승률 약 40퍼센트
					score sc = new score();
					sc.score1();
					System.out.println(teamname[6] + "(이)가 승리했습니다 / " + teamname[5] + "(은)는 패배했습니다");
					teamscore[6] += 3;
					if(main.mt.mtname.equals(teamname[6])) main.cash+=300;
					win[6] += 1;
					lose[5] += 1;

				}
				
				else {	//무승부 약 20퍼센트
					score sc = new score();
					sc.score2();
					System.out.println(teamname[5] + ", " + teamname[6] + "(은)는 비겼습니다");
					teamscore[5] += 1;
					teamscore[6] += 1;
					if(main.mt.mtname.equals(teamname[5])) main.cash+=150;
					if(main.mt.mtname.equals(teamname[6])) main.cash+=150;
					draw[5] += 1;
					draw[6] += 1;
				}
			
				System.out.println();
			}
			int machingN = matching[1];  //다음 실행을 위해 팀 스텟을 돌림
			for(int i = 1; i<7; i++) {
				matching[i] = matching[i+1];
			} matching[7] = machingN;
			
			String teamnameN = teamname[1]; //다음 실행을 위해 팀 이름을 돌림
			for(int i = 1; i<7; i++) {
				teamname[i] = teamname[i+1];
			} teamname[7] = teamnameN;
			
			int teamscoreN = teamscore[1]; //다음 실행을 위해 팀 성적을 돌림
			for(int i = 1; i<7; i++) {
				teamscore[i] = teamscore[i+1];
			} teamscore[7] = teamscoreN;
			
			int rankingN = ranking[1];  //다음 실행을 위해 팀 랭킹을 돌림
			for(int i = 1; i<7; i++) {
				ranking[i] = ranking[i+1];
			} ranking[7] = rankingN;

			int winN = win[1];  //다음 실행을 위해 팀 랭킹을 돌림
			for(int i = 1; i<7; i++) {
				win[i] = win[i+1];
			} win[7] = winN;
			
			int loseN = lose[1];  //다음 실행을 위해 팀 랭킹을 돌림
			for(int i = 1; i<7; i++) {
				lose[i] = lose[i+1];
			} lose[7] = loseN;
			
			int drawN = draw[1];  //다음 실행을 위해 팀 랭킹을 돌림
			for(int i = 1; i<7; i++) {
				draw[i] = draw[i+1];
			} draw[7] = drawN;
			if(p==0)p++;
			
			
			
			
		}
		else if(agree.equals("n") || agree.equals("N")) {
			
		}
		else {
			System.out.println("잘못입력하셨습니다.");
		}
		}
	}
	static void Rank() {
		rank();
		replace();
	
		System.out.println();
		System.out.println("----------"+years + "번째 " +"시즌 현재 순위"+"----------");
		System.out.println();
			for(int i = 0; i<8; i++) {
				System.out.println((rk[i]+1) + "위\t" + "   " + tn[i] + "\t" + "승점" + "   " + ts[i] + "점  "+ w[i] + "승 " + l[i] + "패 " + d[i] + "무 ");
			}
		System.out.println();
		
	}
	static void rank() {
		for(int i=0; i<8; i++)ranking[i]=0; //중복계산하지 않도록 ranking 초기화
		for(int i = 0 ; i < 8 ; i++) {
			for(int j = 0 ; j < 8 ; j++){
				if(teamscore[i] < teamscore[j])
					ranking[i] = ranking[i] + 1;
			}
		}
	}
	static void replace() {
		/*tn = teamname;
		rk = ranking;
		ts = teamscore;*/
		System.arraycopy(teamname, 0, tn, 0, teamname.length);
		System.arraycopy(ranking, 0, rk, 0, ranking.length);
		System.arraycopy(teamscore, 0, ts, 0, teamscore.length);
		System.arraycopy(win, 0, w, 0, win.length);
		System.arraycopy(lose, 0, l, 0, lose.length);
		System.arraycopy(draw, 0, d, 0, draw.length);
		
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if(rk[i] <= rk[j]) {  //3 1
					int rank; //랭킹 임시저장   //1  3
					String name; //이름 임시저장
					int sc; //승점 임시저장
					int won;
					int defeat;
					int drawn;
					rank = rk[j];
					name = tn[j];
					sc = ts[j];
					won = w[j];
					defeat = l[j];
					drawn = d[j];
					
					rk[j] = rk[i];
					tn[j] = tn[i];
					ts[j]=ts[i];
					w[j] = w[i];
					l[j] = l[i];
					d[j] = d[i];
					
					rk[i] = rank;
					tn[i] = name;
					ts[i] = sc;
					w[i] = won;
					l[i] = defeat;
					d[i] = drawn;
				}
			}
		}
	}
}

