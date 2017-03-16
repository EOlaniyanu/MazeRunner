import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class WinningSpace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinningSpace extends Actor
{
    
    public WinningSpace()
    {
        GreenfootImage winningSpaceImage = new GreenfootImage(40, 40);
        
        winningSpaceImage.setColor(Color.YELLOW);
        winningSpaceImage.fillRect(0, 0, 40, 40);
        
        setImage(winningSpaceImage);
    }
    
    /**
     * Act - do whatever the WinningSpace wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
