package com.packagemain.senrug;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class Route extends FragmentActivity{
	//List<Overlay> mapOverlays;
    LocationManager locManager;
    Drawable drawable;
    Document document;
    Route_helper v2GetRouteDirection;
    LatLng fromPosition;
    LatLng toPosition;
    GoogleMap mGoogleMap;
    MarkerOptions markerOptions,markerOptions1;
    Location location ;
    GPS gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
			Parse.initialize(this, "Nr5seKfxX76kVAv4d64gKGsPR63gZGt8eSPjuonO", "XIYlZvOczar9HFXAiRiNoETH4EREib4MDm0ab3rH");

          setContentView(R.layout.main);
          v2GetRouteDirection = new Route_helper();
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
          .findFragmentById(R.id.map);
          mGoogleMap = supportMapFragment.getMap();

          // Enabling MyLocation in Google Map
          mGoogleMap.setMyLocationEnabled(true);
          mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
          mGoogleMap.getUiSettings().setCompassEnabled(true);
          mGoogleMap.getUiSettings().setMyLocationButtonEnabled(true);
          mGoogleMap.getUiSettings().setAllGesturesEnabled(true);
          mGoogleMap.setTrafficEnabled(true);
          mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(12));
          markerOptions = new MarkerOptions();
          markerOptions1=new MarkerOptions();
          gps=new GPS(this);
          fromPosition = new LatLng(gps.getLatitude(), gps.getLongitude());
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
					toPosition=new LatLng(g.getLatitude(),g.getLongitude());
					Toast.makeText(getApplicationContext(), s, s.length()).show();
					GetRouteTask getRoute = new GetRouteTask();
			          getRoute.execute();
				

				    

					
				}
				
			});
          //toPosition = new LatLng(55.17814, -1.64427);
			
			//GetRouteTask getRoute = new GetRouteTask();
			//getRoute.execute();
    }
    
    private class GetRouteTask extends AsyncTask<String, Void, String> {
        
        private ProgressDialog Dialog;
        String response = "";
        @Override
        protected void onPreExecute() {
              Dialog = new ProgressDialog(Route.this);
              Dialog.setMessage("Loading route...");
              Dialog.show();
        }

        @Override
        protected String doInBackground(String... urls) {
              //Get All Route values
                    document = v2GetRouteDirection.getDocument(fromPosition, toPosition, Route_helper.MODE_WALKING);
                    response = "Success";
              return response;

        }

        @Override
        protected void onPostExecute(String result) {
              mGoogleMap.clear();
              if(response.equalsIgnoreCase("Success")){
              ArrayList<LatLng> directionPoint = v2GetRouteDirection.getDirection(document);
              PolylineOptions rectLine = new PolylineOptions().width(20).color(
                          Color.CYAN);

              for (int i = 0; i < directionPoint.size(); i++) {
                    rectLine.add(directionPoint.get(i));
              }
              // Adding route on the map
              mGoogleMap.addPolyline(rectLine);
              markerOptions.position(toPosition);
              markerOptions1.position(fromPosition);
              markerOptions.draggable(true);
              mGoogleMap.addMarker(markerOptions);
              mGoogleMap.addMarker(markerOptions1);
              mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
              mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fromPosition, 15));

              }
             
              Dialog.dismiss();
        }
  }
  @Override
  protected void onStop() {
        super.onStop();
        finish();
  }
}


