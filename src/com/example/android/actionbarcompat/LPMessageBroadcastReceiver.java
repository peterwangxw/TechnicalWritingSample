package com.example.android.actionbarcompat;
import android.util.Log;
import android.widget.Toast;

import com.digby.localpoint.sdk.core.ILPID;
import com.digby.localpoint.sdk.core.ILPMessage;
import com.digby.localpoint.sdk.core.util.LPAbstractMessageBroadcastReceiver;

public class LPMessageBroadcastReceiver extends
		LPAbstractMessageBroadcastReceiver {
	@Override
	public void onAdd(ILPMessage message) {
		String msg = "Added new message: " + message.getTitle();
		toastAndLog(msg);
	}

	@Override
	public void onDelete(ILPID messageId) {
		String msg = "Deleted message with ID: " + messageId.getValue();
		toastAndLog(msg);

	}

	@Override
	public void onModify(ILPMessage message) {
		String msg = "Modified message: " + message.getTitle();
		toastAndLog(msg);
	}

	private void toastAndLog(String msg) {
		Toast toast = Toast.makeText(getContext(), msg, Toast.LENGTH_LONG);
		toast.show();
		Log.d("LPMessageBroadcastReceiver", msg);
	}

}
