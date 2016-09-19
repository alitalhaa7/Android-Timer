package talha.timer.talha.mytimerapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Talha on 2016-07-11.
 */



public class TimerDraw extends View {
private int circleCol,labelCol;
private String label;
    private float angle=0;
    private Paint circlePaint;
    public TimerDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        circlePaint=new Paint();
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.TimerDraw, 0, 0);
        try{
    circleCol=a.getInteger(R.styleable.TimerDraw_circleColor,0);
    labelCol=a.getInteger(R.styleable.TimerDraw_labelColor,0);
    label=a.getString(R.styleable.TimerDraw_circleLabel);
        }
        finally {
a.recycle();
        }

    }

    @Override
    protected void onDraw(Canvas canvas){
      super.onDraw(canvas);

        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;
        int radius = 0;
        if(viewWidthHalf>viewHeightHalf)
            radius=viewHeightHalf-8;
        else
            radius=viewWidthHalf-8;
        circlePaint.setStyle(Style.STROKE);
        circlePaint.setStrokeWidth(9);
        //asdfasdfasdfasdf

        circlePaint.setAntiAlias(true);
        circlePaint.setColor(circleCol);

        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);
        RectF rectF = new RectF(viewWidthHalf-radius, viewHeightHalf-radius, viewWidthHalf+radius, viewHeightHalf+radius);
        circlePaint.setColor(Color.WHITE);
       // canvas.drawRect(rectF,circlePaint);
        circlePaint.setStrokeWidth(10);

        canvas.drawArc(rectF, 270, angle, false, circlePaint);


    }

 public float getAngle(){
     return angle;
 }

    public void setAngle(float angle){
        this.angle=angle;
    }

}