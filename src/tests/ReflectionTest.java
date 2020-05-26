package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.ufba.dc.DC;
import br.ufba.examples.*;

class ReflectionTest {

	@Test 
	void testIfClassExists() {
		assertTrue(DC.classExists("br.ufba.dc.Method"));
		assertFalse(DC.classExists("br.ufba.dc.Function"));		
	}
	
	@Test 
	void testIfClassListExists() {
		ArrayList<String> classesListTrue = new ArrayList<String>();
		classesListTrue.add("br.ufba.dc.Method");
		classesListTrue.add("br.ufba.dc.DCClass");
		assertTrue(DC.classExists(classesListTrue));
		
		ArrayList<String> classesListFalse = new ArrayList<String>();
		classesListFalse.add("br.ufba.dc.Method");
		classesListFalse.add("br.ufba.dc.Function");
		assertFalse(DC.classExists(classesListFalse));
	}
	
	@Test
	void testIfClassExtendsAnotherOne() {
		try {
			Class<?> c1 = Class.forName("br.ufba.examples.TheClass");
			String superClassName = c1.getSuperclass().getName();			
			assertEquals(superClassName, "br.ufba.examples.TheMotherClass");
			
			Class<?> c2 = Class.forName("br.ufba.examples.TheClass");
			superClassName = c2.getSuperclass().getName();			
			assertNotEquals(superClassName, "br.ufba.examples.TheChildClass");
		} catch (ClassNotFoundException e) {
			
		}		
	}
	
	@Test
	void testifClassHasAttribute() {
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheClass");
			assertEquals(c.getDeclaredField("privateString").getName(), "privateString");
		} catch (Exception e) {
			fail();	
		}	

		
	}
	
	void testifClassHasAListOfAttribute() {
		ArrayList<String> attributesList = new ArrayList<String>();
		attributesList.add("privateString");
		attributesList.add("privateInt");
		attributesList.add("publicDouble");
		
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheClass");
			for (String attribute : attributesList) {
				assertEquals(c.getDeclaredField(attribute).getName(), attribute);
			}	
		} catch (Exception e) {
			fail();	
		}			
	}

}
