package com.example.audionmanager;


import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button home,pocket,silent;
	public AudioManager am;
	Toast toast;
	LinearLayout layout;
	TextView text;
	//public Context c;
	
	@Override
	protected void onResume() {
		
		// TODO Auto-generated method stub
		super.onResume();
		
		listener list= new listener(this);
		layout.addView(text);
		toast.setView(layout);
		//listener list= new listener();
		home = (Button) findViewById(R.id.home);
		pocket = (Button) findViewById(R.id.pocket);
		silent = (Button) findViewById(R.id.silent);
		
		home.setOnClickListener(list);
		pocket.setOnClickListener(list);
		silent.setOnClickListener(list);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//c.getApplicationContext();
		am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		toast = new Toast(this);
		layout = new LinearLayout(this);
		text = new TextView(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/*public Context ret_main(){
		return this.c;
	}*/
}
