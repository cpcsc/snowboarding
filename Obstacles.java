import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacles extends Object

{
    public int snowmanTimer = 0;
    private boolean hasDied;
    public boolean atWorldBottom(){
        return (getY() >= getWorld().getHeight() - 1);
    }

    public void act()
    {
        addObst();
    }
    
    public void addObst(){
        if (snowmanTimer > 0){
            snowmanTimer = snowmanTimer - 1;
        }
        else {
            Snowman snowman = new Snowman();
            getWorld().addObject(snowman, Greenfoot.getRandomNumber(getWorld().getWidth()), 0);
            snowmanTimer = 30;
        }
    }
}
