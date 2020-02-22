package coffeMaker5;

public  class WarmerControlExternal {
	private WarmerControlInternal WCI;
	private coffeeMakerComponents CM;
	private boolean coffeeIsready;
	public boolean isBrewing;
	public WarmerControlExternal(coffeeMakerComponents cM) {
		this.WCI = new WarmerControlInternal(cM);
		coffeeIsready = true;
		isBrewing = false;
	}
	public void StartBrewing() {
		isBrewing = true;
		coffeeIsready = false;
    }
	public void CoffeeIsready() {
		isBrewing = false;
	}
	public boolean ready() {
		return WCI.ready();
	}
	public int poll() {
		return WCI.poll(coffeeIsready,isBrewing);
	}
	public void done() {
	coffeeIsready = true;
	}
	public void stop() {
		WCI.stop();
	}

	
}