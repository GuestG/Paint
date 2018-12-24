/* 
 * TCSS 305 - Assignment 5b
 */

package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import model.Rectangle;
import view.GUIDrawingPanel;

/**
 * A listener for the rectangle button.
 * 
 * @author gehry guest
 * @version 2.0
 */
public final class RectangleAction extends AbstractAction {
    
    /** Number for serialization. */
    private static final long serialVersionUID = 5447472080877199651L;
    
    /** Panel field to change the current tool. */
    private GUIDrawingPanel myPanel;
    
    /** Creates a rectangle to set tool in panel. */
    private Rectangle myRectangle;
    
    /**
     * Sets the name for rectangle button and picture, and coordinates
     * them.
     * 
     * @param thePanel a GUIDrawingPAnel
     */
    public RectangleAction(final GUIDrawingPanel thePanel) {
        
        super("Rectangle", new ImageIcon("./resources/Rectangle.gif"));
        
        myRectangle = new Rectangle();
        
        myPanel = thePanel;
        
        putValue(Action.SHORT_DESCRIPTION, 
                 "Selects the Rectangle tool, for drawing a Rectangle.");
        
        putValue(Action.SELECTED_KEY, true);
    }
    
    /** {@inheritDoc} */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        
        myPanel.setCurrentTool(myRectangle);
    }
}
