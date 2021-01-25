package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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