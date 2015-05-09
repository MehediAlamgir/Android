package aiub.ict.eatl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

//To use onClickListener interface as Event Listener, then you have to implement onClickListener interface.OR If you use inline Event Listener , then need not to implement onClickListener interface.

public class ButtonActivity extends Activity implements OnClickListener  
{
	Button button1,button2,button3;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
         button1 = (Button) findViewById(R.id.button1);
         button2 = (Button) findViewById(R.id.button2);
         button3 = (Button) findViewById(R.id.button3);
         
       //Using inline Event Listener
        button1.setOnClickListener(new OnClickListener() { 
			
			public void onClick(View v) {
				
				Toast.makeText(getApplicationContext(), "You Clicked Button 1", Toast.LENGTH_SHORT).show();
			}
		});
        
        //Using OnClickListener Interface
        
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);        
       
    }

	public void onClick(View v)  //Override method of onClickListener interface.
	{
		
//		if(v.getId() == R.id.button2)
		if(v.getId() == button2.getId()) //both of these two types of checks are ok
		{
			Toast.makeText(getApplicationContext(), "You Clicked Button 2", Toast.LENGTH_SHORT).show();
		}
		
		if(v.getId() == R.id.button3)
		{
			Toast.makeText(getApplicationContext(), "You Clicked Button 3", Toast.LENGTH_SHORT).show();
		}		
	}
	
	
	//Using xml defined method 
	public void onClickMethodFromXml(View v)
	{
		Toast.makeText(getApplicationContext(), "You Clicked Button 4", Toast.LENGTH_SHORT).show();
	}
}