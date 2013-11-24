import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Gun extends Pickup
{
    public static int clipSize = 10;
    
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
                b.gun += clipSize;
                getWorld().removeObject(this);
                dead = true;
            }
        }
    }
}
