import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Intro extends World
{
    public Intro()
    {    
        super(900, 700, 1, false);
        Object.speed = 3;
        prepare();
    }
    
    public void prepare() {
        setPaintOrder(SnowJob.class, Buttons.class, Bot.class, Obstacles.class, SnowTrail.class);
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
        addObject(new Reset(), 450, 675);
        addObject(new SpeakerButton(),30,30);
    }
    
    public Bot getBot() {
        return (Bot) getObjects(Bot.class).get(0);      
    }
}
