package fm;

public class Players {
	Football_main main = new Football_main();
	Myteam mt = new Myteam();
	T_arsenal an = new T_arsenal();
	T_barcelona bcn = new T_barcelona();
	T_chelsea cs = new T_chelsea();
	T_liverpool lp = new T_liverpool();
	T_manche mu = new T_manche();
	T_mancity mc = new T_mancity();
	T_real real = new T_real();
	T_tottenham th = new T_tottenham();
	
	double stat;
	String team;
	String position;
	String name;
	int grade=0;
	
	public Players(String name, int grade, double stat, String position) {
		this.name = name;
		this.stat = stat;
		this.position = position;
		this.grade = grade;
	}
	
	void PlayersList(int ch) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("========= 목록 =========");
		System.out.println();
		mt.teamInfo();
		if(!main.mt.mtname.equals("My_Team_(아스널)"))
		an.teamInfo();
		if(!main.mt.mtname.equals("My_Team_(바르샤)"))
		bcn.teamInfo();
		if(!main.mt.mtname.equals("My_Team_(첼시)"))
		cs.teamInfo();
		if(!main.mt.mtname.equals("My_Team_(리버풀)"))
		lp.teamInfo();
		if(!main.mt.mtname.equals("My_Team_(맨유)"))
		mu.teamInfo();
		if(!main.mt.mtname.equals("My_Team_(맨시티)"))
		mc.teamInfo();
		if(!main.mt.mtname.equals("My_Team_(레알)"))
		real.teamInfo();
		if(!main.mt.mtname.equals("My_Team_(토트넘)"))
		th.teamInfo();
		
		System.out.println();
		System.out.println();
	}

}
