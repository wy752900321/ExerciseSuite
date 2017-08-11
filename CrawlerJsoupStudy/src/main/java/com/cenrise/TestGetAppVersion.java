package com.cenrise;

import java.io.IOException;

import org.jsoup.Jsoup;

public class TestGetAppVersion {
	
	private final static String PLAY_STORE_APP_URL = "https://play.google.com/store/apps/details?id=br.com.technosoftware.moli";
	
	private final static String PLAY_STORE_APP_VERSION_TAG = "div[itemprop=softwareVersion]";
	
	public static void main(String[] args) {
		
		try {
			String appVersion = Jsoup.connect(PLAY_STORE_APP_URL).get()
									 .select(PLAY_STORE_APP_VERSION_TAG).first()
									 .ownText();
			
			System.out.println(appVersion);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
