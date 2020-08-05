package br.ufba.dc;

import java.util.ArrayList;

public class DC {
	
	
//	public static Package[] getPackage() {
//	    return Package.getPackages();
//	    		.stream()
//	        .map(Package::getName)
//	        .filter(n -> n.startsWith(prefix));
//	        .collect(toList());
//	}
	
//	public static String getPath() throws UnsupportedEncodingException {
//
//	    String path = Class.getClass().getClassLoader().getResource("").getPath();
//	    String fullPath = URLDecoder.decode(path, "UTF-8");
//	    String pathArr[] = fullPath.split("/WEB-INF/classes/");
//	    System.out.println(fullPath);
//	    System.out.println(pathArr[0]);
//	    fullPath = pathArr[0];
//
//	    return fullPath;
//	}
	
	public static boolean classExists(String className) {
	    try  {
	        Class.forName(className);
	        return true;
	    }  catch (ClassNotFoundException e) {
	        return false;
	    }
	}
	
	public static boolean classExists(ArrayList<String> classNames) {	    
    	for (String name : classNames) {
    		if(!DC.classExists(name))
    			return false;
		}
		return true;
	}
	
	public static DCClass getClass(String name) {
		try {			
			Class<?> c = Class.forName(name);
			DCClass dcclass = new DCClass(c);						
			return dcclass;	
		}  catch (ClassNotFoundException e) {
			return null;
		}		
	}
	
	public static DCClass getInterface(String name) {
		try {			
			Class<?> c = Class.forName(name);
			DCClass dcclass = new DCClass(c);						
			return dcclass;	
		}  catch (ClassNotFoundException e) {
			return null;
		}		
	}
}
