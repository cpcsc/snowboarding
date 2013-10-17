import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Buttons
{
    public void act() 
    {
        setImage(new GreenfootImage("New Game", 50, Color.BLUE, null));
        
        if (Greenfoot.getMouseInfo() != null){
        if (Greenfoot.getMouseInfo().getX() >= 350 && Greenfoot.getMouseInfo().getX() <= 550 &&
            Greenfoot.getMouseInfo().getY() >= 155 && Greenfoot.getMouseInfo().getY() <= 185) {
               setImage(new GreenfootImage("New Game", 50, Color.RED, null));
        }
        }
        
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new SnowWorld());
        }
    }
}