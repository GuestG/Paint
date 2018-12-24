/* 
 * TCSS 305 - Assignment 5b
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import model.Line;
import view.GUIDrawingPanel;

/**
 * A listener for the line button.
 * 
 * @author gehry guest
 * @version 2.0
 */
public final class LineAction extends AbstractAction implements ActionListener {
    
    /** Number for serialization. */
    private static final long serialVersionUID = 5447472080877199651L;
    
    /** Panel field to change the current tool. */
    private GUIDrawingPanel myPanel;
    
    /** Creates a Line to set tool in panel. */
    private Line myLine;
    
    /**
     * Sets the name for Line button and picture, and coordinates
     * them.
     * 
     * @param thePanel a GUIDrawingPAnel
     */
    public LineAction(final GUIDrawingPanel thePanel) {
        
        super("Line", new ImageIcon("./resources/line.gif"));
        
        myLine = new Line();
        
        myPanel = thePanel;
        
        putValue(Action.SHORT_DESCRIPTION, "Selects the line tool, for drawing a line.");
        
        putValue(Action.SELECTED_KEY, true);
    }
    
    /** {@inheritDoc} */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        
        myPanel.setCurrentTool(myLine);
    }
}
