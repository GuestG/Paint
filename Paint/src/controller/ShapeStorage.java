/* 
 * TCSS 305 - Assignment 5b
 */

package controller;

import java.awt.Color;
import java.awt.Shape;

/**
 * Class to store color, thickness, and shape of a tool.
 * 
 * @author gehry guest
 * @version 2.0
 */
public final class ShapeStorage {
    
    /** Color value to save for each object. */
    private Color myColor;
    
    /** Thickness value to save for each object. */
    private int myThickness;
    
    /** Shape value to save for each object. */
    private Shape myShape;
    
    /**
     * Initializes values with the current drawings specifications.
     * 
     * @param theColor takes current color.
     * @param theThickness takes current thickness.
     * @param theShape  takes current shape.
     */
    public ShapeStorage(final Color theColor, final int theThickness, final Shape theShape) {
        
        myColor = theColor;
        
        myThickness = theThickness;
        
        myShape = theShape;
    }
    
    /**
     * Gets color of drawing.
     * 
     * @return myColor the color to store.
     */
    public Color getColor() {
        
        return myColor;
    }
    
    /**
     * Gets thickness of drawing.
     * 
     * @return myThickness the thickness value to store.
     */
    public int getThick() {
        
        return myThickness;
    }
    
    /**
     * Gets shape of drawing.
     * 
     * @return myShape the shape to store.
     */
    public Shape getShape() {
        
        return myShape;
    }
}
