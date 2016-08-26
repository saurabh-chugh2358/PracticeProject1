package com.annotations;

public class AnnotationsDriver {
	private int id;
	private String name;

	@Mutator1_value("xyz")
	public int getId() {
		return id;
	}
	
	@Mutator2_variable(variable="xyz")
	public void setId(int id) {
		this.id = id;
	}

	@Mutator2_valuexxx(valuexxx="xyz")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public static void main(String[] args) {
		

	}
	
	

}
