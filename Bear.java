import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bear extends Obstacles
{
    public int dir = 1;
    public int imgDir = 1;
    private GreenfootImage img = new GreenfootImage("images/PolarBear.png");
    private GreenfootImage img2 = new GreenfootImage("images/PolarBear2.png");
    private GreenfootImage img3 = new GreenfootImage("images/PolarBear3.png");
    private GreenfootImage img4 = new GreenfootImage("images/PolarBear4.png");
    private int animTimer = 0;
    public void act() 
    {
        animTimer++;
        objMove();
        bearAnim();
        if (!dead) {
            getDir();
            bearMove();
            killObst();
        }
    }    

    public void bearAnim() {
        if (imgDir >= 0) {
            if (getImage() == img) {
                setImage(img2);
            }
            else {
                setImage(img);
            }
        }
        else if (imgDir <= 0) {
            if (getImage() == img3) {
                setImage(img4);
            }
            else {
                setImage(img3);
            }
        }
    }
    
    public void bearMove() {
        if (getOneObjectAtOffset(dir + getImage().getWidth()/2, 0, Obstacles.class) != null) {
            dir = 0;
        }        
        setLocation(getX() + dir, getY());        
    }
    
    public void getDir() {
        World w = getWorld();
        if (w.getObjects(Boarder.class).size() != 0) {
            Boarder b = (Boarder) w.getObjects(Boarder.class).get(0);
            if (b.getX() - getX() != 0) {
                dir = (b.getX() - getX()) / Math.abs(b.getX() - getX());
                if (dir != imgDir) {
                    //getImage().mirrorHorizontally();
                    imgDir *= -1;
                }
            } else {
                dir = 0;              
            }
        }
        if(w instanceof Intro){
            if (w.getObjects(Bot.class).size() != 0) {
                Bot bot = (Bot) w.getObjects(Bot.class).get(0);
                if (bot.getX() - getX() != 0) {
                    dir = (bot.getX() - getX()) / Math.abs(bot.getX() - getX());
                    if (dir != imgDir) {
                        //getImage().mirrorHorizontally();
                        imgDir *= -1;
                    }
                } else {
                    dir = 0;              
                }
            }
        }
    }

    public void killObst() {
        if (!dead) {
            Class[] list = {Snowman.class, Log.class};
            for(Class obst : list) {
                removeTouching(obst);
            }
        }
    }
}
