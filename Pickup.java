import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pickup extends Object
{    
    public void killObst() {
        if (!dead) {
            Class[] list = {Log.class, Snowman.class};
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
