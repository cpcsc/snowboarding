import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Start extends Buttons
{
    public Start()
    {
        setImage(new GreenfootImage("New Game", 50, Color.BLUE, Color.WHITE));
    }
    
    public void act() 
    {
        setImage(new GreenfootImage("New Game", 50, Color.BLUE, Color.WHITE));
        getImage().setTransparency(220);
        
        if (Greenfoot.getMouseInfo() != null){
        if (Greenfoot.getMouseInfo().getX() >= 350 && Greenfoot.getMouseInfo().getX() <= 550 &&
            Greenfoot.getMouseInfo().getY() >= 310 && Greenfoot.getMouseInfo().getY() <= 370) {
               setImage(new GreenfootImage("New Game", 50, Color.RED, Color.WHITE));
               getImage().setTransparency(220);
        }
        }
        
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new SnowWorld(0));
        }
    }
}