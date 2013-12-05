import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Snowman extends Obstacles
{
    // Mark McKinney
    
    public Snowman() {
       getImage().scale(36,65);             
    }
    
    public void act() {
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
    
    public void die() {
        World w = getWorld();
        for (int j = 1; j <= 2; j++) {
            w.addObject(new Coin(), getX() + Greenfoot.getRandomNumber(21) - 10, getY() + Greenfoot.getRandomNumber(21) - 10);
        }
        w.removeObject(this);
        dead = true;
    }
}