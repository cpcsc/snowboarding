import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Weapon
{
    
    public void act() 
    {
        setLocation(getX(), getY()-40);
        killEnemy();
    }    
    
    public void killEnemy() {
        for(int i = getY()-40; i <= getY(); i++) {
            if (isTouching(Snowman.class)) {
                removeTouching(Snowman.class);
                getWorld().removeObject(this);
                break;
            }
        }
    }
}