package coffeMaker5;
import java.util.concurrent.TimeUnit;

import FinalcoffeMaker.addOns.Beverage;
import FinalcoffeMaker.addOns.Mocha;
import FinalcoffeMaker.addOns.cinnamon;
import FinalcoffeMaker.addOns.coffee;
import FinalcoffeMaker.addOns.whip;

import java.util.*;
public class FacadeControl {
	private WarmerControlExternal WC;
	private ControlExternal C;
	private BoilerControExternal BC;
	private coffeeMakerComponents CMC;
	private Beverage coffee; 
	public FacadeControl(coffeeMakerComponents CMC) {
		this.CMC = CMC;
		WC = new WarmerControlExternal(CMC);
		C  = new ControlExternal(CMC);
		BC = new BoilerControExternal(CMC);
		coffee = new coffee();
	}

	private void startBrewing() { // checks if Boiler is filled with water AND pot is empty,, then start brewing coffee 
		if(WC.ready()&&BC.ready()) {
			C.startBrewing();
			BC.StartBrewing();
			WC.StartBrewing();
			System.out.println("ACTION: coffee is brewing");
		}
	}
	private void makecoffee() {
		Scanner input = new Scanner(System.in);
		System.out.println("How many coffee you want to drink? up to 12");
		int drinks = input.nextInt();
		for (int i=0; i<drinks; i++) {
			int ans;
			System.out.println("Do you want to add any condimits?\n0- just black  1- whip  2-mocha  3-cinnamon");
			ans = input.nextInt();
			if(ans!=0) {
				customecoffee(ans);	
			}
			else {
				System.out.println(coffee.getDescription());
				System.out.println("cofffe cost is: $"+coffee.cost());
			}	
		}



	}


	private void customecoffee(int ans) {
		int add = ans;
		if(add==1) {
			coffee = new whip(coffee);
			System.out.println(coffee.getDescription());
			System.out.println("cofffe cost is: $"+coffee.cost());
		}
		else if (add==2) {
			coffee = new Mocha(coffee);
			System.out.println(coffee.getDescription());
			System.out.println("cofffe cost1 is: $"+coffee.cost());
		}
		else if (add==3) {
			coffee = new cinnamon(coffee);
			System.out.println(coffee.getDescription());
			System.out.println("cofffe cost1 is: $"+coffee.cost());
		}
		else {
			System.out.println(coffee.getDescription());
			System.out.println("cofffe cost is: $"+coffee.cost());
		}

	}

	private void stop() {
		System.out.println("ACTION: POT HAS BEEN REMOVED. STOP BREWING");
		BC.stop();
		WC.stop();
	}
	private void continueBrew() {
		System.out.println("ACTION: POT ON WARMER. CONTINUE BREWING");
		BC.continueBrew();
	}
	public void test() {

	}

	public void poll() throws InterruptedException {
		//		boolean Cevent = C.poll();
		//		boolean BCEvent = BC.poll();
		//		int WCEvent = WC.poll();
		//System.out.println("BCevent"+BCEvent);
		//System.out.println("WCevet"+WCEvent);
		if(C.poll())
			startBrewing();
		//TimeUnit.SECONDS.sleep(2);
		if(BC.poll()) {
			coffeeIsReady();
		}
		//TimeUnit.SECONDS.sleep(2);
		if(WC.poll()!=0) {
			if(WC.poll()==2)
				continueBrew();
			else if(WC.poll()==3)
				stop();
			else {
				WC.done();
				C.done();
			}
		}
		//TimeUnit.SECONDS.sleep(2);
	}
	private void coffeeIsReady() {
		C.CoffeeIsready();
		WC.CoffeeIsready();
		BC.CoffeeIsready();
		System.out.println("ACTION: coffee is ready");
		makecoffee();

	}


}