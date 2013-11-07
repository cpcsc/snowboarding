import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class StoreButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoreButton extends Buttons
{
    /**
     * Act - do whatever the StoreButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Buy AK (10 coins)", 50, Color.BLUE, null));
        StoreWorld sw = (StoreWorld) getWorld();
        if (Greenfoot.mouseClicked(this)) {
            if(sw.getCoins() >= 10){
                sw.rmCoin(10);
            }
        }
    }    
}
