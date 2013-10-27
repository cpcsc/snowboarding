import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreX2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreX2 extends Pickup
{
    public void act() 
    {
        killObst();
        objMove();
        pickUp();
    }   

    public void pickUp () {
        if (!dead && isTouching(Boarder.class)) {
            SnowWorld w = (SnowWorld) getWorld();
            w.scoreMult(2, 500);
            w.removeObject(this);
            dead = true;      
        }
    }
}
