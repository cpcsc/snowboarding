import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Object extends Actor
{
    public int lives = 3;
    public int score = 0;
    public int speed = 3;
    public boolean atWorldBottom(){
        return (getY() >= getWorld().getHeight() + 50);
    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    public boolean checkTree(int dir) {
        move(dir);
        if (getOneIntersectingObject(Tree.class) != null) {
            move(-dir);
            return true;
        } else {
            move(-dir);
            return false;
        }    
    }
}
