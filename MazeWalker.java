import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class MazeWalker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeWalker extends Actor
{
    private final int NORTH = 270;
    private final int EAST = 0;
    private final int SOUTH = 90;
    private final int WEST = 180;
    
    public MazeWalker()
    {
        GreenfootImage mazeWalkerImage = new GreenfootImage(40, 40);
        
        mazeWalkerImage.setColor(Color.RED);
        mazeWalkerImage.fillRect(0, 0, 40, 40);
        
        setImage(mazeWalkerImage);
        setRotation(EAST);
    }
    
    /**
     * Act - do whatever the MazeWalker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        checkWin();
        
        if( wallOnLeft() == true )
        {
            if ( canMoveForward() == true)
            {
                move(1);
            }
            else
            {
                setRotation( getRotation() + 90 );
            }
        }
        else
        {
            setRotation( getRotation() - 90 );
            
            if ( canMoveForward() == true)
            {
                move(1);
            }
        }
        
    }
    
    /**
     * checkWin will check if MazeWalker has reached WinningSpace, show a message to say 
     * the message has been completed and stops the game
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void checkWin()
    {
        
        if( getOneIntersectingObject(WinningSpace.class) != null )
        {
            getWorld().showText("Maze Completed" , getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
        
    }
    
    /**
     * canMoveForward checks whether MazeWalker can move forward
     * @param There are no parameters
     * @return a boolean stating whether or not we can move forward
     */
    private boolean canMoveForward()
    {
        int xFront = 0;
        int yFront = 0;
        
        boolean moveForward = false;
        
        if ( getRotation() == NORTH )
        {
            yFront = -1;
        }
        else if( getRotation() == SOUTH )
        {
            yFront = 1;
        }
        else if( getRotation() == WEST )
        {
            xFront = -1;
        }
        else if( getRotation() == EAST )
        {
            xFront = 1;
        }
        
        if( getOneObjectAtOffset( xFront, yFront, Wall.class) == null )
        {
             moveForward = true;
        }
        
        return moveForward;
    }
    
    /**
     * wallOnLeft check if there is a Wall on the MazeWalker's left
     * @param There are no parameters
     * @return a boolean stating whether or not there is a wall on the left
     */
    private boolean wallOnLeft()
    {
        int xOffset = 0;
        int yOffset = 0;
        
        boolean wallLeft = false;
        
        if ( getRotation() == NORTH )
        {
            xOffset = -1;
        }
        else if( getRotation() == SOUTH )
        {
            xOffset = +1;
        }
        else if( getRotation() == WEST )
        {
            yOffset = +1;
        }
        else if( getRotation() == EAST )
        {
            yOffset = -1;
        }
        
        if( getOneObjectAtOffset( xOffset, yOffset, Wall.class) != null )
        {
            wallLeft = true;
        }
        
        return wallLeft;
    }
    
}
