import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Powerup
{
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         setLocation(getX(), getY()+3);
         pickUp();
    }    
    
    public void pickUp() {
        Boarder b = (Boarder) getOneIntersectingObject(Boarder.class);
        if (b != null) {
            b.gun += 10;
            getWorld().removeObject(this);
        }
    }
}
