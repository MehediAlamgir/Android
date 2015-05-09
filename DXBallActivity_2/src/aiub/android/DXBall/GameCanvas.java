package aiub.android.DXBall;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class GameCanvas extends View
{
	Paint paint;
	Ball ball ;
	Bar bar;
	
	public GameCanvas(Context context)
	{
		super(context);
		paint = new Paint();
		ball = new Ball();	
		bar = new Bar();
		
	}	
	
	protected void onDraw(Canvas canvas)
	{
		ball.onDraw(canvas);
		bar.onDraw(canvas);
		//canvas.drawRect(100,y1-30 , x1-100,y1, paint);
		
		
		invalidate();
		
	}

}

