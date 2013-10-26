import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Pickup
{
    public void act() 
    {
        killObst();
        objMove();
        pickUp();
    }

    public void pickUp() {
        if (!dead) {
            Boarder b = (Boarder) getOneIntersectingObject(Boarder.class);
            if (getWorld().getObjects(Boarder.class).size() != 0) {
                int air = ((Boarder) getWorld().getObjects(Boarder.class).get(0)).air();
                if (b != null && air <= 0) {
                    SnowWorld w = (SnowWorld) getWorld();
                    w.incScore(100);
                    w.removeObject(this);
                    dead = true;
                }
            }
        }
    }
}