import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class JumpUpgrade extends Buttons
{
    public void act() 
    {
        StoreWorld sw = (StoreWorld) getWorld();
        if(/**!sw.getJumpU()*/ SnowWorld.jumpU == false && sw.getCoins() >= 200){
            setImage(new GreenfootImage("Buy Jump Upgrade (200 coins)", 50, Color.BLUE, null));
        }
        else{
            setImage(new GreenfootImage("Buy Jump Upgrade (200 coins)", 50, Color.GRAY, null));
        }

        if (Greenfoot.mouseClicked(this)) {
            if(sw.getCoins() >= 200 && /**!sw.getJumpU()*/ SnowWorld.jumpU == false){
                sw.rmCoin(200);
                sw.JumpU();
            }
        }
    }    
}
