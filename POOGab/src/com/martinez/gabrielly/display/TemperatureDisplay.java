package com.martinez.gabrielly.display;

public class TemperatureDisplay extends Display{

	public TemperatureDisplay(Double temperature) {
		this.obj = (Double) temperature; 
	}

	@Override
	public String formatter(Object obj) {
		Double temperature = (Double) this.obj;
		String formatTemperature = temperature.toString() + "ºC";
		return formatTemperature;
	}
}
