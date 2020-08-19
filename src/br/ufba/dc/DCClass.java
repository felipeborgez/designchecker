package br.ufba.dc;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class DCClass {
	
	private String name;
	private String CanonicalName;
	private String superClassName;
//	private DCClass superClass;
	
		
	private Class<?> c;
	private DCPackage packageDC;
	protected ArrayList<Attribute> attributes;
	protected ArrayList<DCMethod> methods;
	protected ArrayList<DCConstructor> constructors;
	protected ArrayList<DCInterface> interfaces;
	
	
	public DCClass(Class<?> c) {
		this.c = c;
		this.CanonicalName = c.getName();
		String[] packages = this.CanonicalName.split("\\.");
		this.name = packages[packages.length - 1];
		
		this.superClassName = c.getSuperclass().getName();
		
		this.loadPackage();
		this.loadAttributes();
		this.loadMethods();
		this.loadConstructors();
		this.loadInterfaces();
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isInterface() {
		return Modifier.isInterface(this.c.getModifiers() );
	}
	
	public boolean isEnum() {
		return this.c.isEnum();
	}
	
	public boolean isAbstract() {
		return Modifier.isAbstract( this.c.getModifiers() );
	}
	
	public boolean isFinal() {
		return Modifier.isFinal(this.c.getModifiers());
	}
	
	public boolean isStatic() {
		return Modifier.isStatic(this.c.getModifiers());
	}
	
	public boolean isPublic() {
		return Modifier.isPublic(this.c.getModifiers());
	}
	
	public boolean isPrivate() {
		return Modifier.isPrivate(this.c.getModifiers());
	}
	
	public boolean isProtected() {
		return Modifier.isProtected(this.c.getModifiers());
	}
	
	public boolean extendsFrom(String superClassName) {
		return this.superClassName == superClassName;
	}
	
	public void loadPackage() {
		Package pack = c.getPackage();
		this.packageDC = new DCPackage(pack);
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
	
	public ArrayList<DCMethod> getMethods() {
		return this.methods;
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
	
	private void loadConstructors(){
		ArrayList<DCConstructor> myConstructors = new ArrayList<DCConstructor>();		
		Constructor<?>[] constructors = this.c.getConstructors();
		for (Constructor<?> c : constructors) {			
			myConstructors.add(new DCConstructor(c));
		}
		this.constructors = myConstructors;
	}
	
	public ArrayList<DCConstructor> getContructors(){
		return this.constructors;
	}
	
	private void loadInterfaces(){
		ArrayList<DCInterface> myInterfaces = new ArrayList<DCInterface>();		
		Class<?>[] interfaces = this.c.getInterfaces();
		for (Class<?> i : interfaces) {
			myInterfaces.add(new DCInterface(i));
		}
		this.interfaces = myInterfaces;
	}
	
	public boolean implement(String name) {
		return (this.getInterface(name) != null);
	}
	
	public ArrayList<DCInterface> getInterfaces(){
		return this.interfaces;
	}
	
	public DCInterface getInterface(String name) {
		if (!name.contains(".")) {
			name = this.packageDC.getCanonicalName() + "." + name;
		}
		
		for (DCInterface i : this.getInterfaces()) {
			if (name.equals(i.getName())) {
				return i;
			}
		}
		return null;
	}
}

