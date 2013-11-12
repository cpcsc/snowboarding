import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin2 extends Coins
{
    
    public Coin2() {
        getImage().scale(20*3/2, 20*3/2);
        GreenfootImage img = new GreenfootImage("shadow.png");
        img.drawImage(getImage(), 4, 4);
        setImage(img);
        air = true;
    }

    public void act() 
    {
        if (getY()<0) killObst();
        objMove();
        pickUp();
    }

    public void pickUp() {
        if (!dead) {
            Boarder b = (Boarder) getOneIntersectingObject(Boarder.class);         
            if (b != null && (b.air() >= 0 || b.magnetTimer > 0)) {
                SnowWorld w = (SnowWorld) getWorld();
                w.incScore(100);
                w.removeObject(this);
                w.addCoin(1);
                dead = true;
                Greenfoot.playSound("coin.wav");
            }
        }
    }
}
