package com.threepin.deepakcorporation;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.threepin.dal.Databasehandler;
import com.threepin.models.clsClient;

public class CustomAdapter extends BaseAdapter  {
	
	private Context context;
	public ArrayList<clsClient> rslt;
	private LayoutInflater inflater=null;
	ListView lv;
	Databasehandler dbhandlr;
	
	public CustomAdapter(Context context,ArrayList<clsClient> results) {
		rslt=results;
	    this.context=context;
		inflater = (LayoutInflater)(this.context).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}

	@Override
	public int getCount() {
		return rslt.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	class Holder{
		ImageButton edit,delt;
		public TextView textView1,textView2;
		
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final clsClient tempClient = rslt.get(position);
		Holder h = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.activity_client_info, null);
        h.edit=(ImageButton) rowView.findViewById(R.id.imgeditbtn);
        h.delt=(ImageButton) rowView.findViewById(R.id.imgdeltebtn);
        h.textView1 = (TextView)rowView.findViewById(R.id.textView1);
        h.textView2 = (TextView)rowView.findViewById(R.id.textView2);
        h.textView1.setText(tempClient.cname);
        h.textView2.setText(tempClient.aname);

        h.edit.setTag(tempClient.cid);
       h.delt.setTag(tempClient.cid);
    
       h.delt.setBackgroundColor(Color.LTGRAY);
       
       h.edit.setOnClickListener(new OnClickListener(){
    	   
    	  
        @Override
		public void onClick(final View v) {
        	 Intent i = new Intent(context,EditClient.class);
             context.startActivity(i);
        }
    });
      
        h.delt.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(final View v) {
			AlertDialog.Builder adb = new AlertDialog.Builder(context);
		    adb.setTitle("Delete Client");
		    adb.setIcon(android.R.drawable.ic_dialog_alert);
		    adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
		        @Override
				public void onClick(DialogInterface dialog, int which) {
		        	dbhandlr = new Databasehandler(context, "Databasehandler", null, 1);
		        	dbhandlr.deleteClient(tempClient.cid);
		     rslt.remove(((ImageButton)v).getTag());
			 notifyDataSetChanged(); 
		     } });
		    adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		        @Override
				public void onClick(DialogInterface dialog, int which) {

		        	dialog.dismiss();
		      } });
			    adb.show();
			}			 
	});
   
	return rowView;
	}
}