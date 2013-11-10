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
    public static int speed = 3;
    public boolean dead = false;
    public boolean air = false;
    public boolean atWorldBottom(){
        return (getY() >= getWorld().getHeight() + 70);
    }
    
    public void objMove() {
        setLocation(getX(), getY() + speed);
        if (atWorldBottom()){
            getWorld().removeObject(this);
            dead = true;
        }
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
