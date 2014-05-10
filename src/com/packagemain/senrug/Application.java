package com.packagemain.senrug;

import com.parse.Parse;
import com.parse.PushService;

public class Application extends android.app.Application{
	public Application() {
	  }

	  @Override
	  public void onCreate() {
	    super.onCreate();

		// Initialize the Parse SDK.
		Parse.initialize(this, "Nr5seKfxX76kVAv4d64gKGsPR63gZGt8eSPjuonO", "XIYlZvOczar9HFXAiRiNoETH4EREib4MDm0ab3rH");

		// Specify an Activity to handle all pushes by default.
		PushService.setDefaultPushCallback(this, GridActivity.class);
	  }

}
