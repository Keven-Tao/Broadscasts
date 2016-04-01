package com.mission.broadcastsdemo;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author Taoke
 * @date 2016��2��24��
 * @type_name BootCompleteReceiver
 * 
 * ��Mainfest�ļ��о�̬ע��㲥
 */
public class BootCompleteReceiver extends BroadcastReceiver {

	@SuppressLint("ShowToast")
	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Boot Complete", Toast.LENGTH_SHORT).show();
	}

}
