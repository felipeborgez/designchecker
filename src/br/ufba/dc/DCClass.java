package br.ufba.dc;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class DCClass {
	
//	private String name;
	private String superClassName;
//	private DCClass superClass;
	
	private Class<?> c;
	
	
	public DCClass(Class<?> c) {
//		System.out.println(c.getSuperclass().getName());
		this.superClassName = c.getSuperclass().getName();
		this.c = c;
		
	}		
	
	public boolean extendsFrom(String superClassName) {
		return this.superClassName == superClassName;
	}
	
	public boolean hasAttribute(String name) {
		try {
			return (name == this.c.getDeclaredField(name).getName());
		} catch (Exception e) {
			return false;			
		}		
	}
	
	public boolean hasAttributes(ArrayList<String> attributes) {
		for(String name: attributes) {
			if(!this.hasAttribute(name)) {
				return false;
			}
	        
		}
		return true;
	}
	
	
	

}
