/* 
 * TCSS 305 - Assignment 5b
 */

package view;

import controller.ColorAction;
import controller.ShapeStorage;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import model.Tools;

/** 
 * Creates drawing panel for GUI along with listeners for the panel.
 * 
 * @author Gehry Guest
 * @version 2.0
 */
public final class GUIDrawingPanel extends JPanel {

    /** Number for serialization. */
    private static final long serialVersionUID = 8444575580975344636L;
    
    /** Red value for UW purple. */ 
    private static final int U = 51;
    //I know this field right here is redundant but it just more satisfying to have UWT.
    /** Green value for UW purple. */ 
    private static final int W = 0;
    
    /** Blue value for UW purple. */ 
    private static final int T = 111;
    
    /** Color value for color of shape. */
    private Color myColor = new Color(U, W, T);
    
    /** A array list of previously drawn shapes values. */
    private final ArrayList<ShapeStorage> myPastDrawings;
    
    /** Support for firing property change events from this class. */
    private final PropertyChangeSupport myListChanged;
    
    /** To access getter for thickness slider. */
    private ThicknessChanges myCurrentThicVal;
    
    /** Integer value for thickness of shape. */
    private int myThick;
    
    /** The PaintTool currently in use. */
    private Tools myTool;
    
    /**
     * Constructor for initializing fields.
     * 
     */
    public GUIDrawingPanel() {

        setBackground(Color.WHITE);
        
        myCurrentThicVal = new ThicknessChanges();
        
        myPastDrawings = new ArrayList<ShapeStorage>();
        
        myListChanged = new PropertyChangeSupport(this);

        this.addMouseMotionListener(new MyMouseHandler());
        
        this.addMouseListener(new MyMouseHandler());

        this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    }
    
    /**
     * Sets the current tool.
     * 
     * @param theTool the tool in use.
     */
    public void setCurrentTool(final Tools theTool) {
        
        myTool = theTool;
    }
    
    /**
     * Drawing for panels.
     * 
     * @param theGraphics The graphics context to use for painting.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        
        super.paintComponent(theGraphics);
        
        final Graphics2D g2d = (Graphics2D) theGraphics;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        for (ShapeStorage s : myPastDrawings) {
            
            g2d.setColor(s.getColor());
            
            g2d.setStroke(new BasicStroke(s.getThick()));
            
            g2d.draw(s.getShape());
        }
        
        if (myTool != null) {
            
            g2d.setColor(myColor);

            g2d.setStroke(new BasicStroke(myThick));
            
            g2d.draw(myTool.getShape());
        }
    }
    
    /**
     * Discards drawings on the paint panel.
     * 
     */
    public void clearButton() {
    
        final Point reStart = new Point(-50, -50);
        
        setBackground(Color.WHITE);
        
        myPastDrawings.clear();
        
        myListChanged.firePropertyChange("List Not Filled", false, true);
        
        myTool.setStartingPoint(reStart);
        
        myTool.setEndingPoint(reStart);
        
        repaint();
    }
    
    /**
     * Adds a listener for property change events from this class.
     * 
     * @param theListener a PropertyChangeListener to add.
     */
    public void addPropertyChangeListener(final PropertyChangeListener theListener) {
        
        myListChanged.addPropertyChangeListener(theListener);
    }
    
    /**
     * Removes a listener for property change events from this class.
     * 
     * @param theListener a PropertyChangeListener to remove.
     */
    public void removePropertyChangeListener(final PropertyChangeListener theListener) {
        
        myListChanged.removePropertyChangeListener(theListener);
    }
    
    /**
     * Listens for mouse events to draw on our panel.
     */
    private class MyMouseHandler extends MouseInputAdapter {

        @Override
        public void mousePressed(final MouseEvent theEvent) {
                
            myColor = new ColorAction().getMyColor();
            
            myThick = myCurrentThicVal.getMyThicknessValue();
            
            myTool.setStartingPoint(theEvent.getPoint());
            
            repaint();
            
        }

        @Override
        public void mouseDragged(final MouseEvent theEvent) {

            myTool.setEndingPoint(theEvent.getPoint());

            repaint();
        }

        @Override
        public void mouseReleased(final MouseEvent theEvent) {

            myPastDrawings.add(new ShapeStorage(myColor, myThick, myTool.getShape()));
            
            myListChanged.firePropertyChange("List Filled", false, true);

            repaint();
        }
    }
}
