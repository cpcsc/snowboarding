import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tree extends Obstacles
{
    public Tree() {
        //getImage().scale(59,74);
    }
    
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
