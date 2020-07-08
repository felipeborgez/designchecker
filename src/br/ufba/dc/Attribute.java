package br.ufba.dc;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Attribute {
	
	private String name;
	private Field field;
	
	public Attribute (Field field) {
		this.name = field.getName();
		this.field = field;	
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isPublic() {
		return Modifier.isPublic(this.field.getModifiers());
	}
	
	public boolean isPrivate() {
		return Modifier.isPrivate(this.field.getModifiers());
	}
	
	public boolean isProtected() {
		return Modifier.isProtected(this.field.getModifiers());
	}

}
