import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Invincibility here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Invincible extends Pickup
{
    /**
     * Act - do whatever the Invincibility wants to do. This method is called whenever
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
                b.invincible = -500;
                getWorld().removeObject(this);
                dead = true;
            }
        }
    }
}
