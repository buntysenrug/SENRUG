package com.packagemain.senrug;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AlternateRoute extends Activity{
	WebView viewa;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alternate_route);
		
		String url="http://jplanner.travelinenortheast.info/";
		viewa=(WebView) findViewById(R.id.webviewa);
		viewa.getSettings().setJavaScriptEnabled(true);
		viewa.getSettings().setBuiltInZoomControls(true);
		viewa.setWebViewClient(new WebViewClient());
		viewa.loadUrl(url);
		
		
	}

}
