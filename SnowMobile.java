import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SnowMobile extends Obstacles
{
    // Andrew Tran && Ricky Escobar
    
    public int airTime = 0;
    public int jumpTime;
    public double jumpConst;
    private int trailTimer = 0;
    public int coins = 1;

    public void act() {
        trailTimer++;
        airTime--;
        setLocation(getX(), getY() - Object.speed/2);
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
            w.addObject(new SnowMobileTrail(), getX() + 10, getY() + 20);
            w.addObject(new SnowMobileTrail(), getX() - 11, getY() + 20);
            trailTimer = 0;
        }
    }

    public void logJump() {
        if (!canMove(0, -8 * Object.speed, Log.class) && airTime <= -5) {
            airTime = 30;
            jumpTime = 30;
            jumpConst = -50.0 / 1058.0;
        }
    }

    public void jump(int jumpTime) {
        air = airTime > 0;
        if (air) {
            Image shadow = new Image("shadow.png");
            double scaleFactor = (jumpConst * airTime * airTime - jumpConst * jumpTime * airTime + 50) / 50 ; //parabolic path
            getImage().scale((int) (scaleFactor * getImage().getWidth()),(int) (scaleFactor * getImage().getHeight()));
            getWorld().addObject(shadow, getX(), getY() + (int) getImage().getHeight() / 2 );
        }
    }

    public void ramp() {
        if (airTime < 0 && isTouching(Ramp.class)) {
            airTime = 60;
            jumpTime = 60;   
            jumpConst = -25.0 / 1058.0;
        }
    }

    public void killSnowman() {
        if (!dead && airTime < 0 && isTouching(Snowman.class)) {
            Snowman s = (Snowman) getOneIntersectingObject(Snowman.class);
            s.die();
        }
    }

    public void killBear() {
        if (!dead && airTime < 0 && isTouching(Bear.class)) {
            Bear b = (Bear) getOneIntersectingObject(Bear.class);
            b.die();
        }
    }

    public void bump() {
        if((isTouching(Log.class) && !air) || isTouching(Tree.class)) {
            die();
        }
        if (!dead && getY() <= -200) {
            getWorld().removeObject(this);
            dead = true;
        }
    }

    public void die() {
        World w = getWorld();
        for (int j = 1; j <= coins; j++) {
            w.addObject(new Coin(), getX() + Greenfoot.getRandomNumber(21) - 10, getY() + Greenfoot.getRandomNumber(21) - 10);
        }
        (new GreenfootSound("Explosion.mp3")).play();
        w.addObject(new SnowMobileCrashed(Greenfoot.getRandomNumber(180)-90), getX(), getY());
        w.removeObject(this);
        dead = true;
    }
}
