package br.ufba.examples;

public enum Day {
	
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY;
    
    public String getName(Day day) {
		return day.toString();
	}

}
