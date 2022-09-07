import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class MyWorld extends World
{
    private int objectCounter = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
       
        List<Carl> cList = new ArrayList();
        
        for(int i=0;i<10000;i++){
            createRandomCarl();
        }
    }
    public void addObject(Actor a, int x, int y){
        super.addObject(a,x,y);
        objectCounter++;
    }
    private void createRandomCarl(){
        Carl c  = new Carl();
        addObject(c, Greenfoot.getRandomNumber(550), Greenfoot.getRandomNumber(350));
        c.setAge(Greenfoot.getRandomNumber(125));
    }
}
