import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Weapon
{
    public void act() {
        setLocation(getX(), getY() - 20);
        destroy();
        disappear();
    }    

    public void destroy() {
        if (isTouching(Obstacles.class)) {
            getWorld().addObject(new Explosion(300),getX(),getY());
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

