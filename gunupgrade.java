import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class gunupgrade extends Pickup
{
    public void act() {
        if (getY()<0) killObst();
        objMove();
        pickUp();
    }    

    public void pickUp() {
        if (!dead && isTouching(Boarder.class)) {        
            SnowWorld w = (SnowWorld) getWorld();
            if (w.coins >= 200) {
                w.getBoarder().delayMax -= 5;
                w.removeObject(this);
                dead = true;
                w.coins -= 200;
            }
        }
    }    
}
