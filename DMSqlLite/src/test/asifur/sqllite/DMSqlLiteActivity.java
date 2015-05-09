package test.asifur.sqllite;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DMSqlLiteActivity extends Activity {
    /** Called when the activity is first created. */
	ListView list;
	ArrayList<String> contactList;
	ArrayAdapter<String> adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
         list=(ListView)findViewById(R.id.listView1);
         
         SharedPreferences settings= getSharedPreferences("DATA", 0);
         contactList=new ArrayList<String>();
         String dataStatus=settings.getString("loaded", "no");
         DatabaseHandler db = new DatabaseHandler(this);
         if(dataStatus.equals("no"))
         {
        	    Log.d("Insert: ", "Inserting ..");
                db.addContact(new Contact("Rahim", "01720000000"));       
                db.addContact(new Contact("Karim", "01810000000"));
                db.addContact(new Contact("Ramm",  "01670000000"));
                db.addContact(new Contact("Sham",  "01910000000"));
                
               
                SharedPreferences.Editor editor= settings.edit();
                editor.putString("loaded", "yes");
                editor.commit();            
                
                
        }	 
        	   // Reading all contacts
             Log.d("Reading: ", "Reading all contacts..");
             List<Contact> contacts = db.getAllContacts();      
              
             for (Contact cn : contacts) 
             {
                 String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                 // Writing Contacts to log
                 Log.d("Name: ", log);
                 contactList.add(cn.getName()); 
             }
             adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,contactList);
             list.setAdapter(adapter);
             
         }
         
}