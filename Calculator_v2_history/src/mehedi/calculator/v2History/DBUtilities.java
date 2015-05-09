package mehedi.calculator.v2History;

import java.util.ArrayList;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;



public class DBUtilities
{
	SQLiteDatabase db;
	Context context;
	String dbname;
	
	public  DBUtilities(String dbname,Context context)
	{
		db=context.openOrCreateDatabase(dbname+".db",Context.MODE_PRIVATE, null);
		this.context=context;
		this.dbname=dbname;
	}
	
	public void dropTable(String tableName)
	{
		db=context.openOrCreateDatabase(dbname+".db", Context.MODE_PRIVATE, null);
		String query = "Drop Table "+tableName;
		try {
			db.execSQL(query);
			//Toast.makeText(this.context, "Table Dropped", Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			// TODO: handle exception
			//Toast.makeText(this.context, "Table does not Dropped", Toast.LENGTH_LONG).show();
		}
	}
	
	public void createTable(String tablename,ArrayList<String> content)
    {
		
    	db=context.openOrCreateDatabase(dbname+".db",Context.MODE_PRIVATE, null);
    	int size=content.size();
    	//String tq="create table if not exists itemlist (id integer primary key autoincrement,name text);";
    	String query = "create table if not exists "+tablename+" (";
    	
    	for(int i=0;i<=size-1;i++)
		{
			query += content.get(i)+",";
		}
    	
		query=query.substring(0, query.length()-1);	//substring(0, 4) -->> "abcdeg"-->>abcd
		
		query=query+");";
		
		//return query;
		try
		{
	    	db.execSQL(query);
	    	//Toast.makeText(this.context, "table created", Toast.LENGTH_LONG).show();
		}
		catch(Exception e)
		{
			//Toast.makeText(this.context, "table not created", Toast.LENGTH_LONG).show();	
		}   	
    	
    }
	
	public void insertData(String tablename,ArrayList<Object> data)
	{		
		int size=data.size();
		String x=null;
		String y=null;
		String z=data.get(1).getClass().toString();
		z=z.substring(16, z.length());
					
		String query="insert into "+tablename+"(operand1,operand2,sign,result) values(";
		
		for(int i=0;i<=size-1;i++)
		{
			y=data.get(i).getClass().toString();
			y=y.substring(16, y.length());
		
			if(data.get(i).toString().equals("null"))
			{
				query+=data.get(i)+",";
			}
			else if(y.equals("String"))
			{
				query+="'"+data.get(i)+"',";
			}
			else
			{
				query+=data.get(i)+",";
			}
		}
		
		query=query.substring(0, query.length()-1);
		query=query+");";
		
		try
		{
			db.execSQL(query);
			//Toast.makeText(this.context, "Data Inserted", Toast.LENGTH_LONG).show();
		}
		catch(Exception e)
		{
			//Toast.makeText(this.context, "Data insertion failed", Toast.LENGTH_LONG).show();
		}
	}
	
}
