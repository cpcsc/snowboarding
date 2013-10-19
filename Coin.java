import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Pickup
{
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        killSnowman(); 
        setLocation(getX(), getY()+3);
        pickUp();
    }    
    
    public void pickUp() {
        Boarder b = (Boarder) getOneIntersectingObject(Boarder.class);
        if (b != null) {
            SnowWorld w = (SnowWorld) getWorld();
            w.incScore(100);
            getWorld().removeObject(this);
        }
    }
    
        public void killSnowman() {
        removeTouching(Snowman.class);
    }
}