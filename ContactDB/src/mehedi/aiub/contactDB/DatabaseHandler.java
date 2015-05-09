package mehedi.aiub.contactDB;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper
{
	//Database Version
	private static final int DATABASE_VERSION = 1;
	//Database Name
	private static final String DATABASE_NAME = "contactsManager";
	//Database Table Name
	private static final String TABLE_CONTACTS = "contacts";
	
	//Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_PH_NO = "phone_number";


	public DatabaseHandler(Context context) 
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	//Creating table
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_PH_NO + " TEXT" + ")" ;
		db.execSQL(CREATE_CONTACTS_TABLE);
		
	}

	//Updating table
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		//Drop older table if exists
		String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_CONTACTS;		
		db.execSQL(DROP_TABLE);
		
		//Create New Table
		onCreate(db);		
		
	}
	
	//Adding new contact
	public void addContact(Contact contact)
	{
		SQLiteDatabase db = this.getWritableDatabase(); // Open this "class contex" database with write permission
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_PH_NO, contact.getPhoneNumber());
		
		db.insert(TABLE_CONTACTS, null, values);
		db.close();
		
	}
	
	//Getting Single Contact
	public Contact getContact(int id)
	{
		SQLiteDatabase db = this.getReadableDatabase(); // Open this "class contex" database with Read  permission
		
		String[] columns = new String[] {KEY_ID,KEY_NAME,KEY_PH_NO};
		String[] valueOfID = new String[] {String.valueOf(id)};		
		
		Cursor cursor = db.query(TABLE_CONTACTS, columns, KEY_ID + "=?", valueOfID, null, null, null);
		
		if(cursor != null)
		{
			cursor.moveToFirst();
		}
		
		int ID = Integer.parseInt(cursor.getString(0));
		String NAME = cursor.getString(1);
		String PH_NO = cursor.getString(2);
		
		Contact contact = new Contact(ID,NAME,PH_NO);
		
		return contact;
		
	}
	
	//Getting All Contacts
	public List<Contact> getAllContacts()
	{
		List<Contact> contactList = new ArrayList<Contact>();
		
		//Select All Query
		String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		
		//Looping through all rows and adding to the list
		
		if(cursor.moveToFirst())
		{
			do
			{
				Contact contact = new Contact();
				int ID = Integer.parseInt(cursor.getString(0));
				String NAME =  cursor.getString(1);
				String PH_NO = cursor.getString(2);
				
				contact.setID(ID);
				contact.setName(NAME);
				contact.setPhoneNumber(PH_NO);
				
				//Adding contacts to list
				contactList.add(contact);
				
			}while(cursor.moveToNext());
		}
		
		
		return contactList;		
		
	}
	
	//Updating single contact
	public int updateContact(Contact contact)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_PH_NO, contact.getPhoneNumber());
		
		return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?", new String[] {String.valueOf(contact.getID())});
		
		
	}
	
	//Deleting single contact	
	public void deleteContact(Contact contact)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		db.delete(TABLE_CONTACTS, KEY_ID + " = ?",  new String[] {String.valueOf(contact.getID())});
	}
	
	//Getting contacts Count
	public int getContactsCount()
	{
		String countQuery = "SELECT * FROM " + TABLE_CONTACTS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		db.close();
		
		//return count
		return cursor.getCount();
		
	}
}
