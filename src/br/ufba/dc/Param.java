package br.ufba.dc;

import java.lang.reflect.Parameter;

public class Param {
	
	int order;
	Class<?> type;
//	Object type;
	
	public Param(Parameter p) {
		this.type = p.getType();
	}

}
