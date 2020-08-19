package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.ufba.dc.DC;
import br.ufba.dc.DCClass;

class DCMethodTest {

	@Test 
	void testIfMethodIsAbstract() {
		DCClass c =  DC.getClass("br.ufba.examples.TheClass");		
		assertFalse(c.getMethod("theMethod").isAbstract());
		
		c =  DC.getClass("br.ufba.examples.TheAbstractClass");		
		assertTrue(c.getMethod("abstractMethod").isAbstract());
	}
	
	@Test 
	void testIfMethodIsFinal() {
		DCClass c =  DC.getClass("br.ufba.examples.TheClass");		
		assertFalse(c.getMethod("theMethod").isFinal());
		assertTrue(c.getMethod("finalMethod").isFinal());
	}
	
	@Test 
	void testMethodVisibility() {
		DCClass c =  DC.getClass("br.ufba.examples.TheClass");
		assertFalse(c.getMethod("privateMethod").isPublic());
		assertFalse(c.getMethod("protectedMethod").isPrivate());
		assertFalse(c.getMethod("theMethod").isProtected());
		
		assertTrue(c.getMethod("theMethod").isPublic());
		assertTrue(c.getMethod("privateMethod").isPrivate());
		assertTrue(c.getMethod("protectedMethod").isProtected());
	}
}