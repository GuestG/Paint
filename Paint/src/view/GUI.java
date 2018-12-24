/* 
 * TCSS 305 - Assignment 5b
 */

package view;

import controller.ColorAction;
import controller.EllipseAction;
import controller.LineAction;
import controller.PencilAction;
import controller.RectangleAction;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import model.Line;


/**
 * GUI class to display User interface.
 * 
 * @author Gehry Guest
 * @version 2.0
 */
public final class GUI implements PropertyChangeListener {
     
    /** Creates frame to build GUI. */
    private JFrame myFrame;
    
    /** Creates toolBar to add actions to. */
    private final GUIToolBar myToolBar;
    
    /** Creates paintPanel to add to JFrame. */
    private final GUIDrawingPanel myPaintPanel;
    
    /** Creates menuBar to add actions to. */
    private final JMenuBar myMenuBar;
   
    /** Creates tools menu for the Menu Bar. */
    private final JMenu myToolsButtons;
    
    /** JMenuitem to be used between classes. */
    private final JMenuItem myClear;

    /** Creates a button group so only one can be selected at a time. */
    private final ButtonGroup myRadioButtonGroup;
    
    /** To create and adding actions to the color button. */
    private final ColorAction myColorAction;

    /** Array list to hold actions for tools. */
    private final ArrayList<Action> myToolsActions;
    
    /** String for the programs name. */
    private final String myProgName = "TCSS 305 – Paint Program";
    
    /** String for Icon that is used in program. */
    private final String myIcon = "./resources/Lumpy.PNG";
    
    /** To add thickness slider and actions to GUI. */
    private final ThicknessChanges myThickAction;
    
    /**
     * Constructor to initialize fields for GUI class.
     * 
     */
    public GUI() {
        
        myThickAction = new ThicknessChanges();
        
        myFrame = new JFrame();
        
        myMenuBar = new JMenuBar();
        
        myToolBar = new GUIToolBar();
        
        myPaintPanel = new GUIDrawingPanel();
        
        myToolsActions = new ArrayList<Action>();
        
        myRadioButtonGroup = new ButtonGroup();
        
        myColorAction = new ColorAction();
        
        myToolsButtons = new JMenu("Tools");
        
        myClear = new JMenuItem("Clear");
    }
    
    /**
     * Runs the GUI class.
     * 
     */
    public void start() {
        
        setUpTools();
        
        createOtherButtons();
        
        defaultFrame();   
    }
    
    /**
     * Sets up actions and tool buttons for menu and tool bar.
     * 
     */
    private void setUpTools() {
        
        myPaintPanel.addPropertyChangeListener(this);
        
        myToolsActions.add(new LineAction(myPaintPanel));
        
        myToolsActions.add(new PencilAction(myPaintPanel));
        
        myToolsActions.add(new RectangleAction(myPaintPanel));
        
        myToolsActions.add(new EllipseAction(myPaintPanel));
        
        myPaintPanel.setCurrentTool(new Line());
   
        for (int i = 0; i < myToolsActions.size(); i++) {

            myToolBar.createToolBarButtons(myToolsActions.get(i));
            
            createMenuBarButtons(myToolsActions.get(i));
        }
        
    }
    
    /**
     * Sets up the frame of the GUI and gives it defaults I set up.
     * 
     */
    private void defaultFrame() {
        
        final int oneThird = 3;
        
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        final Dimension defDimension = new Dimension((int) screenSize.getWidth() / oneThird
                                       , (int) screenSize.getHeight() / oneThird);
        
        myFrame.setJMenuBar(myMenuBar);
        
        myFrame.add(myPaintPanel, BorderLayout.CENTER);
        
        myFrame.add(myToolBar, BorderLayout.SOUTH);
        
        myFrame.setSize(defDimension);
        
        myFrame.setMinimumSize(defDimension);
        
        myFrame.setIconImage(new ImageIcon(myIcon).getImage());
        
        myFrame.setTitle(myProgName);
        
        myFrame.setLocationRelativeTo(null);
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        myFrame.setVisible(true);
    }
        
        
    /**
     * Method for making the menu bar along with its components such as 
     * radio button drop down menu.
     * 
     * @param theAction action for buttons.
     */
    public void createMenuBarButtons(final Action theAction) {

        final JRadioButtonMenuItem toolButton = new JRadioButtonMenuItem(theAction);
        
        myRadioButtonGroup.add(toolButton);
      
        myToolsButtons.add(toolButton);         
    }
        
    /**
     * Creates buttons that are non-tool buttons along with
     * there functionality.
     * 
     */
    private void createOtherButtons() {
            
        final JMenu optionButtons = new JMenu("Options");
           
        final JMenu helpButtons = new JMenu("Help");
            
        myMenuBar.add(optionButtons);
            
        myMenuBar.add(myToolsButtons);
            
        myMenuBar.add(helpButtons);
            
        final JMenu thickness = new JMenu("Thickness");
            
        final JMenuItem color = new JMenuItem("Color...");
            
        final JMenuItem about = new JMenuItem("About...");
            
        thickness.add(myThickAction.createSlider());
            
        about.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(final ActionEvent theEvnt) {
                aboutButton();
            }
        });
            
        color.addActionListener(myColorAction);
            
        myClear.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPaintPanel.clearButton();
            }
        });
            
        optionButtons.add(thickness);
            
        optionButtons.addSeparator();
            
        optionButtons.add(color);
            
        optionButtons.addSeparator();
            
        optionButtons.add(myClear);
            
        helpButtons.add(about);
        
        myClear.setEnabled(false);
    }
        
    /**
     * Creates a pop up menu when the about button is selected, 
     * displays information and custom image. 
     * 
     */
    private void aboutButton() {
        
        JOptionPane.showMessageDialog(null, "Autum 2018 \nGehry Guest", myProgName
                                      , JOptionPane.INFORMATION_MESSAGE
                                      , new ImageIcon(myIcon));
    }
    
    /** {@inheritDoc} */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {

        if ("List Filled".equals(theEvent.getPropertyName())) {
//            final Point reStart = new Point(-50, -50);
//            myPaintPanel.setCurrentTool(theTool);
            myClear.setEnabled(true);
        } else if ("List Not Filled".equals(theEvent.getPropertyName())) {
            
            myClear.setEnabled(false);
        }
    }
}



