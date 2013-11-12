import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gunupgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gunupgrade extends Pickup
{
    /**
     * Act - do whatever the gunupgrade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getY()<0) killObst();
        objMove();
        retreive();
    }    
    
    public void retreive()
    {
        if (!dead)
        {
            Boarder b = (Boarder) getOneIntersectingObject(Boarder.class);
            if (b != null)
            {
                SnowWorld w = (SnowWorld) getWorld();
                w.removeObject(this);
                dead = true;
                b.getHardDelay();
                b.changeHardDelay();
                w.addCoin(-200);
            }
        }
    }
    
}
