import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnowMobile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnowMobile extends Obstacles
{
    private int airTime = 0;
    public int jumpTime;
    public double jumpConst;
    private int trailTimer = 0;
    public int dir;
    /**
     * Act - do whatever the SnowMobile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        trailTimer++;
        airTime--;
        setLocation(getX(),getY()-Object.speed);
        trail();
        ramp();
        jump(jumpTime);
        killSnowman();
        killBear();
        bump();
    }

    public void trail() {
        if (airTime < 0) {
            World w = getWorld();
            for (int i = 1; i <= Object.speed; i++) {
                w.addObject(new SnowTrail(), getX() - i*dir/Object.speed, getY() + 20 + i);
            }
        }
    }
    
    public void jump(int jumpTime) 
    {
        if (airTime > 0) {
            Image shadow = new Image("shadow.png");
            getWorld().addObject(shadow, getX(), getY() + (int) getImage().getHeight() / 2 );
        }
    }

    public void ramp() 
    {
        if (airTime < 0 && isTouching(Ramp.class)) {
            airTime = 100;
            jumpTime = 100;   
            jumpConst = -25.0 / 1058.0;
        }
    }

    public void killSnowman() 
    {
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

    public void killBear() 
    {
        if (!dead) {
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
    }

    public void bump()
    {
        Actor tree = getOneIntersectingObject(Tree.class);
        Actor log = getOneIntersectingObject(Log.class);
        if (tree != null || log != null || getY() <= -20){
            SnowWorld w = (SnowWorld) getWorld();
            w.removeObject(this);
        }
    }

}
