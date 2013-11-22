import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bot extends Object
{
    public int speed = 4;
    private int timer = 0;
    
    public void act() 
    {
        timer++;
        if (canMove(10*speed, 0, Tree.class)) {
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
            getWorld().addObject(new SnowTrail(),getX()-5,getY()+25);
            timer=0;
        }
    }
}
