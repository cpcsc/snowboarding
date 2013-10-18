import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Creds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creds extends Buttons
{
    /**
     * Act - do whatever the Creds wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Game Development:\n"
            + "Tyeler Bridges, Ricky Escobar, Mark McKinney, Tarrant Starck,\n"
            + "Andrew Tran, Jeffrey Xie, Megan Voss\n\n\n"
            + "Shadow (snowboarder) sprites - Vicky (http://www.freewebs.com/vickyteam/sprites.htm)\n"
            + "Original Sprite by Ren Ramos (SA3 Sonic) and some parts done by Daniel Sidney\n\n\n"
            + "\n\n"
            + "", 30, Color.BLACK, null));
    }    
}