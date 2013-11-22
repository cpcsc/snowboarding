import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Tutorial extends Buttons
{
    public Tutorial()
    {
        setImage(new GreenfootImage("- Use the left and right arrow keys to move\n"
            + "- Press the up arrow key to jump\n"
            + " - Pick up power-ups along the way\n"
            + "- Press X to fire the gun\n"
            + "- Press Z to fire the rocket launcher\n"
            + "- Press Q to turn the music on/off\n"
            + "- Avoid the obstacles and survive as long as possible\n"
            + "- Good luck! :)", 30, Color.BLACK, Color.WHITE));
        getImage().setTransparency(220);
    } 
}
