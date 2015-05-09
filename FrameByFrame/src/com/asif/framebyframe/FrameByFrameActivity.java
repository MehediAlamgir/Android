package com.asif.framebyframe;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class FrameByFrameActivity extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final ImageView player = (ImageView) findViewById(R.id.player);
        player.setImageResource(R.drawable.frameanimation);
        player.post(new Runnable() 
        {
            public void run() 
            {             
                AnimationDrawable animationDrawable = (AnimationDrawable)player.getDrawable();
                animationDrawable.start();
            }
          });
        
        
		//player.setBackgroundResource(R.drawable.frameanimation);
		//AnimationDrawable anim = (AnimationDrawable) player.getDrawable();
		//anim.start();
    }
}