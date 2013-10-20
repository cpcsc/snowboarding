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
        setImage(new GreenfootImage("Lives: " + lives, 50, Color.BLACK, Color.WHITE));
    }
    
    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpLives(int amount)
    {
        totalLives += amount;
        setImage(new GreenfootImage("Lives: " + totalLives, 50, Color.BLACK, Color.WHITE));
    }
    
    public void respawn(){
        if (getWorld().getObjects(Boarder.class).size() == 0){
            if (noLives()){
                    setImage(new GreenfootImage("You Lose!  ", 50, Color.RED, Color.WHITE));
                }
            if (dead == 0) {
                if(!noLives()) {
                    SnowWorld snowWorld = (SnowWorld) getWorld();
                    Lives lives = snowWorld.getLives();
                    lives.bumpLives(-1);
                    spawnTime++;
                    dead = 1;
                }
            }
            spawnTime = spawnTime +1;
            if (totalLives > 0 && spawnTime > 50){
                Boarder boarder = new Boarder();
                getWorld().addObject(boarder, getRespawnX(388), 388);
                spawnTime = 0;
                dead = 0;
            }
        }
    }
    
    /**
     * Returns the x-value of the middle of the gap between the trees
     * so you don't spawn in the trees.
     */
    public int getRespawnX(int y) {
        World w = getWorld();
        int min = 0;
        int max = getWorld().getWidth();
        for(int i = 1; w.getObjectsAt(i, y, Tree.class).size() != 0; i += 10) {
                min = i;
        }
        for(int i = min + 10; w.getObjectsAt(i, y, Tree.class).size() == 0; i += 10) {
                max = i;
        }
        return (max + min) / 2;
    }
    
    public void act() 
    {
        respawn();
    }    
}