/* 
 * TCSS 305 - Assignment 5b
 */

package model;

import java.awt.Point;
import java.awt.Shape;

/**
 * Creates commonalities between all tools.
 * 
 * @author gehry guest
 * @version 2.0
 */
public interface Tools {
    
    /** 
     * sets the starting point for use in abstract class.
     * 
     * @param theStart a point
     */
    void setStartingPoint(Point theStart);
    
    /** 
     * sets the ending point for use in abstract class.
     * 
     * @param theEnd a point
     */  
    void setEndingPoint(Point theEnd);
    
    /** 
     * gets the shape from selected tools.
     * 
     * @return Shape a shape from the tools.
     */
    Shape getShape();

}
