package aiub.android.DXBall;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;

public class Bar implements Drawable
{
	Paint paint = new Paint();
	float x1,y1;
	

	public void init(int x, int y, Paint paint) {
		// TODO Auto-generated method stub
		
	}

	public boolean colidesWith(Drawable drawable) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onDraw(Canvas canvas) 
	{
		x1=canvas.getWidth(); // x1=480
		y1=canvas.getHeight(); // y1=800
		
		Log.d("Canvas Width", ": "+x1);
		Log.d("Canvas Height", ": "+y1);

		
		paint.setColor(Color.RED);
		paint.setStyle(Style.FILL);
		
		canvas.drawRect(100,y1-30 , x1-100,y1, paint);	
		
		
	}

}

/* 	

	canvas.drawRect(left,top,right,bottom,paint);
	
	In this
	
	left: distance of the left side of rectangular from left side of canvas.
	
	top:Distance of bottom side of rectangular from the top side of canvas
	
	right:distance of the right side of rectangular from left side of canvas.
	
	bottom: Distance of the top side of rectangle from top side of

 */
