package br.ufba.dc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DC {    
    
    private static Set<DCPackage> getPackages(String folder, Set<DCPackage> pack) {
        File dir = new File(folder);
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
            	String path = file.getPath();
            	String packName = path
			            			.substring(path.indexOf("src") + 4)
			            			.replace(File.separator, ".");
            	pack.add(new DCPackage(packName));
            	getPackages(file.getAbsolutePath(), pack);
            }
        }
        return pack;
    }
    
    public static Set<DCPackage> getPackages() {
    	Set<DCPackage> packs = new HashSet<>();
    	getPackages("src", packs);
    	return packs;
    }
    
    public static DCPackage getPackage(String name) {
    	Set<DCPackage> packs = DC.getPackages();
    	for (DCPackage p : packs) {
			if (p.getCanonicalName().equals(name)) {
				return p;
			}
		}
    	return null;
    	
    }
	
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
