package com.packagemain.senrug;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class ListAdapterListener implements OnItemClickListener{

	List<RssItem> list;
	Activity activity;
	
	
	public ListAdapterListener(List<RssItem> aList,Activity anactivity){
		this.list=aList;
		this.activity=anactivity;
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int pos, long id) {
		// TODO Auto-generated method stub
		
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(list.get(pos).getLink()));

		activity.startActivity(i);
		
	}
	

}
