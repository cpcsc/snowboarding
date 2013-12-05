import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

// Tarrant Starck

public class RampCoins extends Buttons
{
    public static boolean canClick = true;
    
    public RampCoins() {
        setImage(new GreenfootImage("Extra Ramp Coins (200 coins)", 50, Color.BLUE, null));
    }    

    public void act() {
        StoreWorld w = (StoreWorld) getWorld();        
        if (canClick && w.getCoins() >= 200) {
            if (Greenfoot.mouseClicked(this)) {
                SnowWorld.rampCoins = true;
                w.rmCoin(200);
                RampCoins.canClick = false;
            }   
        } else {
            setImage(new GreenfootImage("Extra Ramp Coins (200 coins)", 50, Color.GRAY, null));
        }    
    }    
}
