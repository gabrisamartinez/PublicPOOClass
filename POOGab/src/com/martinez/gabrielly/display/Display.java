package com.martinez.gabrielly.display;

import com.martinez.gabrielly.formatter.Formatter;

public abstract class Display implements Formatter {
	protected Object obj;
	
	public void display() {
		System.out.println(formatter(this.obj));
	}
}
