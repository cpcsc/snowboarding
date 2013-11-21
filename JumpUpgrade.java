import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class StoreButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JumpUpgrade extends Buttons
{
    /**
     * Act - do whatever the StoreButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        StoreWorld sw = (StoreWorld) getWorld();
        if(!sw.getJumpU() && sw.getCoins() > 10){
            setImage(new GreenfootImage("Buy Jump Upgrade (10 coins)", 50, Color.BLUE, null));
        }
        else{
            setImage(new GreenfootImage("Buy Jump Upgrade (10 coins)", 50, Color.GRAY, null));
        }

        if (Greenfoot.mouseClicked(this)) {
            if(sw.getCoins() >= 10 && !sw.getJumpU()){
                sw.rmCoin(10);
                sw.JumpU();
            }
        }
    }    
}
