package com.example.jimmi.awsome_brick_game;

import android.graphics.RectF;

public class Brick {

    private RectF rect;

    private boolean isVisible;
    private boolean color = false;
    private int hit = 0;

    public Brick(int row, int column, int width, int height, boolean var){
        this.color = var;

        isVisible = true;

        int padding = 1;

        rect = new RectF(column * width + padding,
                row * height + padding,
                column * width + width - padding,
                row * height + height - padding);
    }

    public RectF getRect(){
        return this.rect;
    }

    public void setInvisible(){
        isVisible = false;
    }

    public boolean getVisibility(){
        return isVisible;
    }
    public void setColor()
    {
        this.color = true;
    }
    public boolean getColor()
    {
        return this.color;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int a)
    {
        this.hit = (this.hit + a);
    }
}