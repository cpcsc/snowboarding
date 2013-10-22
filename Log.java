import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Log here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Log extends Obstacles
{
    /**
     * Act - do whatever the Log wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        logMove();
    }    
    public void logMove() {
        setLocation(getX(), getY()+speed);
        if (atWorldBottom()){
            getWorld().removeObject(this);
        }
    }
}
