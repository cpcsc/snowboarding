import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Snowman extends Obstacles
{
    public Snowman() {
       getImage().scale(36,65);             
    }
    public void act() 
    {
        objMove();
        killObst();
    }
    
    public void killObst() {
        if (!dead) {
            Class[] list = {Ramp.class};
            for(Class obst : list) {
                removeTouching(obst);
            }
        }
    }
}