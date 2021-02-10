package model;//JavaBeanse

import java.io.Serializable;

public class Recipe implements Serializable {

	private String Rname;//レシピ名
	private String Rdata;//レシピの内容

	public Recipe() {}


	public Recipe(String recipe_name,String recipe_data) {

		this.Rname = recipe_name;
		this.Rdata = recipe_data;
	}


	public String getRecipe_name() {
		return Rname;
	}


	public void setRecipe_name(String recipe_name) {
		this.Rname = recipe_name;
	}


	public String getRecipe_data() {
		return Rdata;
	}


	public void setRecipe_data(String recipe_data) {
		this.Rdata = recipe_data;
	}




}
