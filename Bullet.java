import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Weapon
{

    public void act() 
    {
        setLocation(getX(), getY()-40);
        killSnowman();
        killBear();
    }    

    public void killSnowman() {
        for(int i = getY()-40; i <= getY(); i++) {
            if (isTouching(Snowman.class)) {
                removeTouching(Snowman.class);
                World w = getWorld();
                w.addObject(new Coin(), getX(), getY());
                w.removeObject(this);
                dead = true;
                break;
            }
        }
    }

    public void killBear() {
        if (!dead) {
            for(int i = getY()-40; i <= getY(); i++) {
                if (isTouching(Bear.class)) {
                    removeTouching(Bear.class);
                    World w = getWorld();
                    for (int j = 1; j <= 4; j++) {
                        w.addObject(new Coin(), getX() + Greenfoot.getRandomNumber(11) - 5, getY() + Greenfoot.getRandomNumber(11) - 5);
                    }
                    w.removeObject(this);
                    dead = true;
                    break;
                }
            }
        }
    }
}