import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreX2 extends Pickup
{
    // Ricky Escobar
    
    public static int Multiplier = 2;
    
    public void act() 
    {
        if (getY()<0) killObst();
        objMove();
        pickUp();
        if (Multiplier == 3) {
            setImage("x3.png");
        }    
    }   

    public void pickUp () {
        if (!dead && isTouching(Boarder.class)) {
            SnowWorld w = (SnowWorld) getWorld();
            w.scoreMult(Multiplier, 500);
            w.removeObject(this);
            dead = true;      
        }
    }
}
