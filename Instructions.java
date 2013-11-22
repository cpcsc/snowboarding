import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Instructions extends Buttons
{
    public Instructions()
    {
        setImage(new GreenfootImage("Instructions", 50, Color.BLUE, Color.WHITE));
    }
    public void act() 
    {
        setImage(new GreenfootImage("Instructions", 50, Color.BLUE, Color.WHITE));
        getImage().setTransparency(220);
        
        if (getWorld() instanceof Intro) {
         if (Greenfoot.getMouseInfo() != null){
         if (Greenfoot.getMouseInfo().getX() >= 350 && Greenfoot.getMouseInfo().getX() <= 550 &&
             Greenfoot.getMouseInfo().getY() >= 370 && Greenfoot.getMouseInfo().getY() <= 430) {
             setImage(new GreenfootImage("Instructions", 50, Color.RED, Color.WHITE));
             getImage().setTransparency(220);
         }
         }
         if (Greenfoot.mouseClicked(this)) {
             Greenfoot.setWorld(new Tut());
         }
        }
    }
}