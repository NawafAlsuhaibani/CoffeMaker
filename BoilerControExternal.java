package coffeMaker5;

public class BoilerControExternal {
	private BoilerControlInternal BCR;
	private coffeeMakerComponents CM;
	private boolean isBrewing;
	public BoilerControExternal(coffeeMakerComponents CM) {
		this.BCR = new BoilerControlInternal(CM);
		isBrewing = false;
	}
	public void StartBrewing() {
		isBrewing = true;
		BCR.start();
    }
	public boolean ready() {
		return BCR.ready();
	}
	public void CoffeeIsready(){
		isBrewing = false;
	}
	public boolean poll() {
		boolean x;
		if(isBrewing){
			 x = BCR.poll();
			 return x;
		}
		else return false;
	}
	public void stop() {
		
		BCR.stop();
	}
	public void continueBrew() {
		BCR.continueBrew();
	}
}