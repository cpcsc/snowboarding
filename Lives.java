import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lives extends Object
{
    private int totalLives = 3;
    private int spawnTime = 0;
    private int dead = 0;
    
    public boolean noLives() {
        if (totalLives == 0){
            return true;
        }
        else {
            return false;
        }
    }
    
    public Lives(){
        setImage(new GreenfootImage("Lives: " + lives, 50, Color.BLACK, null));
    }
    
    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpLives(int amount)
    {
        totalLives += amount;
        setImage(new GreenfootImage("Lives: " + totalLives, 50, Color.BLACK, null));
    }
    
    public void respawn(){
        if (getWorld().getObjects(Boarder.class).size() == 0){
            if (noLives()){
                    setImage(new GreenfootImage("You Lose!  ", 50, Color.RED, null));
                }
            if (dead == 0) {
                if(!noLives()) {
                    SnowWorld snowWorld = (SnowWorld) getWorld();
                    Lives lives = snowWorld.getLives();
                    lives.bumpLives(-1);
                    spawnTime = spawnTime + 1;
                    dead = 1;
                }
            }
            spawnTime = spawnTime +1;
            if (totalLives > 0 && spawnTime > 50){
                Boarder boarder = new Boarder();
                getWorld().addObject(boarder, 458, 388);
                spawnTime = 0;
                dead = 0;
            }
        }
    }
    
    public void act() 
    {
        respawn();
    }    
}