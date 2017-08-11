package com.sushma.crudassignment.models;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Language {
	@Size(min=2, max=20)
	private String name;
	
	@Size(min=2, max=20)
	private String creator;
	
	@NotNull
	private String currentVersion;
	
	public Language() {
		
	}
	
	public Language(String programminglanguage, String creator, String currentVersion) {
		this.name = programminglanguage;
		this.creator = creator;
		this.currentVersion = currentVersion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}
	
	
}
