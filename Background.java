import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Actor
{
    public int snowTimer = 0;
    public boolean atWorldBottom(){
        if (getY() >= getWorld().getHeight() - 1){
            return true;
        }
        else return false;
    }
    
    public void act() 
    {
        if (snowTimer > 0){
            snowTimer = snowTimer - 1;
        }
        else {
            Snow snow = new Snow();
            getWorld().addObject(snow, Greenfoot.getRandomNumber(getWorld().getWidth()), 0);
            snow.setRotation(Greenfoot.getRandomNumber(360));
            snowTimer = 1;
        }
    }    
}
