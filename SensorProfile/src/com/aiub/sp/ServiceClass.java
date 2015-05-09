package com.aiub.sp;


import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.widget.Toast;


public class ServiceClass extends IntentService implements SensorEventListener
{
	public ServiceClass() 
	{
		super("MehediIntentServ");
		// TODO Auto-generated constructor stub
	}
	
	private SensorManager sensorManager;
	private Sensor proxSensor;
	private AudioManager audioManager;
	private int flag=0;
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
	//Toast.makeText(this, "onStartCommand Started", Toast.LENGTH_SHORT).show();

//		Log.d("onStartCommand","Inside onStartCommand");

		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		proxSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		
		if(flag==0)
		{
			sensorManager.registerListener(this, proxSensor, SensorManager.SENSOR_DELAY_NORMAL);
			flag=1;
		}

		//return super.onStartCommand(intent, flags, startId);
		return START_STICKY;

	}
	
	@Override
	public void onDestroy() 
	{
		super.onDestroy();
		sensorManager.unregisterListener(this);
		// Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
	}

	public void onAccuracyChanged(Sensor arg0, int arg1)
	{
		// TODO Auto-generated method stub
		
	}

	public void onSensorChanged(SensorEvent event) 
	{
//		Log.d("onSensorChanged","Inside onSensorChanged");

		float val = event.values[0];

		if(val==0.0)
		{
			audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
			Toast.makeText(this, "Vibration Activated", Toast.LENGTH_SHORT).show();
		}

		else
		{
			audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
			Toast.makeText(this, "Vibration Activated", Toast.LENGTH_SHORT).show();

		}
		
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		
	}

}
