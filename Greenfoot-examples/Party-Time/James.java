import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class James here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class James extends Actor
{
    private int alcohol = 0;
    public void act()
    {
        AlcoholicBeverage m = (AlcoholicBeverage) getOneIntersectingObject(AlcoholicBeverage.class);
        
        if(m!=null){
            drink(m);
        }
        
        if(alcohol < 100){
            shake();
        }
        
        alcohol--;
        
        if (alcohol < 0){
            alcohol = 0;
        }
    }
    
    private void shake(){
        if(getRotation()!=20){
            setRotation(20);
        }
        else{
            setRotation(-20);
        }
        
    }
    
    private void drink(AlcoholicBeverage m){
        alcohol = alcohol + m.getAlcohol();
        getWorld().removeObject(m);
    }
}
