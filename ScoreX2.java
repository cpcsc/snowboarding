import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreX2 extends Pickup
{
    public void act() 
    {
        if (getY()<0) killObst();
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
