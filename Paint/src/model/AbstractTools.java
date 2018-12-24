/* 
 * TCSS 305 - Assignment 5b
 */

package model;

import java.awt.Point;
import java.awt.Shape;

/**
 * Creates common methods and fields between each tool.
 * 
 * @author gehry guest
 * @version 2.0
 */
public abstract class AbstractTools implements Tools {

    /** A point outside the drawing area. */
    public static final Point NO_POINT = new Point(0, 0);
    
    /** The shape for the shape drawn by this tool. */
    private Shape myShape;
    
    /** The end point for the shape drawn by this tool. */
    private Point myEndP;
    
    /** The start point for the shape drawn by this tool. */
    private Point myStartP;
    
    /**
     * Constructor that initializes fields.
     * 
     */
    protected AbstractTools() {
        
        myStartP = NO_POINT;
        
        myEndP = NO_POINT;
    }
    
    /**
     * @return myStartP the start point for the tool.
     */
    public Point getStartingPoint() {
        
        return myStartP;
    }
    
    /**
     * @return myEndP the end point for the tool.
     */
    public Point getEndingPoint() {
        
        return myEndP;
    } 
    
    /** {@inheritDoc} */
    @Override
    public void setStartingPoint(final Point theStart) {
        
        myStartP = theStart;
        
        myEndP = theStart;
    }
    
    /** {@inheritDoc} */
    @Override
    public void setEndingPoint(final Point theEnd) {
        
        myEndP = theEnd;
    }
    
    /** {@inheritDoc} */
    @Override
    public Shape getShape() {
        
        return myShape;
    }  
    
}
