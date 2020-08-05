package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

class ReflectionMethodTest {
	
	@Test
	void testIfMethodIsAbstract(){
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheClass");
			for (Method m : c.getDeclaredMethods()) {
				if (m.getName() == "theMethod") {
					assertFalse(Modifier.isAbstract( m.getModifiers() ));
					break;
				}
			}
			
			c = Class.forName("br.ufba.examples.TheAbstractClass");
			for (Method m : c.getDeclaredMethods()) {
				if (m.getName() == "abstractMethod") {
					assertTrue(Modifier.isAbstract( m.getModifiers() ));
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			
		} catch (SecurityException e) {
			
		}	
	}
	
	@Test
	void testIfMethodIsFinal() {
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheClass");
			for (Method m : c.getDeclaredMethods()) {
				if (m.getName() == "theMethod") {
					assertFalse(Modifier.isFinal( m.getModifiers() ));
				}
				if (m.getName() == "finalMethod") {
					assertTrue(Modifier.isFinal( m.getModifiers() ));
				}
			}
		} catch (ClassNotFoundException e) {
			
		} catch (SecurityException e) {
			
		}	
	}
	
	@Test
	void testMethodVisibility() {
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheClass");
			for (Method m : c.getDeclaredMethods()) {
				if (m.getName() == "theMethod") {
					assertFalse(Modifier.isProtected( m.getModifiers() ));
				}
				if (m.getName() == "protectedMethod") {
					assertFalse(Modifier.isPrivate( m.getModifiers() ));
				}
				if (m.getName() == "privateMethod") {
					assertFalse(Modifier.isPublic( m.getModifiers() ));
				}
			}
			
			for (Method m : c.getDeclaredMethods()) {
				if (m.getName() == "theMethod") {
					assertTrue(Modifier.isPublic( m.getModifiers() ));
				}
				if (m.getName() == "protectedMethod") {
					assertTrue(Modifier.isProtected( m.getModifiers() ));
				}
				if (m.getName() == "privateMethod") {
					assertTrue(Modifier.isPrivate( m.getModifiers() ));
				}
			}
		} catch (ClassNotFoundException e) {
			
		} catch (SecurityException e) {
			
		}	
	}
	
}
