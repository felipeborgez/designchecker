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

class DCTest {

	@Test 
	void testIfClassExists() {
		assertTrue(DC.classExists("br.ufba.examples.TheClass"));
		assertFalse(DC.classExists("br.ufba.examples.TheSecondClass"));		
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
		assertTrue(DC.getClass("br.ufba.examples.TheClass").extendsFrom("br.ufba.examples.TheMotherClass"));
		assertFalse(DC.getClass("br.ufba.examples.TheClass").extendsFrom("br.ufba.examples.TheChildClass"));
	}
	
	@Test
	void testifClassHasAttribute() {
		DCClass c = DC.getClass("br.ufba.examples.TheClass");		
		assertTrue(c.hasAttribute("privateString"));		
		assertTrue(c.hasAttribute("publicDouble"));
		assertFalse(c.hasAttribute("wrongAttribute"));
	}
	
	@Test
	void testifClassHasAListOfAttribute() {
		ArrayList<String> attributesList = new ArrayList<String>();
		attributesList.add("privateString");
		attributesList.add("privateInt");
		attributesList.add("publicDouble");
		DCClass c = DC.getClass("br.ufba.examples.TheClass");		
		assertTrue(c.hasAttributes(attributesList));
		
		attributesList.add("Atributoerrado");
		assertFalse(DC.classExists(attributesList));
		
	}
	
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
	void testAmountoOfConstructors() {		
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
