package aiub.eatl.ict;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class AnimationActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView view = (TextView) findViewById(R.id.TextView1);
        //Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
       // Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
       // Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
       // Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
       // Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
       // Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.move);
       // Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
       // Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        //Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);
       // Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.sequential_animation);
        Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.together_animation);

        view.startAnimation(myAnimation);
        
    }
}