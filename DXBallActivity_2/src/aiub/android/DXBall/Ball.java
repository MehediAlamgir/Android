package aiub.android.DXBall;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;

public class Ball implements Drawable
{
	Paint paint =  new Paint();
	float x=0,y=0,x1,y1;
	boolean firstTime = true;
	boolean goigup=true;
	boolean goSide=true;

	int radValue=40;
	
	
	protected void calculateNextPos() 
	{	
		//---------------Y Direction Starts-----------------------
		if(goigup==false)
		{
			if((y+radValue)==y1-30)
			{				
				//Log.e("Lower Side", "y: "+y);
				goigup=true;				
			}
			else 
			{
				y+=10;
			}
			
		}
		
		else 
		{
			if((y-radValue) == 0)
			{				
				//Log.e("Upper Side", "y: "+y);
				goigup=false;
				
			}
			else {
				y-=10;			
			}
		}	
		
		//--------------- Y Direction End-----------------------
		
		//--------------- X Direction Starts-----------------------
		
		if(goSide==false)
		{
			if((x+radValue)==x1)
			{				
				//Log.e("Lower Side", "y: "+y);
				goSide=true;				
			}
			else 
			{
				x+=10;
			}
			
		}
		
		else 
		{
			if((x-radValue) == 0)
			{				
				//Log.e("Upper Side", "y: "+y);
				goSide=false;
				
			}
			else {
				x-=10;			
			}
		}			
		
		//-------------- X Direction Ends--------------------------
		
	}
	


	public void init(int x, int y, Paint paint) {
		// TODO Auto-generated method stub
		
	}

	public boolean colidesWith(Drawable drawable) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		
		if(firstTime)
		{
			firstTime=false;
			x=canvas.getWidth()/2;
			y=canvas.getHeight()/2;
			
		}
			
	
		calculateNextPos();
		x1=canvas.getWidth();
		y1=canvas.getHeight();
		
		canvas.drawRGB(255, 255, 255);
		paint.setColor(Color.RED);
		paint.setStyle(Style.FILL);
		canvas.drawCircle(x,y,40, paint);
		//Log.d("center", "x: "+x);
		
	}
	
}
