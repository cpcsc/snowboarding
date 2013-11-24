import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class RocketUpgrade extends Buttons
{
    public static boolean canClick = true;
    public RocketUpgrade() {
        setImage(new GreenfootImage("Rockets Spawn", 50, Color.BLUE, null));
    }    

    public void act() {
        StoreWorld w = (StoreWorld) getWorld();        
        if (canClick && w.getCoins() >= 10) {
            if (Greenfoot.mouseClicked(this)) {
                SnowWorld.rocketsSpawn = true;
                w.rmCoin(10);
                RocketUpgrade.canClick = false;
                Boarder.rocket += 5;
            }
        } else {
            setImage(new GreenfootImage("Rockets Spawn", 50, Color.GRAY, null));
        }    
    }    
}
