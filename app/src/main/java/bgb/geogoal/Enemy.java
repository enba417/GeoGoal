package bgb.geogoal;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Enemy extends GameObject{
    private Bitmap spritesheet;
    private int score;
    private double dya;
    private double dxa;
    private boolean up;
    private boolean playing;
    private Animation animation = new Animation();

    public Enemy(Bitmap res, int w, int h, int numFrames) {

        x = GamePanel.WIDTH - 100;
        y = GamePanel.HEIGHT / 2;
        dy = 0;
        score = 0;
        height = h;
        width = w;

        Bitmap[] image = new Bitmap[numFrames];
        spritesheet = res;

        for (int i = 0; i < image.length; i++)
        {
            image[i] = Bitmap.createBitmap(spritesheet, i*width, 0, width, height);
        }

        animation.setFrames(image);
        animation.setDelay(10);

    }

    public void setUp(boolean b){up = b;}

    public void update()
    {
        animation.update();

/*        if(up){
            dy = (int)(dya-=1.1);

        }
        else{
            dy = (int)(dya+=1.1);
        }

        if(dy>14)dy = 14;
        if(dy<-14)dy = -14;

        y += dy*2;
        dy = 0;*/
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(animation.getImage(),x,y,null);
    }
    public int getScore(){return score;}
    public boolean getPlaying(){return playing;}
    public void setPlaying(boolean b){playing = b;}
    public void resetDYA(){dya = 0;}
    public void resetScore(){score = 0;}
}