/* 
 * TCSS 305 - Assignment 5b
 */

package model;

import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * A tool for drawing lines.
 * 
 * @author gehry guest
 * @version 2.0
 */
public final class Line extends AbstractTools {

    /** {@inheritDoc} */
    @Override
    public Shape getShape() {
        
        return new Line2D.Double(getStartingPoint(), getEndingPoint());
    }

}
