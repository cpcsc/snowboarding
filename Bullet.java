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
                Actor s = getOneIntersectingObject(Snowman.class);
                World w = getWorld();
                w.addObject(new Coin(), s.getX(), s.getY());
                w.removeObject(s);
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
                    Actor b = getOneIntersectingObject(Bear.class);
                    World w = getWorld();
                    for (int j = 1; j <= 4; j++) {
                        w.addObject(new Coin(), b.getX() + Greenfoot.getRandomNumber(21) - 10, b.getY() + Greenfoot.getRandomNumber(21) - 10);
                    }
                    w.removeObject(b);
                    w.removeObject(this);
                    dead = true;
                    break;
                }
            }
        }
    }
}