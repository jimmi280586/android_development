package com.example.jimmi.drawpoint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jimmi on 31-07-2015.
 */
public class Bound extends View
{
    private Context mContext;

    int x = -1;

    int y = -1;

    private int xVelocity = 10;

    private int yVelocity = 5;

    private Handler h;

    private final int FRAME_RATE = 30;


    public Bound(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        mContext = context;
        h = new Handler();
    }

    private Runnable r = new Runnable()
    {
        @Override
        public void run()
        {
            invalidate();
        }

    };

    protected void onDraw(Canvas c) {

        Paint p = new Paint();
        p.setColor(Color.RED);
        c.drawCircle(x, y, 20, p);


        if (x<0 && y <0) {

            x = this.getWidth()/2;

            y = this.getHeight()/2;

        } else {

            x += xVelocity;

            y += yVelocity;

            if ((x > this.getWidth() - 20) || (x < 0)) {

                xVelocity = xVelocity*-1;

            }

            if ((y > this.getHeight() - 20) || (y < 0)) {

                yVelocity = yVelocity*-1;

            }

        }

        c.drawCircle(x, y, 20, p);

        h.postDelayed(r, FRAME_RATE);

    }
}
