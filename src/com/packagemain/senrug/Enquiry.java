package com.packagemain.senrug;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;

public class Enquiry extends Activity{
	
	Button send_button;
	EditText name,phone_no,message_body;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enquiry);
		name =(EditText)findViewById(R.id.name);
		phone_no=(EditText)findViewById(R.id.phone);
		message_body=(EditText)findViewById(R.id.message);
		
		send_button=(Button)findViewById(R.id.send);
		
		send_button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String to="bunty.mystic@gmail.com";
				String subject="Enquiry";
				String message=message_body.getText().toString();
				message=message+"\n"+"Regards\n"+name.getText().toString()+"\n"+phone_no.getText().toString();
				
				Intent email=new Intent(Intent.ACTION_SEND);
				email.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
				email.putExtra(Intent.EXTRA_SUBJECT, new String[]{subject});
				email.putExtra(Intent.EXTRA_TEXT, message);
				email.setType("message/rfc822");
				startActivity(Intent.createChooser(email, "Choose an Email Client "));

				
			}
			
		});
		
		
	}

}
