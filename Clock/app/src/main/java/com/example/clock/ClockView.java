package com.example.clock;
import java.util.Calendar;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ClockView extends View {

    private Paint paint;

    private int strokeWidth = 2;

    private boolean isFirstRunning;

    private Handler handler;
    private Runnable runnable;

    private int radius = 200;

    private String num;
    private String[] clockNumbers = {"12","1","2","3","4","5","6","7","8","9","10","11"};

    private Rect textBounds = new Rect();

    private Calendar calendar;
    private int hour,min,second;
    private float hour_angle,min_angle,sec_angle;

    public ClockView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }
    public ClockView(Context context){
        super(context);
        init();
    }
    private void init(){
        paint = new Paint();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                postInvalidate();
                handler.postDelayed(this,1000);
            }
        };
    }

    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    @Override
    protected void onLayout(boolean changed,int left,int top,int right,int bottom){
        super.onLayout(changed, left, top, right, bottom);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if (!isFirstRunning){
            runClock();
        }
        else{
            initPaint();
            drawClockCircle(canvas);
            drawClockScale(canvas);
            drawClockNumber(canvas);
            drawClockDot(canvas);
            drawClockPoint(canvas);
        }
    }

    private void drawClockPoint(Canvas canvas){
        calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR);
        min = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);

        hour_angle = (float) hour/12*360 + (float)min/60 * 360/12;
        min_angle = (float) min / 60 * 360;
        sec_angle = (float) second /60 * 360;

        canvas.save();
        canvas.rotate(hour_angle,getWidth()/2,getHeight()/2);
        canvas.drawLine(getWidth()/2,getHeight()/2,getWidth()/2,getHeight()/2-65,paint);

        canvas.restore();
        canvas.save();
        canvas.rotate(min_angle,getWidth()/2,getHeight()/2);
        canvas.drawLine(getWidth()/2,getHeight()/2,getWidth()/2,getHeight()/2-90,paint);

        canvas.restore();
        canvas.save();
        canvas.rotate(sec_angle,getWidth()/2,getHeight()/2);
        canvas.drawLine(getWidth()/2,getHeight()/2,getWidth()/2,getHeight()/2-110,paint);

        canvas.restore();
    }

    private void drawClockDot(Canvas canvas){
        paint.reset();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(getWidth()/2,getHeight()/2,6,paint);
        initPaint();
    }

    private void drawClockNumber(Canvas canvas){
        canvas.save();
        paint.setTextSize(25);
        int preX = getWidth()/2;
        int preY = getHeight()/2 - radius - strokeWidth -10;
        int x,y;
        int degree = 360 / clockNumbers.length;
        for(int i=0;i<clockNumbers.length;i++){
            num = clockNumbers[i];
            paint.getTextBounds(num,0,num.length(),textBounds);
            x = (int) (preX - paint.measureText(num) / 2);
            y = preY - textBounds.height();
            canvas.drawText(num,x,y,paint);
            canvas.rotate(degree,getWidth()/2,getHeight()/2);
        }

        canvas.restore();
    }

    private void drawClockScale(Canvas canvas){
        canvas.save();
        int startX = getWidth()/2;
        int startY = getHeight()/2 - radius;

        int stopX = startX;
        int stopY1 = startY + 30;
        int stopY2 = startY + 15;

        float degree = 360/60;
        for(int i=0;i<60;i++){
            if(i%5==0){
                canvas.drawLine(startX,startY,stopX,stopY1,paint);
            }
            else
                canvas.drawLine(startX,startY,stopX,stopY2,paint);
            canvas.rotate(degree,getWidth()/2,getHeight()/2);
        }
        canvas.restore();
    }

    private void drawClockCircle(Canvas canvas){
        int x = getWidth() /2 ;
        int y = getHeight() /2;
        canvas.drawCircle(x,y,radius,paint);
    }

    private void initPaint(){
        paint.reset();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setAntiAlias(true);
    }

    private void runClock(){
        isFirstRunning = true;
        handler.postDelayed(runnable,1000) ;
    }

}
