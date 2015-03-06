package com.threepin.models;

import java.util.ArrayList;

import com.threepin.dal.Databasehandler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class clsClient {
	public String cid;
	public String cname;
	public String eid;
	public String aid;
	public String aname;


}
 class CustomA extends BaseAdapter  {
	
	private Context context;
	public ArrayList<clsClient> rslt;
	private LayoutInflater inflater=null;
	private CustomA cadapter;
	ListView lv;
	Databasehandler dbhandlr;
	
	
	
	
	   

	public CustomA(Context context,ArrayList<clsClient> results) {
		// TODO Auto-generated constructor stub
		rslt=results;
	    this.context=context;
		inflater = (LayoutInflater)(this.context).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}






	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}






	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}






	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}
}
