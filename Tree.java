import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// Ricky Escobar
// Image: Megan Voss

public class Tree extends Obstacles
{
    public void act() 
    {
        killObst();
        objMove();        
    }
       
    public void killObst() {
        if (!dead) {
            Class[] list = {Log.class, Snowman.class, Ramp.class, Coins.class};
            for(Class obst : list) {
                removeTouching(obst);
            }
        }
    }
}
