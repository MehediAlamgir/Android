package test.asifur.sqllite;


import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import test.asifur.sqllite.R;

public class SimpleDatabaseOperationActivvity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
         
        SharedPreferences settings= getSharedPreferences("DATA", 0);
      
        String dataStatus=settings.getString("loadedSD", "no");
             if(dataStatus.equals("no"))
             {
            	 createDatabase();
             }
             
             else
             {
            	 readRecords();
                 SharedPreferences.Editor editor= settings.edit();
                 editor.putString("loadedSD", "yes");
                 editor.commit();
                 
             }
             
             
         }
    
    void createDatabase()
    {
    	 SQLiteDatabase db= openOrCreateDatabase("MyDb", MODE_PRIVATE, null);
         
         String sql="CREATE TABLE IF NOT EXISTS MyTable " +
         		"( FirstName VARCHAR ," + "LastName VARCHAR ,"+
         		"Age INT(3));";
         db.execSQL(sql);
         
         String insertSql="INSERT INTO MyTable VALUES ('Rahim','Karim',23);";
         
         db.execSQL(insertSql);
         db.close();             
    }
         
    void readRecords()
    {
    	 SQLiteDatabase db= openOrCreateDatabase("MyDb", MODE_PRIVATE, null);
         String sql="SELECT * from MyTable ;";
         Cursor c= db.rawQuery(sql, null);
         c.moveToFirst();
         String name=c.getString(c.getColumnIndex("FirstName"));
         Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
         db.close();
    }
     
         
     
}
