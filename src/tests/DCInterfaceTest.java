package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.ufba.dc.DC;
import br.ufba.dc.DCClass;
import br.ufba.dc.DCInterface;
import br.ufba.dc.DCMethod;

class DCInterfaceTest {
	
	@Test
	void testInterfaceMethods() {
		DCClass c = DC.getClass("br.ufba.examples.TheClass");
		DCInterface inter = c.getInterface("br.ufba.examples.InterfaceA");
		
		DCMethod m = inter.getMethod("simpleMethod");
		
		assertEquals("simpleMethod", m.getName());
		
		m = inter.getMethod("simpleMethod");
		assertNull(m);
		
	}

	
}