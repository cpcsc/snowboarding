import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Clipsize extends Buttons
{
    public static boolean canClick = true;
    public Clipsize() {
        setImage(new GreenfootImage("Pistol to AK-47", 50, Color.BLUE, null));
    }    

    public void act() {
        StoreWorld w = (StoreWorld) getWorld();        
        if (canClick && w.getCoins() >= 10) {
            if (Greenfoot.mouseClicked(this)) {
                Gun.clipSize += 20;
                Boarder.delayMax -= 10;
                w.rmCoin(10);
                Clipsize.canClick = false;
            }
        } else {
            setImage(new GreenfootImage("Pistol to AK-47", 50, Color.GRAY, null));    
        }
    }    
} 
