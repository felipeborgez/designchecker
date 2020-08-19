package br.ufba.dc;

import java.util.Set;

public class DCPackage {
	
	private Package p;
	private String name;
	private String CanonicalName;
	private String[] packages;
	
	public DCPackage(Package p) {
		this.p = p;
		this.CanonicalName = this.p.getName();
		this.packages = this.CanonicalName.split("\\.");
		this.name = this.packages[this.packages.length - 1];
	}
	
	public DCPackage(String canonicalName) {
		this.CanonicalName = canonicalName;
		this.packages = this.CanonicalName.split("\\.");
		this.name = this.packages[this.packages.length - 1];
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCanonicalName() {
		return this.CanonicalName;
	}
	
	public boolean equals(DCPackage pack) {
		return this.CanonicalName.equals(pack.CanonicalName);
	}
	
	public DCPackage getPackage(String name) {
		Set<DCPackage> packs = DC.getPackages();
		for (DCPackage p : packs) {
			if(p.getCanonicalName().equals(this.getCanonicalName() + "." + name)) {
				return p;
			}
		}
		return null;
	}

}
