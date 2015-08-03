package com.example.jimmi.drawpoint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jimmi on 31-07-2015.
 */
public class Drawview extends View
{

        private int x = 100;
        private int y = 100;

        public Drawview(Context context, AttributeSet attributeSets) {
            super(context, attributeSets);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint p = new Paint();
            p.setColor(Color.RED);
            canvas.drawCircle(x, y, 20, p);
        }

        public void setPoint(int x, int y)
        {
            this.x = x;
            this.y = y;

        }

}


