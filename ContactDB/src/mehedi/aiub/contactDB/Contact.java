package mehedi.aiub.contactDB;

public class Contact 
{
	private int _id;
	private String _name;
	private String _phoneNumber;
	
	public Contact()
	{
		
	}
	
	public Contact(int id,String name,String phoneNumber)
	{
		this._id=id;
		this._name = name;
		this._phoneNumber = phoneNumber;
	}
	
	public Contact(String name,String phoneNumber)
	{
		this._name = name;
		this._phoneNumber = phoneNumber;
	}
	
	public void setID(int id)	
	{
		this._id = id;
	}
	
	public int getID()
	{
		return this._id;
	}
	
	public void setName(String name)
	{
		this._name = name;
	}
	
	public String getName()
	{
		return this._name;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this._phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber()
	{
		return this._phoneNumber;
	}	

}
