import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blade extends Pickup
{
    /**
     * Act - do whatever the Blade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public void act() 
    {
        if (getY()<0) killObst();
        objMove();
        pickUp();
    }    

    public void pickUp() {
        if (!dead) {
            Boarder b = (Boarder) getOneIntersectingObject(Boarder.class);
            if (b != null) {
                b.sword += 1;
                getWorld().removeObject(this);
                dead = true;
            }
        }
    }
}
