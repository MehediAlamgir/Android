package com.example.audionmanager;


//import android.content.Context;
import android.media.AudioManager;
import android.view.View;
import android.view.View.OnClickListener;


public class listener implements OnClickListener {

	private MainActivity m;
	
	public listener(MainActivity activity){
		m = activity;pro
	}
	/*public listener(MainActivity activity)
	{
		m = activity;	
	}*/
	
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==R.id.home){
			m.am.setStreamVolume(AudioManager.STREAM_RING,m.am.getStreamMaxVolume(AudioManager.STREAM_RING),AudioManager.FLAG_PLAY_SOUND);
			m.text.setText("Home Profile Activated");
			m.toast.show();
		}
		if(arg0.getId()==R.id.pocket){
			m.am.setStreamVolume(AudioManager.STREAM_RING, 1, AudioManager.FLAG_ALLOW_RINGER_MODES|AudioManager.FLAG_PLAY_SOUND);
			m.text.setText("Pocket Profile Activated");
			m.toast.show();
		}
		if(arg0.getId()==R.id.silent){
			m.am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
			m.text.setText("Silent Profile Activated");
			m.toast.show();
		}
	}
/*
	public void silent()
    {
    	AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		audio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);	
    }
    
    public void night()
    {
    	AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		audio.setStreamVolume(AudioManager.STREAM_RING, 1, AudioManager.FLAG_ALLOW_RINGER_MODES|AudioManager.FLAG_PLAY_SOUND);
    	//audio.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER, AudioManager.VIBRATE_SETTING_ON);
    	
    }
    
    public void outdoor()
    {
    	AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		audio.setStreamVolume(AudioManager.STREAM_RING,audio.getStreamMaxVolume(AudioManager.STREAM_RING),AudioManager.FLAG_PLAY_SOUND);
    	//audio.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER,AudioManager.VIBRATE_SETTING_ON);
    	
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==R.id.home){
			night();
		}
		if(arg0.getId()==R.id.pocket){
			outdoor();
		}
		if(arg0.getId()==R.id.silent){
		   silent();
		}
	}
	*/

	

}
