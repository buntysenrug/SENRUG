package com.packagemain.senrug;

import com.packagemain.senrug.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/**
 * Author:- Bunty Makhija
 * 
 * 
 * @see SystemUiHider
 */
public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		Thread timer=new Thread(){
						public void run(){
							try{
								sleep(1500);
							}catch(InterruptedException e){
								e.printStackTrace();
								
							}finally{
								Intent openActivity=new Intent("com.packagemain.senrug.GRIDACTIVITY");
								startActivity(openActivity);
							}
						}
					};
					
					timer.start();
					
		
	}
	@Override
		protected void onPause() {
			// TODO Auto-generated method stub
			super.onPause();
			finish();
		}
	
	
}
