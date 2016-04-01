package com.mission.broadcastsdemo;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
 * ����ʹ�õ���ϵͳ�㲥
 */
public class MainActivity extends Activity {

	private IntentFilter intentFilter;
	private NetworkChangeReceiver networkChangeReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//�Զ���㲥
		Button button = (Button) findViewById(R.id.btn);
		button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent("com.mission.broadcastsdemo.MY_BROADCAST");
				//���ͱ�׼�㲥
//				sendBroadcast(intent);
				//��������㲥
				sendOrderedBroadcast(intent, null);
			}
		});
		
		
		intentFilter = new IntentFilter();
		intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		networkChangeReceiver = new NetworkChangeReceiver();
		//�����ڴ�����ע��㲥
		registerReceiver(networkChangeReceiver, intentFilter);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(networkChangeReceiver);
	}
	
	class NetworkChangeReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
			if (networkInfo != null && networkInfo.isAvailable()) {
				Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
			}
		}
		
	}

}
