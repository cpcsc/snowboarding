import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class RocketLauncher extends Pickup
{
    // Tyeler Bridges
    // Image: Andrew Tran
    
    public void act() {
        if (getY()<0) killObst();
        objMove();
        pickUp();
    }    

    public void pickUp() {
        if (!dead) {
            Boarder b = (Boarder) getOneIntersectingObject(Boarder.class);
            if (b != null) {
                (new GreenfootSound("reload.mp3")).play();
                b.rocket += 5;
                getWorld().removeObject(this);
                dead = true;
            }
        }
    }
}
