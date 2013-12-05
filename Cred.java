import greenfoot.*;

// Mark McKinney

public class Cred extends World
{
    public Cred()
    {
        super(900, 700, 1, false); 
        prepare();
    }
    
    public void prepare() {
        setPaintOrder(Bot.class, Credits.class, Back.class, Creds.class, Obstacles.class);
        Bot bot = new Bot();
        addObject(bot, 450, 588);
        Credits credits = new Credits();
        addObject(credits, 450, 170);
        Back back = new Back();
        addObject(back, 450, 655);
        Creds creds = new Creds();
        addObject(creds, 450, 300);
        Obstacles obstacles = new Obstacles();
        addObject(obstacles, 0, 0);
        for(int y = getHeight() + 50; y > -700; y -= 3) { //spawn in trees
            obstacles.addTree(y);
        }   
    }
    
    public Bot getBot() {
        return (Bot) getObjects(Bot.class).get(0);      
    }
}