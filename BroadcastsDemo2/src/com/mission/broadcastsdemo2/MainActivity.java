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
 * @date 2016��2��24��
 * @type_name MainActivity
 * 
 * ʹ�ñ��ع㲥�����ͺͽ���ֻ���ڸó����ڲ�
 * 
 * ���ع㲥���޷�ͨ����̬ע�᷽ʽ�����յ�
 */
public class MainActivity extends Activity {

	private IntentFilter intentFilter;
	
	private LocalReceiver localReceiver;
	
	private LocalBroadcastManager localBroadcastManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		localBroadcastManager = localBroadcastManager.getInstance(this);//��ȡʵ��
		
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
