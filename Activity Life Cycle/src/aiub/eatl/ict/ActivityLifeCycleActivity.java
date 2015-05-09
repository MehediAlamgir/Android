package aiub.eatl.ict;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class ActivityLifeCycleActivity extends Activity 
{	
	String tag="Events";
	Button btn;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       
        requestWindowFeature(Window.FEATURE_NO_TITLE);	// ​hides the title bar of pop up theme

        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener(){
			
			public void onClick(View arg0) 
			{
				Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
				
			}
		});
        
        Log.d(tag, "In onCreate() Method");
    }
    
	@Override
	protected void onStart() 
	{
		super.onStart();
		Log.d(tag, "In onStart() Method");
	}

	@Override
	protected void onResume() 
	{
		super.onResume();
		Log.d(tag, "In onResume() Method");
	}	

	@Override
	protected void onPause() 
	{
		super.onPause();
		Log.d(tag, "In onPause() Method");
	}

	@Override
	protected void onStop() 
	{
		super.onStop();
		Log.d(tag, "In onStop() Method");
	}	
	
	@Override
	protected void onRestart() 
	{
		super.onRestart();
		Log.d(tag, "In onSResart() Method");
	}

	@Override
	protected void onDestroy() 
	{
		super.onDestroy();
		Log.d(tag, "In onDestroy() Method");
	}
	

}