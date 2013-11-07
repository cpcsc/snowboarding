import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

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
        addObject(new StoreButton(), 450, 300);
    }

    public void act() {
        removeObjects(getObjects(Image.class));
        Image coinImage = new Image("coin.png");
        coinImage.getImage().scale(20,20);
        Image coinNumImage = new Image(""+coins, 30, Color.BLACK, null);
        addObject(coinImage, coinImage.getWidth()/2 + 5, coinImage.getHeight()/2 + 5);
        addObject(coinNumImage, coinImage.getWidth() + 8 + coinNumImage.getWidth()/2, coinImage.getHeight()/2 + 5);
    }
}
