import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.File;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// Mark McKinney and Jeffrey Xie

public class Highscore extends Buttons
{
    private boolean applet()  
    {  
        return null != System.getSecurityManager();  
    }

    public Highscore() {
        if(!applet()){
            File scores = new File(".scores");
            try{
                if(scores.exists()==true){
                    FileInputStream fstream = new FileInputStream(".scores");
                    DataInputStream in = new DataInputStream(fstream);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    try {
                        while (true) {
                            String line = br.readLine();
                            if (line == null) break;
                            setImage(new GreenfootImage("Highscore: " + line, 30, Color.BLACK, Color.WHITE));
                            getImage().setTransparency(220);
                        }
                    }
                    finally {
                        br.close();
                    }
                }
            }catch(IOException e){
                System.out.println("COULD NOT LOG!!");
            }
        }
    }
}
