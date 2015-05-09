package aiub.android.DXBall;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class GameCanvas extends View
{
	Paint paint;
	Ball ball ;
	Bar bar;
	Brick brick;
	
	private float x1,y1;
	boolean Check = true;
	boolean checkBrick=true;
	
	public float left,left1;
	public float top,top1;
	public float right,right1;
	public float bottom,bottom1= -1;
	public ArrayList<Brick> brickObjList;
	public ArrayList<Float> brickPoint;
	public int colour;
	
	public GameCanvas(Context context)
	{
		super(context);
	
		paint = new Paint();
		ball = new Ball();		
		brickObjList = new ArrayList<Brick>();
		brickPoint = new ArrayList<Float>();
		
	}	
	
	protected void onDraw(Canvas canvas)
	{
				
		x1=canvas.getWidth(); // x1=480
		y1=canvas.getHeight(); // y1=800
		
//		if(p1.getBounds().intersect(ball.getBounds()))
//		{
//		    ball.setDy(ball.getDy()*-1);
//		}
		
		
//		Log.d("Canvas Width", ": "+x1);
//		Log.d("Canvas Height", ": "+y1);
		
		if(Check)
		{
			left=100;
			top=y1-30;
			right=x1-100;
			bottom=y1;
			
			bar = new Bar(left,top,right,bottom);
			
			for(int i=0;i<3;i++)
			{
			
				left1 = 0;
				top1 = 1+bottom1;
				right1=x1/4;
				bottom1=top1+40;
				
				
				brick = new Brick(left1,top1,right1,bottom1);
				brickObjList.add(brick);
				brickPoint.add(right1);
				//Log.d("Canvas Left1,top1,right1,bottom1", ": "+left1+", "+top1+", "+right1+","+bottom1);
				
				brick = new Brick(right1+1,top1,2*right1,bottom1);
				brickObjList.add(brick);
				brickPoint.add(right1);
				
				brick = new Brick(2*right1+1,top1,3*right1,bottom1);
				brickObjList.add(brick);
				brickPoint.add(right1);
				
				brick = new Brick(3*right1+1,top1,4*right1,bottom1);
				brickObjList.add(brick);
				brickPoint.add(right1);
		
			}
			
			
			Check=false;
		}
		
		ball.onDraw(canvas,colour);
		bar.onDraw(canvas,colour);
		
		for(int i=0;i<brickObjList.size();i++)
		{
			brick=brickObjList.get(i);
			brick.onDraw(canvas,i);
		}
		
//		for(int j=0;j<brickObjList.size();j++)
//		{
//			Rectangle rectF = brickObjList.get(j);
//			
//			if(intersect(ball,rectF))
//				brickObjList.remove(j);
//		}
		
		invalidate();
		
	}

}

