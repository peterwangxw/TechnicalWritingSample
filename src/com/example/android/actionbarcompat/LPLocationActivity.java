package com.example.android.actionbarcompat;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.digby.localpoint.sdk.core.ILPFilter;
import com.digby.localpoint.sdk.core.ILPLocation;
import com.digby.localpoint.sdk.core.impl.LPLocalpointService;

public class LPLocationActivity extends ListActivity {
	List<ILPLocation> locations;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lplocation);
		// Instance Localpoint Service
		LPLocalpointService lpService = LPLocalpointService
				.getInstance(getApplicationContext());
		// ILPFilter filter = lpService.getLocationProvider().getFilterFactory()
				// .getAllowsCheckInFilter(); 
		ILPFilter filter = lpService.getLocationProvider().getFilterFactory().getWithinDistanceFilter(1000000000);
		locations = lpService.getLocationProvider().getLocations(filter, null);
			
		// Get filtered locations
		locations = lpService.getLocationProvider().getLocations(filter, null);
		// Prepare for ArrayAdapter
		String[] values = new String[locations.size()];
		for (int i = 0; i < values.length; i++) {
			values[i] = locations.get(i).getName();
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, values);
		// Set adapter
		setListAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lplocation_main, menu);
		return true;
	}
	   @Override
	    protected void onListItemClick(ListView l, View v, int position, long id) {
	        ILPLocation location = locations.get(position);
	        location.checkIn();
	        String msg = "Check in store (" + locations.get(position).getName() + ") successfully. You can see it in offer list.";
	        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
	        toast.show();
	    }

}
