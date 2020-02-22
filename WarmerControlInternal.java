package coffeMaker5;

public class WarmerControlInternal{
	coffeeMakerComponents cmc;
	private int potStatus;
	public WarmerControlInternal(coffeeMakerComponents cmc) {
		this.cmc = cmc;
		potStatus = cmc.POT_IS_EMPTY;
	}

	public boolean ready() {
		boolean x = cmc.warmerStatus() == cmc.POT_IS_EMPTY;
		return cmc.warmerStatus() == cmc.POT_IS_EMPTY;
	}
	public void stop() {

	}
	public int poll(boolean coffeeIsready, boolean isBrewing) {
		boolean brewing = isBrewing;
		boolean ready = coffeeIsready;
		int warmerStatus = cmc.warmerStatus();
		if(warmerStatus != potStatus) {
			if(brewing) {
				return BrewEvent(warmerStatus);
			}
			else if(!ready) {
				return warmerEvent(warmerStatus);
			}
			potStatus = warmerStatus;
		}
		return 0;
	}

	private int warmerEvent(int warmerStatus) {
		int event;
		if(warmerStatus == cmc.POT_IS_NOT_EMPTY) {
			cmc.warmerState(cmc.WARMER_IS_ON);
			return 0;
		}else if (warmerStatus == cmc.WARMER_IS_EMPTY) {
			cmc.warmerState(cmc.WARMER_IS_OFF);
			return 0;
		}
		else {
			cmc.warmerState(cmc.WARMER_IS_OFF);
			event = 1;
			return event;
		}
	}

	private int BrewEvent(int warmerStatus) {
		int event;
		if(warmerStatus == cmc.POT_IS_NOT_EMPTY) {  // call continue in "BoilerControExternal"
			cmc.warmerState(cmc.WARMER_IS_ON);
			event = 2;
			return event;
		}
		else if(warmerStatus == cmc.WARMER_IS_EMPTY) { // call stop in "BoilerControExternal"
			cmc.warmerState(cmc.WARMER_IS_OFF);
			event = 3;
			return event;
		}
		else { // call continue in "BoilerControExternal"
			cmc.warmerState(cmc.WARMER_IS_OFF);
			event=2;
			return event;
		}
	}
}