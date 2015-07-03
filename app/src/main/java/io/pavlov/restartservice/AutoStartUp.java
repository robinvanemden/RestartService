package io.pavlov.restartservice;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.os.IBinder;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.content.Intent;

public class AutoStartUp extends Service {
	private static final String TAG = AutoStartUp.class.getSimpleName();
    private BluetoothAdapter bluetoothAdapter;
    private ArrayAdapter<String> btArrayAdapter;


    @Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        Log.d(TAG, "service started running");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
        sendBroadcast(new Intent("YouWillNeverKillMe"));
	}




}

