import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
private Wombat w1;
private Wombat w2;
    public static Monkey myMonkey; // BAD 
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(950, 600, 1); 
        w1 = new Wombat();
        addObject(w1,100,300);
        
        w1.setRotation(15);
        myMonkey = new Monkey();
        int aom = Monkey.amountOfMonkeys; // BAD
        addObject(myMonkey, 700, 300);
        Monkey.amountOfMonkeys = aom + 1; // BAD
        
        //int aom = Monkey.getAmountOfMonkeys();
    }
}
