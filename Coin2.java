import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin2 extends Pickup
{
    public Coin2() {
        getImage().scale(getImage().getWidth() + 7, getImage().getHeight() + 7);
        GreenfootImage img = new GreenfootImage("shadow.png");
        img.drawImage(getImage(), 0, 0);
        setImage(img);
    }
    
    public void act() 
    {
        setLocation(getX(), getY()+3);
        pickUp();
    }

    public void pickUp() {
        Boarder b = (Boarder) getOneIntersectingObject(Boarder.class);
        if (getWorld().getObjects(Boarder.class).size() != 0) {
            int air = ((Boarder) getWorld().getObjects(Boarder.class).get(0)).air();
        
            if (b != null && air >= 0) {
                SnowWorld w = (SnowWorld) getWorld();
                w.incScore(100);
                getWorld().removeObject(this);
            }
    }
    }
}
