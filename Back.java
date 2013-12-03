import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Back extends Buttons
{
    private int coins;
    public void act() {
        if (getWorld() instanceof SnowWorld) {
            setImage(new GreenfootImage("Quit", 30, Color.RED, Color.WHITE));
            getImage().setTransparency(220);
            if (getX() > 80) {
                setImage(new GreenfootImage("Restart", 30, Color.BLUE, Color.WHITE));
                getImage().setTransparency(220);
            }
        } else {
            setImage(new GreenfootImage("Back", 50, Color.BLUE, Color.WHITE));
            getImage().setTransparency(220);
            if (Greenfoot.getMouseInfo() != null){
                if (Greenfoot.getMouseInfo().getX() >= 405 && Greenfoot.getMouseInfo().getX() <= 495 &&
                Greenfoot.getMouseInfo().getY() >= 640 && Greenfoot.getMouseInfo().getY() <= 670) {
                    setImage(new GreenfootImage("Back", 50, Color.RED, Color.WHITE));
                    getImage().setTransparency(220);
                }
            }
        }

        if (Greenfoot.mouseClicked(this)) {
            if (getWorld() instanceof SnowWorld) {
                SnowWorld sw = (SnowWorld) getWorld();
                sw.stopMusic();
                Gun.clipSize = 10;
                Boarder.delayMax = 20;
                RampCoins.canClick = true;
                SnowWorld.rampCoins = false;
                Clipsize.canClick = true;
                RocketUpgrade.canClick = true;
                SnowWorld.rocketsSpawn = false;
                MultiplierUpgrade.canClick = true;
                ScoreX2.Multiplier = 2;
                SnowWorld.jumpU = false;
                if(getX() > 80) {
                    Greenfoot.setWorld(new SnowWorld(0));
                } else {
                    Greenfoot.setWorld(new Intro());
                }
            } else if(getWorld() instanceof StoreWorld) {
                StoreWorld sw = (StoreWorld) getWorld();
                //coins = sw.getCoins();
                Greenfoot.setWorld(sw.getSnowWorld());
                //Greenfoot.setWorld(new SnowWorld(coins));
            } else {
                Greenfoot.setWorld(new Intro());
            }
        }
    }    
}
