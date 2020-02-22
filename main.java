package coffeMaker5;

import java.io.IOException;
import java.util.Scanner;

public class main {
	public static void main(String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		System.out.println("what case you want to test? type 1 OR 2 ");
		int casenum = input.nextInt();
		if(casenum==1) {
			case1();
		}
		else if(casenum==2) {
			case2();
		}


	}
	private static void case1() throws InterruptedException {
		coffeeMaker CM = new coffeeMaker();
		FacadeControl FC = new FacadeControl(CM);
		CM.buttonIsPressed=true;
		CM.boilerIsEmpty=false;
		FC.poll();
		CM.potOnWarmer=false;
		FC.poll();
		CM.potOnWarmer=true;
		CM.potIsNotEmpty=true;
		FC.poll();
		FC.test();
		CM.boilerIsEmpty=true;
		FC.poll();

	}
	private static void case2() throws InterruptedException {
		coffeeMaker CM = new coffeeMaker();
		FacadeControl FC = new FacadeControl(CM);
		CM.buttonIsPressed=true;
		CM.boilerIsEmpty=false;
		FC.poll();
		CM.potOnWarmer=false;
		FC.poll();
		CM.potOnWarmer=true;
		CM.potIsNotEmpty=true;
		FC.poll();
		FC.test();
		CM.boilerIsEmpty=true;
		FC.poll();

	}
}