package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.ufba.dc.Attribute;
import br.ufba.dc.DC;
import br.ufba.examples.*;

class ReflectionTest {

	@Test 
	void testIfClassExists() {
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheClass");			
			assertNotNull(c);						
		} catch (java.lang.ClassNotFoundException e) {
			fail();	//class doesn't exist
		}			
		
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheSecondClass");			
		} catch (java.lang.ClassNotFoundException e) {
			assertTrue(true);
		}
	}
	
	@Test 
	void testIfClassListExists() {
		ArrayList<String> classesListTrue = new ArrayList<String>();
		classesListTrue.add("br.ufba.dc.Method");
		classesListTrue.add("br.ufba.dc.DCClass");
		for (String className : classesListTrue) {
			try {
				Class<?> c = Class.forName(className);			
				assertNotNull(c);						
			} catch (java.lang.ClassNotFoundException e) {
				fail();	//class doesn't exist
			}
		}
		
		ArrayList<String> classesListFalse = new ArrayList<String>();
		classesListFalse.add("br.ufba.dc.Method");
		classesListFalse.add("br.ufba.dc.Function");
		
		try {
			for (String className : classesListTrue) {
				Class<?> c = Class.forName(className);			
			}
		} catch (java.lang.ClassNotFoundException e) {
			assertTrue(true); //Some class doesn't exist
		}
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
		
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheClass");
			assertEquals(c.getDeclaredField("wrongAttribute").getName(), "wrongAttribute");
		} catch (Exception e) {
			assertTrue(true); //TheClass doesn't have a
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
			fail();	//class doesn't exist
		}			
	}
	
	@Test
	void testAmountOfAttributes() {
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheClass");
			int amount = c.getDeclaredFields().length - 1;
			assertEquals(amount, 4);
		} catch (Exception e) {
			fail();	 //class doesn't exist
		}
	}
	
	@Test
	void testCheckCommonAttribute() {
		try {
			Class<?> c1 = Class.forName("br.ufba.examples.TheClass");
			boolean chk1 = c1.getDeclaredField("commonAttribute").getName() == "commonAttribute"; 
				
			
			Class<?> c2 = Class.forName("br.ufba.examples.TheMotherClass");
			boolean chk2 = c2.getDeclaredField("commonAttribute").getName() == "commonAttribute";
			
			assertTrue(chk1 && chk2);
		} catch (Exception e) {
			fail();	 //class doesn't exist
		}

		try {
			Class<?> c1 = Class.forName("br.ufba.examples.TheClass");
			boolean chk1 = c1.getDeclaredField("privateInt").getName() == "privateInt";
			
			Class<?> c2 = Class.forName("br.ufba.examples.TheMotherClass");
			boolean chk2 = c2.getDeclaredField("privateInt").getName() == "privateInt";
			
		} catch (Exception e) {
			assertTrue(true); //TheMotherClass doesn't have privateInt as an attribute
		}
	}
	
	@Test
	void testAttributeVisibility() {		
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheClassPrivateAttributes");
			for (Field f: c.getDeclaredFields()) {
				if (f.getName() != "$jacocoData") {
					assertTrue(Modifier.isPrivate(f.getModifiers()));
				}
			}	
		} catch (Exception e) {
			fail();	 //class doesn't exist
		}
	}
	
	@Test
	void testAmountoOfConstructors() {
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheMotherClass");			
			assertEquals(1, c.getConstructors().length); 
		} catch (Exception e) {
			fail();	 //class doesn't exist
		}
		
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheClass");			
			assertEquals(2, c.getConstructors().length); 
		} catch (Exception e) {
			fail();	 //class doesn't exist
		}
	}
	
}
