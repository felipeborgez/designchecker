package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.ufba.dc.DC;
import br.ufba.dc.DCClass;

class DCTest {

	@Test 
	void testIfClassExists() {
		assertTrue(DC.classExists("br.ufba.dc.Method"));
		assertFalse(DC.classExists("br.ufba.dc.Function"));		
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
		assertFalse(c.hasAttribute("atributoErrado"));
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
		
	
	}

}
