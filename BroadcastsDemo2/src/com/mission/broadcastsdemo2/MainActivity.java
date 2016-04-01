package com.mission.broadcastsdemo2;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author Taoke
 * @date 2016年2月24日
 * @type_name MainActivity
 * 
 * 使用本地广播，发送和接受只能在该程序内部
 * 
 * 本地广播是无法通过静态注册方式来接收的
 */
public class MainActivity extends Activity {

	private IntentFilter intentFilter;
	
	private LocalReceiver localReceiver;
	
	private LocalBroadcastManager localBroadcastManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		localBroadcastManager = localBroadcastManager.getInstance(this);//获取实例
		
		Button button = (Button) findViewById(R.id.btn);
		button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent("com.mission.broadcasttest.LOCAL_BROADCAST");
				localBroadcastManager.sendBroadcast(intent);
			}
		});
		
		intentFilter = new IntentFilter();
		intentFilter.addAction("com.mission.broadcasttest.LOCAL_BROADCAST");
		localReceiver = new LocalReceiver();
		localBroadcastManager.registerReceiver(localReceiver, intentFilter);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		localBroadcastManager.unregisterReceiver(localReceiver);
	}
	
	class LocalReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
		}
		
	}
	

}
