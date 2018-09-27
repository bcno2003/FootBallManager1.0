package fm;
import java.util.*;

public class Market{
	Menu mn = new Menu();
	Football_main fm = new Football_main();
	Players[] data = new Players[8];	
	void nomoney() {
		System.out.println("계약금이 모자랍니다. 다시 선택해주세요.");
		transfer();
	}
	
	void transfer() {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("------이적시장------");
		System.out.println("------선수목록------");
		int i=0;
		int random = (int)(Math.random() * 11);
		data[0] = fm.anp[random];
		data[1] = fm.bcnp[(int)(Math.random() * 11)];
		data[2] = fm.csp[(int)(Math.random() * 11)];
		data[3] = fm.lpp[(int)(Math.random() * 11)];
		data[4] = fm.mup[(int)(Math.random() * 11)];
		data[5] = fm.mcp[(int)(Math.random() * 11)];
		data[6] = fm.realp[(int)(Math.random() * 11)];
		data[7] = fm.thp[(int)(Math.random() * 11)];
		for(i=0;i<data.length;i++) {
			double cost=0;
			System.out.print("["+(i+1)+"]."+data[i].name+"+"+data[i].grade+"      \t"+data[i].stat+"\t"+data[i].position );
			if(data[i].stat>=93) {
				cost = data[i].stat*270;
				System.out.println(" price: "+cost);
			}else if (data[i].stat>=90) {
				cost = data[i].stat*200;
				System.out.println(" price: "+cost);
			}else if (data[i].stat>=87) {
				cost = data[i].stat*140;
				System.out.println(" price: "+cost);
			}else if (data[i].stat>=84) {
				cost = data[i].stat*90;
				System.out.println(" price: "+cost);
			}else if (data[i].stat>=80) {
				cost = data[i].stat*65;
				System.out.println(" price: "+cost);
			}else {
				cost = data[i].stat*50;
				System.out.println(" price: "+cost);
			}
				
		}
		
		System.out.println("[m].메뉴");
		System.out.print("선택 >>");
		String choice = sc.next();
		switch(choice) {
		case "m" :
			break;
		default :
			System.out.println("몇번 선수와 교체 하시겠습니까?");
			System.out.print("선택>>");
			int ch2 = sc.nextInt();
			int psel = Integer.parseInt(choice);
			double cost=0;
			if(fm.mtp[ch2-1].position.equals(data[psel-1].position)) {
				if(fm.mtp[ch2-1].name.equals(data[psel-1].name)) {
					System.out.println("같은 이름의 선수를 계약해서 추가금을 내고 강화 하시겠습니까? (y/n)");
					System.out.println("강화수 / 필요금액 / 성공확률");
					System.out.println("+1   / 2000  / 100%");
					System.out.println("+2   / 3500  /  90%");
					System.out.println("+3   / 5000  /  80%");
					System.out.println("+4   / 7500  /  65%");
					System.out.println("+5   / 11000 /  50%");
					String ch = sc.next();
					if (ch.equals("y")) {
						if(data[psel-1].stat>=93) {
							cost = data[psel-1].stat*270;
							fm.cash -= cost;
							if(fm.cash<0) {
								nomoney();
							}
							}else if (data[psel-1].stat>=90) {
								cost = data[psel-1].stat*200;
								fm.cash -= cost;
								if(fm.cash<0) {
									nomoney();
								}
							}else if (data[psel-1].stat>=87) {
								cost = data[psel-1].stat*140;
								fm.cash -= cost;
								if(fm.cash<0) {
									nomoney();
								}
							}else if (data[psel-1].stat>=84) {
								cost = data[psel-1].stat*90;
								fm.cash -= cost;
								if(fm.cash<0) {
									nomoney();
								}
							}else if (data[psel-1].stat>=80) {
								cost = data[psel-1].stat*65;
								fm.cash -= cost;
								if(fm.cash<0) {
									nomoney();
								}
							}else {
								cost = data[psel-1].stat*50;
								fm.cash -= cost;
								if(fm.cash<0) {
									nomoney();
								}
							}
						Random r = new Random();
						if(fm.mtp[ch2-1].grade==0) {
							System.out.println("+1 강화 성공. 2000의 추가금이 발생합니다.");
							fm.mtp[ch2-1].grade+=1;
							fm.mtp[ch2-1].stat+=2;
							fm.cash -=2000;
							if(fm.cash<0) {
								nomoney();
							}
						}else if(fm.mtp[ch2-1].grade==1) {
							if(r.nextInt(100)<80) {
								System.out.println("+2 강화 성공! 3500의 추가금이 발생합니다.");
								fm.mtp[ch2-1].grade+=1;
								fm.mtp[ch2-1].stat+=2;
								fm.cash -=3500;}
								else { System.out.println("+2 강화에 실패했습니다. 강화수치가 낮아집니다.");
								fm.mtp[ch2-1].grade-=1;
								fm.mtp[ch2-1].stat-=2;
								fm.cash -=3500;
								}
							if(fm.cash<0) {
								nomoney();
							}
						}else if(fm.mtp[ch2-1].grade==2) {
							if(r.nextInt(100)<65) {
								System.out.println("+3 강화 성공!! 5000의 추가금이 발생합니다.");
								fm.mtp[ch2-1].grade+=1;
								fm.mtp[ch2-1].stat+=2;
								fm.cash -=5000;}
								else { System.out.println("+3 강화에 실패했습니다. 강화수치가 낮아집니다.");
								fm.mtp[ch2-1].grade-=1;
								fm.mtp[ch2-1].stat-=2;
								fm.cash -=5000;
								}
							if(fm.cash<0) {
								nomoney();
							}
						}else if(fm.mtp[ch2-1].grade==3) {
							if(r.nextInt(100)<50) {
								System.out.println("+4 강화 성공!!! 7500의 추가금이 발생합니다.");
								fm.mtp[ch2-1].grade+=1;
								fm.mtp[ch2-1].stat+=2;
								fm.cash -=7500;}
								else { System.out.println("+4 강화에 실패했습니다. 강화수치가 낮아집니다.");
								fm.mtp[ch2-1].grade-=1;
								fm.mtp[ch2-1].stat-=2;
								fm.cash -=7500;
								}
							if(fm.cash<0) {
								nomoney();
							}
						}else if(fm.mtp[ch2-1].grade==4) {
							if(r.nextInt(100)<33) {
								System.out.println("+5 강화 성공!!!! 11000의 추가금이 발생합니다.");
								fm.mtp[ch2-1].grade+=1;
								fm.mtp[ch2-1].stat+=2;
								fm.cash -=11000;}
								else { System.out.println("+5 강화에 실패했습니다. 강화수치가 낮아집니다.");
								fm.mtp[ch2-1].grade-=1;
								fm.mtp[ch2-1].stat-=2;
								fm.cash -=11000;
								}
							if(fm.cash<0) {
								nomoney();
							}
						}else {
							System.out.println("더이상 강화 할수 없습니다.");
							transfer();
						}
					} else {
						System.out.println("취소 되었습니다.");
						transfer();
					}
				}else if (!fm.mtp[ch2-1].name.equals(data[psel-1].name)) {
					if(data[psel-1].stat>=93) {
					cost = data[psel-1].stat*270;
					fm.cash -= cost;
					if(fm.cash<0) {
						nomoney();
					}
					}else if (data[psel-1].stat>=90) {
						cost = data[psel-1].stat*200;
						fm.cash -= cost;
						if(fm.cash<0) {
							nomoney();
						}
					}else if (data[psel-1].stat>=87) {
						cost = data[psel-1].stat*140;
						fm.cash -= cost;
						if(fm.cash<0) {
							nomoney();
						}
					}else if (data[psel-1].stat>=84) {
						cost = data[psel-1].stat*90;
						fm.cash -= cost;
						if(fm.cash<0) {
							nomoney();
						}
					}else if (data[psel-1].stat>=80) {
						cost = data[psel-1].stat*65;
						fm.cash -= cost;
						if(fm.cash<0) {
							nomoney();
						}
					}else {
						cost = data[psel-1].stat*50;
						fm.cash -= cost;
						if(fm.cash<0) {
							nomoney();
						}
					}
			fm.mtp[ch2-1]=new Players(data[psel-1].name,0,data[psel-1].stat, data[psel-1].position);}
			}else {
				System.out.println("선택한 선수와 바꿀 선수의 position 이 다릅니다. 다시 선택해주세요.");
				transfer();
			}
			/*my.teamInfo();*/
		}
      
   }catch(InputMismatchException e) {
	   System.out.println("잘못된 형식입니다. 다시 입력해주세요.");
	   transfer();
   }
}
}
