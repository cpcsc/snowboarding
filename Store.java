import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Store extends Obstacles
{
    public void act() 
    {
        objMove();
        SnowWorld sw = (SnowWorld) getWorld();
        if(!dead) {
            if(getWorld().getObjects(Boarder.class).size() != 0) {
                if(getOneIntersectingObject(Boarder.class) != null) {
                    Greenfoot.setWorld(new StoreWorld(getWorld(), sw.getCoins()));
                    getWorld().removeObject(this);
                }
            }
        }
    }    
}
