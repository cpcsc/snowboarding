import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Coins
{
    public void act() 
    {
        if (getY() < 0) killObst(); 
        objMove();
        pickUp();
    }

    public void pickUp() {
        if (!dead) {
            Boarder b = (Boarder) getOneIntersectingObject(Boarder.class);         
            if (b != null && (b.air() < 0 || b.magnetTimer > 0)) {
                SnowWorld w = (SnowWorld) getWorld();
                w.incScore(100);
                getWorld().removeObject(this);
                dead = true;
            }
        }
    }
}