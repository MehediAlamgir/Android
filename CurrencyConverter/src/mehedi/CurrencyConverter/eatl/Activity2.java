package mehedi.CurrencyConverter.eatl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends Activity 
{
	int amount;
	double taka,dollar,value;
	String from,to;
	EditText amountValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity2);
		 
		 amountValue = (EditText) findViewById(R.id.amountValue);
		 Button showResult = (Button) findViewById(R.id.showResult);
		 
		 showResult.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) 
			{
				Intent data = new Intent();
				Bundle extras = getIntent().getExtras();
				if(extras != null)
				{					
					from = extras.getString("from");
					to = extras.getString("to");
					amount = Integer.parseInt(amountValue.getText().toString());
//					
//					Log.d("from  ", "value: "+from);
//					Log.d("to ", "Value: "+to);
//					Log.d("amount ", "Value: "+amount);
					
					if(from.equalsIgnoreCase("Dollar") && to.equalsIgnoreCase("Taka"))
					{
//						Log.d("First If ", " Block");
						value = amount*78;
					}
					
					else if(from.equalsIgnoreCase("Taka") && to.equalsIgnoreCase("Dollar"))
					{
//						Log.d("First If ", " Block");
						value = amount/78.0;
					}
				}
//				Toast.makeText(getApplicationContext(), "Taka: "+value, Toast.LENGTH_SHORT).show();
				
				data.putExtra("result", value);
				setResult(RESULT_OK, data);
				
				finish();
				
			}
		});
	}

}
