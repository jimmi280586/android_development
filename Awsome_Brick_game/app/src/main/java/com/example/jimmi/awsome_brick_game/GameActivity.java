package com.example.jimmi.awsome_brick_game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class GameActivity extends Activity {

   public BreakoutView breakoutView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        breakoutView = new BreakoutView(this);
        setContentView(breakoutView);
        Intent intent = getIntent();

    }


    class BreakoutView extends SurfaceView implements Runnable {

        Thread gameThread = null;
        SurfaceHolder ourHolder;
        volatile boolean playing;
        boolean paused = true;
        Canvas canvas;
        Paint paint;
        long fps;
        private long timeThisFrame;
        int screenX;
        int screenY;
        Paddle paddle;
        Ball ball;
        Ball ball2;
        Brick[] bricks = new Brick[200];
        int numBricks = 0;
        int ballsLeft;
        int score = 0;
        int score1 = 0;
        int lives = 3;
        int level = 0;

        public BreakoutView(Context context)
        {
            super(context);

            ourHolder = getHolder();
            paint = new Paint();
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenX = size.x;
            screenY = size.y;
            paddle = new Paddle(screenX, screenY);
            ball = new Ball(screenX, screenY,false);
            ball2=new Ball(screenX,screenY,true);

            createBricksAndRestart();


        }

        public void createBricksAndRestart(){

            // Put the ball back to the start
            ball.reset(screenX, screenY,false);
            ball2.reset(screenX,screenY,true);
            paddle.reset(screenX, screenY);
            int brickWidth = screenX / 8;
            int brickHeight = screenY / 10;

            // Build a wall of bricks for level 0
            numBricks = 0;
            if(level == 0)
            {
                for (int column = 0; column < 8; column++)
                {
                    for (int row = 0; row < 3; row++)
                    {
                        bricks[numBricks] = new Brick(row, column, brickWidth, brickHeight, false);
                        numBricks++;
                    }
                }
            }
            // Build a wall of bricks for level between 0 and 3
            if(level <= 3 && level > 0)
            {
                //increase ball speed
                ball.setxVelocity((ball.getxVelocity() + 100));
                ball.setyVelocity((ball.getyVelocity() + 100));
                for (int column = 0; column < 10; column++)
                {
                    for (int row = 0; row < 4; row++)
                    {
                        if(row == 1 || row == 3)
                        {
                            //makes 2 rows difrent then the others used later for more hits
                            bricks[numBricks] = new Brick(row, column, brickWidth, brickHeight, true);
                            numBricks++;
                        }
                        else
                        {
                            bricks[numBricks] = new Brick(row, column, brickWidth, brickHeight, false);
                            numBricks++;
                        }
                    }
                }
            }

            {ballsLeft=2;}

            // if game over reset scores, lives and level
            if(lives == 0) {
                score = 0;
                score1 = 0;
                lives = 3;
                level = 0;
            }

        }

        @Override
        public void run() {
            while (playing) {

                // Capture the current time in milliseconds in startFrameTime
                long startFrameTime = System.currentTimeMillis();

                // Update the frame
                if(!paused)
                {
                    update();
                }

                // Draw the frame
                try
                {
                    draw();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                // Calculate the frame per second
                // We can then use the result to update the paddel and ball obj
                timeThisFrame = System.currentTimeMillis() - startFrameTime;
                if (timeThisFrame >= 1)
                {
                    fps = 1000 / timeThisFrame;
                }

            }

        }

        // Everything that needs to be updated goes in here
        // Movement, collision detection
        public void update()
        {
            // Move the paddle if required acording to the set frame per second
            paddle.update(fps);
            ball.update(fps);
            ball2.update(fps);

            // Check for ball colliding with a brick and checks for hits
            for(int i = 0; i < numBricks; i++)
            {
                if (bricks[i].getVisibility())
                {
                    if(RectF.intersects(bricks[i].getRect(), ball.getRect()))
                    {
                        if((bricks[i].getColor() == true) && (bricks[i].getHit() < 3))
                        {
                            bricks[i].setHit(1);
                            ball.reverseYVelocity();

                            score = score + 10;
                        }
                        else
                        {
                            bricks[i].setInvisible();
                            ball.reverseYVelocity();

                            score = score + 10;
                        }

                    }
                    if(RectF.intersects(bricks[i].getRect(), ball2.getRect()))
                    {
                        if((bricks[i].getColor() == true) && (bricks[i].getHit() < 3))
                        {
                            bricks[i].setHit(1);
                            ball2.reverseYVelocity();

                            score = score + 10;
                        }
                        else
                        {
                            bricks[i].setInvisible();
                            ball2.reverseYVelocity();

                            score = score + 10;
                        }

                    }
                }
            }

            // Check for ball colliding with paddle
            if(RectF.intersects(paddle.getRect(),ball.getRect()))
            {
                ball.setRandomXVelocity();
                ball.reverseYVelocity();
                ball.clearObstacleY(paddle.getRect().top - 2);
            }
            if(RectF.intersects(paddle.getRect(),ball2.getRect()))
            {
                ball2.setRandomXVelocity();
                ball2.reverseYVelocity();
                ball2.clearObstacleY(paddle.getRect().top - 2);
            }

            // Bounce the ball back when it hits the bottom of screen
            if(ball.getRect().bottom > screenY)
            {
                ball.reverseYVelocity();

                // Lose a life
                if(ballsLeft>0)
                {
                    ballsLeft--;
                    ball.reset(screenX,screenY,false);
                }
                else
                {
                lives --;
                ballsLeft=2;
                paused=true;
                ball.reset(screenX,screenY,false);
                paddle.reset(screenX, screenY);
                }


                if(lives == 0)
                {
                    paused = true;
                    createBricksAndRestart();
                }
            }
            if(ball2.getRect().bottom > screenY)
            {
                ball2.reverseYVelocity();

                // Lose a life
                if(ballsLeft>0)
                {
                    ballsLeft--;
                    ball2.reset(screenX,screenY,true);
                }
                else
                {
                    lives --;
                    ballsLeft=2;
                    paused=true;
                    ball2.reset(screenX,screenY,true);
                    paddle.reset(screenX, screenY);
                }
                if(lives == 0)
                {
                    paused = true;
                    createBricksAndRestart();
                }
            }

            // Bounce the ball back when it hits the top of screen
            if(ball.getRect().top < 0){
                ball.reverseYVelocity();
                ball.clearObstacleY(12);
            }

            {
                if(ball2.getRect().top < 0){
                ball2.reverseYVelocity();
                ball2.clearObstacleY(12);
            }
            }

            // If the ball hits left wall bounce
            if(ball.getRect().left < 0){
                ball.reverseXVelocity();
                ball.clearObstacleX(2);
            }

            {
                if(ball2.getRect().left < 0)
                {
                    ball2.reverseXVelocity();
                    ball2.clearObstacleX(2);
                }
            }
            // If the ball hits right wall bounce
            if(ball.getRect().right > screenX - 10)
            {
                ball.reverseXVelocity();
                ball.clearObstacleX(screenX - 22);
            }

            {
            if(ball2.getRect().right > screenX - 10)
            {
                ball2.reverseXVelocity();
                ball2.clearObstacleX(screenX - 22);
            }

            }

            // Pause if cleared screen
            if(score == numBricks * 10)
            {
                paused = true;
                createBricksAndRestart();
            }

        }

        // Draw the newly updated scene
        public void draw() throws InterruptedException {

            // Make sure our drawing surface is valid or we crash
            if (ourHolder.getSurface().isValid()) {
                // Lock the canvas ready to draw
                canvas = ourHolder.lockCanvas();

                // Draw the background color
                canvas.drawColor(Color.CYAN);

                // Choose the brush color for drawing
                paint.setColor(Color.BLACK);

                // Draw the paddle
                canvas.drawRect(paddle.getRect(), paint);

                // Draw the ball
                canvas.drawRect(ball.getRect(), paint);

                canvas.drawRect(ball2.getRect(),paint);

                // Change the brush color for drawing
                paint.setColor(Color.argb(255,  249, 129, 0));

                // Draw the bricks if visible
                for(int i = 0; i < numBricks; i++){


                    if(bricks[i].getVisibility()) {
                        if(bricks[i].getColor())
                        {
                            paint.setColor(Color.GREEN);
                            canvas.drawRect(bricks[i].getRect(), paint);
                        }
                        else {
                            paint.setColor(Color.argb(255,  249, 129, 0));
                            canvas.drawRect(bricks[i].getRect(), paint);
                        }
                    }
                }

                // Choose the brush color for drawing
                paint.setColor(Color.argb(255,  255, 255, 255));

                // Draw the score
                paint.setTextSize(40);
                canvas.drawText("Level Score: " + score + "   Lives: " + lives + "   Level: " + level + "   Total Score " + score1, 10, 50, paint);

                // Has the player cleared the screen?
                if(score == numBricks * 10){
                    paint.setTextSize(90);
                    canvas.drawText("YOU HAVE WON!", 10, screenY / 2, paint);
                    score1 += score;
                    score = 0;
                    level++;
                    createBricksAndRestart();

                }

                // Has the player lost?
                if(lives <= 0){
                    paint.setTextSize(90);
                    canvas.drawText("YOU HAVE LOST!", 10,screenY/2, paint);
                }

                // Draw everything to the screen
                ourHolder.unlockCanvasAndPost(canvas);
            }

        }

        public void pause() {
            playing = false;
            try {
                gameThread.join();
            } catch (InterruptedException e) {
                Log.e("Error:", "joining thread");
            }

        }

        public void resume() {
            playing = true;
            gameThread = new Thread(this);
            gameThread.start();
        }

        @Override
        public boolean onTouchEvent(MotionEvent motionEvent) {

            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {

                // Player has touched the screen
                case MotionEvent.ACTION_DOWN:

                    paused = false;

                    if(motionEvent.getX() > screenX / 2){
                        paddle.setMovementState(paddle.RIGHT);
                    }
                    else{
                        paddle.setMovementState(paddle.LEFT);
                    }

                    break;

                // Player has removed finger from screen
                case MotionEvent.ACTION_UP:

                    paddle.setMovementState(paddle.STOPPED);
                    break;
            }
            return true;
        }

    } //end of inner class

    // This method executes when the player starts the game
    @Override
    protected void onResume() {
        super.onResume();

        breakoutView.resume();
    }


    @Override
    protected void onPause() {
        super.onPause();

        breakoutView.pause();
    }

}
//end of main class