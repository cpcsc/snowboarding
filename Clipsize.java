import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

// Tarrant Starck

public class Clipsize extends Buttons
{
    public static boolean canClick = true;
    public Clipsize() {
        setImage(new GreenfootImage("Gun Upgrade (250 coins)", 50, Color.BLUE, null));
    }    

    public void act() {
        StoreWorld w = (StoreWorld) getWorld();        
        if (canClick && w.getCoins() >= 250) {
            if (Greenfoot.mouseClicked(this)) {
                Gun.clipSize += 20;
                Boarder.delayMax -= 10;
                w.rmCoin(250);
                Clipsize.canClick = false;
            }
        } else {
            setImage(new GreenfootImage("Gun Upgrade (250 coins)", 50, Color.GRAY, null));    
        }
    }    
} 
