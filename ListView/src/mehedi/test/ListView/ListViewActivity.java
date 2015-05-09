package mehedi.test.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends Activity 
{   
	private ListView mainListView;
	private ArrayAdapter<String> listAdapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mainListView =   (ListView) findViewById(R.id.mainListView);
        
        String[] planets = new String[] {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
        ArrayList<String>planetList = new ArrayList<String>();
        planetList.addAll(Arrays.asList(planets));
        
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow,planetList);
        
        listAdapter.add("Ceres");
        listAdapter.add("Pluto");
        listAdapter.add("Haumea");
        listAdapter.add("MakeMake");
        listAdapter.add("Eris");
        
        mainListView.setAdapter(listAdapter);
        
        mainListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View v, int arg2,long arg3) 
			{
				TextView tv = (TextView) v.findViewById(R.id.textView1); 
				Toast.makeText(getApplicationContext(), "You Have Clicked: "+ tv.getText(), Toast.LENGTH_SHORT).show();
				
			}
        	
		});
        
    }
    
    
}