package com.threepin.deepakcorporation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SummaryFragment extends Fragment {
	


	public SummaryFragment(){
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_summery, container, false);
        
        return rootView;
    }
}
