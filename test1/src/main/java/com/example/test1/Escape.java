package com.example.test1;

public class Escape {
	public String error(String e) {
		String message="";
		if(e.length()==0) {
			message="一文字も入力されていません";
		}else if(31<=e.length()) {
			message="30文字以内で入力してください";
		}
		return message;
		
	}
	
	public String change(String str) {
		String result=str.replace("&", "&amp;")
				.replace("\"", "&quot;")
				.replace("<", "&lt;")
				.replace(">", "&gt;")
				.replace("'", "&#39;");
		return result;
	}
}
