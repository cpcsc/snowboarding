import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// Mark McKinney && Ricky Escobar

public class Store extends Pickup
{
    public void act() 
    {
        objMove();
        if (!dead) {
            removeTouching(Obstacles.class);
            removeTouching(Pickup.class);
            removeTouching(Ramp.class);
            SnowWorld sw = (SnowWorld) getWorld();
            if(getWorld().getObjects(Boarder.class).size() != 0 && getOneIntersectingObject(Boarder.class) != null && !((Boarder)getOneIntersectingObject(Boarder.class)).air) {
                Greenfoot.setWorld(new StoreWorld(getWorld(), sw.getCoins()));
                getWorld().removeObject(this);
            }
        }
    }    
}
