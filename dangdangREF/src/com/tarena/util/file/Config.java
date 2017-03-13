package com.tarena.util.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config extends Properties {
	private static final long serialVersionUID = 1L;
	private static Config config;

	private Config() {
		InputStream in = this.getClass().getResourceAsStream(
				"/config/prop/jdbc.properties");
		try {
			this.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized static Config getInstance() {
		if (config != null) {
			return config;
		} else {
			return new Config();
		}
	}

	public static String getString(String key) {
		return Config.getInstance().getProperty(key);
	}

	public static int getInt(String key) {
		return Integer.parseInt(Config.getInstance().getProperty(key));
	}

	public static double getDouble(String key) {
		return Double.parseDouble(Config.getInstance().getProperty(key));
	}

	public static void main(String[] args) {
		System.out.println(Config.getString("driver"));
	}
}
