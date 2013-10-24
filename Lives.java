import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

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
    private boolean sent = false;
    
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
        getImage().setTransparency(220);
    }
    
    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpLives(int amount)
    {
        totalLives += amount;
        setImage(new GreenfootImage("Lives: " + totalLives, 50, Color.BLACK, Color.WHITE));
        getImage().setTransparency(220);
    }
    
    public void respawn(){
        if (getWorld().getObjects(Boarder.class).size() == 0){
            if (noLives()){
                    setImage(new GreenfootImage("You Lose!  ", 50, Color.RED, Color.WHITE));
                    getImage().setTransparency(220);
                    
                    if(!sent){
                        File scores = new File(".scores");
                        try{
                            if(scores.exists()==false){
                                scores.createNewFile();
                            }
                            PrintWriter out = new PrintWriter(new FileWriter(scores, true));
                            SnowWorld sw = (SnowWorld) getWorld();
                            out.append(sw.getScore() + "\n");
                            out.close();
                        }catch(IOException e){
                            System.out.println("COULD NOT LOG!!");
                        }
                        sent = true;
                    }
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