package com.martinez.gabrielly.main;

import java.util.Date;

import com.martinez.gabrielly.display.CalendarDisplay;
import com.martinez.gabrielly.display.ClockRadioDisplay;
import com.martinez.gabrielly.display.RadioDisplay;
import com.martinez.gabrielly.display.TemperatureDisplay;

public class Main {

	public static void main(String[] args) {
		new ClockRadioDisplay(new Date()).display();
		new RadioDisplay(107.5).display();
		new TemperatureDisplay(31.4).display();
		new CalendarDisplay(new Date()).display();
	}

}
