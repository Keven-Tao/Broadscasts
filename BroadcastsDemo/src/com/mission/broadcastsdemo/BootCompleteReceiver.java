package com.mission.broadcastsdemo;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author Taoke
 * @date 2016年2月24日
 * @type_name BootCompleteReceiver
 * 
 * 在Mainfest文件中静态注册广播
 */
public class BootCompleteReceiver extends BroadcastReceiver {

	@SuppressLint("ShowToast")
	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Boot Complete", Toast.LENGTH_SHORT).show();
	}

}
