package coffeMaker5;

public interface coffeeMakerComponents {

	int warmerStatus();
	int WARMER_IS_EMPTY=0;
	int POT_IS_EMPTY=1;
	int POT_IS_NOT_EMPTY=2;
	int POT_FILLING=3;
	
	void warmerState(int warmerState); 
	int WARMER_IS_ON=0;
	int WARMER_IS_OFF=1;
	
	void indicator(int indicator); 
	int INDICATOR_IS_ON=0;
	int INDICATOR_IS_OFF=1;
	
	/////////////////////
	
	int boilerStatus(); 
	int BOILER_IS_EMPTY=0;
	int BOILER_IS_NOT_EMPTY=1;
	
	void boilerState(int boilerState); 
	int BOILER_IS_ON=0;
	int BOILER_IS_OFF=1;
	
	void valveState(int valveState); 
	int VALVE_IS_OPEN=0;
	int VALVE_IS_CLOSED=1;
	
	/////////////////////
	
	
	int buttonStatus(); 
	int BUTTON_IS_PRESSED=0;
	int BUTTON_IS_NOT_PRESSED=1;
	
	/////////////////////
	

}
