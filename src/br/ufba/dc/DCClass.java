package br.ufba.dc;

import java.lang.reflect.Method;
import java.awt.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class DCClass {
	
//	private String name;
	private String superClassName;
//	private DCClass superClass;
	
	private Class<?> c;
	protected ArrayList<Attribute> attributes;
	protected ArrayList<DCMethod> methods;
	protected ArrayList<DCConstructor> constructors;
	
	
	public DCClass(Class<?> c) {
		this.superClassName = c.getSuperclass().getName();
		this.c = c;
		this.loadAttributes();
		this.loadMethods();
		this.loadConstructors();
		
	}
	
	public boolean isAbstract() {
		return Modifier.isAbstract( this.c.getModifiers() );
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
	
	public int attributesAmount() {
		return this.attributes.size();
	}
	
	private void loadAttributes(){
		ArrayList<Attribute> myAttributes = new ArrayList<Attribute>();		
		Field[] fields = this.c.getDeclaredFields();
		for (Field f : fields) {
			if (f.getName() != "$jacocoData") {
				Attribute attr = new Attribute(f);
				myAttributes.add(attr);
			}
		}
		this.attributes = myAttributes;
	}
	
	public ArrayList<Attribute> getAttributes(){
		return this.attributes;		
	}
	
	private void loadMethods(){
		ArrayList<DCMethod> myMethod = new ArrayList<DCMethod>();		
		Method[] methods = this.c.getDeclaredMethods();
		for (Method m : methods) {
			if (m.getName() != "$jacocoInit") {
				DCMethod method = new DCMethod(m);
				myMethod.add(method);
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
		System.out.println("Method " + name + " not found at " + c.getName() + " \n");
		return null;
	}
	
	private void loadConstructors(){
		ArrayList<DCConstructor> myConstructors = new ArrayList<DCConstructor>();		
		Constructor[] constructors = this.c.getConstructors();
		for (Constructor c : constructors) {			
			myConstructors.add(new DCConstructor(c));
		}
		this.constructors = myConstructors;
	}
	
	public ArrayList<DCConstructor> getContructors(){
		return this.constructors;
	}
}
