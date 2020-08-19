package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.ufba.dc.DC;
import br.ufba.dc.DCClass;
import br.ufba.dc.DCInterface;

class DCClassTest {

	@Test 
	void testIfClassIsAbstract() {
		assertFalse(DC.getClass("br.ufba.examples.TheClass").isAbstract());
		assertTrue(DC.getClass("br.ufba.examples.TheAbstractClass").isAbstract());
	}
	
	@Test 
	void testIfClassImplementsInterface() {
		DCClass c = DC.getClass("br.ufba.examples.TheClass");
		
		assertFalse(c.implement("br.ufba.examples.InterfaceB"));
		assertTrue(c.implement("br.ufba.examples.InterfaceA"));
		
		// Test using the simples(short) name
		assertFalse(c.implement("InterfaceB"));
		assertTrue(c.implement("InterfaceA"));
	}
	
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
		assertFalse(c.hasAttributes(attributesList));
		
	}
}