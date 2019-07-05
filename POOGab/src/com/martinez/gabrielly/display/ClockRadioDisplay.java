package com.martinez.gabrielly.display;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockRadioDisplay extends Display {
	
	public ClockRadioDisplay(Date date) {
		this.obj = date;
	}

	@Override
	public String formatter(Object obj) {
		Date date = (Date) this.obj;
		String dateFormat = new SimpleDateFormat("HH:mm").format(date);
		
		return dateFormat; 
	}
}
