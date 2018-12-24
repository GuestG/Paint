/* 
 * TCSS 305 - Assignment 5b
 */

package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Path2D;

/**
 * A tool for drawing a path.
 * 
 * @author gehryguest
 * @version 2.0
 */
public final class Pencil extends AbstractTools {

    /** Path that will be used for pencil. */
    private Path2D myPath;
    
    /** {@inheritDoc} */
    @Override
    public void setStartingPoint(final Point theStartPoint) {
        
        myPath = new Path2D.Double();
        
        myPath.moveTo(theStartPoint.getX(), theStartPoint.getY());
        
        setEndingPoint(theStartPoint);
    } 
    
    /** {@inheritDoc} */
    @Override
    public Shape getShape() {
       
        myPath.lineTo(getEndingPoint().getX(), getEndingPoint().getY());
        
        return myPath;
    }
}
