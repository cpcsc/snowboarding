import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends Buttons
{
    public Instructions()
    {
        setImage(new GreenfootImage("Instructions", 50, Color.BLUE, null));
    }
    public void act() 
    {
        setImage(new GreenfootImage("Instructions", 50, Color.BLUE, null));
        
        if (getWorld() instanceof Intro) {
         if (Greenfoot.getMouseInfo() != null){
         if (Greenfoot.getMouseInfo().getX() >= 350 && Greenfoot.getMouseInfo().getX() <= 550 &&
             Greenfoot.getMouseInfo().getY() >= 235 && Greenfoot.getMouseInfo().getY() <= 265) {
             setImage(new GreenfootImage("Instructions", 50, Color.RED, null));
         }
         }
         if (Greenfoot.mouseClicked(this)) {
             Greenfoot.setWorld(new Tut());
         }
        }
    }
}