package com.mission.broadcastsdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show();
		//有序广播时收到广播将不允许广播继续传播,截断广播
//		abortBroadcast();
	}

}
