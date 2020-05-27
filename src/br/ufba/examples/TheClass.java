package br.ufba.examples;

public class TheClass extends TheMotherClass{
	
	private String privateString;
	private int privateInt;
	public double publicDouble;
	
	private int commonAttribute;
	
	public TheClass() {
		System.out.println("Just for test");
	}
	
	public TheClass(String param1, int param2) {
		System.out.println("Just for test with params");
	}
	

}
