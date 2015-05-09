package mehedi.calculator.v2History;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

public class Activity2 extends Activity
{

	SQLiteDatabase db;
    String history;
    
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		
		//Toast.makeText(this.getBaseContext(), "Inside Oncreate 1", Toast.LENGTH_LONG).show();
		
		db=this.openOrCreateDatabase("mydb.db",Context.MODE_PRIVATE, null);
		
		EditText et1 = ((EditText) findViewById(R.id.history_text));
		
		history="";
		
		//Cursor resultCursor=db.rawQuery("SELECT * FROM history", null);
		Cursor resultCursor=db.rawQuery("SELECT * FROM history", null);
		//Toast.makeText(this.getBaseContext(), "After Cursor object initialization 2", Toast.LENGTH_LONG).show();
		
		resultCursor.moveToFirst();
		while(!resultCursor.isAfterLast())
		{
			//Toast.makeText(this.getBaseContext(), "After While loop 3", Toast.LENGTH_LONG).show();
			
		//	int id=resultCursor.getInt(0);
		  String first=resultCursor.getString(0);
		  String second=resultCursor.getString(1);
		  String sign=resultCursor.getString(2);
		  //history+="=";
		  String result=resultCursor.getString(3);
		  history+=first+sign+second+"="+result+"\n"; 
		  //history+=id+second+first+"="+sign+"\n";  //first=0,sign=2,second=1,result=3

		  resultCursor.moveToNext();
		  
		}
		et1.setText(history);
		}
		
	}
	
	


