package com.threepin.deepakcorporation;

import java.util.ArrayList;

import com.threepin.dal.Databasehandler;
import com.threepin.models.clsClient;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class ClientsFragment extends Fragment implements OnClickListener {
	private View v;
	private Context context;
	Databasehandler dbhandlr;
	ListView clientList;
    ArrayList<clsClient> addlist;
	public ClientsFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
 
		context=getActivity();
		v= inflater.inflate(R.layout.fragment_clients, container,false);
		dbhandlr = new Databasehandler(context, "Databasehandler", null, 1);
		
		
		((Button)v.findViewById(R.id.addclientbtn)).setOnClickListener(this);
	
		clientList = (ListView)v.findViewById(R.id.clientList);
		
	
     return v;
    }
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume(); 
		addlist = dbhandlr.getAllClients();
		   // ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,addlist); 
		  
		   CustomAdapter adapter = new CustomAdapter(context,addlist);
		 
		        clientList.setAdapter(adapter);   
			   clientList.setBackgroundColor(Color.LTGRAY);
				 
		
	}
	@Override
	public void onClick(View v) {
		Intent i = new Intent(getActivity().getApplicationContext(),EditClient.class);
        startActivity(i);
		
	}
}
