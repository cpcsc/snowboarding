import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnowMobileTrail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnowMobileTrail extends Actor
{
    public SnowMobileTrail() {
        int w = getImage().getWidth();
        getImage().scale(w, 6*Object.speed);
    }
    public int timer = 0;
    public void act() 
    {
        timer++;
        setLocation(getX(), getY() + Object.speed);
        if (getY() >= getWorld().getHeight()+20){
            getWorld().removeObject(this);
        }
        else if (timer >= 50) {
            getWorld().removeObject(this);
            timer = 0;
        }
        getImage().setTransparency((50-timer)*255/75);
    }  
    
}
