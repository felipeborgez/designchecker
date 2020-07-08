package br.ufba.dc;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class DCMethod {
	
	private String name;
	private Method method;
	
	public DCMethod (Method method) {
		this.name = method.getName();
		this.method = method;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isAbstract() {
		return Modifier.isAbstract(this.method.getModifiers());
	}
	
	public boolean isFinal() {
		return Modifier.isFinal(this.method.getModifiers());
	}
	
	public boolean isPublic() {
		return Modifier.isPublic(this.method.getModifiers());
	}
	
	public boolean isPrivate() {
		return Modifier.isPrivate(this.method.getModifiers());
	}
	
	public boolean isProtected() {
		return Modifier.isProtected(this.method.getModifiers());
	}

}
