import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    private int acts = 0;
    
    public void act(){
        acts++;
        
        if(acts%25==0){
            if(getObjects(Baby.class).size()<10)
            {
                Baby b = new Baby();
                addObject(b,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
            }
        }
        
        if(acts%100==0){
            if(getObjects(BabyFood.class).size()<100)
            {
                BabyFood b = new BabyFood();
                addObject(b,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
            }
        }
    }
    
    public void spawnAtInterval(Class c, int interval){
    
    }
    
    public MyWorld()
    {    
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Font f = new Font("Verdana",74);
        getBackground().setFont(f);
        getBackground().drawString("Hello", 200, 200);
        
        for(int i=0;i<10;i++) // i = i + 1;
        {
            Baby b = new Baby();
            addObject(b,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        }
    }
}
