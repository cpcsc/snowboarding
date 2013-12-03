import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class StoreText extends Buttons
{   
    private int storeTimer = 0;
    private SnowWorld sw;
    private int c;
    private int timerStore = 0;
    public StoreText(SnowWorld w, int coin) {
        /**setImage(new GreenfootImage("Press 'S' to Open the Store", 20, Color.BLACK, Color.WHITE));
        getImage().setTransparency(220);
        sw = w;
        c = coin;*/
    }

    public void act() {
        /**storeTimer++;
        timerStore = 0;
        if (Greenfoot.isKeyDown("s") && storeTimer >= 1000){
            //getWorld().removeObject(this);
            getImage().setTransparency(0);
            Greenfoot.setWorld(new StoreWorld(sw,c));
            timerStore = 0;
        }
        if (storeTimer >= 200) {
            //getWorld().removeObject(this);
            getImage().setTransparency(0);
            //storeTimer = 0;
        }*/
    }
}
