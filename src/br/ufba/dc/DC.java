package br.ufba.dc;

import java.util.ArrayList;

public class DC {
	
	public static boolean classExists(String className) {
	    try  {
	        Class.forName(className);
	        return true;
	    }  catch (ClassNotFoundException e) {
	        return false;
	    }
	}
	
	public static boolean classExists(ArrayList<String> classNames) {	    
    	for (String name : classNames) {
    		if(!DC.classExists(name))
    			return false;
		}
		return true;
	}
	
	public static DCClass getClass(String name) {
		try {			
			Class<?> c = Class.forName(name);
			DCClass dcclass = new DCClass(c);						
			return dcclass;	
		}  catch (ClassNotFoundException e) {
			return null;
		}		
	}
}
