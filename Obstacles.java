import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacles extends Object

{
    public int snowmanTimer = 0;
    public int treeTimer = 0;
    private boolean hasDied;
    private int lTrees = 1;
    private int rTrees = 1;
    public boolean atWorldBottom(){
        return (getY() >= getWorld().getHeight() + 50);
    }

    public void act()
    {
        addSnowman();
        addTree(-50);
    }
    
    public void addSnowman(){
        if (snowmanTimer > 0){
            snowmanTimer--;
        }
        else {
            Snowman snowman = new Snowman();
            getWorld().addObject(snowman, Greenfoot.getRandomNumber(getWorld().getWidth()), -50);
            snowmanTimer = 30;
        }
    }
    
    public void addTree(int y){
        if (treeTimer > 0){
            treeTimer--;
        }
        else {
            lTrees += Greenfoot.getRandomNumber(3) - 1; // num of trees on left edge
            rTrees += Greenfoot.getRandomNumber(3) - 1; // num of  trees on right edge
            if (lTrees + rTrees > 7) {                 // can't cover whole screen w/ trees
                lTrees--;
                rTrees--;
                }
            if (lTrees < 1) lTrees = 1;                 //always at least one tree on both sides
            if (rTrees < 1) rTrees = 1;
            
            for(int i = 1; i <= lTrees; i++) 
            {
                Tree tree = new Tree();
                getWorld().addObject(tree, tree.getImage().getWidth()*(2*i-1)/2, y);
            }
            for(int i = 1; i <= rTrees; i++) 
            {
                Actor tree = new Tree();
                getWorld().addObject(tree, getWorld().getWidth() - tree.getImage().getWidth()*(2*i-1)/2, y);
            }
            Tree tree = new Tree();
            treeTimer = tree.getImage().getHeight() / 3 - 1;
        }
    }
}
