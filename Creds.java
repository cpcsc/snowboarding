import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Creds extends Buttons
{
    public void act() 
    {
        setImage(new GreenfootImage("Game Development:\n"
            + "Tyeler Bridges, Ricky Escobar, Mark McKinney, Tarrant Starck,\n"
            + "Andrew Tran, Jeffrey Xie, Megan Voss\n\n\n"
            + "\n\n"
            + "", 30, Color.BLACK, Color.WHITE));
        getImage().setTransparency(220);
    }    
}
