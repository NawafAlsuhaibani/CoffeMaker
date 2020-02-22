package coffeMaker5;

public class coffeeMaker implements coffeeMakerComponents {
	boolean buttonIsPressed;
	boolean indicatorIsOn;
	boolean valvleisClosed;
	boolean boilerisOn;
	boolean boilerIsEmpty;
	boolean warmerIsOn;
	boolean potOnWarmer;
	boolean potIsNotEmpty;
	int potsize;
	
	
	public coffeeMaker() {
		buttonIsPressed = false;
		indicatorIsOn = false;
		valvleisClosed =true;
		
		boilerisOn = false;
		boilerIsEmpty=true;
		
		
		warmerIsOn = false;
		potOnWarmer = true;
		potIsNotEmpty=false;
		potsize=0;
		
	}
	public void report() {
		String total = "\nReport:";
		total +="\n Button is pressed: "+buttonIsPressed;
		total +="\n warmer is on: "+warmerIsOn;
		total +="\n boiler is on: "+boilerisOn;
		total +="\n pot is empty: "+!potIsNotEmpty;
		total +="\n boiler is empty: "+boilerIsEmpty;
		total +="\n pot on warmer: "+potOnWarmer;
		total +="\n indicator Is On: "+indicatorIsOn;
		total +="\n Valve Is closed: "+valvleisClosed;
		total +="\nEND REPORT\n";
		System.out.println(total);
	}
	@Override
	public int warmerStatus() {
		if(!potOnWarmer)
		return WARMER_IS_EMPTY;
		else if (potIsNotEmpty)
			return POT_IS_NOT_EMPTY;
		else return POT_IS_EMPTY;
	}
	@Override
	public int boilerStatus() {
		if(boilerIsEmpty)
		return BOILER_IS_EMPTY;
		else return BOILER_IS_NOT_EMPTY;
	}

	@Override
	public int buttonStatus() {
		if(buttonIsPressed)
		return BUTTON_IS_PRESSED;
		else return BUTTON_IS_NOT_PRESSED;
	}

	@Override
	public void boilerState(int boilerState) {
		boilerisOn = (boilerState == BOILER_IS_ON);
		
	}

	@Override
	public void warmerState(int warmerState) {
		warmerIsOn = (warmerState==WARMER_IS_ON);
	}

	@Override
	public void indicator(int indicator) {
		indicatorIsOn = (indicator==INDICATOR_IS_ON);
		
	}

	@Override
	public void valveState(int valveState) {
		valvleisClosed = (VALVE_IS_CLOSED == valveState);
		
	}
	
}