package com.mission.broadcastsdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show();
		//����㲥ʱ�յ��㲥��������㲥��������,�ضϹ㲥
//		abortBroadcast();
	}

}
