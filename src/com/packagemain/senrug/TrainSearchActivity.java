package com.packagemain.senrug;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TrainSearchActivity extends Activity{

	WebView view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.train_web);
		
		String url="http://m.nationalrail.co.uk/pj/home";
		view=(WebView) findViewById(R.id.webview1);
		view.getSettings().setJavaScriptEnabled(true);
		view.setWebViewClient(new WebViewClient());
		view.loadUrl(url);
		
	}

}
