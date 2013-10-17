import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boarder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boarder extends Object
{   
    private int dragFromX, dragFromY;
    private int invincible = 0;

    public void act() 
    {
        moveAround();
        die();
        invincible = invincible + 1;
    }
    
    public void moveAround()
    {
        if (Greenfoot.isKeyDown("left")){
            move(-4);
            setImage("left.png");
        }
        if (Greenfoot.isKeyDown("right")){
            move(4);
            setImage("right.png");
        }
        if (!Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right")){
            setImage("straight.png");
        }
        if (Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("right")){
            setImage("straight.png");
            move(0);
        }
        
        // touchscreen (mouse drag) detection/movement
        if (Greenfoot.mousePressed(null))  
        {  
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            dragFromX = mouse.getX();  
            dragFromY = mouse.getY();  
        }  
        if (Greenfoot.mouseDragged(null) || Greenfoot.mouseDragEnded(null))  
        {  
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            int newX = mouse.getX(), newY = mouse.getY();  
            // check difference(s) and act upon them 
            
            if (newX > dragFromX + 30)
            {
                move(4);
                setImage("right.png");
            }
            
            if (newX < dragFromX - 30)
            {
                move(-4);
                setImage("left.png");
            }
        }
    }
    
    public void die(){
        Actor snowman = getOneIntersectingObject(Snowman.class);
        if (snowman != null && invincible > 50){
            getWorld().removeObject(this);
        }
    }
}