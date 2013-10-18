import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Obstacles
{
    /**
     * Act - do whatever the Tree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        killSnowman();
        treeMove();
        
    }
    
    public void treeMove(){
        setLocation(getX(), getY()+3);
        if (atWorldBottom()){
            getWorld().removeObject(this);
        }
    } 
    public void killSnowman() {
        Actor snow = getOneIntersectingObject(Snowman.class);
        if (snow != null) {
            getWorld().removeObject(snow);
            return;
        }
    }
}
