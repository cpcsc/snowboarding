import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class RampCoins extends Buttons
{
    public static int canclick = 0;
    
    public RampCoins()
    {
        setImage(new GreenfootImage("More Ramp Coins", 50, Color.BLUE, null));
    }    

    public void act() 
    {
        StoreWorld w = (StoreWorld) getWorld();
        
        if ( canclick < 1 && w.getCoins() >= 10)
        {
            if (Greenfoot.mouseClicked(this))
            {
                SnowWorld.rampcoins += 1;
                w.rmCoin(10);
                RampCoins.canclick += 1;
            }   
        }    
        else
        {
            setImage(new GreenfootImage("More Ramp Coins", 50, Color.GRAY, null));
        }    
    }    
}
