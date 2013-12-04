import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Boarder extends Object
{   
    private int dragFromX, dragFromY;
    public int invincible = 0;
    private int airTime = 0;
    public int gun = 0;
    public static int rocket = 0;
    public int shotDelay = 0;
    public boolean shield = false;
    public int jumpTime;
    public double jumpConst;
    public int magnetTimer = 0;
    private int trailTimer = 0;
    public int dir;
    public static int delayMax = 20;
    public boolean storeSpawned = false;
    public int timerStore = 0;
    private SnowWorld sw;
    private int c;
    public void act() {
        trailTimer++;
        moveAround();
        ramp();
        trail();
        dieObstacle();
        dieTree();
        invincible++;
        airTime--;
        shotDelay++;
        respawnBlink();
        ramp();
        jump(jumpTime);
        magnet();
        timerStore++;
        if (dead) Boarder.rocket = 0; 
    }

    public void moveAround() {
        if (Greenfoot.isKeyDown("left") && getX() >= 0){
            if (canMove(-4, 0, Tree.class) || invincible < 100) {
                move(-4);
            }
            setImage("left.png");
            dir = -4;
        }
        if (Greenfoot.isKeyDown("right") && getX() <= getWorld().getWidth()){
            if (canMove(4, 0, Tree.class) || invincible < 100) {
                move(4);
            }
            setImage("right.png");
            dir = 4;
        }
        if (!Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right")){
            setImage("straight.png");
            dir = 0;
        }
        if (Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("right")){
            setImage("straight.png");
            move(0);
        }  
        if (!dead && Greenfoot.isKeyDown("up")) {
            SnowWorld sw = (SnowWorld) getWorld();
            if (airTime <= -6) {
                if(sw.getJumpU()){
                    airTime = 85;
                    jumpTime = 85;
                } else {
                    airTime = 50;
                    jumpTime = 50;
                }
                jumpConst = -50.0 / 1058.0;
            } else if (airTime <= -5) {
                if(sw.getJumpU()){
                    airTime = 40;
                    jumpTime = 40;
                } else {
                    airTime = 25;
                    jumpTime = 25;
                }
                jumpConst = -50.0 / 1058.0;
            }
        }
        if (Greenfoot.isKeyDown("z") && gun > 0 && shotDelay >= delayMax) {
            Bullet bullet = new Bullet();
            if (shotDelay == delayMax) {
                bullet.angle = Greenfoot.getRandomNumber(11) - 5;
            }
            getWorld().addObject(bullet, getX(), getY());
            shotDelay = 0;
            (new GreenfootSound("GunShotSound.mp3")).play();
            gun--;
        }
        if (Greenfoot.isKeyDown("x") && rocket > 0 && shotDelay >= delayMax) {
            Rocket r = new Rocket();
            getWorld().addObject(r, getX(), getY());
            shotDelay = 0;
            (new GreenfootSound("GunShotSound.mp3")).play();
            rocket--;
        }
        SnowWorld w = (SnowWorld) getWorld();
        w.incScore(1);
    }

    public void ramp() {
        if (airTime < 0 && !dead && isTouching(Ramp.class)) {
            SnowWorld sw = (SnowWorld) getWorld();
            if(sw.getJumpU()){
                airTime = 150;
                jumpTime = 150;
            }
            else{
                airTime = 100;
                jumpTime = 100;   
            }
            jumpConst = -25.0 / 1058.0;
        }
    }

    public void trail() {
        if (airTime < 0) {
            World w = getWorld();
            for (int i = 1; i <= Object.speed; i++) {
                w.addObject(new SnowTrail(12), getX() - 5 - i*dir/Object.speed, getY() + 20 + i);                 
            }
        }
    }

    public int air() {
        return airTime;
    }

    public void dieObstacle(){
        Object obstacle = (Object) getOneIntersectingObject(Obstacles.class);
        if (obstacle != null && invincible > 100 && air == obstacle.air) {
            if (!shield) {
                SnowWorld w = (SnowWorld) getWorld();
                w.multCounter = 0;
                w.removeObject(this);
                dead = true;
            } else {
                shield = false;
                invincible = 0;
            }
        }
    }

    public void dieTree() {
        if (!dead) {
            Actor tree = getOneIntersectingObject(Tree.class);
            if (tree != null && invincible > 100) {
                if (!shield) {
                    SnowWorld w = (SnowWorld) getWorld();
                    w.multCounter = 0;
                    w.removeObject(this);
                    dead = true;
                } else {
                    shield = false;
                    invincible = 0;
                }
            }
        }
    }

    public void respawnBlink() {
        SnowWorld w = (SnowWorld) getWorld();
        if (invincible < 100) {
            GreenfootImage img = getImage();
            int fast = (invincible >= 0) ? 2 : 1;
            double transparency = 127 * Math.sin(fast * invincible / 4.0) + 128;
            img.setTransparency((int) transparency);
            setImage(img);      

            /**if(w.getLives().getTotalLives() < 3){
                if(storeSpawned == false){
                    getWorld().addObject(new StoreText(w,w.getCoins()), 450, 150);
                    storeSpawned = true;
                }
            }*/
        }
        if (invincible == 100) {
            getImage().setTransparency(255);
        }
    }

    public void setInvincible(int i) {
        invincible = i;
    }
    
    public int getInvincible(){
        return invincible;
    }

    public void jump(int jumpTime) {
        air = airTime > 0;
        if (!dead) {
            if (air) {
                getWorld().setPaintOrder(Counter.class, Coin2.class, Boarder.class, SnowMobile.class, Image.class, Lives.class, Buttons.class, Obstacles.class, Weapon.class, Pickup.class);
            } else {
                getWorld().setPaintOrder(Counter.class, Coin2.class, SnowMobile.class, Boarder.class, Image.class, Lives.class, Buttons.class, Obstacles.class, Weapon.class, Pickup.class);
            }
            if (air) {
                Image shadow = new Image("shadow.png");
                double scaleFactor = (jumpConst * airTime * airTime - jumpConst * jumpTime * airTime + 50) / 50 ; //parabolic path
                getImage().scale((int) (scaleFactor * getImage().getWidth()),(int) (scaleFactor * getImage().getHeight()));
                getWorld().addObject(shadow, getX(), getY() + (int) getImage().getHeight() / 2 );
            }
        }
    }

    public void magnet() {
        magnetTimer--;
        if (magnetTimer > 0 && !dead) {
            List l = getNeighbours(200, false, Pickup.class);
            for (int i = 0; i < l.size(); i++) {
                Actor a = (Actor) l.get(i);
                a.turnTowards(getX(), getY());
                a.move(Object.speed + 2);
                a.setRotation(0);
            }
        }
    }
}