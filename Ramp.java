import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ramp extends Object
{
    public Ramp() {
        getImage().scale(169,100);        
    }
    
    public void act() 
    {
        objMove();
        killObst();
    }
    
    public void killObst() {
        if (!dead) {
            Class[] list = {Log.class, Snowman.class, Pickup.class, Ramp.class};
            for(Class obst : list) {
                removeTouching(obst);
            }
        }
    }
}
