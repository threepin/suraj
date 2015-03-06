package com.threepin.deepakcorporation;

import com.threepin.dal.Databasehandler;
import com.threepin.models.clsClient;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditClient extends Activity {
	public Button save, update;
	private EditText  clientname,areaname;
	Databasehandler dbhandlr;
	clsClient cls;
    AlertDialog alertdialog; 
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_client);
		dbhandlr = new Databasehandler(this, "Databasehandler", null, 1);
		alertdialog = new AlertDialog.Builder(this).create();
		areaname = (EditText)findViewById(R.id.areatext);
		 clientname = (EditText)findViewById(R.id.nametext);
	     
		
	 save = (Button) findViewById(R.id.savebuttn);
	 save.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				    final String clnm=clientname.getText().toString();
					final String arnm = areaname.getText().toString();
					
					 if(clnm.trim().equalsIgnoreCase("") && arnm.trim().equalsIgnoreCase(""))
					 {
						 Toast.makeText(getApplicationContext(), "Enter Client and Area Name", Toast.LENGTH_SHORT).show();
					 }	 
					 else if(clnm.trim().equalsIgnoreCase("")){
						 Toast.makeText(getApplicationContext(), "Enter Client Name", Toast.LENGTH_SHORT).show();
					 }
					 else if(arnm.trim().equalsIgnoreCase("")){
						 Toast.makeText(getApplicationContext(), "Enter Area Name", Toast.LENGTH_SHORT).show();
					 }
					 else{
						 int tempAreaId = (int)   dbhandlr.addArea(arnm);
				         dbhandlr.addClient(clnm,true,tempAreaId);
				         Toast.makeText(getApplicationContext(), "Client Added Succesfully", Toast.LENGTH_SHORT).show();
						 clientname.setText("");
						 areaname.setText("");
					 }
			}}); 
	 
	 update = (Button) findViewById(R.id.updtbtn);
     
	 update.setOnClickListener(new OnClickListener (){
		@Override
		public void onClick(View v) {
		
		
		 final String clnm1=clientname.getText().toString();
			 final String arnm1 = areaname.getText().toString();
		
			 if(clnm1.trim().equalsIgnoreCase("") && arnm1.trim().equalsIgnoreCase(""))
			 {
				 Toast.makeText(getApplicationContext(), "Enter Client and Area Name", Toast.LENGTH_SHORT).show();
			 }
			  else if(clnm1.trim().equalsIgnoreCase("")){
					 Toast.makeText(getApplicationContext(), "Enter Client Name", Toast.LENGTH_SHORT).show();
			 }
				 else if(arnm1.trim().equalsIgnoreCase("")){
					 Toast.makeText(getApplicationContext(), "Enter Area Name", Toast.LENGTH_SHORT).show();
			 }
		     else{
				 Toast.makeText(getApplicationContext(), "Client updated Succesfully", Toast.LENGTH_SHORT).show();
			 }
		} 
	});
	}
}	