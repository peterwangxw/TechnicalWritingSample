package com.example.android.actionbarcompat;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import android.util.Log;
import android.widget.Toast;

import com.digby.localpoint.sdk.core.ILPError;
import com.digby.localpoint.sdk.core.profile.ILPAttributeValue;
import com.digby.localpoint.sdk.core.util.LPAbstractAttributeBroadcastReceiver;

public class LPAttributeBroadcastReceiver extends LPAbstractAttributeBroadcastReceiver {

    
    @Override
    public void onUpdateFailure(Map<String, ILPAttributeValue<?>> attrs, ILPError error) {      
        String errmsg = "Error: " + error.getErrorCode() + ". " + error.getErrorMessage();
        toastAndLog(errmsg);
    }

    @Override
    public void onUpdateSuccess(Map<String, ILPAttributeValue<?>> attrs) {
        Map<String, String> attrs2 = new HashMap<String, String>();
        Set<String> keys = attrs.keySet();
        for (String key : keys) {
            ILPAttributeValue<?> attr = attrs.get(key);
            String value = attr.getValue().toString();
            attrs2.put(key, value);
        }
        
        String msg = "Attributes updated successfully: " + attrs2.toString();
        toastAndLog(msg);
    }
    
    private void toastAndLog(String msg) {
        Toast toast = Toast.makeText(getContext(), msg, Toast.LENGTH_LONG);
        toast.show();
        Log.d("LPMessageBroadcastReceiver", msg);
    }
    
}
