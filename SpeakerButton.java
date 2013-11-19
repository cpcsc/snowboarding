import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeakerButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeakerButton extends Buttons
{
    private GreenfootSound bgm;
    private GreenfootImage img = new GreenfootImage("images/Speaker.png");
    private GreenfootImage img2 = new GreenfootImage("images/SpeakerOff.png");
    private int keyDelay = 0;
    boolean isOff = false;
    public SpeakerButton(GreenfootSound bkgMusic)
    {
        bgm = bkgMusic;
    }
    
    public SpeakerButton()
    {
       
    }
    
    /**
     * Act - do whatever the SpeakerButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        keyDelay++;
        if (Greenfoot.isKeyDown("q") && isOff == false && keyDelay >= 50) {
            setImage(img2);
            isOff = true;
            keyDelay = 0;
        }        
        else if (Greenfoot.isKeyDown("q") && isOff == true && keyDelay >= 50) {
            setImage(img);
            isOff = false;
            keyDelay = 0;
        }
    }
    
    public boolean getOff()
    {
        return isOff;
    }    
}
