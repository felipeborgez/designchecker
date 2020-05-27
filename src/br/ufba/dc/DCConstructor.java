package br.ufba.dc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class DCConstructor {
	
	ArrayList<Param> params;
	Constructor<?> c;
	
	public DCConstructor(Constructor<?> c) {
		this.c = c;
		loadParams(c);
	}
	
	private void loadParams(Constructor<?> c) {
		for (Parameter p : c.getParameters()) {
//			this.params.add(new Param(p));
		}
	}

	
	public ArrayList<Param> getParams(){
		return this.params;
	}
	
}
