package mehedi.aiub.contactDB;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Contacts.Settings;
import android.util.Log;
import android.widget.ArrayAdapter;

public class ContactDBActivity extends Activity 
{	
	ArrayList<String> contactList;
	 ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        SharedPreferences settings = getSharedPreferences("DATA", 0);
        contactList = new ArrayList<String>();
        String dataStatus = settings.getString("loaded", "no");
        DatabaseHandler db = new DatabaseHandler(this);
        
        if(dataStatus.equals("no"))
        {
        	Log.d("Insert ", "Inserting ..");
        	db.addContact(new Contact("Rahim", "01674555366"));
        	db.addContact(new Contact("Karim", "01774555366"));
        	db.addContact(new Contact("Rahim", "0174555366"));
        	db.addContact(new Contact("Rahim", "01674555366"));
        	
        	
        	SharedPreferences.Editor editor = settings.edit();
        	editor.putString("loaded", "yes");
        	editor.commit();

        }
        
        //Reading All Contacts
        Log.d("Reading: ", "Reading All Contacts..");
        List<Contact> contacts = db.getAllContacts();
        
        for(Contact con : contacts)
        {
        	String log = "ID: " + con.getID() + " ,Name: " + con.getName() + " ,Phone: " + con.getPhoneNumber();
        	
        	//Writing Contacts to log
        	Log.d("Name: ", log);
        	contactList.add(con.getName());
        }
        
        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.main);
        list.setAdapter(adapter);
    }
}