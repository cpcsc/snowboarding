import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Weapon
{
    public void act() 
    {
        setLocation(getX(), getY() - 40);
        killSnowman();
        killBear();
        killSnowMobile();
        disappear();
    }    

    public void killSnowman() {
        if (isTouching(Snowman.class)) {
            Snowman s = (Snowman) getOneIntersectingObject(Snowman.class);
            s.die();
            die();
        }
    }

    public void killBear() {    
        if (!dead && isTouching(Bear.class)) {
            Bear b = (Bear) getOneIntersectingObject(Bear.class);
            b.die();
            die();
        }
    }

    public void killSnowMobile() {
        if (!dead && isTouching(SnowMobile.class)) {
            SnowMobile sm = (SnowMobile) getOneIntersectingObject(SnowMobile.class);
            sm.die();
            die();
        }
    }

    public void disappear(){       
        if (!dead && getY() <= -200){
            die();
        }
    }
    
    public void die() {
        dead = true;
        getWorld().removeObject(this);
    }
}