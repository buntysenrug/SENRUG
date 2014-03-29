package com.packagemain.senrug;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Tabbed extends TabActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab);
		TabHost th =getTabHost();
		TabSpec tab1 = (TabSpec) th.newTabSpec("Arrival");
	    TabSpec tab2 = (TabSpec) th.newTabSpec("Alternate");
	    
	    tab1.setIndicator("Plan Journey", null).setContent(
	            new Intent(this, TrainSearchActivity.class));
	    tab2.setIndicator("Alternate", null).setContent(
	            new Intent(this, AlternateRoute.class));
	    
	    th.addTab(tab1);
	    th.addTab(tab2);
	    
	}
	

}
