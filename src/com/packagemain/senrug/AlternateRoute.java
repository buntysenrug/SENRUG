package com.packagemain.senrug;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.parse.LocationCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

public class AlternateRoute extends Activity{
	WebView viewa;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Parse.initialize(this, "Nr5seKfxX76kVAv4d64gKGsPR63gZGt8eSPjuonO", "XIYlZvOczar9HFXAiRiNoETH4EREib4MDm0ab3rH");
		
		/*ParseObject station=new ParseObject("Station");
		station.put("name", "Haymarket");
		ParseGeoPoint p=new ParseGeoPoint(40,-30);
		LatLng l=new LatLng(p.getLatitude(),p.getLongitude());
		station.put("location",p);
		station.saveInBackground();
		*/
		setContentView(R.layout.alternate_route);
		
		
		String url="http://jplanner.travelinenortheast.info/";
		viewa=(WebView) findViewById(R.id.webviewa);
		viewa.getSettings().setJavaScriptEnabled(true);
		viewa.getSettings().setBuiltInZoomControls(true);
		viewa.setWebViewClient(new WebViewClient());
		viewa.loadUrl(url);
		
		
	}

}
