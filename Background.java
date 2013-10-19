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
        return (getY() >= getWorld().getHeight() + 50); // smooth exit
    }
    
    public void act() 
    {
        if (snowTimer > 0){
            snowTimer--;
        }
        else {
            Snow snow = new Snow();
            getWorld().addObject(snow, Greenfoot.getRandomNumber(getWorld().getWidth()), -50);
            snow.setRotation(Greenfoot.getRandomNumber(360));
            snowTimer = 1;
        }
    }    
}
