import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends Buttons
{
    public Credits()
    {
        setImage(new GreenfootImage("Credits", 50, Color.BLUE, null));
    }
    public void act() 
    {
        setImage(new GreenfootImage("Credits", 50, Color.BLUE, Color.WHITE));
        getImage().setTransparency(220);
        
        if (getWorld() instanceof Intro) {
         if (Greenfoot.getMouseInfo() != null){
         if (Greenfoot.getMouseInfo().getX() >= 385 && Greenfoot.getMouseInfo().getX() <= 515 &&
             Greenfoot.getMouseInfo().getY() >= 430 && Greenfoot.getMouseInfo().getY() <= 490) {
             setImage(new GreenfootImage("Credits", 50, Color.RED, Color.WHITE));
             getImage().setTransparency(220);
         }
         }
        
         if (Greenfoot.mouseClicked(this)) {
             Greenfoot.setWorld(new Cred());
         }
        }
    }    
}
