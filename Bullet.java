import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Weapon
{

    public void act() 
    {
        setLocation(getX(), getY()-40);
        killSnowman();
        killBear();
        bump();
    }    

    public void killSnowman() {
        for(int i = getY()-40; i <= getY(); i++) {
            if (isTouching(Snowman.class)) {
                Actor s = getOneIntersectingObject(Snowman.class);
                World w = getWorld();
                for (int j = 1; j <= 2; j++) {
                        w.addObject(new Coin(), s.getX() + Greenfoot.getRandomNumber(21) - 10, s.getY() + Greenfoot.getRandomNumber(21) - 10);
                    }
                w.removeObject(s);
            }
        }
    }

    public void killBear() {    
            for(int i = getY()-40; i <= getY(); i++) {
                if (isTouching(Bear.class)) {
                    Actor b = getOneIntersectingObject(Bear.class);
                    World w = getWorld();
                    for (int j = 1; j <= 4; j++) {
                        w.addObject(new Coin(), b.getX() + Greenfoot.getRandomNumber(21) - 10, b.getY() + Greenfoot.getRandomNumber(21) - 10);
                    }
                    (new GreenfootSound("PolarBearDead.mp3")).play();
                    w.removeObject(b);
                }
            }
    }
    
     public void bump(){
        Actor tree = getOneIntersectingObject(Tree.class);
        Actor log = getOneIntersectingObject(Log.class);
        if (tree != null || log != null || getY() <= -20){
            SnowWorld w = (SnowWorld) getWorld();
            w.removeObject(this);
        }
    }
}