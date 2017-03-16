import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public Player()
    {
        GreenfootImage PlayerImage = new GreenfootImage(40, 40);
        
        PlayerImage.setColor(Color.GREEN);
        PlayerImage.fillRect(0, 0, 40, 40);
        
        setImage(PlayerImage);
        setRotation(270);
    }
    
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        checkWin();
        
        if( Greenfoot.isKeyDown("left") )
        {
            setRotation(180);
        }
        else if( Greenfoot.isKeyDown("right") )
        {
            setRotation(0);
        }
        else if( Greenfoot.isKeyDown("up") )
        {
            setRotation(270);
        }
        else if( Greenfoot.isKeyDown("down") )
        {
            setRotation(90);
        }
        
        
        canMove();
        movement();
        
    }
    
    /**
     * checkWin checks if the Player has touched the Winning Space 
     * and prints a message in the world and stops the program
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void checkWin()
    {
        if( getOneIntersectingObject(WinningSpace.class) != null )
        {
            getWorld().showText("You are Smarter than a Program! CONGRATULATIONS!" , getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
    
    /**
     * movement allows user to control the movement of Player\
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void movement()
    {
        if( canMove() == true )
        {
            if( Greenfoot.isKeyDown("left") )
            {
                setRotation(180);
                setLocation( getX() - 1, getY());
            }
            else if( Greenfoot.isKeyDown("right") )
            {
                setRotation(0);
                setLocation( getX() + 1, getY());
            }
            else if( Greenfoot.isKeyDown("up") )
            {
                setRotation(270);
                setLocation( getX(), getY() - 1);
            }
            else if( Greenfoot.isKeyDown("down") )
            {
                setRotation(90);
                setLocation( getX(), getY() + 1);
            }
        }
        
    }
    
    /**
     * canMove checks if there is a wall in the direction Player is moving and Offsets the movement
     * 
     * @param There are no parameters
     * @return A boolean called moveForward is returned 
     */
    private boolean canMove()
    {
        int xFront = 0;
        int yFront = 0;
        
        boolean moveForward = false;
        
        if( getRotation() == 270 )
        {
            yFront = -1;
        }
        else if( getRotation() == 90 )
        {
            yFront = 1;
        }
        else if( getRotation() == 180 )
        {
            xFront = -1;
        }
        else if( getRotation() == 0 )
        {
            xFront = 1;
        }
        
        if( getOneObjectAtOffset( xFront, yFront, Wall.class) == null )
        {
             moveForward = true;
        }
        
        return moveForward;
    }
    
}
