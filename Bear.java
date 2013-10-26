import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bear extends Obstacles
{
    public int dir = 1;
    public int imgDir = 1;
    public void act() 
    {
        objMove();
        if (!dead) {
            getDir();
            bearMove(); 
            killObst();
        }
    }    

    public void bearMove() {
        if (getOneObjectAtOffset(dir + getImage().getWidth()/2, 0, Obstacles.class) != null) {
            dir = 0;
        }        
        setLocation(getX() + dir, getY());        
    }

    public void getDir() {
        World w = getWorld();
        if (w.getObjects(Boarder.class).size() != 0) {
            Boarder b = (Boarder) w.getObjects(Boarder.class).get(0);
            if (b.getX() - getX() != 0) {
                dir = (b.getX() - getX()) / Math.abs(b.getX() - getX());
                if (dir != imgDir) {
                    getImage().mirrorHorizontally();
                    imgDir *= -1;
                }
            } else {
                dir = 0;              
            }
        }
    }
    
    public void killObst() {
        if (!dead) {
            Class[] list = {Snowman.class, Log.class};
            for(Class obst : list) {
                removeTouching(obst);
            }
        }
    }
}
