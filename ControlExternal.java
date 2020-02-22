package coffeMaker5;

public  class ControlExternal {	
	private ControlInternal CI;
	private coffeeMakerComponents CM;
	private boolean coffeeIsReady;
	
	public ControlExternal(coffeeMakerComponents CM) {
		this.CI= new ControlInternal(CM);
		coffeeIsReady = true;
	}

	public void startBrewing() {
		coffeeIsReady = false;
	}
	
	public void CoffeeIsready() {
		CI.CoffeeIsready();
	}
	
	public boolean poll() {
		return CI.poll();
	}
	public void done() {
		coffeeIsReady = true;
		CI.finish();
		}
	
}