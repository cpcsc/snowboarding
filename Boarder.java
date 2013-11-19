import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Boarder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boarder extends Object
{   
    private int dragFromX, dragFromY;
    public int invincible = 0;
    private int airTime = 0;
    public int gun = 0;
    public int shotDelay = 0;
    public int sword = 0;
    public int jumpTime;
    public double jumpConst;
    public int magnetTimer = 0;
    private int trailTimer = 0;
    public int dir;
    public int delayMax = 20;
    public static int thedelaymax = 20;
    public void act() 
    {
        trailTimer++;
        moveAround();
        ramp();
        trail();
        if (sword > 0) {
            blade();
        }
        dieObstacle();
        dieTree();
        invincible++;
        airTime--;
        shotDelay++;
        respawnBlink();
        ramp();
        jump(jumpTime);
        magnet();
        upgrades();
    }

    public void moveAround()
    {
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
        if (Greenfoot.isKeyDown("up")) {
            if (airTime <= -5) {
                SnowWorld sw = (SnowWorld) getWorld();
                if(!dead && sw.getJumpU()){
                    airTime = 85;
                    jumpTime = 85;
                }
                else{
                    airTime = 50;
                    jumpTime = 50;
                }
                jumpConst = -50.0 / 1058.0;
            }
        }
        if (Greenfoot.isKeyDown("space") && gun > 0 && shotDelay >= thedelaymax) {
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX(), getY());
            shotDelay = 0;
            (new GreenfootSound("GunShotSound.mp3")).play();
            gun--;
        }
        // touchscreen (mouse drag) detection/movement
        if (Greenfoot.mousePressed(null))  
        {  
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            dragFromX = mouse.getX();  
            dragFromY = mouse.getY();  
        }  
        if (Greenfoot.mouseDragged(null) || Greenfoot.mouseDragEnded(null))  
        {  
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            int newX = mouse.getX(), newY = mouse.getY();  
            // check difference(s) and act upon them 

            if (newX > dragFromX + 30 && getX() <= getWorld().getWidth())
            {
                move(4);
                setImage("right.png");
            }

            if (newX < dragFromX - 30 && getX() >= 0)
            {
                move(-4);
                setImage("left.png");
            }

            if (newY < dragFromY - 30)
            {
                if (airTime <= -20) {
                    airTime = 46;
                }
            }
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

    public void blade()
    {
        if (isTouching(Snowman.class) && airTime < 0) {
            Actor s = getOneIntersectingObject(Snowman.class);
            World w = getWorld();
            for (int j = 1; j <= 2; j++) {
                w.addObject(new Coin(), s.getX() + Greenfoot.getRandomNumber(21) - 10, s.getY() + Greenfoot.getRandomNumber(21) - 10);
            }
            w.removeObject(s);
            sword = sword - 1;
        }
        if (!dead && isTouching(Bear.class) && airTime < 0) {
            Actor b = getOneIntersectingObject(Bear.class);
            World w = getWorld();
            for (int j = 1; j <= 4; j++) {
                w.addObject(new Coin(), b.getX() + Greenfoot.getRandomNumber(21) - 10, b.getY() + Greenfoot.getRandomNumber(21) - 10);
            }
            (new GreenfootSound("PolarBearDead.mp3")).play();
            w.removeObject(b);
            sword = sword - 1;
        }
    }

    public int air() {
        return airTime;
    }

    public void dieObstacle(){
        Object obstacle = (Object) getOneIntersectingObject(Obstacles.class);
        if (obstacle != null && invincible > 100 && air == obstacle.air && sword == 0){
            SnowWorld w = (SnowWorld) getWorld();
            w.multCounter = 0;
            w.removeObject(this);
            dead = true;
        }
    }

    public void dieTree() {
        if (!dead) {
            Actor tree = getOneIntersectingObject(Tree.class);
            if (tree != null && invincible > 100) {
                SnowWorld w = (SnowWorld) getWorld();
                w.multCounter = 0;
                w.removeObject(this);
                dead = true;
            }
        }
    }

    public void respawnBlink() {
        if (invincible < 100) {
            GreenfootImage img = getImage();
            int fast = (invincible >= 0) ? 2 : 1;
            double transparency = 127 * Math.sin(fast * invincible / 4.0) + 128;
            img.setTransparency((int) transparency);
            setImage(img);      
        }
        if (invincible == 100) {
            GreenfootImage img = getImage();
            img.setTransparency(255);
            setImage(img);        
        }
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

    public int getGun() {
        return gun;
    }
    
    public int getSword() {
        return sword;
    }

    public void upgrades(){
        SnowWorld sw = (SnowWorld) getWorld();
        if(!dead && sw.getJumpU()){

        }
    }
}