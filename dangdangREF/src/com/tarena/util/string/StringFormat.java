package com.tarena.util.string;

public class StringFormat {
	public static String isNotNullString(String string) {
		String str = "";
		if (string != null) {
			str = string.trim();
		}
		return str;
	}

	public static double isNotNullDouble(String string) {
		double d = 0;
		if (string != null && !string.equals("")) {
			d = Double.parseDouble(string.trim());
		}
		return d;
	}

	public static int isNotNullInteger(String string) {
		int result = 1;
		try {
			if (string != null && !string.equals("")) {
				result = Integer.parseInt(string.trim());
			}
		} catch (NumberFormatException e) {
			return -1;
		}
		return result;
	}

	public static boolean isNotNullAndEmpty(String str) {
		boolean bool = false;
		if (str != null && !str.equals("")) {
			bool = true;
		}
		return bool;
	}

}
