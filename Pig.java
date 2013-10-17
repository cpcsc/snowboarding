import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pig here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pig extends Object
{
    public int speed = 4;
    
    public void act() 
    {
        move(speed);
        if (getX() >= getWorld().getWidth() - 50){
            moveLeft();
        }
        if (getX() < 50) {
            moveRight();
        }
    }
    
    public void moveLeft() {
        setImage("cop_left.png");
        speed = -speed;
    }
    public void moveRight() {
        setImage("cop_right.png");
        speed = -speed;
    }
}