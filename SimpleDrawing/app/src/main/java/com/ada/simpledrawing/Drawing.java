package com.ada.simpledrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class Drawing extends View{

    private int x=90;
    private int y=90;
    private String c;

    public Drawing(Context context, AttributeSet attributeSets) {
        super(context, attributeSets);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        if(c=="b"){ p.setColor(Color.BLUE);}
        if(c=="g"){p.setColor(Color.GREEN);}
        if(c=="y"){p.setColor(Color.YELLOW);}

        canvas.drawCircle(x, y, 10, p);
    }

    public void setColor(String c)
    {
        this.c=c;
    }
    public void setPoint(int x, int y)
    {
        this.x = x;
        this.y = y;

    }
}
