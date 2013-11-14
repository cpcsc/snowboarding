import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Back here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Back extends Buttons
{
    public void act() 
    {
        if (getWorld() instanceof SnowWorld) {
            setImage(new GreenfootImage("Quit", 30, Color.RED, Color.WHITE));
            getImage().setTransparency(220);

            if (getX() > 80) {
                setImage(new GreenfootImage("Restart", 30, Color.BLUE, Color.WHITE));
                getImage().setTransparency(220);
            }
        }
        else {
            setImage(new GreenfootImage("Back", 50, Color.BLUE, null));
            if (Greenfoot.getMouseInfo() != null){
                if (Greenfoot.getMouseInfo().getX() >= 405 && Greenfoot.getMouseInfo().getX() <= 495 &&
                    Greenfoot.getMouseInfo().getY() >= 640 && Greenfoot.getMouseInfo().getY() <= 670) {
                    setImage(new GreenfootImage("Back", 50, Color.RED, null));
                }
            }
        }

        if (Greenfoot.mouseClicked(this)) {
            if (getWorld() instanceof SnowWorld) {
                SnowWorld sw = (SnowWorld) getWorld();
                sw.stopMusic();
                if(getX() > 80){
                    Greenfoot.setWorld(new SnowWorld(0));
                } else {
                    Greenfoot.setWorld(new Intro());
                }
            }
            else if(getWorld() instanceof StoreWorld) {
                StoreWorld sw = (StoreWorld) getWorld();
                Greenfoot.setWorld(sw.getSnowWorld());
            }
            else {
                Greenfoot.setWorld(new Intro());
            }
        }
    }    
}
