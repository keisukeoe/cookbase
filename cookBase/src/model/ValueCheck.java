package model;

public class ValueCheck {

	public static String checkadd(String recipe_name, String recipe_data) {
		String errMsg = "";

		//レシピ名の必須項目
		if("".equals(recipe_name)) {
			errMsg += "レシピ名をご記入ください<br>";
		}else if(recipe_name.length() > 20) {
			errMsg += "レシピ名は20文字以内でご記入ください<br>";
		}

		//レシピ内容の必須項目
		if("".equals(recipe_data)) {
			errMsg += "レシピ内容をご記入ください<br>";
		}else if(recipe_data.length()<50 && recipe_data.length()>500) {
			errMsg += "レシピ内容を50文字以上、500文字以内でご記入ください";
		}

		return errMsg;
	}
}
