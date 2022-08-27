package com.adobe.prj.client;

import java.util.Locale;
import java.util.ResourceBundle;

public class Example {
	public static void main(String[] args) {
		// i18N ==> Internationalization
		ResourceBundle res = ResourceBundle.getBundle("config", new Locale("hi", "IN"));
		System.out.println(res.getString("PRD_NOT_AVILABLE_MSG"));
	}
}
