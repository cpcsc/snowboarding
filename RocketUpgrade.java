import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class RocketUpgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RocketUpgrade extends Buttons
{
    public static int canclick = 0;
    public RocketUpgrade()
    {
        setImage(new GreenfootImage("Rockets Spawn", 50, Color.BLUE, null));
    }    
    /**
     * Act - do whatever the RocketUpgrade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        StoreWorld w = (StoreWorld) getWorld();
        
        if (canclick < 1 && w.getCoins() >= 10)
        {
            if (Greenfoot.mouseClicked(this))
            {
                SnowWorld.rocketsspawn += 1;
                w.rmCoin(10);
                RocketUpgrade.canclick += 1;
                Boarder.rocket += 5;
            }
        }
        else
        {
            setImage(new GreenfootImage("Rockets Spawn", 50, Color.GRAY, null));
        }    
    }    
}
