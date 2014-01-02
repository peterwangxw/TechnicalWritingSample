package com.example.android.actionbarcompat;

import android.util.Log;
import android.widget.Toast;

import com.digby.localpoint.sdk.core.ILPError;
import com.digby.localpoint.sdk.core.ILPID;
import com.digby.localpoint.sdk.core.ILPLocation;
import com.digby.localpoint.sdk.core.util.LPAbstractLocationBroadcastReceiver;

public class LPLocationBroadcastReceiver  extends LPAbstractLocationBroadcastReceiver {
    
   @Override
   public void onEntry(ILPLocation location) {
       String msg = "Entered location: " + location.getName();
       toastAndLog(msg);
   }

   @Override
   public void onExit(ILPLocation location) {
       String msg = "Exited location: " + location.getName();
       toastAndLog(msg);
   }

   @Override
   public void onAdd(ILPLocation location) {
       String msg = "Added new location: " + location.getName();
       toastAndLog(msg);
   }


   @Override
   public void onModify(ILPLocation location) {
       String msg = "Modified location: " + location.getName();
       toastAndLog(msg);
   }

   @Override
   public void onDelete(ILPID locationId) {
       String msg = "Removed location with ID: " + locationId.getValue();
       toastAndLog(msg);
   }

   @Override
   public void onCheckInSuccess(ILPLocation location) {
       String msg = "Successfully checked in to location: " + location.getName();
       toastAndLog(msg);
   }

   @Override
   public void onCheckInFailure(ILPLocation location, ILPError error) {
       String msg = error.getErrorMessage() + ": " + location.getName();
       toastAndLog(msg);
   }

   private void toastAndLog(String msg) {
       Toast toast = Toast.makeText(getContext(), msg, Toast.LENGTH_LONG);
       toast.show();
       Log.d("LPLocationBroadcastReceiver", msg);   
   }

}


