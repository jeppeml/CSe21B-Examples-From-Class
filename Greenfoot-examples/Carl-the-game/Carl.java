import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Carl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carl extends Actor
{
    private int age=1;
    /**
     * Act - do whatever the Carl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        age++;
    }   
    
    public void setAge(int age){
        this.age = age;
    }
    
    public int getAge(){
        return age;
    }
}
