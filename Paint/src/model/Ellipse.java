/* 
 * TCSS 305 - Assignment 5b
 */

package model;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * A tool for drawing Ellipses.
 * 
 * @author gehry guest
 * @version 2.0
 */
public final class Ellipse extends AbstractTools {

    /** {@inheritDoc} */
    @Override
    public Shape getShape() {
        
        final Ellipse2D.Double ellispe = new Ellipse2D.Double();
        
        ellispe.setFrameFromDiagonal(getStartingPoint(), getEndingPoint());
        
        return ellispe;
    }
}
