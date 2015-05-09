package mehedi.calculator.v2History;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculator_v2_historyActivity extends Activity
{
	private EditText txt;
	public float res,temp;
	public String s,s1; 
	private boolean flag;
	private String sign;
	private float first;
	private float second;
	DBUtilities dbUtilities;
	
	
	/** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        dbUtilities=new DBUtilities("mydb", getApplicationContext());
        
        dbUtilities.dropTable("history");
        
        ArrayList<String> content=new ArrayList<String>();
        
     // content.add(0,"id integer primary key autoincrement");
        content.add(0,"operand1 text");
        content.add(1,"operand2 text");
        content.add(2,"sign text");
        content.add(3,"result text");
        
        dbUtilities.createTable("history", content);
        
    }
 
    @Override
   	protected void onResume() {
   	
   		super.onResume();
   		txt = (EditText)findViewById(R.id.text);
   		
   	}
    
    public void clicked(View v)
    {
    	Button b=(Button)v;
    	txt.setText(txt.getText().toString()+b.getText());
    	s1=txt.getText().toString();
    	flag=true;
    }
    
    public void clicked_dot(View v)
    {
    	Button b=(Button)v;
    	
    	if(txt.getText().toString().contains("."))
    	{
    		
    	}
    	else
    	{
    		txt.setText(txt.getText().toString()+b.getText());
        	s1=txt.getText().toString();   
        	
    	}
    	flag=true;
    }
    
    public void clicked_plus(View v)
    {
    	//Button b=(Button) findViewById(R.id.add);   	
    	first = Float.parseFloat(txt.getText().toString().trim()); 
    	txt.setText("");  
    	sign="+";
    	//sign=(char)b;
    	
    }
    
    public void clicked_minus(View v)
    {
    	//Button b=(Button)v;    	
    	first = Float.parseFloat(txt.getText().toString().trim()); 
    	txt.setText("");  
    	sign="-";
    	
    }
    public void clicked_multiply(View v)
    {
    	//Button b=(Button)v;    	
    	first = Float.parseFloat(txt.getText().toString().trim()); 
    	txt.setText("");  
    	sign="*";
    	
    }
    
    public void clicked_divide(View v)
    {
    	//Button b=(Button)v;    	
    	first = Float.parseFloat(txt.getText().toString().trim()); 
    	txt.setText("");  
    	sign="/";
    	
    }
    

    public void clicked_eq(View v)
    {
    	if(flag==true)
		{
			second = Float.valueOf(txt.getText().toString());
			flag=false;	
			
		}
		else
			first = Float.valueOf(txt.getText().toString());
    	
    	if(sign=="+")
    	{    		
    		res =first+second;    		
    	}
    	
    	if(sign=="-")
    	{
    		res =first-second;
    	}
    	
    	if(sign=="/")
    	{
    		res =first/second;
    	}
    	
    	if(sign=="*")
    	{
    		res =first*second;
    	}
    	
    	s=Float.toString(res);
    	txt.setText(s);   
    	
    	ArrayList<Object> data = new ArrayList<Object>();
    	
    	 data.add(0,Float.toString(first));
         data.add(1,Float.toString(second));
         data.add(2,sign.toString());
         data.add(3,Float.toString(res));
         
         dbUtilities.insertData("history", data);   
    	
    }   

    
    public void clicked_history(View v)
    {
    	Intent i = new Intent(this,Activity2.class);
    	//EditText et = (EditText) findViewById(R.id.text);
    	//String str =  et.getText().toString();
    	//i.putExtra("H",str);
    	startActivity(i);
    	
    }

	
   
}