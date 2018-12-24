/* 
 * TCSS 305 - Assignment 5b
 */

package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import model.Ellipse;
import view.GUIDrawingPanel;

/**
 * A listener for the ellipse button.
 * 
 * @author gehry guest
 * @version 2.0
 */
public final class EllipseAction extends AbstractAction {
    
    /** Number for serialization. */
    private static final long serialVersionUID = 5447472080877199651L;
    
    /** Panel field to change the current tool. */
    private GUIDrawingPanel myPanel;
    
    /** Creates a Ellipse to set tool in panel. */
    private Ellipse myEllipse;
    
    /**
     * Sets the name for Ellipse button and picture, and coordinates
     * them.
     * 
     * @param thePanel a GUIDrawingPAnel
     */
    public EllipseAction(final GUIDrawingPanel thePanel) {
        
        super("Ellipse", new ImageIcon("./resources/Ellipse.gif"));
        
        myEllipse = new Ellipse();
        
        myPanel = thePanel;
        
        putValue(Action.SHORT_DESCRIPTION, "Selects the Ellipse tool, for drawing a Ellipse.");
        
        putValue(Action.SELECTED_KEY, true);
    }
    
    /** {@inheritDoc} */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        
        myPanel.setCurrentTool(myEllipse);
    }
}
