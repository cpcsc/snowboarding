import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class RampCoins extends Buttons
{
    public static boolean canClick = true;
    
    public RampCoins() {
        setImage(new GreenfootImage("More Ramp Coins", 50, Color.BLUE, null));
    }    

    public void act() {
        StoreWorld w = (StoreWorld) getWorld();        
        if (canClick && w.getCoins() >= 10) {
            if (Greenfoot.mouseClicked(this)) {
                SnowWorld.rampCoins = true;
                w.rmCoin(10);
                RampCoins.canClick = false;
            }   
        } else {
            setImage(new GreenfootImage("More Ramp Coins", 50, Color.GRAY, null));
        }    
    }    
}
