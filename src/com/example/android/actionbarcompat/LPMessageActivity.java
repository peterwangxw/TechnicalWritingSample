package com.example.android.actionbarcompat;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.digby.localpoint.sdk.core.ILPFilter;
import com.digby.localpoint.sdk.core.ILPMessage;
import com.digby.localpoint.sdk.core.impl.LPLocalpointService;

public class LPMessageActivity extends ListActivity {
	List<ILPMessage> validOffers;
    List<ILPMessage> expiredOffers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lpmessage);
		  LPLocalpointService service = LPLocalpointService.getInstance(getApplicationContext());
	        // Fetch all valid offers
	        ILPFilter validOffersFilter = service.getMessageProvider().getFilterFactory().getValidFilter();
	        validOffers = service.getMessageProvider().getMessages(validOffersFilter, null);
	        // Fetch all expired offers
	        ILPFilter expiredOffersFilter = service.getMessageProvider().getFilterFactory().getExpiredFilter();
	        expiredOffers = service.getMessageProvider().getMessages(expiredOffersFilter, null);
	        // Prepare for ArrayAdapter
	        String[] values = new String[validOffers.size() + expiredOffers.size()];
	        for (int i = 0; i < values.length; i++) {
	            if (i < validOffers.size()) {
	                values[i] = validOffers.get(i).getTitle();
	            } else {
	                values[i] = "Expired: "+expiredOffers.get(i - validOffers.size()).getTitle();
	            }
	        }
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
	        //Set adapter
	        setListAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lpmessage, menu);
		return true;

	}
  


}
