package mehedi.aiub.highscore;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HighScoreActivity extends Activity 
{
	TextView highScore,randValue;
	Button playButton,resetButton;	
	
	Random random = new Random();
	int randNumber,val,temp=0;
	String value;
	SharedPreferences myPref;
	public static final String PREFS_NAME = "MyPrefsFile";
	public static int cnt=1;
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        highScore = (TextView) findViewById(R.id.highScore);
        randValue = (TextView) findViewById(R.id.randValue);
        
        playButton = (Button) findViewById(R.id.play);
        resetButton = (Button) findViewById(R.id.reset);
        
        
        myPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		value = myPref.getString("score", "0");
		
        saveInSharedPreference(Integer.parseInt(value));
        highScore.setText(value);
        
        
//        if(randValue.getText()==null)
//        {
//        	randValue.setText(0);
//        }
//        
        
        playButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
				randNumber = generateRandomNumber(random,1,10000);
				randValue.setText(""+randNumber);		
				myPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
				value = myPref.getString("score", "0");
				//Log.d("Value o0f Temp: ", " "+temp);
				//Log.d("Value o0f value: ", " "+value);
				val =  Integer.parseInt(value);
				//highScore.setText(""+val);
				 if(val<randNumber)
				 {
					 highScore.setText(""+ randNumber);
					 saveInSharedPreference(randNumber);
					 
				 }
				
			}
		});
        
        
        resetButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
				randValue.setText("");
				clearSharedPreference();
			//	highScore.setText("");
				
			}
		});
        
    }    
    
    public static int generateRandomNumber(Random random,int low,int high)
    {
    	int number = random.nextInt(high) + low;
    	return number;
    }
    
    public void saveInSharedPreference(Integer value)
    {
    	//Log.d("cnt : ","value: "+cnt);
        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        myPref = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPref.edit();
        editor.putString("score", value.toString());

        // Commit the edits!
        editor.commit();
    }
    
    public void clearSharedPreference()
    {
    	SharedPreferences preferences = getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
    	SharedPreferences.Editor editor = preferences.edit();
    	editor.clear(); 
    	editor.commit();
    }
}