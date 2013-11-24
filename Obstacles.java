import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Obstacles extends Object
{
    public int snowmanTimer = 0;
    public int treeTimer = 0;
    public int logTimer = 0;
    private boolean hasDied;
    private int lTrees = 1;
    private int rTrees = 1;
    public SnowWorld sw = (SnowWorld) getWorld();

    public void act() {
        addSnowman();
        addTree(-700);
        addLog();
        addBear();
    }

    public void addSnowman(){
        if (snowmanTimer > 0) {
            snowmanTimer--;
        } else {
            Snowman snowman = new Snowman();
            getWorld().addObject(snowman, Greenfoot.getRandomNumber(getWorld().getWidth()), -100);
            snowmanTimer = Math.max(30, 105 - 15 * Object.speed);
            
        }
    }

    public void addTree(int y) {
        if (treeTimer > 0) {
            treeTimer--;
        } else {
            lTrees += Greenfoot.getRandomNumber(3) - 1;                            // num of trees on left edge
            rTrees += Greenfoot.getRandomNumber(3) - 1;                            // num of  trees on right edge
            if (lTrees + rTrees > Math.min(Object.speed + 3, 9)) {                 // can't cover whole screen w/ trees
                lTrees--;
                rTrees--;
            }
            if (lTrees < 1) lTrees = 1;                                            //always at least one tree on both sides
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
            treeTimer = tree.getImage().getHeight() / speed - 1;
        }       
    }

    public void addLog() {
        if (logTimer > 0){
            logTimer--;
        } else if (getWorld() instanceof SnowWorld) {
            SnowWorld w = (SnowWorld) getWorld();
            if (w.getScore() >= 10000) {
                Log log = new Log();
                getWorld().addObject(log, Greenfoot.getRandomNumber(getWorld().getWidth() - 20) + 10, -100);
                logTimer = 90;
            }
        } else {
            Log log = new Log();
            getWorld().addObject(log, Greenfoot.getRandomNumber(getWorld().getWidth() - 20) + 10, -100);
            logTimer = Math.max(90, 150 - 10 * Object.speed);
        }              
    }

    public void addBear() {
        if (getWorld() instanceof SnowWorld) {
            SnowWorld w = (SnowWorld) getWorld();
            if (Greenfoot.getRandomNumber(500) == 0 && w.getScore() >= 30000) {
                w.addObject2(new Bear(), w.randX(-100, 50), -100);
            }
        }
    }
}
