import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Baby here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Baby extends Actor
{
    private int hungryness = 1000; // <0 child dies, Extremely hungry = 0, full = 1000
    
    public void act() 
    {
        checkHungerAndDie();
        BabyFood food = (BabyFood) getOneIntersectingObject(BabyFood.class);
        if(food != null){
            eat(food);
        }
        
    }  
    
    private void checkHungerAndDie(){
        hungryness = hungryness - 1;
        if (hungryness<0){ // baby dies 
            getWorld().removeObject(this);
        }
    }
    
    public void cry(){
    }
    
    public void eat(BabyFood food){
        hungryness = hungryness + food.getNutrionalValue();
        if(hungryness>1000){
            hungryness = 1000;
        }
        getWorld().removeObject(food);
    }
    
    public void sleep(){
    }
    
    public Turd shit(){
        return new Turd();
    }
}
