import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bot extends Object
{
    public int speed = 4;
    private int timer = 0;
    
    public void act() 
    {
        timer++;
        if (!checkTree(10*speed)) {
            setLocation(getX() + speed, getY());
        } else {
            turn();
        }
        trail();
    }

    public void turn() {
        GreenfootImage img = getImage();
        img.mirrorHorizontally();
        setImage(img);
        speed *= -1;
        setLocation(getX() + speed, getY());
    }
    
    public void trail() {
        if (timer >= 1) {
            getWorld().addObject(new SnowTrail(),getX(),getY()+25);
            getWorld().addObject(new SnowTrail(),getX()-10,getY()+25);
            timer=0;
        }
    }
}
