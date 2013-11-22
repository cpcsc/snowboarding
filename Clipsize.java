import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Clipsize extends Buttons
{
    public static int canclick = 0;
    public Clipsize()
    {
        setImage(new GreenfootImage("Pistol to AK-47", 50, Color.BLUE, null));
    }    

    public void act() 
    {
        StoreWorld w = (StoreWorld) getWorld();
        
        if (canclick < 1 && w.getCoins() >= 10)
        {
            if (Greenfoot.mouseClicked(this))
            {
                Gun.clipsize += 20;
                Boarder.thedelaymax -= 10;
                w.rmCoin(10);
                Clipsize.canclick += 1;
            }
        }   
        else
        {
            setImage(new GreenfootImage("Pistol to AK-47", 50, Color.GRAY, null));
    
        }
    }    
} 
