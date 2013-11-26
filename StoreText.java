import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class StoreText extends Buttons
{   
    public StoreText() {
        setImage(new GreenfootImage("Press 'S' to Open the Store", 20, Color.BLACK, Color.WHITE));
        getImage().setTransparency(220);
    }

    public void act() {
        Boarder b = (Boarder) getWorld().getObjects(Boarder.class).get(0);
        if(b.getInvincible() == 100){
            getWorld().removeObject(this);
        }
    }
}
