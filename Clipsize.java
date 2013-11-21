import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Clipsize here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clipsize extends Buttons
{
    public Clipsize()
    {
        setImage(new GreenfootImage("Pistol to AK-47", 50, Color.BLUE, null));
    }    

    public void act() 
    {
        setImage(new GreenfootImage("Pistol to AK-47", 50, Color.BLUE, null));
        
        if (Greenfoot.mouseClicked(this))
        {
            StoreWorld w = (StoreWorld) getWorld();
            
            if(w.getCoins() >= 10)
            {
                Gun.clipsize += 20;
                Boarder.thedelaymax -= 10;
                w.rmCoin(10);
            }
        }    
    }    
}
