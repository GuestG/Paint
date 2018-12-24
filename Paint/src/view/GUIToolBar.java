/* 
 * TCSS 305 - Assignment 5b
 */

package view;

import controller.ColorAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Sets up tool bar with buttons and actions. 
 * 
 * @author Gehry Guest
 * @version 2.0
 */
public final class GUIToolBar extends JToolBar {

    /** Number Generated for serialization. */
    private static final long serialVersionUID = 3448611892812420278L;
    
    /** Creates a button group so only one can be selected at a time. */
    private final ButtonGroup myButtonToolBarGroup;
    
    /** To create and adding actions to the color button. */
    private final ColorAction myColorAction;

    /**
     * Constructor for GUIToolBar no fields needed to initialized. 
     * 
     */
    public GUIToolBar() {
        
        myColorAction = new ColorAction();
        
        myButtonToolBarGroup = new ButtonGroup();
        
        final JButton color = new JButton(myColorAction);
        
        this.add(color);
    }
    
    /**
     * Creates buttons for tool bar. 
     * 
     * @param theAction actions for buttons.
     */
    public void createToolBarButtons(final Action theAction) {
        
        final JToggleButton toolBarButton = new JToggleButton(theAction);

        myButtonToolBarGroup.add(toolBarButton);
        
        this.add(toolBarButton);  
    }
}
