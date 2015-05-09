package aiub.eatl.ict;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends Activity 
{
   private static int progress;
   private ProgressBar progressBar;
   private int progressStatus=0;
   private Handler handler = new Handler();
   private Button btn1,btn2;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        
        btn1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v1) 
			{
				setContentView(R.layout.cycle_progressbar);
		        
		        progress=0;
		        progressBar = (ProgressBar) findViewById(R.id.progressBar);
		        
		        new Thread(new Runnable() 
		        {
					
					public void run() 
					{
						while(progressStatus<10)
						{
							progressStatus=doSomeWork();
						}
						
						// Hide the Progress Bar
						handler.post(new  Runnable() 
						{
							public void run() 
							{
								//0: Visible, 4:Invisible, 8:Gone
								progressBar.setVisibility(8);
							}
						});
						
					}
					
					private int doSomeWork()
					{
						try 
						{
							Thread.sleep(500);
						} catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
						return ++progress;
					}
					
				}).start();
			}
		});
        
        btn2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v2) 
			{
				
				setContentView(R.layout.horizontal_progressbar);
				
		        
		        progress=0;
		        progressBar = (ProgressBar) findViewById(R.id.progressBar);
		        progressBar.setMax(100);
		        
		        new Thread(new Runnable() 
		        {
					
					public void run() 
					{
						while(progressStatus<100)
						{
							progressStatus=doSomeWork();
							
							// Update the Progress Bar
							handler.post(new  Runnable() 
							{
								public void run() 
								{								
									progressBar.setProgress(progressStatus);
								}
							});
							
						}				

						
						// Hides the Progress Bar
						handler.post(new  Runnable() 
						{
							public void run() 
							{
								//0: Visible, 4:Invisible, 8:Gone
								progressBar.setVisibility(8);
							}
						});
						
					}
					
					private int doSomeWork()
					{
						try 
						{
							Thread.sleep(50);
						} catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
						return ++progress;
					}
					
				}).start();
				
			}
		});


        
    }
}