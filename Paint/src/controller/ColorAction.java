/* 
 * TCSS 305 - Assignment 5b
 */

package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JColorChooser;

/**
 * A listener for Color button.
 * 
 * @author Gehry Guest
 * @version 2.0
 */
public final class ColorAction extends AbstractAction {
    
    /** Number for serialization. */
    private static final long serialVersionUID = 5447472080877199651L;
    
    /** Red value for UW purple. */ 
    private static final int U = 51;
    //I know this field right here is redundant but it just more satisfying to have UWT.
    /** Green value for UW purple. */ 
    private static final int W = 0;
    
    /** Blue value for UW purple. */ 
    private static final int T = 111;
    
    /** To hold values for what color has been chosen. */
    private static Color myColor = new Color(U, W, T);
    //without making this global I could not get thickness value from this class to another.
  
    /**
     * Sets name for color button and coordinates actions.
     * 
     */
    public ColorAction() {
        
        super("Color...");
        
        putValue(Action.SHORT_DESCRIPTION, "Selects the line tool, for drawing a line.");
        
        putValue(Action.SELECTED_KEY, true);
    }
    
    /**
     * Method for Color picking.
     * 
     * @return Color theColor picked.
     */
    public Color colorButton() {
        
        final Color colorPicked = JColorChooser.showDialog(null, 
                                                           "Color Chooser", myColor);
        return colorPicked;
    }
    
    /**
     * Returns a color when picked from color chooser.
     * 
     * @return Color 
     */
    public Color getMyColor() {
        
        return myColor;
    }

    /** {@inheritDoc} */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        
        myColor = colorButton();
    }
}
