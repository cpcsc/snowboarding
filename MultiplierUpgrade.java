import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class MultiplierUpgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MultiplierUpgrade extends Buttons
{
    public static boolean canClick = true;
    public MultiplierUpgrade() {
        setImage(new GreenfootImage("Multiplier Now x3", 50, Color.BLUE, null));
    }
    
    public void act() 
    {
        StoreWorld w = (StoreWorld) getWorld();
        if (canClick && w.getCoins() >= 10) {
            if (Greenfoot.mouseClicked(this)){
                w.rmCoin(10);
                MultiplierUpgrade.canClick = false;
                ScoreX2.Multiplier = 3;
            }
        }
        else {
            setImage(new GreenfootImage("Multiplier Now x3", 50, Color.GRAY, null));
        }    
    }    
}
