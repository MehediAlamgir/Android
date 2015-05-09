package mehedi.aiub.ict;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class TranslateTweenAnimationActivity extends Activity {
	Animation animation;
	TextView translatetext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		getInit();
	}

	public void getInit() {
		translatetext = (TextView) findViewById(R.id.translatetext);
		animation = AnimationUtils.loadAnimation(this, R.anim.translate);
		translatetext.startAnimation(animation);
	}

}