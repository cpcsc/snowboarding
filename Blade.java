import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Blade extends Pickup
{
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
