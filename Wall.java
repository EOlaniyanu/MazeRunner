import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    
    public Wall()
    {
        GreenfootImage wallImage = new GreenfootImage(40, 40);
        
        wallImage.setColor(Color.BLACK);
        wallImage.fillRect(0, 0, 40, 40);
        
        setImage(wallImage);
    }
    
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
