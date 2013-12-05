import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Object extends Actor
{
    public static int speed = 3;
    public boolean dead = false;
    public boolean air = false;
    public boolean atWorldBottom(){     // Mark McKinney
        return (getY() >= getWorld().getHeight() + 70);
    }
    
    public void objMove() {    // Ricky Escobar
        setLocation(getX(), getY() + speed);
        if (atWorldBottom()){
            getWorld().removeObject(this);
            dead = true;
        }
    }
    
    public boolean checkTree(int dir) {    // Ricky Escobar
        move(dir);
        if (getOneIntersectingObject(Tree.class) != null) {
            move(-dir);
            return true;
        } else {
            move(-dir);
            return false;
        }    
    }
    
    // Ricky Escobar
    public boolean canMove(int dx, int dy, Class cls) { //Returns whether or not the object can move to (x + dx, y + dy) and not be intersecting am object of class cls 
        setLocation(getX() + dx, getY() + dy);
        boolean c = getOneIntersectingObject(cls) == null;
        setLocation(getX() - dx, getY() - dy);
        return c;
    }
}
