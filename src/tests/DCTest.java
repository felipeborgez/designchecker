package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.ufba.dc.Attribute;
import br.ufba.dc.DC;
import br.ufba.dc.DCClass;

class DCTest {

	
	
	@Test
	void testAmountOfAttributes() {
		int amount = DC.getClass("br.ufba.examples.TheClass").getAttributes().size();
		assertEquals(amount, 4);
	}
	
	@Test
	void testCheckCommonAttribute() {
		boolean chk1 = DC.getClass("br.ufba.examples.TheMotherClass").hasAttribute("commonAttribute");
		boolean chk2 = DC.getClass("br.ufba.examples.TheClass").hasAttribute("commonAttribute");
		
		assertTrue(chk1 && chk2);
		
		chk1 = DC.getClass("br.ufba.examples.TheMotherClass").hasAttribute("privateInt");
		chk2 = DC.getClass("br.ufba.examples.TheClass").hasAttribute("privateInt");
		
		assertFalse(chk1 && chk2);
	}
	
	@Test
	void testAttributeVisibility() {		
		ArrayList<Attribute> attributes = DC.getClass("br.ufba.examples.TheClassPrivateAttributes").getAttributes();
		for (Attribute attr : attributes) {
			assertTrue(attr.isPrivate());
		}
	}

	@Test
	void testAmountOfConstructors() {		
		assertEquals(1, DC.getClass("br.ufba.examples.TheMotherClass").getContructors().size());
		assertEquals(2, DC.getClass("br.ufba.examples.TheClass").getContructors().size());
	}
	
	@Test
	void testConstructorsParamsSorting() {		
//		ArrayList<DCConstructor> cList = DC.getClass("br.ufba.examples.TheClass").getContructors();
//		for (DCConstructor c: cList) {
//			ArrayList<Param> pList = c.getParams();
//			for (Param p : pList) {
//				System.out.println(" KK " + p.getClass());
//			}
//			
//		}
	}
}
