package tests;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Set;

import org.junit.jupiter.api.Test;

import br.ufba.dc.DCAttribute;
import br.ufba.dc.DC;
import br.ufba.dc.DCClass;
import br.ufba.dc.DCPackage;

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
		ArrayList<DCAttribute> attributes = DC.getClass("br.ufba.examples.TheClassPrivateAttributes").getAttributes();
		for (DCAttribute attr : attributes) {
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
	
	@Test
	void testGettingAPackages() {
		String pName = "brasil";
		DCPackage p = DC.getPackage(pName);
		assertNull(p);
		
		pName = "ufba";
		p = DC.getPackage(pName);
		assertNull(p);
		
		pName = "br.ufba.";
		p = DC.getPackage(pName);
		assertNull(p);
		
		pName = "br";
		p = DC.getPackage(pName);
		assertEquals(pName, p.getCanonicalName());
		
		pName = "br.ufba";
		p = DC.getPackage(pName);
		assertEquals(pName, p.getCanonicalName());
		
		pName = "br.ufba.dc";
		p = DC.getPackage(pName);
		assertEquals(pName, p.getCanonicalName());
	}
	
	@Test
	void testPackagesBrowsing() {
		String pName = "br.example";
		DCPackage p = DC.getPackage(pName);
		assertNull(p);
		
		
		p = DC.getPackage("br")
				.getPackage("ufba");		

		pName = "br.ufba";
		p = DC.getPackage(pName);
		assertEquals(pName, p.getCanonicalName());
		
		try {
			p = DC.getPackage("br")
					.getPackage("example")
					.getPackage("ufba");
			assertNull(p);
			System.out.println(p.getName());
			System.out.println(p.getCanonicalName());
//			p = ;
//			assertNull(p);
		} catch (NullPointerException e) {
			assertNull(p);
			System.out.println(p.toString()); 
			
		}
	}
		
	@Test
	void testGetClassFromPackage() {
		DCPackage p = DC.getPackage("br.ufba.examples");
		String className = p.getClass("TheClass").getCanonicalName();
		assertEquals("br.ufba.examples.TheClass", className);
	}
		
	
}
