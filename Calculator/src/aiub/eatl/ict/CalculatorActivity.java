package aiub.eatl.ict;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.PublicKey;

import aiub.eatl.ict.R.string;
import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.sax.Element;
import android.text.StaticLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends Activity 
{
	private final static String FILE = "history.txt"; 
	private EditText editText;
	private float first,second,result;
	public static int  cnt=0,length;
	private String valueOfEditText,t,subString; 
	private String temp,txt;
	private String sign,his;
	private int signPosition,dotPosition;
	public static int removePosition;
	public Button b1;
		
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view1);
    }
    
    //This method is for display orientation change
    public void onConfigurationChanged(Configuration newConfig)
    {
    	super.onConfigurationChanged(newConfig);
    	
    	if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
    	{
    		setContentView(R.layout.view1);
    	}
    	else 
    	{
    		setContentView(R.layout.view2);			
		}
    }    
    
    
    @Override
	protected void onResume() 
    {		
		super.onResume();
		editText = (EditText) findViewById(R.id.editText1);
	}

	public void clicked(View v)
    {
    	Button b = (Button) v;
    	t=b.getText().toString();
    	valueOfEditText=editText.getText().toString().trim();
    	
    	
//    	Log.e("b", "Value: "+b.getText());
//    	Log.e("EditText Value", "Value: "+valueOfEditText);
    	
    	if(valueOfEditText.equals(""))
    	{
    		editText.setText(valueOfEditText+ b.getText());
    		
    		
//    		Log.e("Check ", "1st IF ");
//    		Log.e("Inside If", "EditText: "+editText.getText().toString().trim());
    	}    	
    	
    	else if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/") )
    	{ 
    		b.setBackgroundColor(Color.RED);
    		b1=b;
    		temp = editText.getText().toString().trim();
    		first = Float.parseFloat(temp);
    		sign= b.getText().toString();
    		
    		editText.setText(temp + b.getText());   
    		
    		
//    		Log.e("first ", "value: "+first);
//    		Log.e("Check ", "3rd IF ELSE ");
    	}
    	
    	else if(t.equals("="))
    	{    	
    		b1.setBackgroundResource(android.R.drawable.btn_default); 	// Set Button color to its default color
   
    		
    		temp=editText.getText().toString().trim();
    		his=temp;
    		signPosition = temp.indexOf(sign);
    		subString = temp.substring(signPosition+1); //str="123+345". Then, substring(4)=345
    		second = Float.parseFloat(subString);
    		
    		if(sign.equals("+"))
    		{
    			result = first+second;
    			editText.setText("");
    			temp=Float.toString(result);
    			editText.setText(temp);
    		}
    		
    		else if(sign.equals("-"))
    		{
    			result = first-second;
    			editText.setText("");
    			temp=Float.toString(result);
    			editText.setText(temp);
    		}
    		
    		else if(sign.equals("*"))
    		{
    			result = first*second;
    			editText.setText("");
    			temp=Float.toString(result);
    			editText.setText(temp);
    		}
    		
    		else if(sign.equals("/"))
    		{
    			result = first/second;
    			editText.setText("");
    			temp=Float.toString(result);
    			editText.setText(temp);
    		}    		
    		
    		txt = his + " = " + result;
    		Log.d("history", "val: "+txt);
    		saveHistory(txt);
    		
    		
    		
//    		Log.e("Sign Position", "Position: "+signPosition);  
//    		Log.e("SubString", "2nd Operand Value: "+second);  
//    		Log.e("Check ", "4th IF ELSE(=) ");
    	}
    	
    	else if(!t.equals("+") || !t.equals("-") || !t.equals("*") || !t.equals("/") || !t.equals("=") )
    	{
    		temp = editText.getText().toString().trim();
    		editText.setText(temp+b.getText());	    		
    		
//    		Log.e("Check ", "2nd IF ELSE(!) ");
		}
    	
    }
	
	public void history(View v) 
	{
		readFile();
	}
	
	 public void saveHistory(String str) 
	 {
		 Toast.makeText(getApplicationContext(), "In saveHistory Function", Toast.LENGTH_SHORT).show();
		try 
		{
			OutputStreamWriter out = new OutputStreamWriter(openFileOutput(FILE,Context.MODE_APPEND));
			out.write(str);
			out.write('\n');
			out.close();			
			
		} 
		catch (Exception e) 
		{
			Toast.makeText(getApplicationContext(), "Exception: "+e.toString(), Toast.LENGTH_SHORT).show();
		}
		
	 }
	 
	 public void readFile() 
	 {
		 try 
		 {
			InputStream in = openFileInput(FILE);
			if(in != null)
			{
				InputStreamReader tmp = new InputStreamReader(in);
				BufferedReader reader = new BufferedReader(tmp);
				
				String str;
				StringBuilder buf = new StringBuilder();
				while((str = reader.readLine()) != null)
				{
					buf.append(str);
					buf.append('\n');
				}
				
				in.close();
				editText.setText(buf.toString());
				
			}
		 } 
		 catch (Exception e) 
		 {
			Toast.makeText(getApplicationContext(), "Exception: "+e.toString(), Toast.LENGTH_SHORT).show();
		 }
		
 	 }

	public void clicked_dot(View v)
	 {
	  	Button b=(Button)v;
	  	temp=editText.getText().toString();
	   	length = temp.length();
	   	subString = temp.substring(length-1, length);
	   	
	   	if(length>0 && subString.equals("."))
	   	{
	   		
	   	}
	   	else
	   	{
	   		editText.setText(editText.getText().toString()+b.getText());       	
	   	}
    }
	
	 
	 public void clear(View v) 
	 {
		editText.setText("");
	 }
	 
	 
	 public void delete(View v)
	 {
		 temp=editText.getText().toString();
		 removePosition = temp.length();
		 
		 editText.setText(temp.substring(0, removePosition-1) + temp.substring(removePosition));
		 
	 }
}