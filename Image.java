import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Image here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Image extends Actor
{
    public Image(String filename) {
        setImage(filename);
    }
    
    public Image(String text, int size, java.awt.Color color, java.awt.Color bg) {
        setImage(new GreenfootImage(text, size, color, bg));
    }
    
    public void act() 
    {
        // Add your action code here.
    }   
    
    public int getWidth() {
        return getImage().getWidth();
    }
    
    public int getHeight() {
        return getImage().getHeight();
    }
}
