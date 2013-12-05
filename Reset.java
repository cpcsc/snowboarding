import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

// Mark McKinney

public class Reset extends Buttons
{
    private boolean applet()  
    {  
        return null != System.getSecurityManager();  
    }

    public Reset() 
    {
        if(!applet()){
            setImage(new GreenfootImage("Reset Highscore", 30, Color.BLUE, Color.WHITE));
            getImage().setTransparency(220);
            File scores = new File(".scores");
            try{
                if(scores.exists()==false){
                    scores.createNewFile();
                    PrintWriter out = new PrintWriter(new FileWriter(scores, false));
                    out.print(0);
                    out.close();
                    Greenfoot.setWorld(new Intro());
                }
            }
            catch(IOException e){
                System.out.println("COULD NOT LOG!!");
            }
        }
    }

    public void act() 
    {
        if(!applet()){
            setImage(new GreenfootImage("Reset Highscore", 30, Color.BLUE, Color.WHITE));
            getImage().setTransparency(220);

            if (Greenfoot.getMouseInfo() != null){
                if (Greenfoot.getMouseInfo().getX() >= 360 && Greenfoot.getMouseInfo().getX() <= 540 &&
                Greenfoot.getMouseInfo().getY() >= 665 && Greenfoot.getMouseInfo().getY() <= 685) {
                    setImage(new GreenfootImage("Reset Highscore", 30, Color.RED, Color.WHITE));
                    getImage().setTransparency(220);
                }
            }
            if (Greenfoot.mouseClicked(this)) {
                File scores = new File(".scores");
                try{
                    if(scores.exists()==false){
                        scores.createNewFile();
                        PrintWriter out = new PrintWriter(new FileWriter(scores, false));
                        out.print(0);
                        out.close();
                    }
                    else{
                        PrintWriter out = new PrintWriter(new FileWriter(scores, false));
                        out.print(0);
                        out.close();
                    }
                }
                catch(IOException e){
                    System.out.println("COULD NOT LOG!!");
                }
                Greenfoot.setWorld(new Intro());
            }
        }
    }
}
