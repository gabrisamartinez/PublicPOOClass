package com.martinez.gabrielly.display;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarDisplay extends Display{
	
	public CalendarDisplay(Date date) {
		this.obj = date;
	}

	@Override
	public String formatter(Object obj) {
		Date date = (Date) this.obj;
		String dateFormat = new SimpleDateFormat("dd/mm/yyyy").format(date);
		
		return dateFormat; 
	}

}
