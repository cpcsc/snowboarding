import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ramp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ramp extends Object
{
    /**
     * Act - do whatever the Ramp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY()+speed);
        //Pickup p = (Pickup) getWorld().getObjects(Pickup.class);
        
        if (atWorldBottom()){
            getWorld().removeObject(this);
        }
        //if (getY()<0) p.killCoins();
    }
}
