package com.packagemain.senrug;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter{
	private Context context;
	private final String[] values;
	
	public ImageAdapter(Context context, String[] value){
		this.context=context;
		this.values=value;
	}
	
	public View getView(int position,View convertView, ViewGroup parent){
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View gridView;
		if(convertView==null){
			gridView=new View(context);
			
			//import the layout of single icon
			gridView=inflater.inflate(R.layout.icon,null);
			
			// set value into textview
		TextView textView = (TextView) gridView
		.findViewById(R.id.grid_item_label);
		textView.setText(values[position]);
						
		// set image based on selected text
		ImageView imageView = (ImageView) gridView
		.findViewById(R.id.grid_item_image);
		
		String value = values[position];
		if (value.equals("Trains")) {
			imageView.setImageResource(R.drawable.train);
		} else if (value.equals("Locate")) {
			imageView.setImageResource(R.drawable.find);
		} else if (value.equals("Newsletter")) {
			imageView.setImageResource(R.drawable.news);
		} else if (value.equals("Vandalism")){
			imageView.setImageResource(R.drawable.vand);
		}else if(value.equals("Enquiry")){
			imageView.setImageResource(R.drawable.enquiry);
		}

	} else {
		gridView = (View) convertView;
	}

	return gridView;
			
		}
		


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return values.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}


}