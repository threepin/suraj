package com.threepin.deepakcorporation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class EmployeeFragment extends Fragment {
	
	private EditText searchEditText1;
	private Button addButton;
	private ListView employeeList;
	
	public EmployeeFragment(){
		
		addButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			}
		});
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_employee, container, false);
        
        searchEditText1 = (EditText) rootView.findViewById(R.id.searchEditText1);
        addButton = (Button) rootView.findViewById(R.id.addButton);
        employeeList = (ListView) rootView.findViewById(R.id.employeeList);
         
        return rootView;
	}	
	
}
