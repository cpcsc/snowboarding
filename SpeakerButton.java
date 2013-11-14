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
        if (Greenfoot.mouseClicked(this) && isOff == false) {
            setImage(img2);
            isOff = true;
            bgm.setVolume(0);
        }
        else if (Greenfoot.mouseClicked(this) && isOff == true) {
            setImage(img);
            isOff = false;
            bgm.setVolume(80);
        }
    }    
}
