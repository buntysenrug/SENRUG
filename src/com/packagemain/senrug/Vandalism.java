package com.packagemain.senrug;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;

public class Vandalism extends Activity{

	Button send;
	EditText name_of_station,incident;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vandalism);
		send=(Button)findViewById(R.id.send);
		name_of_station=(EditText)findViewById(R.id.station);
		incident=(EditText)findViewById(R.id.incident);
		
		send.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String phone_no="07500869611";
				String sms=name_of_station.getText().toString()+"\n"+incident.getText().toString();
				
				try{
					SmsManager manager=SmsManager.getDefault();
					manager.sendTextMessage(phone_no, null, sms, null, null);
					Toast.makeText(getApplicationContext(), "SMS Sent Successfully ", Toast.LENGTH_LONG);
					Intent start=new Intent("com.packagemain.senrug.GRIDACTIVITY");
					startActivity(start);
					
				}catch(Exception e){
					Toast.makeText(getApplicationContext(), "SMS Failed", Toast.LENGTH_LONG).show();
				}
				
			}
			
		});
		
	}
	

}
