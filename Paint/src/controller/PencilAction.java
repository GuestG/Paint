/* 
 * TCSS 305 - Assignment 5b
 */

package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import model.Pencil;
import view.GUIDrawingPanel;

/**
 * A listener for the pencil button.
 * 
 * @author gehry guest
 * @version 2.0
 */
public final class PencilAction extends AbstractAction {
    
    /** Number for serialization. */
    private static final long serialVersionUID = 5447472080877199651L;
    
    /** Panel field to change the current tool. */
    private GUIDrawingPanel myPanel;
    
    /** Creates a Pencil to set tool in panel. */
    private Pencil myPencil;
    
    /**
     * Sets the name for Pencil button and picture, and coordinates
     * them.
     * 
     * @param thePanel a GUIDrawingPAnel
     */
    public PencilAction(final GUIDrawingPanel thePanel) {
        
        super("Pencil", new ImageIcon("./resources/Pencil.gif"));
        
        myPencil = new Pencil();
        
        myPanel = thePanel;
        
        putValue(Action.SHORT_DESCRIPTION, "Selects the Pencil tool, for drawing a Pencil.");
        
        putValue(Action.SELECTED_KEY, true);
       
    }
    
    /** {@inheritDoc} */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        
        myPanel.setCurrentTool(myPencil);
    }
}
