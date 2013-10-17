import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snowman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snowman extends Obstacles
{
    /**
     * Act - do whatever the Snowman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        snowmanMove();
    }
    
    public void snowmanMove(){
        setLocation(getX(), getY()+3);
        if (atWorldBottom()){
            getWorld().removeObject(this);
        }
    }
}