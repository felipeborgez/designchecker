package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.ufba.dc.Attribute;
import br.ufba.dc.DC;
import br.ufba.examples.*;

class ReflectionClassTest {
	
	@Test
	void testIfClassIsAbstract() {
		try {
			Class<?> c1 = Class.forName("br.ufba.examples.TheClass");
			assertFalse(Modifier.isAbstract( c1.getModifiers() ));
			
			Class<?> c2 = Class.forName("br.ufba.examples.TheAbstractClass");
			assertTrue(Modifier.isAbstract( c2.getModifiers() ));
		} catch (ClassNotFoundException e) {
			
		}		
	}
	
}
