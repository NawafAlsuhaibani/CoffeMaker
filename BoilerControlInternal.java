package coffeMaker5;

public class BoilerControlInternal implements poll  {
	
	private coffeeMakerComponents cmc;
	
	public BoilerControlInternal(coffeeMakerComponents cM) {
		this.cmc = cM;
	}
	public void start() {
		
		cmc.boilerState(cmc.BOILER_IS_ON);
		cmc.valveState(cmc.VALVE_IS_CLOSED);

	}
	public boolean ready() {
		boolean x = cmc.boilerStatus() == cmc.BOILER_IS_NOT_EMPTY;
		return cmc.boilerStatus() == cmc.BOILER_IS_NOT_EMPTY;
	}
	public void stop() {
		cmc.boilerState(cmc.BOILER_IS_OFF);
		cmc.valveState(cmc.VALVE_IS_OPEN);

	}
	public void continueBrew() {
		cmc.boilerState(cmc.BOILER_IS_ON);
		cmc.valveState(cmc.VALVE_IS_CLOSED);
	
	}
	@Override
	public boolean poll() {
		if(cmc.boilerStatus() == cmc.BOILER_IS_EMPTY) {
			cmc.boilerState(cmc.BOILER_IS_OFF);
			cmc.valveState(cmc.VALVE_IS_CLOSED);
			return true;
		}
		else {
			return false;
		} 
	}
}