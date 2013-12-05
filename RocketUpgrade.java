import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

// Tarrant Starck

public class RocketUpgrade extends Buttons
{
    public static boolean canClick = true;
    public RocketUpgrade() {
        setImage(new GreenfootImage("Unlock Rocket Launcher (250 coins)", 50, Color.BLUE, null));
    }    

    public void act() {
        StoreWorld w = (StoreWorld) getWorld();        
        if (canClick && w.getCoins() >= 250) {
            if (Greenfoot.mouseClicked(this)) {
                SnowWorld.rocketsSpawn = true;
                w.rmCoin(250);
                RocketUpgrade.canClick = false;
                Boarder.rocket += 5;
            }
        } else {
            setImage(new GreenfootImage("Unlock Rocket Launcher (250 coins)", 50, Color.GRAY, null));
        }    
    }    
}
