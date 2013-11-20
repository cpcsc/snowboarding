import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Explosion extends Actor
{
    public int size;
    public int explodeTimer = 0;
    public Explosion(int size) {
        this.size = size;
        GreenfootImage img = new GreenfootImage("explosion/explosion_010_" + explodeTimer + ".gif");
        img.scale(size, 108 * size / 149);
        setImage(img);
        (new GreenfootSound("Explosion.mp3")).play();
    }

    public void act() {
        setLocation(getX(), getY() + Object.speed);
        kill();
        explode();
    }    

    public void kill() {
        getWorld().removeObjects(getIntersectingObjects(Obstacles.class));
    }

    public void explode() {
        if (explodeTimer < 12) {
            GreenfootImage img = new GreenfootImage("explosion/explosion_010_" + explodeTimer + ".gif");
            img.scale(size, 108 * size / 149);
            setImage(img);
            explodeTimer++;
        } else {
            getWorld().removeObject(this);
        }
    }
}
