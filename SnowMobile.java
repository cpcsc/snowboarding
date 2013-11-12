import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnowMobile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnowMobile extends Obstacles
{
    public int airTime = 0;
    public int jumpTime;
    public double jumpConst;
    private int trailTimer = 0;
    public int coins = 1;
    /**
     * Act - do whatever the SnowMobile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        trailTimer++;
        airTime--;
        setLocation(getX(),getY()-Object.speed/2);
        setImage("SnowMobile.png");
        trail();
        ramp();
        logJump();
        jump(jumpTime);
        killSnowman();
        killBear();
        bump();
    }

    public void trail() {
        if (trailTimer >= 3 && !air) {
            World w = getWorld();
            w.addObject(new SnowMobileTrail(), getX() + 10 , getY() + 20);
            w.addObject(new SnowMobileTrail(), getX() - 11 , getY() + 20);
            trailTimer = 0;
        }
    }

    public void logJump() {
        if (getOneObjectAtOffset(0, -getImage().getHeight()/2 - 8*Object.speed, Log.class) != null && airTime <= -5) {
            if (airTime <= -5) {
                airTime = 30;
                jumpTime = 30;
                jumpConst = -50.0 / 1058.0;
            }
        }
    }

    public void jump(int jumpTime) 
    {
        air = airTime > 0;
        if (air) {
            Image shadow = new Image("shadow.png");
            double scaleFactor = (jumpConst * airTime * airTime - jumpConst * jumpTime * airTime + 50) / 50 ; //parabolic path
            getImage().scale((int) (scaleFactor * getImage().getWidth()),(int) (scaleFactor * getImage().getHeight()));
            getWorld().addObject(shadow, getX(), getY() + (int) getImage().getHeight() / 2 );
        }
    }

    public void ramp() 
    {
        if (airTime < 0 && isTouching(Ramp.class)) {
            airTime = 60;
            jumpTime = 60;   
            jumpConst = -25.0 / 1058.0;
        }
    }

    public void killSnowman() 
    {
        if (!dead && airTime < 0 && isTouching(Snowman.class)) {
            Actor s = getOneIntersectingObject(Snowman.class);
            World w = getWorld();
            for (int j = 1; j <= 2; j++) {
                w.addObject(new Coin(), s.getX() + Greenfoot.getRandomNumber(21) - 10, s.getY() + Greenfoot.getRandomNumber(21) - 10);
            }
            w.removeObject(s);
        }
    }

    public void killBear() 
    {
        if (!dead && airTime < 0 && isTouching(Bear.class)) {
            Actor b = getOneIntersectingObject(Bear.class);
            World w = getWorld();
            for (int j = 1; j <= 4; j++) {
                w.addObject(new Coin(), b.getX() + Greenfoot.getRandomNumber(21) - 10, b.getY() + Greenfoot.getRandomNumber(21) - 10);
            }
            (new GreenfootSound("PolarBearDead.mp3")).play();
            w.removeObject(b);
        }
    }

    public void bump()
    {
        Actor tree = getOneIntersectingObject(Tree.class);
        Actor log = getOneIntersectingObject(Log.class);
        SnowWorld w = (SnowWorld) getWorld();
        if (tree != null || log != null && airTime < 0){
            for (int j = 1; j <= coins; j++) {
                w.addObject(new Coin(), getX() + Greenfoot.getRandomNumber(21) - 10, getY() + Greenfoot.getRandomNumber(21) - 10);
            }
            w.addObject(new SnowMobileCrashed(Greenfoot.getRandomNumber(180)-90),getX(),getY());
            w.removeObject(this);
            dead = true;
            (new GreenfootSound("Explosion.mp3")).play();
        }
        if (!dead && getY() <= -50) {
            w.removeObject(this);
            dead = true;
        }
    }

}
