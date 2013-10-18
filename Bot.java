import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bot extends Object
{
    public int speed = 4;
    
    public void act() 
    {
        if (!checkTree(10*speed)) {
            setLocation(getX() + speed, getY());
        } else {
            turn();
        }
    }

    public void turn() {
        GreenfootImage img = getImage();
        img.mirrorHorizontally();
        setImage(img);
        speed *= -1;
        setLocation(getX() + speed, getY());
    }  
}