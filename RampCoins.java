import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

// Tarrant Starck && Ricky Escobar

public class RampCoins extends Buttons
{
    public static boolean canClick = true;
    public void act() {
        StoreWorld w = (StoreWorld) getWorld();
        setImage(new GreenfootImage("Extra Ramp Coins (200 coins)", 50, Color.BLUE, null));
        if (canClick && w.getCoins() >= 200) {
            if (Greenfoot.mouseClicked(this)) {
                SnowWorld.rampCoins = true;
                w.rmCoin(200);
                RampCoins.canClick = false;
            }
            MouseInfo mi = Greenfoot.getMouseInfo();
            if (mi != null) {
                int left = getX() - getImage().getWidth()/2;
                int right = left + getImage().getWidth();
                int up = getY() - getImage().getHeight()/ 2;
                int down = up + getImage().getHeight();
                int x = mi.getX();
                int y = mi.getY();
                if (x > left && x < right && y > up && y < down) {
                    setImage(new GreenfootImage("Extra Ramp Coins (200 coins)", 50, Color.RED, null));
                }
            }
        } else if(SnowWorld.rampCoins) {
            setImage(new GreenfootImage("Extra Ramp Coins (BOUGHT)", 50, Color.GRAY, null));
        } else {
            setImage(new GreenfootImage("Extra Ramp Coins (200 coins)", 50, Color.BLACK, null));
        }    
    }    
}
