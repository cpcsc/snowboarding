import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Rocket extends Weapon
{
    // Tyeler Bridges
    // Image: Andrew Tran
    
    public void act() {
        setLocation(getX(), getY() - 20);
        destroy();
        disappear();
    }    

    public void destroy() {
        if (isTouching(Obstacles.class)) {
            getWorld().addObject(new Explosion(250),getX(),getY());
            dead = true;
            getWorld().removeObject(this);
        }
    }

    public void disappear() {       
        if (!dead && getY() <= -200){
            SnowWorld w = (SnowWorld) getWorld();
            w.removeObject(this);
            dead = true;
        }
    }
}
