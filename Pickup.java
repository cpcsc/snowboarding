import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pickup extends Object
{   
    public void act() 
    {
    }   
    public void killObst() {
        if (!dead) {
            Class[] list = {Log.class, Snowman.class, Ramp.class};
            for(Class obst : list) {
                removeTouching(obst);
            }
        }
    }
    public void killObst2()
    {
        if (!dead) {
            Class[] list = {Log.class, Snowman.class, Ramp.class};
            for(Class obst : list) {
                removeTouching(obst);
            }
        }
    }
    public void killCoins()
    {
        Class[] list = {Coin.class, Coin2.class};
        for(Class obst : list)
        {
            removeTouching(obst);
        }
    }    
}
