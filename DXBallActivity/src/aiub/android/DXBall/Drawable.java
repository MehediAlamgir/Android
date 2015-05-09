package aiub.android.DXBall;

import android.R.integer;
import android.graphics.Canvas;
import android.graphics.Paint;

public interface Drawable
{
	public int x=0;
	public int y=0;
	public Paint paint=null;
	
	public void init(int x,int y,Paint paint);//you can use constructor if you like
	// this method will be responsible for colision detection with other object including
	//ball, bar and several bricks with each other
	public boolean colidesWith(Drawable drawable);	
	
	public void onDraw(Canvas canvas,int color);
	 
	
}
