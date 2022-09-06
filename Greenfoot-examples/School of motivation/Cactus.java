import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cactus here.
 * 
 * @author Jeppe
 * @version 0.01b
 */
public class Cactus extends Actor
{
    private int life=100; // instance variable
    /**
     * Act - do whatever the Cactus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(1);
        life = life - 1;
        if (life<1){
            getWorld().removeObject(this);
            
        }
    }


}
