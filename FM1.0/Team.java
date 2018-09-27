package fm;


public class Team {
	
	String[] name = new String[8];
	int[] stat = new int[8];
	
	
	T_arsenal an = new T_arsenal();
	T_barcelona bcn = new T_barcelona();
	T_chelsea cs = new T_chelsea();
	T_liverpool lp = new T_liverpool();
	T_manche mu = new T_manche();
	T_mancity mc = new T_mancity();
	T_real real = new T_real();
	T_tottenham th = new T_tottenham();
	
	
	void tname() {
		name[0] = an.name;
		name[1] = bcn.name;
		name[2] = cs.name;
		name[3] = lp.name;
		name[4] = mu.name;
		name[5] = mc.name;
		name[6] = real.name;
		name[7] = th.name;
	}
	void tstat() {
		stat[0] = an.playerAvg();
		stat[1] = bcn.playerAvg();
		stat[2] = cs.playerAvg();
		stat[3] = lp.playerAvg();
		stat[4] = mu.playerAvg();
		stat[5] = mc.playerAvg();
		stat[6] = real.playerAvg();
		stat[7] = th.playerAvg();
	}

	
	void teamList() {
		
	}
	

}
