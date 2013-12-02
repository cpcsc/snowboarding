import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class StoreText extends Buttons
{   
    private int storeTimer = 0;
    private SnowWorld sw;
    private int c;
    public StoreText(SnowWorld w, int coin) {
        setImage(new GreenfootImage("Press 'S' to Open the Store", 20, Color.BLACK, Color.WHITE));
        getImage().setTransparency(220);
        sw = w;
        c = coin;
    }

    public void act() {
        storeTimer++;
        if (Greenfoot.isKeyDown("s")){
            getWorld().removeObject(this);
            Greenfoot.setWorld(new StoreWorld(sw,c));
        }
        if (storeTimer >= 200) {
            getWorld().removeObject(this);
        }
    }
}
