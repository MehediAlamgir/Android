package aiub.android.DXBall;

import android.R.integer;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;

public class Brick implements Drawable
{
	Paint paint = new Paint();
	Ball ball = new Ball();
	
	private float left;
	private float top;
	private float right;
	private float bottom;
	
	public Brick(float left, float top, float right, float bottom)
	{
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}



	public void init(int x, int y, Paint paint)
	{		
		
	}

	public boolean colidesWith(Drawable drawable) 
	{
		
		return false;
	}

	public void onDraw(Canvas canvas,int color) 
	{
		if(color % 2 ==0)
		{
			paint.setColor(Color.RED);
			paint.setStyle(Style.FILL);
		}
		
		else 
		{
			paint.setColor(Color.GREEN);
			paint.setStyle(Style.FILL);
		}
		
		canvas.drawRect(this.left, this.top, this.right, this.bottom, paint);		
		
		if(ball.y - ball.radValue >= this.right)
		{
			
		}
		
	}

}

/* 	

	canvas.drawRect(left,top,right,bottom,paint);
	
	here, upper left corner will be at (left,top) and lower left corner will be at (right,bottom)
	
	canvas.drawRect(25, 50, 75, 150, paint);
	here,Rectangle's upper left corner will be at (25, 50) and lower left corner will be at (75, 150)
	
	
	In this
	
	left: distance of the left side of rectangular from left side of canvas.
	
	top:Distance of bottom side of rectangular from the top side of canvas
	
	right:distance of the right side of rectangular from left side of canvas.
	
	bottom: Distance of the top side of rectangle from top side of canvas

 */
