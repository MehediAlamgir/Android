package mehedi.aiub.sqlitedb;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class SQLiteDBActivity extends Activity {
	 
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        SharedPreferences settings = getSharedPreferences("DATA", 0);
        String dataStatus = settings.getString("loaded", "no");
        if(dataStatus.contains("no"))
        {
        	createDatabase();
        	SharedPreferences.Editor editor = settings.edit();
        	editor.putString("loaded", "yes");
        	editor.commit();
        }            
        else
        {
        	readRecords();
        }
                
    }
    
    void createDatabase()
    {
    	SQLiteDatabase db = openOrCreateDatabase("MyDb", MODE_PRIVATE, null);
    	
    	String sql = "CREATE TABLE IF NOT EXISTS MyTable "+"(FirstName VARCHAR," + "LastName VARCHAR," + 
    					"Age INT(3));";
    	
    	db.execSQL(sql);
    	
    	String insertSQL = "INSERT INTO MyTable VALUES ('Rahim','Karim',23);";
    	db.execSQL(insertSQL);
    	Toast.makeText(getApplicationContext(), "Database Created and Value Inserted Successfully", Toast.LENGTH_SHORT).show();
    	db.close();
    }
    
    void readRecords()
    {
    	SQLiteDatabase db = openOrCreateDatabase("MyDb", MODE_PRIVATE, null);
    	String sql = "SELECT * FROM MyTable ;";
    	Cursor c = db.rawQuery(sql, null);
    	c.moveToFirst();
    	String name = c.getString(c.getColumnIndex("FirstName"));
    	Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
    	db.close();
    	
    }
}