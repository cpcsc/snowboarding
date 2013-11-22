import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class JumpUpgrade extends Buttons
{
    public void act() 
    {
        StoreWorld sw = (StoreWorld) getWorld();
        if(!sw.getJumpU() && sw.getCoins() >= 10){
            setImage(new GreenfootImage("Buy Jump Upgrade (10 coins)", 50, Color.BLUE, null));
        }
        else{
            setImage(new GreenfootImage("Buy Jump Upgrade (10 coins)", 50, Color.GRAY, null));
        }

        if (Greenfoot.mouseClicked(this)) {
            if(sw.getCoins() >= 10 && !sw.getJumpU()){
                sw.rmCoin(10);
                sw.JumpU();
            }
        }
    }    
}
