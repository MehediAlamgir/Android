package aiub.eatl.ict;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class IntentActivity extends Activity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       // First intent to use ACTION_VIEW action with correct data
       Button startBrowser_a = (Button) findViewById(R.id.start_browser_a);
       
       startBrowser_a.setOnClickListener(new View.OnClickListener() {
          public void onClick(View view) {
             Intent i = new Intent(android.content.Intent.ACTION_VIEW, 
             Uri.parse("http://www.aiub.edu"));
             startActivity(i);
          }
       });

       // Second intent to use LAUNCH action with correct data
       Button startBrowser_b = (Button) findViewById(R.id.start_browser_b);
       startBrowser_b.setOnClickListener(new View.OnClickListener() {
          public void onClick(View view) {
//             Intent i = new Intent("com.example.intentdemo.LAUNCH", 
//             Uri.parse("http://http://stackoverflow.com/"));
        	  
              Intent i = new Intent(android.content.Intent.ACTION_VIEW, 
                      Uri.parse("http://stackoverflow.com/"));
             startActivity(i);
          }
       });

       // Third intent to use LAUNCH action with incorrect data
       Button startBrowser_c = (Button) findViewById(R.id.start_browser_c);
       startBrowser_c.setOnClickListener(new View.OnClickListener() {
          public void onClick(View view) {
             Intent i = new Intent("com.example.intentdemo.LAUNCH", 
             Uri.parse("https://uva.onlinejudge.org/")); // In manifest file , android:scheme is set up with http. So if we input other than http , then it will cause exception. As here we use htts , so it results exception.
             startActivity(i);
          }
       });

    }

}