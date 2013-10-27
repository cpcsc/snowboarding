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
    public int scoreMult = 1;
    public int multCounter = 0;

    public void act() {
        spawnPowerup();
        multCounter--;
        showPowerup();
        speedUp();
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

    public Lives getLives(){
        return theLives;
    }

    public void stopMusic() {
        bkgMusic.stop();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Counter.class, Image.class, Coin2.class, Pig.class, Boarder.class, Lives.class, Back.class, Obstacles.class, Weapon.class, Pickup.class, Snow.class);
        Boarder boarder = new Boarder();
        addObject(boarder, getWidth()/2, 400);
        //Pig pig = new Pig();
        //addObject(pig, 464, 600);
        Obstacles obstacles = new Obstacles();
        addObject(obstacles, 0, 0);
        Back back = new Back();
        addObject(back, 30, 680);
        Back back2 = new Back();
        addObject(back2, 100, 680);
        //Background background = new Background();
        //addObject(background, 882, 17);
        /*for(int y = -50; y < getHeight() + 50; y += 6) { //spawn in snow
        Snow snow = new Snow();
        snow.setRotation(Greenfoot.getRandomNumber(360));
        addObject(snow, Greenfoot.getRandomNumber(getWidth()), y);
        }*/
        for(int y = getHeight() + 50; y > -700; y -= 3) { //spawn in trees
            obstacles.addTree(y);
        }      
        addObject(score, getWidth()/2, 17);
    }

    public void spawnPowerup() {
        if (Greenfoot.getRandomNumber(2000) == 0) { 
            addObject(new Gun(), randX(-100), -100);
        }
        if (Greenfoot.getRandomNumber(3000) == 0) { 
            addObject(new Invincible(), randX(-100), -100);
        }
        if (Greenfoot.getRandomNumber(100) == 0) {
            addObject(new Coin(), randX(-100), -100);
        }
        if (Greenfoot.getRandomNumber(300) == 0) {
            addObject(new Coin2(), randX(-100), -100);
        }
        if (Greenfoot.getRandomNumber(400) == 0) {
            addObject(new Ramp(), randX(-100), -100);
        }
        if (Greenfoot.getRandomNumber(1500) == 0) {
            addObject(new ScoreX2(), randX(-100), -100);
        }
        if (Greenfoot.getRandomNumber(800) == 0) {
            spawnLineOfCoins();
        }
    }

    public void spawnLineOfCoins() {
        int x1 = randX(-20);
        int r = Greenfoot.getRandomNumber(5) + 5;
        int x2 = randX(-20 - 60*r);
        for (int i = 0; i < r; i++) {
            addObject( new Coin(), (i * x2 + (r - i) * x1) / r, -20 - 60*i);
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

    public void scoreMult(int multiplier, int frames) {
        multCounter = frames;
        scoreMult = multiplier;
    }

    public void incScore(int pts) {
        scoreMult = (multCounter <= 0) ? 1 : scoreMult;
        score.add((Object.speed - 2) * scoreMult * pts);    
    }

    public void showPowerup() {
        removeObjects(getObjects(Image.class));
        if (multCounter > 0 && scoreMult == 2) {
            Image multImage = new Image("x2.png");
            addObject(multImage, score.getX() + score.getImage().getWidth()/2 + multImage.getImage().getWidth()/2, 15);
        }
        if (getObjects(Boarder.class).size() != 0) {
            Boarder b = (Boarder) getObjects(Boarder.class).get(0);
            if (b.gun > 0) {
                Image gunImage = new Image("Handgun.png");
                addObject(gunImage, score.getX() - score.getImage().getWidth()/2 - gunImage.getImage().getWidth()/2, 15);
            }
        }
    }

    public void speedUp() { 
        Object.speed = 3 + (int) Math.sqrt(getScore() / 10000);
    }

    public int getScore() {
        return score.getValue();
    }
}
