package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

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
	
	@Test 
	void testIfClassImplementsInterface() {
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheClass");
			
			boolean hasInterfaceB = false;
			for (Class<?> m : c.getInterfaces()) {
				System.out.println(m.getName());
				if (m.getName() == "br.ufba.examples.InterfaceB") {					
					hasInterfaceB = true;
				}
				
			}
			assertFalse(hasInterfaceB);
			
			
			
			for (Class<?> m : c.getInterfaces()) {
				System.out.println(m.getName());
				if (m.getName() == "br.ufba.examples.InterfaceA") {
					assertTrue(true);
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			
		} catch (SecurityException e) {
			
		}
	}@Test 
	void testIfClassExists() {
		try {
			Class<?> c = Class.forName("br.ufba.examples.TheClass");			
			assertNotNull(c);						
		} catch (java.lang.ClassNotFoundException e) {
			fail();	//class doesn't exist
		}			
		
		try {
			@SuppressWarnings("unused")
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
				@SuppressWarnings("unused")
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
	
}
