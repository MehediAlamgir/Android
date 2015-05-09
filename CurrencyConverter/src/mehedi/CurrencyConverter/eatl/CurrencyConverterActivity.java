package mehedi.CurrencyConverter.eatl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CurrencyConverterActivity extends Activity 
{
	Spinner fromSpinner,toSpinner;
	Button amount;
	EditText result;
	String from,to;
	int amountValue;
	int request_Code=1;
  
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        amount = (Button) findViewById(R.id.amount);
                
        amount.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) 
			{
				
				 fromSpinner = (Spinner) findViewById(R.id.spinner1);
			     toSpinner = (Spinner) findViewById(R.id.spinner2);			         
			     from = fromSpinner.getSelectedItem().toString();
			     to = toSpinner.getSelectedItem().toString();   
			     result = (EditText) findViewById(R.id.result);
			       
//			      Log.d("In Main Activity from  ", "value: "+from);
//			      Log.d("In Main Activity to ", "Value: "+to);
				
				Intent i = new Intent("android.intent.action.ACTIVITY2");
				Bundle extras = new Bundle();
				extras.putString("from", from);
				extras.putString("to", to);			
				i.putExtras(extras);
				
				startActivityForResult(i, request_Code);								
			}
		});
        
    }
	
	public void onActivityResult(int requestCode,int resultCode,Intent data)
	{
		if(requestCode == request_Code )
		{
			if(resultCode == RESULT_OK)
			{
				double res = data.getDoubleExtra("result", 0.0);
				Log.d("Result: ", " "+res);
				result.setText(""+res);
				//result.sett);
			}
		}
	}
}