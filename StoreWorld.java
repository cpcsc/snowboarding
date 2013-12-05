import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

// Mark McKinney - StoreWorld, jump upgrades
// Tarrant Starck - other upgrades

public class StoreWorld extends World
{
    private World sw;
    private int coins;
    public StoreWorld()
    {    
        super(900, 700, 1, false);
        prepare();
    }

    public StoreWorld(World SnowWorld, int Coins) {
        this();
        sw = SnowWorld;
        coins = Coins;
    }

    public World getSnowWorld() {
        return sw;
    }

    public int getCoins() {
        return coins;
    }

    public void rmCoin(int quant) {
        coins -= quant;
        ((SnowWorld)sw).setCoins(coins);
    }

    public void prepare() {
        addObject(new Back(), 450, 650);
        addObject(new JumpUpgrade(), 450, 300);
        addObject(new Clipsize(), 450, 200);
        addObject(new RampCoins(), 450, 100);
        addObject(new RocketUpgrade(), 450, 500);
        addObject(new MultiplierUpgrade(), 450, 400);
    }

    public void act() {
        removeObjects(getObjects(Image.class));
        Image coinImage = new Image("coin.png");
        coinImage.getImage().scale(20,20);
        Image coinNumImage = new Image(""+coins, 30, Color.BLACK, null);
        addObject(coinImage, coinImage.getWidth()/2 + 5, coinImage.getHeight()/2 + 5);
        addObject(coinNumImage, coinImage.getWidth() + 8 + coinNumImage.getWidth()/2, coinImage.getHeight()/2 + 5);
    }
    
    public void JumpU(){
        ((SnowWorld)sw).JumpU();
    }
    public boolean getJumpU(){
        return ((SnowWorld)sw).getJumpU();
    }
}
