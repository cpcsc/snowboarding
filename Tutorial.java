import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (1.0)
 */
public class Tutorial extends Buttons
{
    public Tutorial()
    {
        setImage(new GreenfootImage("Use the left and right arrow keys to move\n"
            + "(For touchscreens: drag left and right to move)\n\n"
            + "Press the up arrow key to jump\n"
            + "(For touchscreens: drag up to jump)\n\n"
            + "Press the spacebar to fire the gun\n\n"
            + "Avoid the obstacles and survive as long as possible\n\n"
            + "Good luck! :)", 30, Color.BLACK, null));
        
    }
    /**
     * Act - do whatever the Tutorial wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
}