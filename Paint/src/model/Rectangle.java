/* 
 * TCSS 305 - Assignment 5b
 */

package model;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * Rectangle tool for drawing Rectangles.
 * 
 * @author gehry guest
 * @version 2.0
 */
public final class Rectangle extends AbstractTools {

    /** {@inheritDoc} */
    @Override
    public Shape getShape() {
        
        final Rectangle2D.Double rectangle = new Rectangle2D.Double();
        
        rectangle.setFrameFromDiagonal(getStartingPoint(), getEndingPoint());
        
        return rectangle;
    }
}
