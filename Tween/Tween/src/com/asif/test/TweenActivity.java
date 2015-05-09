package com.asif.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class TweenActivity extends Activity 
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView view = (TextView) findViewById(R.id.Textview1);
		Animation myanimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
		view.startAnimation(myanimation);
    }
}