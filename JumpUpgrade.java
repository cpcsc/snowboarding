import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

// Mark McKinney

public class JumpUpgrade extends Buttons
{
    public void act() 
    {
        StoreWorld sw = (StoreWorld) getWorld();
        if(SnowWorld.jumpU == false && sw.getCoins() >= 200){
            setImage(new GreenfootImage("Jump Upgrade (200 coins)", 50, Color.BLUE, null));
        }
        else{
            setImage(new GreenfootImage("Jump Upgrade (200 coins)", 50, Color.GRAY, null));
        }

        if (Greenfoot.mouseClicked(this)) {
            if(sw.getCoins() >= 200 && SnowWorld.jumpU == false){
                sw.rmCoin(200);
                sw.JumpU();
            }
        }
    }    
}
