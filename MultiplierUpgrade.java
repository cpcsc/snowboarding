import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

// Tarrant Starck

public class MultiplierUpgrade extends Buttons
{
    public static boolean canClick = true;
    public MultiplierUpgrade() {
        setImage(new GreenfootImage("Multiplier Upgrade (200 coins)", 50, Color.BLUE, null));
    }
    
    public void act() 
    {
        StoreWorld w = (StoreWorld) getWorld();
        if (canClick && w.getCoins() >= 200) {
            if (Greenfoot.mouseClicked(this)){
                w.rmCoin(200);
                MultiplierUpgrade.canClick = false;
                ScoreX2.Multiplier = 3;
            }
        }
        else {
            setImage(new GreenfootImage("Multiplier Upgrade (200 coins)", 50, Color.GRAY, null));
        }    
    }    
}
