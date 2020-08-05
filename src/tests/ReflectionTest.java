package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ReflectionTest {

	
	
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
			@SuppressWarnings("unused")
			boolean chk1 = c1.getDeclaredField("privateInt").getName() == "privateInt";
			
			Class<?> c2 = Class.forName("br.ufba.examples.TheMotherClass");
			@SuppressWarnings("unused")
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
	void testAmountOfConstructors() {
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
