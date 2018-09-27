package fm;

public class score extends Football_main{
	
	public static void score1() {
		int random = (int)(Math.random()*14+1);
		switch(random) {
			case 1: System.out.println("1:0");
			break;
			case 2: System.out.println("2:0");
			break;
			case 3: System.out.println("3:0");
			break;
			case 4: System.out.println("4:0");
			break;
			case 5: System.out.println("5:0");
			break;
			case 6: System.out.println("2:1");
			break;
			case 7: System.out.println("3:1");
			break;
			case 8: System.out.println("3:2");
			break;
			case 9: System.out.println("4:1");
			break;
			case 10: System.out.println("4:2");
			break;
			case 11: System.out.println("4:3");
			break;
			case 12: System.out.println("5:1");
			break;
			case 13: System.out.println("5:2");
			break;
			case 14: System.out.println("5:3");
			break;
			case 15: System.out.println("5:4");
			break;
		}
		return;
	}
	public static void score2() {
		int random = (int)(Math.random()*4+1);
		switch(random) {
			case 1: System.out.println("0:0");
			break;
			case 2: System.out.println("1:1");
			break;
			case 3: System.out.println("2:2");
			break;
			case 4: System.out.println("3:3");
			break;
			case 5: System.out.println("4:4");
			break;
		}
		return;
	}

}
