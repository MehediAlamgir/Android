package com.aiub.sp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SensorProfileActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
    
    public void BtnStart(View v)
    {
//    	Log.d("BtnStart","Inside BtnStart");
    	
    	Intent intent = new Intent(getBaseContext(), ServiceClass.class);
    	Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
    	startService(intent);
    
	}
    
    public void BtnStop(View v)
    {
    	Intent intent = new Intent(getBaseContext(), ServiceClass.class);
    	Toast.makeText(this, "Service Stoped", Toast.LENGTH_SHORT).show();
    	stopService(intent);
    	
		
	}
}