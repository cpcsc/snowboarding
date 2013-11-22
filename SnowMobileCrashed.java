import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SnowMobileCrashed extends Object
{
    public int explodeTimer = 0;
    public SnowMobileCrashed(int rotation)
    {
        setRotation(rotation);
    }

    public void act() 
    {
        explode();
        setLocation(getX(),getY()+Object.speed);
        if (getY() >= getWorld().getHeight()+20) {
            getWorld().removeObject(this);
        }
    }    

    public void explode() {
        if (explodeTimer < 12) {
            getWorld().addObject(new Image("explosion/explosion_010_"+explodeTimer+".gif"), getX(), getY());
            explodeTimer++;
        }
    }
}
