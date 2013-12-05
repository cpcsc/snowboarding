import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SnowTrail extends Actor
{
    // Ricky Escobar && Andrew Tran

    public int timer = 0;
    
    public SnowTrail() {
    }

    public SnowTrail(int w) {
        getImage().scale(w,15);
    }

    public void act() {
        timer++;
        setLocation(getX(), getY() + Object.speed);
        if (getY() >= getWorld().getHeight()+20){
            getWorld().removeObject(this);
        }
        else if (timer >= 75) {
            getWorld().removeObject(this);
            timer = 0;
        }
        getImage().setTransparency((75-timer)*255/150);
    }    
}
