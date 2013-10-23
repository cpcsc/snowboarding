import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnowWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnowWorld extends World
{
    private GreenfootSound bkgMusic;
    private Lives theLives;
    public Counter score = new Counter("Score: ");
    
    public void act() {
        spawnPowerup();
    }
   
    public SnowWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 700, 1, false); 
        
        theLives = new Lives();
        addObject(theLives, 820, 670);
        
        //start music in the snow world
        bkgMusic = new GreenfootSound("Animals - Martin Garrix.mp3");
        //Credit: Martin Garrix
        bkgMusic.playLoop();

        prepare();
    }
    
    public void stopMusic(){
        bkgMusic.stop();
    }
    
    public Lives getLives(){
        return theLives;
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Coin2.class, Pig.class, Boarder.class, Lives.class, Back.class, Counter.class, Obstacles.class, Weapon.class, Pickup.class, Snow.class);
        Boarder boarder = new Boarder();
        addObject(boarder, 458, 388);
        Pig pig = new Pig();
        addObject(pig, 464, 600);
        Obstacles obstacles = new Obstacles();
        addObject(obstacles, 0, 0);
        Back back = new Back();
        addObject(back, 30, 680);
        Back back2 = new Back();
        addObject(back2, 100, 680);
        Background background = new Background();
        addObject(background, 882, 17);
        for(int y = -50; y < getHeight() + 50; y += 6) { //spawn in snow
            Snow snow = new Snow();
            snow.setRotation(Greenfoot.getRandomNumber(360));
            addObject(snow, Greenfoot.getRandomNumber(getWidth()), y);
        }
        for(int y = getHeight() + 70; y > -70; y -= 3) { //spawn in trees
            obstacles.addTree(y);
        }       
        addObject(score, getWidth()/2, 17);
    }
    
    public void spawnPowerup() {
        if (Greenfoot.getRandomNumber(2000) == 0) { 
            addObject(new Gun(), randX(-20), -20);
        }
        if (Greenfoot.getRandomNumber(100) == 0) {
            addObject(new Coin(), randX(-20), -20);
        }
        if (Greenfoot.getRandomNumber(300) == 0) {
            addObject(new Coin2(), randX(-20), -20);
        }
        if (Greenfoot.getRandomNumber(400) == 0) {
            addObject(new Ramp(), randX(-20), -20);
        }
    }
    
    public int randX(int y) { //Returns random x-value between the trees at a given y-value
        int min = 0;
        int max = 0;
        Tree tree = new Tree();
        int w = tree.getImage().getWidth();
        for(int i = w/2; getObjectsAt(i, y, Tree.class).size() != 0; i += w) {
            min = i + w;
        }
        for(int i = min + w; getObjectsAt(i, y, Tree.class).size() == 0 && i < getWidth(); i += w) {
            max = i;
        }
        return Greenfoot.getRandomNumber(max - min - 20) + min + 10;
    }
    
    public void incScore(int pts) {
        score.add(pts);    
    }
    
    public int getScore() {
        return score.getValue();
    }
}
