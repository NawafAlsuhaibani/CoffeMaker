package coffeMaker5;

	public class ControlInternal implements poll {
		coffeeMakerComponents cmc;
		
		public ControlInternal(coffeeMakerComponents cmc) {
			this.cmc = cmc;
		}
		public void CoffeeIsready() {
			
			cmc.indicator(cmc.INDICATOR_IS_ON);
			
		}

		public void finish() {	
			cmc.indicator(cmc.INDICATOR_IS_OFF);
		
		}
		@Override
		public boolean poll() {
			boolean x = cmc.buttonStatus()==cmc.BUTTON_IS_PRESSED;
				return x;
		}
}