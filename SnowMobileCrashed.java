import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnowMobileCrashed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnowMobileCrashed extends Object
{
    public SnowMobileCrashed(int rotation)
    {
        setRotation(rotation);
    }
    /**
     * Act - do whatever the SnowMobileCrashed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(),getY()+Object.speed);
        if (getY() >= getWorld().getHeight()+20) {
            getWorld().removeObject(this);
        }
    }    
}
