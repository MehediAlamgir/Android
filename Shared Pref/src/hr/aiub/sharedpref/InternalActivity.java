package hr.aiub.sharedpref;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class InternalActivity extends Activity 
{

	Button btnWrite, btnRead, btnRaw;
	TextView txtView, txtRaw;
	EditText editText;
	String FILENAME = "test.txt";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.internal_main);
		
		this.btnRead = (Button) findViewById(R.id.btnShowData);
		this.btnWrite = (Button) findViewById(R.id.btnWriteData);
		
		this.txtView = (TextView) findViewById(R.id.txtViewData);
		this.editText = (EditText) findViewById(R.id.editText);
		
		this.btnRaw = (Button) findViewById(R.id.btnReadRaw);
		this.txtRaw = (TextView) findViewById(R.id.txtRawView);
		
		addButtonListener();	
		
		addRawButtonListener();
	}

	private void addRawButtonListener() 
	{
		
		this.btnRaw.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				InputStream is = getResources().openRawResource(R.raw.myfile);
				
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader buffer = new BufferedReader(isr);
				
				StringBuilder sb = new StringBuilder();
				String line;
			
				try 
				{
					while ((line = buffer.readLine()) != null) 
					{
						sb.append(line);
					}
				}catch (IOException e) {
				
					e.printStackTrace();
				}		
			
				
				try 
				{
					buffer.close();
					isr.close();
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				txtRaw.setText(sb);
			}
		});
		
	}

	private void addButtonListener() 
	{
		
		this.btnWrite.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
				
				String data = editText.getText().toString();

				FileOutputStream fos = null;
				try 
				{
					fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
					//fos = openFileOutput(FILENAME, Context.MODE_APPEND);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				try {
					fos.write(data.getBytes());
					fos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		this.btnRead.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
				
				FileInputStream fis = null;
				try 
				{
					fis = openFileInput(FILENAME);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				InputStreamReader inputStreamReader = new InputStreamReader(fis);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
				StringBuilder sb = new StringBuilder();
				String line;
			
				try 
				{
					while ((line = bufferedReader.readLine()) != null) 
					{
						sb.append(line);
					}
				}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
				
			
				try {
					bufferedReader.close();
					inputStreamReader.close();
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				txtView.setText(sb);
			}
		});
		
	}

	
}
