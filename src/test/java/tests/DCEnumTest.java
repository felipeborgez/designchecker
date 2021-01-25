package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.ufba.dc.DC;
import br.ufba.dc.DCClass;
import br.ufba.dc.DCInterface;
import br.ufba.dc.DCMethod;
import br.ufba.examples.Day;

class DCEnumTest {
	
	@Test
	void testOrdinary() {
		
		assertEquals(Day.SUNDAY.toString(), "SUNDAY");
//		Day d = new Day();
		
	}
	
	 
	
}