package com.packagemain.senrug;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class GridActivity extends Activity {

	GridView gridView;
	static final String[] VALUES=new String[]{"Trains","Locate","Newsletter","Vandalism","Enquiry"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_grid);
		gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setAdapter(new ImageAdapter(this, VALUES));
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Toast.makeText(
				   getApplicationContext(),
				   ((TextView) v.findViewById(R.id.grid_item_label))
				   .getText(), Toast.LENGTH_SHORT).show();
				String temp= ((TextView) v.findViewById(R.id.grid_item_label)).getText().toString();
				//System.out.print(temp);
				if(temp.equals("Trains")){
					Intent trainsearch=new Intent("com.project.senrug.TABBED");
					startActivity(trainsearch);
				}
				if(temp.equals("Enquiry")){
					Intent enquiry=new Intent("com.project.senrug.ENQUIRY");
					startActivity(enquiry);
				}
				
				if(temp.equals("Locate")){
					Intent enquiry=new Intent("com.project.senrug.ROUTE");
					startActivity(enquiry);
				}
				
				if(temp.equals("Vandalism")){
										
					Intent enquiry=new Intent("com.project.senrug.VANDALISM");
					startActivity(enquiry);
				}
				if(temp.equals("Newsletter")){
					Intent enquiry=new Intent("com.project.senrug.NEWSLETTER");
					startActivity(enquiry);
				}
				
				
 
			}

			
		});
		
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//finish();
	}
	
	
	

}