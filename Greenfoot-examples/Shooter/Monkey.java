import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monkey extends Actor
{
    private int bananasEaten = 0;
    
    public Monkey(){
        super();
        GreenfootImage img = getImage();
        //img.scale(150,150);
        
        getImage().scale((int)(img.getWidth()*0.3), (int)(img.getHeight()*0.3));
    }
    
    /**
     * Act - do whatever the Monkey wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Banana b = (Banana) getOneIntersectingObject(Banana.class);
        if (b!=null){
            bananasEaten++;
            getWorld().removeObject(b);
        }
    }    
}
