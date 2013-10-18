import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends World
{
    /**
     * Constructor for objects of class Intro.
     * 
     */
    public Intro()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 700, 1, false);
        
        prepare();
    }
    
    public void prepare() {
        setPaintOrder(Bot.class, Start.class, Credits.class, Instructions.class, Obstacles.class, Snow.class);
        Bot bot = new Bot();
        addObject(bot, 450, 588);
        Start start = new Start();
        addObject(start, 450, 170);
        Instructions instructions = new Instructions();
        addObject(instructions, 450, 250);
        Credits credits = new Credits();
        addObject(credits, 450, 330);
        Background background = new Background();
        addObject(background, 882, 17);
        Obstacles obstacles = new Obstacles();
        addObject(obstacles, 0, 0);
        for(int y = -50; y < getHeight() + 50; y += 6) { //spawn in snow
            Snow snow = new Snow();
            snow.setRotation(Greenfoot.getRandomNumber(360));
            addObject(snow, Greenfoot.getRandomNumber(getWidth()), y);
        }
        for(int y = getHeight() + 50; y > -50; y -= 3) { //spawn in trees
            obstacles.addTree(y);
        }   
    }
}
