package com.tarena.util;

import java.io.Serializable;
import java.util.UUID;

public class VerifyUtil implements Serializable {
	private static final long serialVersionUID = 8806480873074474684L;

	/**
	 * Éú³ÉUUID
	 * @return
	 */
	public static String randomUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	// public static void main(String[] args) {
	// System.out.println(randomUUID());
	// System.out.println(randomUUID());
	// }
}
