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
        Object.speed = 3;
        prepare();
    }
    
    public void prepare() {
        setPaintOrder(SnowJob.class, Buttons.class, Obstacles.class, Bot.class, SnowTrail.class);
        Bot bot = new Bot();
        addObject(bot, 450, 588);
        Start start = new Start();
        addObject(start, 450, 340);
        Instructions instructions = new Instructions();
        addObject(instructions, 450, 400);
        Credits credits = new Credits();
        addObject(credits, 450, 460);
        SnowJob snowjob = new SnowJob();
        addObject(snowjob, 450, 150);
        Obstacles obstacles = new Obstacles();
        addObject(obstacles, 0, 0);
        for(int y = getHeight() + 50; y > -700; y -= 3) { //spawn in trees
            obstacles.addTree(y);
        }
        addObject(new Highscore(), 450, 520);
    }
}
