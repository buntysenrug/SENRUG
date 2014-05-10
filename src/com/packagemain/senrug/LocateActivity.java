package com.packagemain.senrug;

import java.util.List;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.parse.FindCallback;
import com.parse.LocationCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class LocateActivity extends Activity{
	
	 private GoogleMap map;
	  static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	  static final LatLng KIEL = new LatLng(53.551, 9.993);

	  protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.map);
			Parse.initialize(this, "Nr5seKfxX76kVAv4d64gKGsPR63gZGt8eSPjuonO", "XIYlZvOczar9HFXAiRiNoETH4EREib4MDm0ab3rH");

		  map=((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
		  /*  Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG)
		        .title("Hamburg"));
		    Marker kiel = map.addMarker(new MarkerOptions()
		        .position(KIEL)
		        .title("Kiel")
		        .snippet("Kiel is cool")
		        .icon(BitmapDescriptorFactory
		            .fromResource(R.drawable.ic_launcher)));
		    
		   

		    // Move the camera instantly to hamburg with a zoom of 15.
		    map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 15));

		    // Zoom in, animating the camera.
		    map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
		    */
		 final ProgressDialog dialog = ProgressDialog.show(this, "", "Looking for Nearest SENRUG Station......", true);
		  dialog.show();
			GPS gps=new GPS(this);
			//static final lat=gps.getLatitude()
			ParseGeoPoint p=new ParseGeoPoint(gps.getLatitude(),gps.getLongitude());
			
			ParseQuery<ParseObject> query = ParseQuery.getQuery("Station");
			query.whereNear("location", p);
			
			query.setLimit(10);
			query.findInBackground(new FindCallback<ParseObject>(){

				@Override
				public void done(List<ParseObject> objects, ParseException e) {
					// TODO Auto-generated method stub
					String s=(String) objects.get(0).get("name");
					ParseGeoPoint g=objects.get(0).getParseGeoPoint("location");
					LatLng p=new LatLng(g.getLatitude(),g.getLongitude());
					Toast.makeText(getApplicationContext(), s, s.length()).show();
					dialog.dismiss();
					Marker nearest=map.addMarker(new MarkerOptions().position(p).title(s));
				    map.moveCamera(CameraUpdateFactory.newLatLngZoom(p, 15));
				

				    

					
				}
				
			});


			
		  }

	
	

}
