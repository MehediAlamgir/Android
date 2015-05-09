package hr.aiub.sharedpref;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefActivity extends Activity 
{
	public static final String PREFS_NAME = "MyPrefsFile";
	TextView txtView;
	EditText edit;
	Button btn; 
	SharedPreferences myPref;
    
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.txtView = (TextView) findViewById(R.id.TextView1);
        this.edit = (EditText)findViewById(R.id.editText1);
        this.btn=(Button)findViewById(R.id.button1);
        // Restore preferences
        this.myPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String str = myPref.getString("info", "No Info Found");
        
        this.txtView.setText(str);
    }
    
    public void save(View v)
    {
        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        this.myPref = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = this.myPref.edit();
        editor.putString("info", this.edit.getText().toString());

        // Commit the edits!
        editor.commit();
    }
}