package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.ufba.dc.Attribute;
import br.ufba.dc.DC;
import br.ufba.dc.DCClass;
import br.ufba.dc.DCConstructor;
import br.ufba.dc.Param;

class DCClassTest {

	@Test 
	void testIfClassIsAbstract() {
		assertFalse(DC.getClass("br.ufba.examples.TheClass").isAbstract());
		assertTrue(DC.getClass("br.ufba.examples.TheAbstractClass").isAbstract());
	}
}