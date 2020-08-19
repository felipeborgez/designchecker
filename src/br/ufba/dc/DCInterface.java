package br.ufba.dc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class DCInterface {
	
	Class<?> c;
	String name;
	protected ArrayList<DCMethod> methods;
	
	public DCInterface(Class<?> c) {
		this.c = c;
		this.name = c.getName();
		this.loadMethods();
	}
	
	public String getName() {
		return this.name;
	}
	
	private void loadMethods(){
		ArrayList<DCMethod> myMethod = new ArrayList<DCMethod>();		
		Method[] methods = this.c.getDeclaredMethods();
		for (Method m : methods) {
			if (m.getName() != "$jacocoInit") {
				DCMethod method = new DCMethod(m);
				myMethod.add(method);
//				System.out.println("LOG: " + method);
			}
		}
		this.methods = myMethod;
	
	}
	
	public DCMethod getMethod(String name) {
		for (DCMethod m : this.methods) {
			if (m.getName() == name) {
				return m;
			}
		}
		System.out.println("Method \"" + name + "\" not found at " + c.getName() + " \n");
		return null;
	}

}
