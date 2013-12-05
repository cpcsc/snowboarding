import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// Ricky Escobar
// Image: Megan Voss

public class Log extends Obstacles
{
    public Log() {
        getImage().scale(189,30);
    }

    public void act() 
    {
        killObst();
        objMove();
    }    

    public void killObst() {
        if (!dead) {
            Class[] list = {Snowman.class, Ramp.class};
            for(Class obst : list) {
                removeTouching(obst);
            }
        }
    }
}
