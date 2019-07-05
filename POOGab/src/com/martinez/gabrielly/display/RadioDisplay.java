package com.martinez.gabrielly.display;

public class RadioDisplay extends Display{
	
	public RadioDisplay(Double tuning) {
		this.obj = (Double) tuning;

	}

	@Override
	public String formatter(Object obj) {
		Double tuning = (Double) this.obj;
		String formatTuning = tuning.toString() + " Mhz";
		return formatTuning;
	}
}
