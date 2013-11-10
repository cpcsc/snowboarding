import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnowTral here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnowTrail extends Actor
{
    public SnowTrail(int w)
    {
        getImage().scale(w,15);
    }
    
    public SnowTrail()
    {
    }
    
    private int timer = 0;
    /**
     * Act - do whatever the SnowTral wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timer++;
        
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        //if (w > 1 && timer>=3) {
            //getImage().scale(w*9/10,h*9/10);
            //timer = 0;
        //}
        if (w <= 1) {
            getWorld().removeObject(this);
        }
        setLocation(getX(), getY() + Object.speed);
        if (getY() >= getWorld().getHeight()+20){
            getWorld().removeObject(this);
        }
        else if (timer > 150) {
            getWorld().removeObject(this);
            timer = 0;
        }
    }    
}
